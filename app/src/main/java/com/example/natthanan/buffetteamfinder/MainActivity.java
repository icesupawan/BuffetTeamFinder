package com.example.natthanan.buffetteamfinder;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);

        // Search
        SearchView seearchView = (SearchView) findViewById(R.id.menu_search);
        Intent searchIntent = getIntent();
        if (Intent.ACTION_SEARCH.equals(searchIntent.getAction())) {

            String query = searchIntent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
        }


        // Tab
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        final TabLayout.Tab homeTab = tabLayout.newTab();
        final TabLayout.Tab profileTab = tabLayout.newTab();

        tabLayout.addTab(profileTab);
        tabLayout.addTab(homeTab);


        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));


        // ViewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager, false); // set Listener with viewpager
        homeTab.setIcon(R.drawable.home_tab_white);
        profileTab.setIcon(R.drawable.profile_tab);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                Change Icon
                switch (position) {
                    case 0: {
                        homeTab.setIcon(R.drawable.home_tab_white);
                        profileTab.setIcon(R.drawable.profile_tab);
                        break;
                    }
                    case 1: {
                        profileTab.setIcon(R.drawable.profile_tab_white);
                        homeTab.setIcon(R.drawable.home_tab);
                        break;
                    }
                }
//
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.menu_search);
        android.widget.SearchView searchView = (android.widget.SearchView) searchItem.getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setIconifiedByDefault(false);
//        searchView.requestFocus();




        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu:
                Toast.makeText(this, "You Click Menu", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    // When pressed back button, switch to home tab
    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() != 0) {
            viewPager.setCurrentItem(0, true);
        } else super.onBackPressed();
    }
}
