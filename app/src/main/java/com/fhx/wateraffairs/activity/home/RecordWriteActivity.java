package com.fhx.wateraffairs.activity.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.activity.form.BarTourRecordActivity;
import com.fhx.wateraffairs.activity.form.ChannelRecordActivity;
import com.fhx.wateraffairs.activity.form.DispatchRecordActivity;
import com.fhx.wateraffairs.activity.form.FlowObservationActivity;
import com.fhx.wateraffairs.activity.form.GateHoistRecordActivity;
import com.fhx.wateraffairs.activity.form.GateHoistingCapacityActivity;
import com.fhx.wateraffairs.activity.form.PermeateVolumeActivity;
import com.fhx.wateraffairs.activity.form.ReservoirLevelActivity;
import com.fhx.wateraffairs.activity.form.ReservoirPrecipitationActivity;
import com.fhx.wateraffairs.activity.form.ReservoirRecordActivity;
import com.fhx.wateraffairs.activity.form.TempObservationActivity;
import com.fhx.wateraffairs.activity.form.WaterLockCheckActivity;
import com.fhx.wateraffairs.activity.form.WaterlockTourActivity;
import com.fhx.wateraffairs.adapter.RecordWriteAdapter;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class RecordWriteActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recycle_write)
    RecyclerView recycleWrite;

    RecordWriteAdapter adapter;
    List<String> itemList;

    @Override
    protected int initLayout() {
        return R.layout.activity_record_write;
    }

    @Override
    protected void initView() {
        tvTitle.setText("选择填写记录表");
    }

    @Override
    protected void initData() {
        itemList = new ArrayList<>();
        itemList.add("大坝巡视检查记录表");
        itemList.add("大坝表面水平位移、垂直位移观测记录表");
        itemList.add("渗透流量观测记录表（容积法）");
        itemList.add("渗透流量观测记录表（量水堰法）");
        itemList.add("水库水位观测记录表");
        itemList.add("水库降水量观测记录表");
        itemList.add("温度计观测记录表（气温）");
        itemList.add("温度计观测记录表（库水温）");
        itemList.add("流量观测记录表");
        itemList.add("水闸巡视检查记录表");
        itemList.add("水闸外观形态检测记录表");
        itemList.add("闸门启闭力检测记录表");
        itemList.add("启闭机考核记录表");
        itemList.add("渠道工程检查记录表");
        itemList.add("水库工程检查记录表");
        itemList.add("调度指令纪录表");


        recycleWrite.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecordWriteAdapter(itemList);
        recycleWrite.setAdapter(adapter);
    }

    @Override
    protected void initListen() {
        adapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (view.getId()) {
                case R.id.ll_item:
                    ToastShort(itemList.get(position));
                    CutToUtils instance = CutToUtils.getInstance();
                    switch (itemList.get(position)) {
                        case "大坝巡视检查记录表":
                            instance.JumpTo(RecordWriteActivity.this, BarTourRecordActivity.class);
                            break;
                        case "渗透流量观测记录表（容积法）":
                            instance.JumpToOne(RecordWriteActivity.this, PermeateVolumeActivity.class, "容积法");
                            break;
                        case "渗透流量观测记录表（量水堰法）":
                            instance.JumpToOne(RecordWriteActivity.this, PermeateVolumeActivity.class, "量水堰法");
                            break;
                        case "水库水位观测记录表":
                            instance.JumpTo(RecordWriteActivity.this, ReservoirLevelActivity.class);
                            break;
                        case "水库降水量观测记录表":
                            instance.JumpTo(RecordWriteActivity.this, ReservoirPrecipitationActivity.class);
                            break;
                        case "温度计观测记录表（气温）":
                            instance.JumpToOne(RecordWriteActivity.this, TempObservationActivity.class, "气温");
                            break;
                        case "温度计观测记录表（库水温）":
                            instance.JumpToOne(RecordWriteActivity.this, TempObservationActivity.class, "库水温");
                            break;
                        case "流量观测记录表":
                            instance.JumpToOne(RecordWriteActivity.this, FlowObservationActivity.class, "库水温");
                            break;
                        case "水闸巡视检查记录表":
                            instance.JumpTo(RecordWriteActivity.this, WaterlockTourActivity.class);
                            break;
                        case "水闸外观形态检测记录表":
                            instance.JumpTo(RecordWriteActivity.this, WaterLockCheckActivity.class);
                            break;
                        case "闸门启闭力检测记录表":
                            instance.JumpTo(RecordWriteActivity.this, GateHoistingCapacityActivity.class);
                            break;
                        case "启闭机考核记录表":
                            instance.JumpTo(RecordWriteActivity.this, GateHoistRecordActivity.class);
                            break;
                        case "渠道工程检查记录表":
                            instance.JumpTo(RecordWriteActivity.this, ChannelRecordActivity.class);
                            break;
                        case "水库工程检查记录表":
                            instance.JumpTo(RecordWriteActivity.this, ReservoirRecordActivity.class);
                            break;
                        case "调度指令纪录表":
                            instance.JumpTo(RecordWriteActivity.this, DispatchRecordActivity.class);
                            break;
                    }
                    break;
            }
        });
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
