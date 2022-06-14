package com.atguigu.shoppingmall.home.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;

import com.atguigu.shoppingmall.R;
import com.atguigu.shoppingmall.base.BaseFragment;
import com.atguigu.shoppingmall.home.adapter.HomeViewPagerAdapter;

public class HomeViewFragment extends BaseFragment {
    private ImageButton ibCommunityIcon;
    private TabLayout tablayout;
    private ViewPager viewPager;
    private ImageButton ibCommunityMessage;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home_top, null);
        //ibCommunityIcon = (ImageButton) view.findViewById(R.id.ib_community_icon);
        tablayout = (TabLayout) view.findViewById(R.id.home_tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.home_view_pager);
        //ibCommunityMessage = (ImageButton) view.findViewById(R.id.ib_community_message);

        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);
        tablayout.setVisibility(View.VISIBLE);
        tablayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }

}
