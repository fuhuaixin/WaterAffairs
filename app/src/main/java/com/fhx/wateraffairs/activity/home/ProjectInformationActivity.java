package com.fhx.wateraffairs.activity.home;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.adapter.ProjectInformationAdapter;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.bean.ProjectInformationBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 工程信息
 */
public class ProjectInformationActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recycle_project)
    RecyclerView recycleProject;

    private ProjectInformationAdapter adapter;
    private List<ProjectInformationBean> mList = new ArrayList<>();
    private List<ProjectInformationBean.ItemBean> mItem1 = new ArrayList<>();
    private List<ProjectInformationBean.ItemBean> mItem2 = new ArrayList<>();
    private List<ProjectInformationBean.ItemBean> mItem3 = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_project_information;
    }

    @Override
    protected void initView() {
        tvTitle.setText("工程信息");
    }

    @Override
    protected void initData() {
        mItem1.add(new ProjectInformationBean.ItemBean("灌区类型：","大灌区"));
        mItem1.add(new ProjectInformationBean.ItemBean("灌区规模：","中型A类"));
        mItem1.add(new ProjectInformationBean.ItemBean("灌区面积：","367563.58  m³"));

        mItem2.add(new ProjectInformationBean.ItemBean("总干渠：","367.58  m³/s"));
        mItem2.add(new ProjectInformationBean.ItemBean("东风支渠：","67.38  m³"));
        mItem2.add(new ProjectInformationBean.ItemBean("北宸支渠：","67.38  m³"));

        mList.add(new ProjectInformationBean(false, "灌区信息", mItem1));
        mList.add(new ProjectInformationBean(false, "渠道", mItem2));
        mList.add(new ProjectInformationBean(false, "渠道生产交通桥", mItem3));
        mList.add(new ProjectInformationBean(false, "涵闸", mItem3));
        mList.add(new ProjectInformationBean(false, "水闸", mItem3));
        mList.add(new ProjectInformationBean(false, "缆式量水设备", mItem3));
        mList.add(new ProjectInformationBean(false, "涵洞", mItem3));
        mList.add(new ProjectInformationBean(false, "倒虹吸", mItem3));
        mList.add(new ProjectInformationBean(false, "渡槽", mItem3));

        recycleProject.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProjectInformationAdapter(mList);
        recycleProject.setAdapter(adapter);

        LayoutInflater inflater = LayoutInflater.from(this);
        View headerView = inflater.inflate(R.layout.adapter_project_information_header,null);

        adapter.addHeaderView(headerView);
    }

    @Override
    protected void initListen() {
        adapter.setOnItemChildClickListener((adapter, view, position) -> {
            for (int i = 0; i < mList.size(); i++) {
                if (i != position) {
                    mList.get(i).setIfOpen(false);
                }
            }
            if (mList.get(position).isIfOpen()) {
                mList.get(position).setIfOpen(false);
            } else {
                mList.get(position).setIfOpen(true);
            }
            adapter.notifyDataSetChanged();
        });
    }


    @OnClick({R.id.image_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
        }
    }
}
