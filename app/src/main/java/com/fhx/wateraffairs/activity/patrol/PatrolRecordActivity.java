package com.fhx.wateraffairs.activity.patrol;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.baidu.mapapi.model.LatLng;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.adapter.PatrolRecordAdapter;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.bean.PatrolRecordBean;
import com.fhx.wateraffairs.bean.PatrolRecordSectionBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 巡查记录
 */
public class PatrolRecordActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recycle_record)
    RecyclerView recycleRecord;

    private PatrolRecordAdapter recordAdapter;
    List<PatrolRecordSectionBean> mList = new ArrayList<>();
    List<LatLng> latLngList = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_patrol_record;
    }

    @Override
    protected void initView() {
        tvTitle.setText("巡查记录");
    }

    @Override
    protected void initData() {

        latLngList.add(new LatLng(34.798202, 113.811016));
        latLngList.add( new LatLng(34.798128, 113.812453));
        latLngList.add(new LatLng(34.798188, 113.814222));
        latLngList.add(new LatLng(34.797098, 113.814222));
        latLngList.add( new LatLng(34.796009, 113.814222));
        mList.add(new PatrolRecordSectionBean(true, "十二月"));
        mList.add(new PatrolRecordSectionBean(new PatrolRecordBean("张庄桥某某位置", "2020-12-10", latLngList)));
        mList.add(new PatrolRecordSectionBean(new PatrolRecordBean("张庄桥某某位置", "2020-12-15", latLngList)));
        mList.add(new PatrolRecordSectionBean(true, "十一月"));
        mList.add(new PatrolRecordSectionBean(new PatrolRecordBean("张庄桥某某位置", "2020-11-13", latLngList)));
        mList.add(new PatrolRecordSectionBean(new PatrolRecordBean("张庄桥某某位置", "2020-11-18", latLngList)));
        mList.add(new PatrolRecordSectionBean(true, "十月"));
        mList.add(new PatrolRecordSectionBean(new PatrolRecordBean("张庄桥某某位置", "2020-10-13", latLngList)));
        mList.add(new PatrolRecordSectionBean(new PatrolRecordBean("张庄桥某某位置", "2020-10-18", latLngList)));
        mList.add(new PatrolRecordSectionBean(true, "九月"));
        mList.add(new PatrolRecordSectionBean(new PatrolRecordBean("张庄桥某某位置", "2020-09-13", latLngList)));
        mList.add(new PatrolRecordSectionBean(new PatrolRecordBean("张庄桥某某位置", "2020-09-18", latLngList)));

        recycleRecord.setLayoutManager(new LinearLayoutManager(this));
        recordAdapter = new PatrolRecordAdapter(mList);
        recycleRecord.setAdapter(recordAdapter);

    }

    @Override
    protected void initListen() {

    }


    @OnClick(R.id.image_back)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
        }
    }
}
