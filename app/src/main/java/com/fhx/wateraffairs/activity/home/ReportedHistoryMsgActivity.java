package com.fhx.wateraffairs.activity.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.fragment.HomeFragment;
import com.to.aboomy.banner.Banner;
import com.to.aboomy.banner.HolderCreator;
import com.to.aboomy.banner.IndicatorView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 上报记录详情
 */
public class ReportedHistoryMsgActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.banner)
    Banner banner;

    private List<String> imageList = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_reported_msg_history;
    }

    @Override
    protected void initView() {
        tvTitle.setText("信息详情");
    }

    @Override
    protected void initData() {

        imageList.clear();
        imageList.add("http://pic.netbian.com/uploads/allimg/201221/233225-1608564745f480.jpg");
        imageList.add("http://pic.netbian.com/uploads/allimg/201222/001824-160856750454cc.jpg");
        imageList.add("http://pic.netbian.com/uploads/allimg/201228/210128-1609160488f8b7.jpg");

        //使用内置Indicator
        IndicatorView qyIndicator = new IndicatorView(this)
                .setIndicatorColor(Color.DKGRAY)
                .setIndicatorSelectorColor(Color.WHITE);

        banner.setIndicator(qyIndicator)
                .setRoundCorners(5)
                .setHolderCreator(new ImageHolderCreator())
                .setPages(imageList);
    }

    @Override
    protected void initListen() {

    }


    @OnClick({R.id.image_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
        }
    }

    //banner监听
    public class ImageHolderCreator implements HolderCreator {
        @Override
        public View createView(final Context context, final int index, Object o) {
            ImageView iv = new ImageView(context);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(ReportedHistoryMsgActivity.this).load(o).into(iv);
            //内部实现点击事件
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, index + "", Toast.LENGTH_LONG).show();
                }
            });
            return iv;
        }
    }
}
