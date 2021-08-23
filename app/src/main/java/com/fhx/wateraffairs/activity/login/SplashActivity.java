package com.fhx.wateraffairs.activity.login;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.utils.CutToUtils;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 启动页
 */
public class SplashActivity extends BaseActivity {

    @BindView(R.id.image_text)
    ImageView imageText;

    @Override
    protected int initLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        ImmersionBar.with(this)
                .reset()
                .init();
    }

    @Override
    protected void initData() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(2000);
        animationSet.addAnimation(alphaAnimation);
        imageText.setAnimation(animationSet);

        new Handler().postDelayed(new Runnable() {
            public void run() {
//                if (mmkv.decodeString("userPhone")!=null&& !TextUtils.isEmpty(mmkv.decodeString("userPhone"))
//                        &&mmkv.decodeString("password")!=null &&!TextUtils.isEmpty(mmkv.decodeString("password"))){
//                    autoLogin();
//                }else {
//
//                }
                finish();
                CutToUtils.getInstance().JumpTo(SplashActivity.this, LoginActivity.class);
            }
        }, 2000);
    }

    @Override
    protected void initListen() {

    }

}
