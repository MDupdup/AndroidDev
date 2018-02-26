package com.malo.androiddev;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView infoActView;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavigationDrawer();

        setTitle("Android Dev !");

        Toast.makeText(this,"Bienvenue dans l'app de dev Android !", Toast.LENGTH_LONG).show();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    protected void onStart() {
        Log.i(TAG,"onStart");

        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG,"onResume");

        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.i(TAG,"onStop");

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy");

        super.onDestroy();
    }

    public void initNavigationDrawer() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.nav_hello:
                        Intent intent1 = new Intent(MainActivity.this, HelloWorldActivity.class);
                        intent1.addFlags(intent1.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent1);
                        break;
                    case R.id.nav_loremipsum:
                        Intent intent2 = new Intent(MainActivity.this, LoremActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_lancede:
                        Intent intent3 = new Intent(MainActivity.this, LanceDeActivity.class);
                        intent3.addFlags(intent3.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent3);
                        break;
                    case R.id.nav_timer:
                        Intent intent4 = new Intent(MainActivity.this, TimerActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.nav_notes:
                        Intent intent5 = new Intent(MainActivity.this, NotesActivity.class);
                        startActivity(intent5);
                    case R.id.nav_memo:
                        Intent intent6 = new Intent(MainActivity.this, MemoActivity.class);
                        startActivity(intent6);
                    case R.id.nav_liseuse:
                        Intent intent7 = new Intent(MainActivity.this, LiseuseActivity.class);
                        startActivity(intent7);
                    default:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) return true;
        return super.onOptionsItemSelected(item);
    }
}
