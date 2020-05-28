package com.e.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;

import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;

import butterknife.BindView;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> mFragmensts = new ArrayList<>();
    private MyViewPagerAdapter adapter;
    private static final String TAG = "MainActivity";

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @BindView(R.id.vp_container)
    ViewPager view_pager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mTabLayout = findViewById(R.id.tab_layout);
        view_pager = findViewById(R.id.vp_container);
//        mFragmensts = DataGenerator.getFragments("TabLayout Tab");
        mFragmensts.add(new HomeFragment());
        mFragmensts.add(new HomeFragment());
        mFragmensts.add(new HomeFragment());
     //   mFragmensts.add(new StudyFragment());
     //   mFragmensts.add(new MeFragment());
        adapter = new MyViewPagerAdapter(getSupportFragmentManager(),mFragmensts);
        view_pager.setAdapter(adapter);
        view_pager.setOffscreenPageLimit(2);
        view_pager.setCurrentItem(0,false);
        for(int i=0;i<3;i++){
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(DataGenerator.getTabView(this,i)));
        }
        chooseFirst();
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.e(TAG, "onTabSelected: " + tab.getPosition());
                view_pager.setCurrentItem(tab.getPosition(),true);
                recoverItem();
                View view =tab.getCustomView();
                ImageView imageView = view.findViewById(R.id.tab_content_image);
                TextView textView = view.findViewById(R.id.tab_content_text);
                imageView.setImageDrawable(getResources().getDrawable(DataGenerator.mTabResPressed[tab.getPosition()]));
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        view_pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

    /**
     * 初始化
     */
    private void chooseFirst(){
        TabLayout.Tab tabAt =  mTabLayout.getTabAt(0);
        View view =tabAt.getCustomView();
        ImageView imageView = view.findViewById(R.id.tab_content_image);
        TextView textView = view.findViewById(R.id.tab_content_text);
        imageView.setImageDrawable(getResources().getDrawable(DataGenerator.mTabResPressed[0]));
        textView.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    /**
     * 恢复默认
     */
    private void recoverItem() {
        for (int i = 0; i < 3; i++) {
            TabLayout.Tab tabAt =  mTabLayout.getTabAt(i);
            View view =tabAt.getCustomView();
            ImageView imageView = view.findViewById(R.id.tab_content_image);
            TextView textView = view.findViewById(R.id.tab_content_text);
            imageView.setImageDrawable(getResources().getDrawable(DataGenerator.mTabRes[i]));
            textView.setTextColor(Color.GRAY);
        }
    }
}
