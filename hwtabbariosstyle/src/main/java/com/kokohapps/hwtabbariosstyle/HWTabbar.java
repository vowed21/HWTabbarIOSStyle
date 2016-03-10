package com.kokohapps.hwtabbariosstyle;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by hyunwookim on 16. 3. 8..
 */
public class HWTabbar extends LinearLayout {

    private ViewPager mViewPager;
    private ArrayList<HWTabbarItem> mTabbarItemArr = new ArrayList<>();


    public HWTabbar(Context context) {
        super(context);
    }

    public HWTabbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HWTabbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void initTabbar(ViewPager viewPager, ArrayList<String> titleArr, ArrayList<Integer>imgSrcArr, ArrayList<Integer> selectedImgSrcArr, int selectedColor) throws Exception{
        mViewPager = viewPager;

        this.setBackgroundColor(Color.rgb(239, 239, 244));

        int pagerCount = viewPager.getAdapter().getCount();
        if(!(pagerCount == titleArr.size() && pagerCount == imgSrcArr.size() && pagerCount == selectedImgSrcArr.size())){
            throw new Exception("Must PageCount == titleArr.size() == imgSrcArr.size() == selectedImgSrcArr.size()");
        }
        else if(pagerCount > 6){
            throw new Exception("Maximum PageCount = 6");
        }



        TabClickListener clickListener = new TabClickListener();

        for(int i=0; i<pagerCount; i++) {
            HWTabbarItem item = new HWTabbarItem(getContext(), titleArr.get(i), imgSrcArr.get(i), selectedImgSrcArr.get(i), selectedColor, i);
            LayoutParams params = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
            item.setLayoutParams(params);
            this.addView(item);
            mTabbarItemArr.add(item);
            item.setItemIsSelected(false);
            item.setOnClickListener(clickListener);
        }

        mTabbarItemArr.get(0).setItemIsSelected(true);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                tabbarRefresh(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


    }


    private class TabClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {

            HWTabbarItem item = (HWTabbarItem) v;
            tabbarRefresh(item.position);
            mViewPager.setCurrentItem(item.position, false);

        }
    }

    private void tabbarRefresh(int selectedPosition){

        for( HWTabbarItem item : mTabbarItemArr){
            item.setItemIsSelected(false);
        }

        mTabbarItemArr.get(selectedPosition).setItemIsSelected(true);
    }

    public void setBadge(int tabbarItemPosition, String badgeValue){

        HWTabbarItem item = mTabbarItemArr.get(tabbarItemPosition);
        item.setBadgeValue(badgeValue);
    }

}
