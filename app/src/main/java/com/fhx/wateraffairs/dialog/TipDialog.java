package com.fhx.wateraffairs.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.fhx.wateraffairs.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 提示dialog
 * 使用
 *         TipDialog tipDialog = new TipDialog(getContext());
 *         tipDialog.setImageTip(R.mipmap.ic_tip_success);
 *         tipDialog.setTip("提交成功");
 *         tipDialog.setTip("请耐心等待");
 *         tipDialog.show();
 */
public class TipDialog extends Dialog {

    @BindView(R.id.image_tip)
    ImageView imageTip;
    @BindView(R.id.tv_tip)
    TextView tvTip;
    @BindView(R.id.tv_tip_msg)
    TextView tvTipMsg;
    @BindView(R.id.image_close)
    ImageView imageClose;

    int image=0;
    String tip="";
    String tipMsg="";

    public TipDialog(@NonNull Context context) {
        super(context, R.style.TipDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_tip);
        ButterKnife.bind(this);

        Window window = getWindow();
        window.setGravity(Gravity.CENTER);
        window.setWindowAnimations(R.style.dialogAnimations);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        setMsg();

    }


    @OnClick(R.id.image_close)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.image_close:
                dismiss();
                break;
        }
    }


    private void setMsg() {
        if (image!=0){
            imageTip.setImageResource(image);
        }
        if (!tip.equals("")){
            tvTip.setText(tip);
        }
        if (!tipMsg.equals("")){
            tvTipMsg.setText(tipMsg);
        }
    }


    public void setImageTip(int image) {
        this.image = image;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setTipMsg(String tipMsg) {
        this.tipMsg = tipMsg;
    }
}
