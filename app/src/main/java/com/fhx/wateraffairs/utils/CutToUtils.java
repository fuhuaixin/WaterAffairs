package com.fhx.wateraffairs.utils;

import android.app.Activity;
import android.content.Intent;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseBean;


/**
 * 跳转
 */
public class CutToUtils {

    private static final CutToUtils instance = new CutToUtils();

    public static CutToUtils getInstance() {
        return instance;
    }

    /**
     * 直接跳转 无需参数
     * @param context
     * @param activity
     */
    public void JumpTo(Activity context, Class<? extends Activity> activity) {
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.activity_in_from_anim, R.anim.activity_in_to_anim);
    }

    /**
     * 传递bean
     * @param context
     * @param activity
     * @param bean
     */
    public void JumpToBean(Activity context, Class<? extends Activity> activity, BaseBean bean) {
        Intent intent = new Intent(context, activity);
        intent.putExtra("bean", bean);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.activity_in_from_anim, R.anim.activity_in_to_anim);

    }

    /**
     * 一个参数跳转
     * @param context
     * @param activity
     * @param jumpOne
     */
    public void JumpToOne(Activity context, Class<? extends Activity> activity, String jumpOne) {
        Intent intent = new Intent(context, activity);
        intent.putExtra("jumpOne", jumpOne);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.activity_in_from_anim, R.anim.activity_in_to_anim);

    }

    /**
     * 两个参数跳转
     * @param context
     * @param activity
     * @param jumpOne
     * @param jumpTwo
     */
    public void JumpToTwo(Activity context, Class<? extends Activity> activity, String jumpOne, String jumpTwo){
        Intent intent = new Intent(context, activity);
        intent.putExtra("jumpOne", jumpOne);
        intent.putExtra("jumpTwo", jumpTwo);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.activity_in_from_anim, R.anim.activity_in_to_anim);

    }



}
