package com.fhx.wateraffairs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.fhx.wateraffairs.activity.patrol.PatrolActivity;
import com.fhx.wateraffairs.fragment.HomeFragment;
import com.fhx.wateraffairs.fragment.InspectionFragment;
import com.fhx.wateraffairs.fragment.MineFragment;
import com.fhx.wateraffairs.utils.CutToUtils;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg_home;
    private RadioButton rb_home;
    private RadioButton rb_scan;
    private RadioButton rb_mine;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onResume() {
        super.onResume();
        //其他权限
        applyWritePermission();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //沉浸式
        ImmersionBar.with(this)
                .statusBarColor(R.color.white)
                .statusBarDarkFont(true)
                .navigationBarDarkIcon(true)
                .fitsSystemWindows(true)
                .init();
        initView();
        initData();
        initListener();
    }


    /**
     * 所有绑定
     */

    private void initView() {
        rg_home = findViewById(R.id.rg_home);
        rb_home = findViewById(R.id.rb_home);
        rb_scan = findViewById(R.id.rb_scan);
        rb_mine = findViewById(R.id.rb_mine);

    }


    /**
     * 所有数据处理
     */
    private void initData() {

        fragments.add(new HomeFragment());
        fragments.add(new InspectionFragment());
        fragments.add(new MineFragment());

        SwitchFragment(0);
    }


    /**
     * 申请权限
     */
    public void applyWritePermission() {
        String[] permissions = new String[]{Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.VIBRATE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION};
        if (Build.VERSION.SDK_INT >= 23) {
            for (int i = 0; i < permissions.length; i++) {
                if (ContextCompat.checkSelfPermission(this, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, permissions, 1);
                }
            }
          /*  if (ContextCompat.checkSelfPermission(this, permissions[0]) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(this, permissions[1]) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(this, permissions[2]) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(this, permissions[3]) != PackageManager.PERMISSION_GRANTED) {

            }*/
        }

    }


    /**
     * 所有监听
     */
    boolean ischecked = true;

    private void initListener() {

        rg_home.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rb_home.setChecked(false);
                rb_scan.setChecked(false);
                rb_mine.setChecked(false);
                switch (checkedId) {
                    case R.id.rb_home:
                        ischecked = true;
                        rb_home.setChecked(true);
                        SwitchFragment(0);
                        break;
                    case R.id.rb_scan:
                        if (ischecked) {
                            rb_home.setChecked(true);
                        } else {
                            rb_mine.setChecked(true);
                        }
//                        SwitchFragment(1);
                        CutToUtils.getInstance().JumpTo(MainActivity.this, PatrolActivity.class);
                        break;
                    case R.id.rb_mine:
                        ischecked = false;
                        rb_mine.setChecked(true);
                        SwitchFragment(2);
                        break;
                }
            }
        });


    }


    public void SwitchFragment(int i) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragments.get(i));
        fragmentTransaction.commit();
    }


    /**
     * 两次点击退出
     */
    private static final int TIME_EXIT = 2000;
    private long mBackPressed;

    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_EXIT > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(this, "再点击一次返回退出程序", Toast.LENGTH_SHORT).show();
            mBackPressed = System.currentTimeMillis();
        }
    }


}
