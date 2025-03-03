package com.sumitkotiya.quickbazar.activites;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import com.sumitkotiya.quickbazar.API_set_and_controller.Api_controller;
import com.sumitkotiya.quickbazar.R;
import com.sumitkotiya.quickbazar.adapters.CategoryAdapter;
import com.sumitkotiya.quickbazar.adapters.DealsAdapter;
import com.sumitkotiya.quickbazar.models.CategoryResponseModel;
import com.sumitkotiya.quickbazar.models.DealsResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class dashboard extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public NavigationView navigationView;

    RecyclerView cat_recycler,deal_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dash_drawer), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
        });


        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //declaration
        cat_recycler = findViewById(R.id.cat_recycler);
        deal_recycler = findViewById(R.id.deal_recycler);
        navigationView = findViewById(R.id.dash_nav);
        drawerLayout = findViewById(R.id.dash_drawer);


        //Slider
        sliderSetup();

        //process_cat_data
        process_cat_data();


        //process deals
        process_deals_data();














        ////1@@@@@@@@@@@@@@@@@@@@@@@






            actionBarDrawerToggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);

            drawerLayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();

//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    if (id == R.id.nav_logout) {
                        Toast.makeText(dashboard.this, "You clicked logout", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    } else if (id == R.id.myCart) {
                        Toast.makeText(dashboard.this, "You clicked my cart", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }else if (id == R.id.myAccount) {
                        Toast.makeText(dashboard.this, "You clicked my account", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    return false;
                }
            });

    }




    public void sliderSetup(){
        // Create image list
        ArrayList<SlideModel> imageList = new ArrayList<>();

        // Add images to the list
        imageList.add(new SlideModel(R.drawable.one, "The animal population decreased by 58 percent in 42 years.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.two, "Elephants and tigers may become extinct.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.three, "And people do that.", ScaleTypes.CENTER_CROP));

        // Find ImageSlider by ID
        ImageSlider imageSlider = findViewById(R.id.image_slider);

        // Set Image List
        imageSlider.setImageList(imageList);
    }
    //Slide in and out
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //category process
    public void process_cat_data(){
        //
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false);
        cat_recycler.setLayoutManager(gridLayoutManager);
        cat_recycler.setHasFixedSize(true);
        cat_recycler.setNestedScrollingEnabled(true);

        Call<List<CategoryResponseModel>> call = Api_controller.getInstance().getApi().getCategoryData();
        call.enqueue(new Callback<List<CategoryResponseModel>>() {
            @Override
            public void onResponse(Call<List<CategoryResponseModel>> call, Response<List<CategoryResponseModel>> response) {
                List<CategoryResponseModel> data = response.body();
                CategoryAdapter categoryAdapter = new CategoryAdapter(data);
                cat_recycler.setAdapter(categoryAdapter);
            }

            @Override
            public void onFailure(Call<List<CategoryResponseModel>> call, Throwable throwable) {
                Toast.makeText(dashboard.this, throwable.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


    public void process_deals_data(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        deal_recycler.setLayoutManager(gridLayoutManager);
        deal_recycler.setHasFixedSize(true);
        deal_recycler.setNestedScrollingEnabled(false); // Disable scrolling


        Call<List<DealsResponseModel>> call = Api_controller.getInstance().getApi().getDealsData();
        call.enqueue(new Callback<List<DealsResponseModel>>() {
            @Override
            public void onResponse(Call<List<DealsResponseModel>> call, Response<List<DealsResponseModel>> response) {
                List<DealsResponseModel> data = response.body();
                DealsAdapter dealsAdapter = new DealsAdapter(data);
                deal_recycler.setAdapter(dealsAdapter);
            }

            @Override
            public void onFailure(Call<List<DealsResponseModel>> call, Throwable throwable) {
                Toast.makeText(dashboard.this, throwable.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


}