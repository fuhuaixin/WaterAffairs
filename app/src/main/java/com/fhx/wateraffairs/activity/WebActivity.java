package com.fhx.wateraffairs.activity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;


import butterknife.BindView;
import butterknife.OnClick;


/**
 * web通用页
 */
public class WebActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.webview)
    WebView webView;

    public ZLoadingDialog zLoadingDialog;

    private String title, url;
    private WebSettings settings;

    @Override
    protected int initLayout() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        //提示
        dialog();

        title = getIntent().getStringExtra("jumpOne");
        url = getIntent().getStringExtra("jumpTwo");
        Log.e("fhxx", url);


        tvTitle.setText(title);
        webView.loadUrl(url);
//        webView.loadUrl("file:///android_asset/web.html");
        settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                zLoadingDialog.show();
            }

            //WebView发起的WEB请求因为网络原因失败时回调
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                zLoadingDialog.dismiss();
            }

            //WebView发起的WEB请求收到服务器的错误消息时回调
            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                zLoadingDialog.dismiss();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                zLoadingDialog.dismiss();
                webView.loadUrl("javascript:getAllPick()");
            }
        });

    }

    /**
     * dialog相关
     */
    public void dialog() {
        zLoadingDialog = new ZLoadingDialog(this);
        zLoadingDialog.setLoadingBuilder(Z_TYPE.CHART_RECT)
                .setLoadingColor(Color.parseColor("#eeeeee"))
                .setHintText("加载中...")
                .setHintTextSize(14F)
                .setHintTextColor(Color.parseColor("#eeeeee"))
                .setDialogBackgroundColor(Color.parseColor("#CC111111"))
                .setDurationTime(1.3);
    }

    @Override
    protected void initListen() {

    }

    @OnClick(R.id.image_back)
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
        }
    }
}
