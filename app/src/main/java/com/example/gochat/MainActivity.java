package com.example.gochat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //call tool bar for bar action
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Tablayout ve view pager to see my activity in my fragment
        TabLayout tabLayout = (TabLayout) findViewById(R.id.TabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);


        //adabter for connect viewpager with tablayout fragents
        AdabterLayout adabter = new AdabterLayout(this ,getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adabter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
//function set app bar menu (srch,sittig ,etc;)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menuchat,menu);
//        getMenuInflater().inflate(R.menu.searchmenu,menu);
        return true;

    }
}
