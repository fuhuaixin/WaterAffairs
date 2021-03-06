package com.fhx.wateraffairs.activity.login;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fhx.wateraffairs.MainActivity;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.utils.CutToUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录界面
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.image_user)
    ImageView imageUser;
    @BindView(R.id.edit_user)
    EditText editUser;
    @BindView(R.id.image_user_del)
    ImageView imageUserDel;
    @BindView(R.id.ll_user)
    LinearLayout llUser;
    @BindView(R.id.image_password)
    ImageView imagePassword;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.image_password_del)
    ImageView imagePasswordDel;
    @BindView(R.id.ll_password)
    LinearLayout llPassword;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListen() {
        editUser.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    llUser.setBackgroundResource(R.drawable.shape_user_sel_bg);
                    llPassword.setBackgroundResource(R.drawable.shape_user_unsel_bg);
                    imageUser.setImageResource(R.mipmap.icon_user_sel);
                    imagePassword.setImageResource(R.mipmap.icon_password_unsel);
                }
            }
        });

        editUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    imageUserDel.setVisibility(View.VISIBLE);
                } else {
                    imageUserDel.setVisibility(View.GONE);
                }
            }
        });


        editPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    llUser.setBackgroundResource(R.drawable.shape_user_unsel_bg);
                    llPassword.setBackgroundResource(R.drawable.shape_user_sel_bg);
                    imageUser.setImageResource(R.mipmap.icon_user_unsel);
                    imagePassword.setImageResource(R.mipmap.icon_password_sel);
                }
            }
        });

        editPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    imagePasswordDel.setVisibility(View.VISIBLE);
                } else {
                    imagePasswordDel.setVisibility(View.GONE);
                }
            }
        });
    }

    @OnClick({R.id.tv_login,R.id.image_user_del,R.id.image_password_del,R.id.tv_forget})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.tv_login:
                if (editUser.getText().toString().equals("")) {
                    ToastShort("请输入账号");
                    return;
                }
                if (editPassword.getText().toString().equals("")) {
                    ToastShort("请输入密码");
                    return;
                }
                finish();
                CutToUtils.getInstance().JumpTo(LoginActivity.this, MainActivity.class);
                break;

            case R.id.image_user_del:
                editUser.setText("");
                break;
            case R.id.image_password_del:
                editPassword.setText("");
                break;
            case R.id.tv_forget:
               ToastShort("忘记密码");

                break;
        }
    }
}
