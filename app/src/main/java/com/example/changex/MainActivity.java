package com.example.changex;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    public NavController navController;
    public Toolbar toolbar;
    private DrawerLayout drawerLayout;
    public AppBarConfiguration appBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.main_content);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        configureToolbar();
        configureNavigationDrawer();

    }
    private void configureToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(false);
    }
    private void configureNavigationDrawer() {
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.navigation);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Fragment f = null;
                int itemId = menuItem.getItemId();
                if (itemId == R.id.exchange) {
                    f = new exchange_fragment();
                } else if (itemId == R.id.converter) {
                    f = new converter_fragment();
                }else if (itemId == R.id.settings) {
                    f = new settings_fragment();
                }
                if (f != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, f)
                            .commit();
                    drawerLayout.closeDrawers();
                    return true;
                }

                return false;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment f = null;
        int itemId = item.getItemId();
        if (itemId == R.id.exchange) {
            f = new exchange_fragment();
        } else if (itemId == R.id.converter) {
            f = new converter_fragment();
        } else if (itemId == R.id.settings) {
            f = new settings_fragment();
        }
        if (f != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, f)
                    .commit();
            drawerLayout.closeDrawers();
            return true;
        }

        return false;
    }
}
