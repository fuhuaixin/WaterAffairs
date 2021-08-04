package com.fhx.wateraffairs.activity.video;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.adapter.ReBackVidioAdapter;
import com.fhx.wateraffairs.base.AppUrl;
import com.fhx.wateraffairs.bean.ReBackVidioListBean;
import com.fhx.wateraffairs.dialog.DateSingleDialog;
import com.fhx.wateraffairs.utils.DateUtil;
import com.tencent.mmkv.MMKV;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import java.util.List;

/**
 * 回放列表
 */
public class RebackVidioListActivity extends Activity implements View.OnClickListener {

    private TextView tvTitle, tv_today, tv_choose_data;
    private ImageView imageBack, image_right;
    private RecyclerView recycle_reback;
    private ReBackVidioAdapter reBackVidioAdapter;
    private String backId, strHis;
    private DateSingleDialog singleDialog;
    public ZLoadingDialog zLoadingDialog;
    public MMKV mmkv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vidio_reback);
        mmkv=MMKV.defaultMMKV();
        dialog();
        zLoadingDialog.show();
        backId = getIntent().getStringExtra("backId");
        strHis = getIntent().getStringExtra("historyurl");
        initViews();
        initData();
        getVidio(backId, DateUtil.getCurDate("yyyy-MM-dd"));
    }

    private void initViews() {
        tvTitle = findViewById(R.id.tv_title);
        imageBack = findViewById(R.id.image_back);
        image_right = findViewById(R.id.image_right);
        recycle_reback = findViewById(R.id.recycle_reback);
        tv_today = findViewById(R.id.tv_today);
        tv_choose_data = findViewById(R.id.tv_choose_data);

        imageBack.setOnClickListener(this);
        tv_today.setOnClickListener(this);
        image_right.setOnClickListener(this);
        tv_choose_data.setOnClickListener(this);
    }

    private void initData() {
        tvTitle.setText("回放列表");
        image_right.setVisibility(View.VISIBLE);
        image_right.setImageResource(R.mipmap.icon_calendar);
        recycle_reback.setLayoutManager(new LinearLayoutManager(this));
        singleDialog = new DateSingleDialog(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_today:
                getVidio(backId, DateUtil.getCurDate("yyyy-MM-dd"));
                break;
            case R.id.image_back:
                finish();
                break;
            case R.id.image_right:
            case R.id.tv_choose_data:
                singleDialog.show();
                Window window = singleDialog.getWindow();
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.gravity = Gravity.CENTER;
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                singleDialog.getWindow().setAttributes(lp);

                CalendarView calendarView = singleDialog.findViewById(R.id.calendarView);
                calendarView.setOnCalendarSelectListener(new CalendarView.OnCalendarSelectListener() {
                    @Override
                    public void onCalendarOutOfRange(Calendar calendar) {

                    }

                    @Override
                    public void onCalendarSelect(Calendar calendar, boolean isClick) {
                        getVidio(backId, calendar.getYear() + "-" + calendar.getMonth() + "-" + calendar.getDay());
                    }
                });

                break;

        }
    }

    /**
     * 获取回放列表
     *
     * @param id
     * @param data
     */
    private void getVidio(final String id, String data) {
        EasyHttp.get(AppUrl.HistoryDatesDetial)
                .params("videoId", id)
                .params("time", data)
                .headers("token",mmkv.decodeString("token"))
                .syncRequest(false)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        zLoadingDialog.dismiss();
                        Toast.makeText(RebackVidioListActivity.this, "请求失败，请稍后再试", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onSuccess(String s) {
                        final ReBackVidioListBean reBackVidioListBean = JSON.parseObject(s, ReBackVidioListBean.class);
                        zLoadingDialog.dismiss();
                        if (reBackVidioListBean.isStatus() && reBackVidioListBean.getData() != null) {
                            final List<ReBackVidioListBean.DataBean> data1 = reBackVidioListBean.getData();
                            reBackVidioAdapter = new ReBackVidioAdapter(R.layout.item_reback_vidio, data1);
                            recycle_reback.setAdapter(reBackVidioAdapter);
                            reBackVidioAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                                @Override
                                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                    switch (view.getId()) {
                                        case R.id.ll_item:
                                            Intent intent = new Intent(RebackVidioListActivity.this, ReBackVidioActivity.class);
                                            intent.putExtra("videoId", backId);
                                            intent.putExtra("startTime", data1.get(position).getStartTime());
                                            intent.putExtra("endTime", data1.get(position).getEndTime());
                                            intent.putExtra("historyurl", strHis);
                                            startActivity(intent);
                                            break;
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(RebackVidioListActivity.this, "列表请求失败，请稍后再试", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    /**
     * dialog相关
     */
    public void dialog() {
        zLoadingDialog = new ZLoadingDialog(this);
        zLoadingDialog.setLoadingBuilder(Z_TYPE.CIRCLE_CLOCK)
                .setLoadingColor(Color.parseColor("#eeeeee"))
                .setHintText("加载中...")
                .setHintTextSize(14F)
                .setHintTextColor(Color.parseColor("#eeeeee"))
                .setDialogBackgroundColor(Color.parseColor("#CC111111"))
                .setDurationTime(1.3);
    }
}
