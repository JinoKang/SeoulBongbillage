package kr.jinho.seoulmobilejava.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import kr.jinho.seoulmobilejava.fragment.MapFragment;
import kr.jinho.seoulmobilejava.fragment.MyPageFragment;
import kr.jinho.seoulmobilejava.fragment.RecruitFragment;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                RecruitFragment recruitFragment = new RecruitFragment();
                return recruitFragment;
            case 1:
                MapFragment mapFragment = new MapFragment();
                return mapFragment;
            case 2:
                MyPageFragment myPageFragment = new MyPageFragment();
                return myPageFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
