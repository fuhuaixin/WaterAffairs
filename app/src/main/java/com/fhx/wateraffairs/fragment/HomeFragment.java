package com.fhx.wateraffairs.fragment;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.activity.home.ContactsActivity;
import com.fhx.wateraffairs.activity.home.MessageActivity;
import com.fhx.wateraffairs.activity.home.RecordWriteActivity;
import com.fhx.wateraffairs.activity.video.MonitorVideoListActivity;
import com.fhx.wateraffairs.activity.home.MonitoringActivity;
import com.fhx.wateraffairs.activity.home.NewsNotifyActivity;
import com.fhx.wateraffairs.activity.home.ProjectInformationActivity;
import com.fhx.wateraffairs.activity.home.ReportedInformationActivity;
import com.fhx.wateraffairs.activity.home.WaterCollectActivity;
import com.fhx.wateraffairs.activity.patrol.AnomalyRecordActivity;
import com.fhx.wateraffairs.activity.patrol.AnomalyRecordMsgActivity;
import com.fhx.wateraffairs.activity.patrol.PatrolRecordActivity;
import com.fhx.wateraffairs.adapter.AnomalyRecordAdapter;
import com.fhx.wateraffairs.base.AppUrl;
import com.fhx.wateraffairs.base.BaseFragment;
import com.fhx.wateraffairs.bean.AnomalyRecordBean;
import com.fhx.wateraffairs.bean.HomeMessageBean;
import com.fhx.wateraffairs.utils.CutToUtils;
import com.gyf.immersionbar.ImmersionBar;
import com.to.aboomy.banner.Banner;
import com.to.aboomy.banner.HolderCreator;
import com.to.aboomy.banner.IndicatorView;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.recycle_recode)
    RecyclerView recycleRecode;
    @BindView(R.id.tv_news_one)
    TextView tv_news_one;
    @BindView(R.id.tv_news_two)
    TextView tv_news_two;


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
        ImmersionBar.with(this)
                .statusBarColor(R.color.white)
                .statusBarDarkFont(true)
                .navigationBarDarkIcon(true)
                .fitsSystemWindows(true)
                .init();
        cutTo = CutToUtils.getInstance();
        imageList.clear();
        imageList.add("http://pic.netbian.com/uploads/allimg/201229/220230-1609250550f18c.jpg");
        imageList.add("http://pic.netbian.com/uploads/allimg/201221/233225-1608564745f480.jpg");
        imageList.add("http://pic.netbian.com/uploads/allimg/201231/180633-160940919351b9.jpg");
        setBanner();
        setAdapter();
        getNoticeList();
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

    @OnClick({R.id.ll_message, R.id.ll_location, R.id.rl_notify, R.id.ll_monitor, R.id.ll_water_collect,
            R.id.ll_reported, R.id.ll_project, R.id.ll_contact, R.id.image_anomalyRecord, R.id.ll_patrol_record})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_message:
                cutTo.JumpTo(getActivity(), MessageActivity.class);
                break;
            case R.id.rl_notify:
                cutTo.JumpTo(getActivity(), NewsNotifyActivity.class);
                break;
            case R.id.ll_location:

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
                cutTo.JumpTo(getActivity(), MonitorVideoListActivity.class);
                break;
            case R.id.image_anomalyRecord:
                cutTo.JumpTo(getActivity(), AnomalyRecordActivity.class);
                break;
            case R.id.ll_patrol_record:
//                cutTo.JumpTo(getActivity(), PatrolRecordActivity.class);
                cutTo.JumpTo(getActivity(), RecordWriteActivity.class);
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

    private void getNoticeList() {
        EasyHttp.get(AppUrl.NoticeList)
                .params("pageNum", "1")
                .params("pageSize", "2")
                .headers("Authorization", mmkv.decodeString("token"))
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        HomeMessageBean bean = JSON.parseObject(s, HomeMessageBean.class);
                        if (bean.isSuccess()) {
                            List<HomeMessageBean.DataBean.RecordsBean> records = bean.getData().getRecords();
                            if (records.size() >= 2) {
                                tv_news_one.setText(records.get(0).getNewsContent());
                                tv_news_two.setText(records.get(1).getNewsContent());

                            }
                        }
                    }
                });
    }

}
