package com.fhx.wateraffairs.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.activity.home.ContactsActivity;
import com.fhx.wateraffairs.activity.mine.ChangePassWordActivity;
import com.fhx.wateraffairs.activity.mine.MineComplainActivity;
import com.fhx.wateraffairs.activity.mine.PersonMesActivity;
import com.fhx.wateraffairs.adapter.MineListAdapter;
import com.fhx.wateraffairs.base.BaseFragment;
import com.fhx.wateraffairs.bean.MineListBean;
import com.fhx.wateraffairs.utils.CutToUtils;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MineFragment extends BaseFragment {
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_job)
    TextView tvJob;
    @BindView(R.id.rl_header)
    RelativeLayout rlHeader;
    @BindView(R.id.recycle_mine)
    RecyclerView recycleMine;

    private MineListAdapter mineListAdapter;
    private List<MineListBean> mineListBeanList = new ArrayList<>();

    @Override
    public int setLayoutId() {
        return R.layout.fragment_mine;
    }


    @Override
    public void setViewData(View view) {
        super.setViewData(view);
        ImmersionBar.with(this)
                .reset()
                .init();
        mineListBeanList.clear();
        mineListBeanList.add(new MineListBean("通讯录", R.mipmap.icon_mine_contacts, false));
        mineListBeanList.add(new MineListBean("修改密码", R.mipmap.icon_mine_chager, false));
        mineListBeanList.add(new MineListBean("检查更新", R.mipmap.icon_mine_check, true));
        mineListBeanList.add(new MineListBean("投诉反馈", R.mipmap.icon_mine_complain, false));
        mineListBeanList.add(new MineListBean("关于我们", R.mipmap.icon_mine_about, false));
        mineListAdapter = new MineListAdapter(mineListBeanList);
        recycleMine.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleMine.setAdapter(mineListAdapter);
    }


    @OnClick(R.id.rl_header)
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.rl_header:
                CutToUtils.getInstance().JumpTo(getActivity(), PersonMesActivity.class);
                break;
        }
    }

    @Override
    public void setClickEvent(View view) {
        super.setClickEvent(view);

        mineListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (mineListBeanList.get(position).getName()) {
                    case "通讯录":
                        CutToUtils.getInstance().JumpTo(getActivity(), ContactsActivity.class);
                        break;
                    case "修改密码":
                        CutToUtils.getInstance().JumpTo(getActivity(), ChangePassWordActivity.class);
                        break;
                    case "检查更新":

                        break;
                    case "投诉反馈":
                        CutToUtils.getInstance().JumpTo(getActivity(), MineComplainActivity.class);
                        break;
                    case "关于我们":

                        break;
                }

            }
        });


    }

}
