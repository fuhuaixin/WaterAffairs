package com.fhx.wateraffairs.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.tencent.mmkv.MMKV;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;
    public MMKV mmkv;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (AppCompatActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mmkv =MMKV.defaultMMKV();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(setLayoutId(), container, false);
        ButterKnife.bind(this,inflate);
        return inflate;
//        return setLayoutView(inflater,container,savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        findViewById(view);
        setViewData(view);
        setClickEvent(view);
    }

    public void startToFragment(Context context, int container, Fragment newFragment,String tag) {

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, newFragment);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int setLayoutId();

    /**
     * findViewById
     */
    public void findViewById(View view){}

    /**
     * setViewData
     */
    public void setViewData(View view){}

    /**
     * setClickEvent
     */
    public void setClickEvent(View view){}

}
