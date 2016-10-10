package com.example.natthanan.buffetteamfinder;

import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ChooseDealActivity extends AppCompatActivity implements CreateDealDialog.Communicator {

    Toolbar toolbar;
    private Spinner amountSpinner;
    private Spinner timeSpinner;
    Communicator communicator;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_deal);

        // Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        // CardView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.choose_deal_list_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new DealRecyclerAdapter());

        // Fab button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabBtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                CreateDealDialog createDealDialog = new CreateDealDialog();
                createDealDialog.show(manager, "dialog");
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

    // Get data from create deal form
    @Override
    public void onDialogMessage(String restaurant, String branch, String time, String promotion, int amount) {

        Toast.makeText(this, restaurant + "\n" + branch + "\n" + time + "\n" + promotion + "\n" + Integer.toString(amount) + "\n", Toast.LENGTH_LONG).show();
    }

    interface Communicator {
        public void onDialogMessage(String restaurant, String branch, String time, String promotion, int amount);
    }
}
