package com.fhx.wateraffairs.activity.video;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.adapter.MonitorVideoListAdapter;
import com.fhx.wateraffairs.base.AppUrl;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.bean.MonitorVideoListBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 视频监控列表
 */
public class MonitorVideoListActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.image_zyl)
    ImageView imageZyl;
    @BindView(R.id.image_hhl)
    ImageView imageHhl;
    @BindView(R.id.image_yxl)
    ImageView imageYxl;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recycle_zyl)
    RecyclerView recycleList;
    @BindView(R.id.recycle_hhl)
    RecyclerView recycleHhlList;
    @BindView(R.id.recycle_yxl)
    RecyclerView recycleYxlList;
    private MonitorVideoListBean monitorVideoListBean;
    private MonitorVideoListAdapter adapter;
    private MonitorVideoListAdapter Hhladapter;
    private MonitorVideoListAdapter YXladapter;
    private List<MonitorVideoListBean.DataBean.AllVideoUrlBean> allVideoUrl;
    private List<MonitorVideoListBean.DataBean.AllVideoUrlBean> allZyl;
    private List<MonitorVideoListBean.DataBean.AllVideoUrlBean> allHhl;
    private List<MonitorVideoListBean.DataBean.AllVideoUrlBean> allYxl;

    private int zyl=0,hhl=0,yxl=0;
    @Override
    protected int initLayout() {
        return R.layout.activity_monitor_list;
    }

    @Override
    protected void initView() {
        tvTitle.setText("监控列表");
    }

    @Override
    protected void initData() {

        recycleList.setLayoutManager(new GridLayoutManager(this,2));
        recycleHhlList.setLayoutManager(new GridLayoutManager(this,2));
        recycleYxlList.setLayoutManager(new GridLayoutManager(this,2));
        getMonitorList();
    }

    @Override
    protected void initListen() {

    }



    @OnClick({R.id.image_back,R.id.ll_zyl,R.id.ll_hhl,R.id.ll_yxl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.ll_zyl:
                if (zyl==0){
                    imageZyl.setImageResource(R.mipmap.icon_item_down);
                    recycleList.setVisibility(View.VISIBLE);
                    zyl=1;
                }else {
                    imageZyl.setImageResource(R.mipmap.icon_item_right);
                    recycleList.setVisibility(View.GONE);
                    zyl=0;
                }
                break;
            case R.id.ll_hhl:
                if (hhl==0){
                    imageHhl.setImageResource(R.mipmap.icon_item_down);
                    recycleHhlList.setVisibility(View.VISIBLE);
                    hhl=1;
                }else {
                    imageHhl.setImageResource(R.mipmap.icon_item_right);
                    recycleHhlList.setVisibility(View.GONE);
                    hhl=0;
                }
                break;
            case R.id.ll_yxl:
                if (yxl==0){
                    imageYxl.setImageResource(R.mipmap.icon_item_down);
                    recycleYxlList.setVisibility(View.VISIBLE);
                    yxl=1;
                }else {
                    imageYxl.setImageResource(R.mipmap.icon_item_right);
                    recycleYxlList.setVisibility(View.GONE);
                    yxl=0;
                }
                break;
        }
    }

    private void getMonitorList() {
        EasyHttp.get(AppUrl.VideoVideos)
                .timeStamp(true)
                .syncRequest(false)
                .headers("token",mmkv.decodeString("token"))
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                     ToastShort("请求失败");
                    }

                    @Override
                    public void onSuccess(String s) {
                        monitorVideoListBean = JSON.parseObject(s, MonitorVideoListBean.class);
                    if (monitorVideoListBean.isStatus()){
                        allVideoUrl = monitorVideoListBean.getData().getAllVideoUrl();
                        allZyl =new ArrayList<>();
                        allZyl.clear();

                        for (int i = 0; i < 5; i++) {
                            allZyl.add(allVideoUrl.get(i));
                        }
                        adapter =new MonitorVideoListAdapter(allZyl, MonitorVideoListActivity.this);
                        recycleList.setAdapter(adapter);
                        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                            @Override
                            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                item(allZyl,position);
                            }
                        });

                        allHhl =new ArrayList<>();
                        allHhl.clear();
                        for (int i = 0; i < 5; i++) {
                            allHhl.add(allVideoUrl.get(i+5));
                        }
                        Hhladapter =new MonitorVideoListAdapter(allHhl,MonitorVideoListActivity.this);
                        recycleHhlList.setAdapter(Hhladapter);
                        Hhladapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                        Hhladapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                            @Override
                            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                item(allHhl,position);
                            }
                        });

                        allYxl =new ArrayList<>();
                        allYxl.clear();
                        for (int i = 0; i < allVideoUrl.size(); i++) {
                            if (i>9){
                                allYxl.add(allVideoUrl.get(i));
                            }
                        }
                        YXladapter =new MonitorVideoListAdapter(allYxl,MonitorVideoListActivity.this);
                        recycleYxlList.setAdapter(YXladapter);
                        YXladapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                        YXladapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                            @Override
                            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                item(allYxl,position);
                            }
                        });
                    }
                    }
                });
    }

    private void item(List<MonitorVideoListBean.DataBean.AllVideoUrlBean> bean,int i){
        String videourl = bean.get(i).getVideourl();
        String videotype = bean.get(i).getVideotype();
        if (videotype.equals("hknvr")) {
            if (videourl != null && !videourl.equals("")) {
                Intent intent = new Intent(MonitorVideoListActivity.this, MonitorVideoActivity.class);
                intent.putExtra("videoname", bean.get(i).getVideoname());
                intent.putExtra("videourl", videourl);
                intent.putExtra("videoid", bean.get(i).getVideoid());
                intent.putExtra("historyurl", bean.get(i).getHistoryurl());
                startActivity(intent);
            } else {
                ToastShort("未获取到摄像头状态");
            }
        } else if (videotype.equals("ezopen")){
            Intent intent = new Intent(MonitorVideoListActivity.this, EzOpenActivity.class);
            intent.putExtra("accesstoken", bean.get(i).getAccesstoken());
            intent.putExtra("videourl", bean.get(i).getVideourl());
            startActivity(intent);
            Log.e("fhxxEZOPEN",bean.get(i).getAccesstoken()+"\n"
                    +bean.get(i).getVideourl());
        }
    }

}
