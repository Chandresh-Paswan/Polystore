package com.example.android.polystore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class NavigationHome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_home);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final ImageView imageInToolbar = (ImageView) toolbar.findViewById(R.id.actionBarImage);
        setSupportActionBar(toolbar);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        android.support.v4.app.FragmentTransaction transaction = NavigationHome.this.getSupportFragmentManager().beginTransaction();
        LandingFragment fragmentlanding = new LandingFragment();
        transaction.replace(R.id.container, fragmentlanding).commit();




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profile_item) {

            android.support.v4.app.FragmentTransaction transaction = NavigationHome.this.getSupportFragmentManager().beginTransaction();
            LandingFragment fragmentlanding = new LandingFragment();
            transaction.replace(R.id.container, fragmentlanding).commit();

        }

        else if (id == R.id.producers) {

            android.support.v4.app.FragmentTransaction transaction = NavigationHome.this.getSupportFragmentManager().beginTransaction();
            ProducerList producerList = new ProducerList();
            transaction.replace(R.id.container, producerList).commit();

            }

        else if (id == R.id.cust_order_details) {


        }


        else if (id == R.id.create_orders) {

            android.support.v4.app.FragmentTransaction transaction = NavigationHome.this.getSupportFragmentManager().beginTransaction();
            CreateOrder createOrder = new CreateOrder();
            transaction.replace(R.id.container, createOrder).commit();

        }else if (id == R.id.notification) {


        }else if (id == R.id.setting) {


        }

        else if (id == R.id.forgot_password) {


        }else if (id == R.id.sign_out) {


        }

        else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
