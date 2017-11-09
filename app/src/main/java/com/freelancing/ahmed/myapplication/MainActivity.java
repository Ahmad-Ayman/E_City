package com.freelancing.ahmed.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;

    public String title;

    private TabLayout tabLayout;
    DrawerLayout drawer;

    private String[] pageTitle = {"الرحلات", "ابرز المعالم", "الصفحة الرئيسية"};
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPager.setCurrentItem(2);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        for (int i = 0; i < 3; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));

        }

        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("المدينة الالكترونية");

        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);

        //set viewpager adapter
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        //change Tab selection when swipe ViewPager
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //change ViewPager page when tab selected
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
               // viewPager.setCurrentItem(2);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

      //  if (savedInstanceState == null) {
        //    navigationView.getMenu().performIdentifierAction(R.id.nav_resturant,0);
        //}

        viewPager.setCurrentItem(2);
    }

    @Override
    protected void onStart() {
        toolbar.setTitle("المدينة الالكترونية");
        super.onStart();
    }


    @Override
    protected void onResume() {

        toolbar.setTitle("المدينة الالكترونية");
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menusRight) {
            if(drawer.isDrawerOpen(Gravity.RIGHT)){
                drawer.closeDrawer(Gravity.RIGHT);
            }
            else{
                drawer.openDrawer(Gravity.RIGHT);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        FragmentManager fm  = getSupportFragmentManager();
        switch(item.getItemId()) {
            case R.id.nav_resturant:
                GoToURL("https://www.tripadvisor.com.eg/Restaurants-g297555-Sharm_El_Sheikh_South_Sinai_Red_Sea_and_Sinai.html");
               //itle="المدينة الالكترونيه";
              // viewPager.setCurrentItem(0);
                break;

            case R.id.nav_hotels:
                GoToURL("https://www.tripadvisor.com.eg/SmartDeals-g297555-Sharm_El_Sheikh_South_Sinai_Red_Sea_and_Sinai-Hotel-Deals.html");
                //  viewPager.setCurrentItem(1);
                break;

            case R.id.nav_airlines:
                GoToURL("https://www.skyscanner.net/");
                //viewPager.setCurrentItem(2);
                break;

            case R.id.nav_companies:

                GoToURL("http://www.travelyalla.com/%D8%B1%D8%AD%D9%84%D8%A7%D8%AA-%D8%B4%D8%B1%D9%85-%D8%A7%D9%84%D8%B4%D9%8A%D8%AE/3/0/14");
                break;

            case R.id.nav_id:
                GoToURL("https://cso.gov.eg/NetServices?ServiceId=9");
                //Toast.makeText(this, "id pressed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_brith:
                GoToURL("https://cso.gov.eg/NetServices?ServiceId=1");
                break;
            case R.id.nav_drive:
                GoToURL("http://www.egypt.gov.eg/Services/LoadxtrServices.aspx?PgURL=102553&section=personas");
                break;
            case R.id.nav_electricity:
                GoToURL("http://www.egypt.gov.eg/services/LoadxtrServices.aspx?PgURL=70753&section=serviceproviders");
                break;
            case R.id.nav_water:
                GoToURL("http://www.egypt.gov.eg/default.html");
                break;
            case R.id.nav_phone:
                GoToURL("https://billing.te.eg/ar-EG");
                break;
            case R.id.nav_lost:
                GoToURL("http://www.mfa.gov.eg/arabic/ConsularServices/Pages/ConsularServiceDetails.aspx?ID=Passports%20and%20Nationality%20Affairs");
                break;
            case R.id.nav_empassy:
                GoToURL("http://www.eip.gov.eg/Directories/Directory.aspx?id=8");
                break;
            case R.id.nav_carrent:
                GoToURL("https://www.vipcars.com/?viplang=ar&country=48&city=443");
                break;
            case R.id.nav_complement:
                GoToURL("http://www.moiegypt.gov.eg/Arabic/Departments%20Sites/Tourism/");
                break;
            case R.id.nav_about:
                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                startActivity(intent);
                break;

        }

        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
      //  item.setChecked(true);
        getSupportActionBar().setTitle(title);
        assert drawer != null;
        drawer.closeDrawer(GravityCompat.END);
        return true;

    }



    public void GoToURL(String url){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }


}