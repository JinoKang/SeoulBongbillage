package kr.jinho.seoulmobilejava.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.jinho.seoulmobilejava.R;
import kr.jinho.seoulmobilejava.adapter.TabPagerAdapter;

public class MainTabActivity extends BaseActivity {


    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);
        ButterKnife.bind(this);

        tabInit();


        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(tabPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void tabInit() {
        TabLayout.Tab mapTab = mTabLayout.newTab().setIcon(R.drawable.calendar);
        mapTab.setText("모집봉사");
        TabLayout.Tab volunteerTab = mTabLayout.newTab().setIcon(R.drawable.ic_place);
        volunteerTab.setText("봉사지도");
        TabLayout.Tab myPageTab = mTabLayout.newTab().setIcon(R.drawable.user);
        myPageTab.setText("마이페이지");

        mTabLayout.addTab(mapTab);
        mTabLayout.addTab(volunteerTab);
        mTabLayout.addTab(myPageTab);
    }
}
