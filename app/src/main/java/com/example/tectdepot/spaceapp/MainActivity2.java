package com.example.tectdepot.spaceapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsets;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements PlanetsRecycleViewInterface {


    RecyclerView planetsRecycleView;
    ArrayList<Planets> planets = new ArrayList<>();
    private MenuItem item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        View decorView = getWindow().getDecorView();
        int flags = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(flags);
        planetsRecycleView = findViewById(R.id.planetsRecycleView);

        setPlanets();
        Planets_Adapter adapter = new Planets_Adapter(MainActivity2.this, planets, this);

        planetsRecycleView.setAdapter(adapter);
        planetsRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_navbar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.home:
                item.setChecked(true);
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.missions:
                item.setChecked(true);
                Toast.makeText(this, "Missions", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.favorites:
                item.setChecked(true);
                Toast.makeText(this, "Favorites", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.profile:
                item.setChecked(true);
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    private void setPlanets(){
        planets.add(new Planets("Mercury", R.drawable.mercury_img));
        planets.add(new Planets("Venus", R.drawable.venus_img));
        planets.add(new Planets("Earth", R.drawable.earth_img));
        planets.add(new Planets("Mars", R.drawable.mars_img));
        planets.add(new Planets("Jupiter", R.drawable.jupiter_img));
        planets.add(new Planets("Saturn", R.drawable.saturn_img));
        planets.add(new Planets("Uranus", R.drawable.uranus_img));
        planets.add(new Planets("Neptune", R.drawable.neptune_img));
    }


    @Override
    public void onItemClick(int position) {
        Intent i = new Intent(MainActivity2.this, PlanetsInfoActivity.class);
        String pos = Integer.toString(position);
        i.putExtra("position", pos);
        startActivity(i);
        overridePendingTransition(R.anim.start_anim, R.anim.end_anim);
    }
}