package com.example.mob403_asm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mob403_asm.fragments.HomeFragment;
import com.example.mob403_asm.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;

    Fragment homeFragment = new HomeFragment();
    Fragment profileFragment = new ProfileFragment();
    FragmentManager fm = getSupportFragmentManager();
    Fragment activeFragment = homeFragment;

    Toolbar myToolbar;
    CardView toolbar_cardview;
    TextView toolbar_title;
    EditText ed_search;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ÁNH XẠ
        toolbar_cardview = findViewById(R.id.toolbar_cardview);
        toolbar_title = findViewById(R.id.toolbar_title);
        ed_search = findViewById(R.id.ed_search);

        // SET UP TOOLBAR
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");

        // SET UP BOTTOM NAVIGATION BAR
        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        // giữ state của từng fragment, tham khảo: https://medium.com/@oluwabukunmi.aluko/bottom-navigation-view-with-fragments-a074bfd08711
        fm.beginTransaction().add(R.id.fragment_container, profileFragment, "2").hide(profileFragment).commit();
        fm.beginTransaction().add(R.id.fragment_container, homeFragment, "1").commit();

        // on search
        editTextHandler();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @SuppressLint({"SetTextI18n", "NewApi"})
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.action_home:
                            fm.beginTransaction().hide(activeFragment).show(homeFragment).commit();
                            activeFragment = homeFragment;
                            toolbar_cardview.setVisibility(View.VISIBLE);
                            toolbar_title.setVisibility(View.GONE);
                            return true;
                        case R.id.action_sell:
                            startActivityForResult(new Intent(MainActivity.this, SellActivity.class), 999);
                            return true;
                        case R.id.action_profile:
                            fm.beginTransaction().hide(activeFragment).show(profileFragment).commit();
                            activeFragment = profileFragment;
                            toolbar_cardview.setVisibility(View.GONE);
                            toolbar_title.setVisibility(View.VISIBLE);
                            return true;
                    }

                    return false;
                }
            };

    public void editTextHandler() {
        // listen event khi gõ từ khóa để search
        ed_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // listen event khi nhấn nút search trên bàn phím
        ed_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    Toast.makeText(MainActivity.this, "Đợi tí đang tìm...", Toast.LENGTH_SHORT).show();
                    ed_search.clearFocus();
                    hideKeyboard(MainActivity.this);
                    return true;
                }

                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 999 && resultCode == RESULT_CANCELED) {
            if (fm.getBackStackEntryCount() >= 0) {
                fm.popBackStack(); // quay lại fragment trước khi mở activity đăng bán

                // check xem fragment nào đang được mở để set check cho bottom navigation items
                homeFragment = getSupportFragmentManager().findFragmentByTag("1");
                if (homeFragment != null && homeFragment.isVisible()) {
                    bottomNav.getMenu().getItem(0).setChecked(true); // nếu home fragment đang visible (mở) thì set check cho index thứ 0
                } else {
                    bottomNav.getMenu().getItem(2).setChecked(true); // ngược lại thì set check cho profile fragment (index thứ 2)
                }
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_main_menu, menu);

        return true;
    }

    // ẩn bàn phím và clear edittext focus khi nhấn ra ngoài
    // tham khảo: https://stackoverflow.com/questions/4828636/edittext-clear-focus-on-touch-outside/8766475
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    ed_search.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    // DISMISS SOFT KEYBOARD
    // tham khảo: https://stackoverflow.com/questions/1109022/how-to-set-visibility-android-soft-keyboard
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        view.clearFocus();
    }
}
