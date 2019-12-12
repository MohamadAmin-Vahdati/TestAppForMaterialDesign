package com.mavp.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView ;
    RecyclerView recyclerView ;


    RelativeLayout layoutParent ;
    MaterialToolbar materialToolbar ;
    CoordinatorLayout coordinatorLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutParent = findViewById(R.id.layoutParent) ;


        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.getOrCreateBadge(R.id.home).setNumber(1000);

        materialToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(materialToolbar);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        DrawerLayout drawerLayout = findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, materialToolbar, 0, 0);
        drawerToggle.syncState();

        final MaterialAlertDialogBuilder  dialog = new MaterialAlertDialogBuilder(this , R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog)
                .setMessage("this is just a app which designed with material design !!!")
                .setPositiveButton("thanks ;)", null);

        NavigationView navigationView = findViewById(R.id.navigation) ;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                dialog.show();
                return false;
            }
        });





        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.home:
                        Toast.makeText(MainActivity.this, R.string.home, Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.musiclibrary:
                        Toast.makeText(MainActivity.this, R.string.musicLibrary, Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.artists:
                        Toast.makeText(MainActivity.this, R.string.Artists, Toast.LENGTH_SHORT).show();
                        return true;
                }

                return false;
            }
        });







        recyclerView = findViewById(R.id.recycler_view);
        SetRecycler setRecycler =  new SetRecycler(recyclerView,this ,layoutParent );


        coordinatorLayout = findViewById(R.id.coordinatorLayout);



    }

    @Override
    public void onBackPressed() {
        if (recyclerView.getVisibility() == View.GONE){
            recyclerView.setVisibility(View.VISIBLE);
            materialToolbar.setVisibility(View.VISIBLE);
            coordinatorLayout.setVisibility(View.GONE);
        }else {
            super.onBackPressed();
        }

    }
}
