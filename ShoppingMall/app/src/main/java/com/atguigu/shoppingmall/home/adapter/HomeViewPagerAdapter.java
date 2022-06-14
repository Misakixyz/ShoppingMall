package com.atguigu.shoppingmall.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.atguigu.shoppingmall.home.fragment.HomeFragment;
import com.atguigu.shoppingmall.community.fragment.NewPostFragment;

import java.util.ArrayList;
import java.util.List;


public class HomeViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] titles = new String[]{"推荐", "订阅"};

    public HomeViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }

    private void initFragments() {
        HomeFragment homeFragment = new HomeFragment();
        NewPostFragment newPostFragment = new NewPostFragment();
        fragmentList.add(homeFragment);
        fragmentList.add(newPostFragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
