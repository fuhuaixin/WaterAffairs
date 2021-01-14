package com.fhx.wateraffairs.activity.mine;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人中心 投诉反馈
 */
public class MineComplainActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_complain)
    EditText etComplain;
    @BindView(R.id.tv_edit_size)
    TextView tvEditSize;
    @BindView(R.id.tv_commit)
    TextView tvCommit;


    @Override
    protected int initLayout() {
        return R.layout.activity_mine_complain;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        tvTitle.setText("投诉反馈");
    }

    @Override
    protected void initListen() {
        etComplain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("fhxx", s.toString());
                tvEditSize.setText(s.length() + "/200");
            }
        });
    }

    @OnClick({R.id.image_back,R.id.tv_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.tv_commit:
                ToastShort("提交");
                break;
        }
    }


}
