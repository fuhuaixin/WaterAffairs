package com.fhx.wateraffairs.activity.home;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 历史数据
 */
public class MonitorHistoryActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    //获取日历的一个实例，里面包含了当前的年月日
    Calendar calendar;
    @BindView(R.id.tv_start_choose)
    TextView tvStartChoose;
    @BindView(R.id.tv_end_choose)
    TextView tvEndChoose;
    @BindView(R.id.tv_start_end_time)
    TextView tvStartEndTime;
    @BindView(R.id.ll_bot)
    LinearLayout llBot;
    private DatePickerDialog startPicker;
    private DatePickerDialog endPicker;

    @Override
    protected int initLayout() {
        return R.layout.activity_monitor_history;
    }

    @Override
    protected void initView() {
        calendar = Calendar.getInstance();
    }

    String months,days;
    @Override
    protected void initData() {
        tvTitle.setText("历史数据");
        startPicker = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            if (month<9){
                months="0"+(month+1);
            }else {
                months=(month+1)+"";
            }
            if (dayOfMonth<10){
                days="0"+dayOfMonth;
            }else {
                days=dayOfMonth+"";
            }
            tvStartChoose.setText(year + "-" +months + "-" + days);
        }, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        endPicker = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            if (month<9){
                months="0"+(month+1);
            }else {
                months=(month+1)+"";
            }
            if (dayOfMonth<10){
                days="0"+dayOfMonth;
            }else {
                days=dayOfMonth+"";
            }
            tvEndChoose.setText(year + "-" + months + "-" + days);
        }, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    protected void initListen() {

    }


    @OnClick({R.id.image_back, R.id.image_right, R.id.tv_start_choose, R.id.tv_end_choose, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_right:
                break;
            case R.id.tv_start_choose:
                startPicker.show();
                break;
            case R.id.tv_end_choose:
                endPicker.show();
                break;
            case R.id.tv_search:
                String s = tvStartChoose.getText().toString();
                String s1 = tvEndChoose.getText().toString();
                if (!s.equals("请选择")&&!s1.equals("请选择")){
                    llBot.setVisibility(View.VISIBLE);
                    tvStartEndTime.setText(tvStartChoose.getText().toString()+"-"+tvEndChoose.getText().toString());
                }else {
                    ToastShort("请选择");
                }

                break;
        }
    }


}
