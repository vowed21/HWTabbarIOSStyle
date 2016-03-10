package com.kokohapps.hwtabbariosstyle;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by hyunwookim on 16. 3. 9..
 */
public class HWTabbarItem extends RelativeLayout {

    private static final int TABBAR_TEXT_COLOR_DEFAULT = Color.rgb(95, 95, 95);

    private static int tabbarSelectedColor;

    private TextView tvTitle, tvBadge;
    private ImageView ivIcon;
    int position;

    private int mImageSrc, mSelectedImageSrc;

    public HWTabbarItem(Context context, String title, int imgSrc, int selectedImgSrc, int selectedColor, int position) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.hwtabbar_item, this, true);

        this.position = position;
        mImageSrc = imgSrc;
        mSelectedImageSrc = selectedImgSrc;
        tabbarSelectedColor = selectedColor;

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvBadge = (TextView) findViewById(R.id.tvBadge);
        ivIcon = (ImageView) findViewById(R.id.ivIcon);

        tvTitle.setText(title);
        tvBadge.setVisibility(View.GONE);
    }

    public void setItemIsSelected(Boolean isSelected){

        //선택되었다면.
        if (isSelected) {
            tvTitle.setTextColor(tabbarSelectedColor);
            ivIcon.setImageResource(mSelectedImageSrc);
        }
        else{
            tvTitle.setTextColor(TABBAR_TEXT_COLOR_DEFAULT);
            ivIcon.setImageResource(mImageSrc);
        }
    }

    public void setBadgeValue(String badgeValue){

        if(badgeValue == null || badgeValue.isEmpty()){
            tvBadge.setVisibility(View.GONE);
        }else{
            tvBadge.setVisibility(View.VISIBLE);
            tvBadge.setText(badgeValue);
        }
    }


}
