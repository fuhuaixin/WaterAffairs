package com.fhx.wateraffairs.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 个人中心修改密码
 */
public class ChangePassWordActivity extends BaseActivity {

    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_change_one)
    EditText etChangeOne;
    @BindView(R.id.et_change_two)
    EditText etChangeTwo;
    @BindView(R.id.tv_commit)
    TextView tvCommit;

    @Override
    protected int initLayout() {
        return R.layout.activity_change_password;
    }

    @Override
    protected void initView() { }

    @Override
    protected void initData() {
        tvTitle.setText("修改密码");
    }

    @Override
    protected void initListen() {

    }


    @OnClick({R.id.image_back,R.id.tv_commit})
    public void onImageBackClicked(View view) {
        switch (view.getId()){
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.tv_commit:

                break;
        }
    }


}
