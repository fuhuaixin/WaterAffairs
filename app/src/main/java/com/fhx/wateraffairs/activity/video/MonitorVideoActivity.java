package com.fhx.wateraffairs.activity.video;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.utils.DeviceUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

/**
 * 视频播放1
 */
public class MonitorVideoActivity extends BaseActivity {


    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.image_right)
    ImageView imageRight;
    @BindView(R.id.ll_title)
    LinearLayout llTitle;
    @BindView(R.id.top_part_live_activity)
    LinearLayout topPartLiveActivity;
    @BindView(R.id.vitamio)
    VideoView vitamio;
    @BindView(R.id.image_stop)
    ImageView imageStop;
    @BindView(R.id.image_scale)
    ImageView imageScale;
    @BindView(R.id.ll_bot)
    RelativeLayout llBot;
    @BindView(R.id.fl_video_view_live_activity)
    FrameLayout flVideoViewLiveActivity;
    @BindView(R.id.seekBar)
    SeekBar seekBar;
    @BindView(R.id.tv_monitor_title)
    TextView tvMonitorTitle;
    @BindView(R.id.ll_reback_vidio)
    LinearLayout llRebackVidio;
    @BindView(R.id.bottom_part_live_activity)
    LinearLayout bottomPartLiveActivity;
    private String strTitle = "", strUrl = "", strId = "", strHis = "";
    private int isStop = 0;


    @Override
    protected int initLayout() {
        return R.layout.activity_monitor_video;
    }

    @Override
    protected void initView() {
        Vitamio.isInitialized(this);
        strTitle = getIntent().getStringExtra("videoname");
        strUrl = getIntent().getStringExtra("videourl");
        strId = getIntent().getStringExtra("videoid");
        strHis = getIntent().getStringExtra("historyurl");
        dialog();
        zLoadingDialog.show();
    }

    @Override
    protected void initData() {
        tvTitle.setText("监控播放");
        tvMonitorTitle.setText(strTitle);

        vitamio.setVideoURI(Uri.parse(strUrl));
        vitamio.start();
//
        vitamio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                //此处设置播放速度为正常速度1
//                mediaPlayer.setPlaybackSpeed(1.0f);
                zLoadingDialog.dismiss();

                isStop = 1;

            }
        });
        vitamio.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                ToastShort("播放失败");
                zLoadingDialog.dismiss();

                return false;
            }
        });

    }

    @Override
    protected void initListen() {
        vitamio.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.ACTION_DOWN == event.getAction()) {
                    if (isScreenClear) {
                        isScreenClear = false;
                        llBot.setVisibility(View.VISIBLE);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (!isScreenClear) {
                                    isScreenClear = true;
                                    llBot.setVisibility(View.GONE);
                                }
                            }
                        }, 3000);
                    } else {
                        isScreenClear = true;
                        llBot.setVisibility(View.GONE);
                    }
                }
                return true;
            }
        });
    }



    @OnClick({R.id.image_back, R.id.image_stop, R.id.image_scale,R.id.ll_reback_vidio})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_stop:
                if (isStop == 0) {
                    vitamio.start();
                    isStop = 1;
                    imageStop.setImageResource(R.mipmap.icon_vidio_stop);
                } else {
                    vitamio.pause();
                    isStop = 0;
                    imageStop.setImageResource(R.mipmap.icon_vidio_start);
                }
                break;
            case R.id.image_scale:
                if (!isFullScreen) {
                    setFullScreen();
                } else {
                    setVideoPreview();
                }
                break;
            case R.id.ll_reback_vidio:
                Intent intent = new Intent(MonitorVideoActivity.this, RebackVidioListActivity.class);
                intent.putExtra("backId", strId);
                intent.putExtra("historyurl", strHis);
                startActivity(intent);
                break;
        }
    }

    /**
     * 设置视频全屏
     */
    private boolean isScreenClear = true;
    private boolean isFullScreen;

    private void setFullScreen() {
        LinearLayout.LayoutParams fullScreenLLP = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//        LinearLayout.LayoutParams fullScreenLLP = new LinearLayout.LayoutParams(
//                DeviceUtil.getHeightPixel(this), DeviceUtil.getWidthPixel(this) - DeviceUtil.getStatusBarHeight(this));

        topPartLiveActivity.setVisibility(View.GONE);
        bottomPartLiveActivity.setVisibility(View.GONE);
        flVideoViewLiveActivity.setLayoutParams(fullScreenLLP);//mFlVideoView的宽是屏幕高度，高是屏幕宽度-状态栏高度
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//Activity横屏
        vitamio.setVideoLayout(VideoView.VIDEO_LAYOUT_STRETCH, 0);
        isFullScreen = true;
        imageScale.setImageResource(R.mipmap.icon_vidio_shrink);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    /**
     * 设置视频缩小
     */
    public void setVideoPreview() {
        LinearLayout.LayoutParams previewLLP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DeviceUtil.dip2px(213, this));
        topPartLiveActivity.setVisibility(View.VISIBLE);
        bottomPartLiveActivity.setVisibility(View.VISIBLE);
        flVideoViewLiveActivity.setLayoutParams(previewLLP);//mFlVideoView的宽是屏幕的宽度，高是203dp
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//Activity竖屏
        vitamio.setVideoLayout(VideoView.VIDEO_LAYOUT_SCALE, 0);
        isFullScreen = false;
        imageScale.setImageResource(R.mipmap.icon_vidio_full);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (vitamio != null && vitamio.isPlaying()) {
            vitamio.stopPlayback();//停止播放，并释放资源
        }
    }
}
