package com.example.natthanan.buffetteamfinder;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ChooseDealActivity extends AppCompatActivity {

    Toolbar toolbar;
    private Spinner amountSpinner;
    private Spinner timeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_deal);

        // Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);

        // Search
        Intent searchIntent = getIntent();
        if (Intent.ACTION_SEARCH.equals(searchIntent.getAction())) {

            String query = searchIntent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(ChooseDealActivity.this, query, Toast.LENGTH_SHORT).show();
        }

        // Filter Zoneeeeee
        amountSpinner = (Spinner) findViewById(R.id.amount_spinner);
        timeSpinner = (Spinner) findViewById(R.id.time_spinner);

        String[] amount = getResources().getStringArray(R.array.amount);
        ArrayAdapter<String> adapterAmount = new ArrayAdapter<>(this, R.layout.spinner_item, amount);
        adapterAmount.setDropDownViewResource(R.layout.spinner_dropdown_item);
        amountSpinner.setAdapter(adapterAmount);

        String[] time = getResources().getStringArray(R.array.time);
        ArrayAdapter<String> adapterTime = new ArrayAdapter<>(this, R.layout.spinner_item, time);
        adapterTime.setDropDownViewResource(R.layout.spinner_dropdown_item);
        timeSpinner.setAdapter(adapterTime);



    }

    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

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
}
