package com.e.firstapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

//https://blog.csdn.net/ytfunnysite/article/details/102612740
public class DataGenerator {
    public static final int []mTabRes = new int[]{R.drawable.lesson_default,R.drawable.study_default,R.drawable.personal_default};
    public static final int []mTabResPressed = new int[]{R.drawable.lesson_selected,R.drawable.study_selected,R.drawable.personal_selected};
    public static final String []mTabTitle = new String[]{"选课","学习","我的"};

    public static List<Fragment> getFragments(String from){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance(from));
        fragments.add(HomeFragment.newInstance(from));
        fragments.add(HomeFragment.newInstance(from));
        return fragments;
    }

    /**
     * 获取Tab 显示的内容
     * @param context
     * @param position
     * @return
     */
    public static View getTabView(Context context, int position){
        View view = LayoutInflater.from(context).inflate(R.layout.home_tab_content,null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(DataGenerator.mTabRes[position]);
        TextView tabText = (TextView) view.findViewById(R.id.tab_content_text);
        tabText.setText(mTabTitle[position]);
        return view;
    }
}

