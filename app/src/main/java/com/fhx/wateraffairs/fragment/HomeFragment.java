package com.fhx.wateraffairs.fragment;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.activity.home.ContactsActivity;
import com.fhx.wateraffairs.activity.home.MessageActivity;
import com.fhx.wateraffairs.activity.home.MonitoringActivity;
import com.fhx.wateraffairs.activity.home.NewsNotifyActivity;
import com.fhx.wateraffairs.activity.home.ProjectInformationActivity;
import com.fhx.wateraffairs.activity.home.ReportedInformationActivity;
import com.fhx.wateraffairs.activity.home.WaterCollectActivity;
import com.fhx.wateraffairs.activity.patrol.AnomalyRecordActivity;
import com.fhx.wateraffairs.activity.patrol.AnomalyRecordMsgActivity;
import com.fhx.wateraffairs.adapter.AnomalyRecordAdapter;
import com.fhx.wateraffairs.base.BaseFragment;
import com.fhx.wateraffairs.bean.AnomalyRecordBean;
import com.fhx.wateraffairs.dialog.TipDialog;
import com.fhx.wateraffairs.utils.CutToUtils;
import com.to.aboomy.banner.Banner;
import com.to.aboomy.banner.HolderCreator;
import com.to.aboomy.banner.IndicatorView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.recycle_recode)
    RecyclerView recycleRecode;

    private List<String> imageList = new ArrayList<>();
    private AnomalyRecordAdapter anomalyRecordAdapter;
    private List<AnomalyRecordBean> adapterList = new ArrayList<>();
    private CutToUtils cutTo;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        cutTo = CutToUtils.getInstance();
        imageList.clear();
        imageList.add("http://pic.netbian.com/uploads/allimg/201229/220230-1609250550f18c.jpg");
        imageList.add("http://pic.netbian.com/uploads/allimg/201221/233225-1608564745f480.jpg");
        imageList.add("http://pic.netbian.com/uploads/allimg/201231/180633-160940919351b9.jpg");
        setBanner();
        setAdapter();

    }

    private void setAdapter() {
        adapterList.clear();
        for (int i = 0; i < 5; i++) {
            adapterList.add(new AnomalyRecordBean(i, "这是标题" + i, "这是我的msg" + i, "1-" + i));
        }
        anomalyRecordAdapter = new AnomalyRecordAdapter(adapterList);
        recycleRecode.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleRecode.setAdapter(anomalyRecordAdapter);
        anomalyRecordAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CutToUtils.getInstance().JumpTo(getActivity(), AnomalyRecordMsgActivity.class);
            }
        });
    }

    private void setBanner() {
        //自定义indicator的位置
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.bottomMargin = dip2px(40);

        //使用内置Indicator
        IndicatorView qyIndicator = new IndicatorView(getContext())
                .setIndicatorColor(Color.DKGRAY)
                .setIndicatorSelectorColor(Color.WHITE)
                .setParams(params);

        banner.setIndicator(qyIndicator)
                .setRoundCorners(5)
                .setHolderCreator(new ImageHolderCreator())
                .setPages(imageList);
    }


    private int dip2px(float dp) {
        return (int) (dp * getContext().getResources().getDisplayMetrics().density);
    }

    @OnClick({R.id.ll_message, R.id.ll_notify, R.id.ll_monitor, R.id.ll_water_collect,
            R.id.ll_reported, R.id.ll_project, R.id.ll_contact,R.id.image_anomalyRecord})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_message:
                cutTo.JumpTo(getActivity(), MessageActivity.class);
                break;
            case R.id.ll_notify:
                cutTo.JumpTo(getActivity(), NewsNotifyActivity.class);
                break;
            case R.id.ll_monitor:
                cutTo.JumpTo(getActivity(), MonitoringActivity.class);
                break;
            case R.id.ll_water_collect:
                cutTo.JumpTo(getActivity(), WaterCollectActivity.class);
                break;
            case R.id.ll_reported:
                cutTo.JumpTo(getActivity(), ReportedInformationActivity.class);
                break;
            case R.id.ll_project:
                cutTo.JumpTo(getActivity(), ProjectInformationActivity.class);
                break;
            case R.id.ll_contact:
                cutTo.JumpTo(getActivity(), ContactsActivity.class);
                break;
            case R.id.image_anomalyRecord:
                cutTo.JumpTo(getActivity(), AnomalyRecordActivity.class);
                break;
        }
    }

    //banner监听
    public class ImageHolderCreator implements HolderCreator {
        @Override
        public View createView(final Context context, final int index, Object o) {
            ImageView iv = new ImageView(context);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(getContext()).load(o).into(iv);
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
