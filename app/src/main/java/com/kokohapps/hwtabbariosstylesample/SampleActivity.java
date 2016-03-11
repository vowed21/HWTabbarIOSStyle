package com.kokohapps.hwtabbariosstylesample;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kokohapps.hwtabbariosstyle.HWTabbar;


public class SampleActivity extends FragmentActivity {

    ViewPager viewPager;
    HWTabbar tabbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new Adapter(getSupportFragmentManager()));

        tabbar = (HWTabbar) findViewById(R.id.tabbarController);

        String[] titleArr = {"탭", "탭22", "탭3333", "탭4444"};
        Integer[] imgSrcArr = {R.drawable.off, R.drawable.off, R.drawable.off, R.drawable.off};
        Integer[] selectedImgSrcArr = {R.drawable.on, R.drawable.on, R.drawable.on, R.drawable.on};



        try {
            tabbar.initTabbar(viewPager, titleArr, imgSrcArr, selectedImgSrcArr, Color.BLUE);
        }
        catch (Exception e){
            e.printStackTrace();
        }


        tabbar.setBadge(2, "Wow~!");
        tabbar.setBadge(0, "1");


    }








    private class Adapter extends FragmentPagerAdapter {

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return MyFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 4;
        }
    }


    public static class MyFragment extends Fragment {

        int position;

        public static MyFragment newInstance(int position) {

            MyFragment fragment = new MyFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            fragment.setArguments(bundle);
            fragment.position = position;
            return fragment;

        }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            TextView tv = new TextView(getActivity());
            tv.setText("PAGE "+position);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(30);
            return tv;
        }
    }

}
