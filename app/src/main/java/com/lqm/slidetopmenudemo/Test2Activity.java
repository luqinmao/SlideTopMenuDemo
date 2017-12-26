package com.lqm.slidetopmenudemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Test2Activity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    String[] tabStrings = {"科技","体育","娱乐"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        tabLayout = findViewById(R.id.tablayout);
        viewPager =  findViewById(R.id.viewpager);

        initView();
    }

    private void initView() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fragments.add(new OneFragment());
        }
        tabLayout.addTab(tabLayout.newTab().setText(tabStrings[0]));
        tabLayout.addTab(tabLayout.newTab().setText(tabStrings[1]));
        tabLayout.addTab(tabLayout.newTab().setText(tabStrings[2]));

        viewPager.setAdapter(new TabFragAdapter(getSupportFragmentManager(),fragments));
        tabLayout.setupWithViewPager(viewPager);

    }

    class TabFragAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragments;

        public TabFragAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return tabStrings.length;
        }

        //此方法用来显示tab上的名字  (不添加将不显示文字)
        @Override
        public CharSequence getPageTitle(int position) {
            return tabStrings[position];
        }
    }

}
