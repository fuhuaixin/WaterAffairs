package com.fhx.wateraffairs.activity.form;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 大坝巡视检查记录表
 */
public class BarTourRecordActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.image_right)
    ImageView imageRight;
    @BindView(R.id.ll_barTi)
    LinearLayout ll_barTi;
    @BindView(R.id.tv_barti_choose)
    TextView tvBarTiChoose;

    //坝体 图片上传
    private List<String> barTiList =new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_bar_tour_record;
    }

    @Override
    protected void initView() {
        imageRight.setImageResource(R.mipmap.icon_title_right_confirm);
        tvTitle.setText("大坝巡视检查记录表");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListen() {

    }

    @OnClick({R.id.image_back,R.id.image_right, R.id.ll_barTi})
    public void OnClicks(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_right:

                break;
            case R.id.ll_barTi:
                Intent intent = new Intent(BarTourRecordActivity.this, ImageCommitActivity.class);
                startActivityForResult(intent, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("返回值11=====》", requestCode + " ---" + resultCode + "---");
        if (requestCode == 1 && resultCode == 1) {
            barTiList = data.getStringArrayListExtra("imageList");

            Log.e("返回值22=====》", barTiList.toString());
            tvBarTiChoose.setText("已选择");
            tvBarTiChoose.setTextColor(getResources().getColor(R.color.bot_text));
        }
    }
}
