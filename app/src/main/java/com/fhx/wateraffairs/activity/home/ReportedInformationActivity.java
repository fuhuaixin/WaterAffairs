package com.fhx.wateraffairs.activity.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.adapter.ImageChooseAdapter;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.dialog.ListDialog;
import com.fhx.wateraffairs.utils.CutToUtils;
import com.scrat.app.selectorlibrary.ImageSelector;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

/**
 * 信息上报
 */
public class ReportedInformationActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.image_right)
    ImageView imageRight;
    @BindView(R.id.recycle_image)
    RecyclerView recycleImage;
    private ImageChooseAdapter chooseAdapter;
    private List<String> mImageList = new ArrayList<>(); //上传图列表
    private ListDialog chooseImageDialog; //相机 和选择图片弹窗
    private List<String> chooseImageList = new ArrayList<>(); //相机和选择图片list
    private List<String> UpImageList = new ArrayList<>(); //压缩上传图片列表

    private static final int REQUEST_CODE_SELECT_IMG = 1;
    private static final int REQUEST_CAMERA = 2;
    private static final int MAX_SELECT_COUNT = 3;

    @Override
    protected int initLayout() {
        return R.layout.activity_reported_information;
    }

    @Override
    protected void initView() {
        tvTitle.setText("信息上报");
    }

    @Override
    protected void initData() {
        imageRight.setImageResource(R.mipmap.icon_monitor_history);
        chooseImageList.add("相机");
        chooseImageList.add("图片选择");
        chooseImageDialog = new ListDialog(this);
        chooseImageDialog.setTitle("选择上传方式");
        chooseImageDialog.setList(chooseImageList);

        recycleImage.setLayoutManager(new GridLayoutManager(this, 3));
        chooseAdapter = new ImageChooseAdapter(this, mImageList);
        recycleImage.setAdapter(chooseAdapter);

    }

    @Override
    protected void initListen() {
        chooseImageDialog.setListener(new ListDialog.LeaveMyDialogListener() {
            @Override
            public void onClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        useCamera();
                        break;
                    case 1:
                        ImageSelector.show(ReportedInformationActivity.this, REQUEST_CODE_SELECT_IMG, MAX_SELECT_COUNT - mImageList.size());

                        break;
                }
                chooseImageDialog.dismiss();
            }
        });
        chooseAdapter.setClickListener(new ImageChooseAdapter.OnItemClickListener() {
            @Override
            public void onAdd(View view, int position) {
                chooseImageDialog.show();
            }

            @Override
            public void onDel(View view, int position) {
                mImageList.remove(position);
//                UpImageList.remove(position);
                chooseSize();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {
            Log.e("TAG", "拍照---------" + FileProvider.getUriForFile(this, "com.fhx.propertyuser.provider", file));
            Log.e("TAG", "拍照---------" + file);
//            imageView.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
            Luban(file);

        } else if (requestCode == REQUEST_CODE_SELECT_IMG) {
            showContent(data);
            return;
        }

    }


    @OnClick({R.id.image_back, R.id.image_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_right:
                CutToUtils.getInstance().JumpTo(ReportedInformationActivity.this,ReportedHistoryActivity.class);
                break;
        }
    }

    /**
     * 初始化相机相关权限
     * 适配6.0+手机的运行时权限
     */
    private File file;

    private void useCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/images/" + System.currentTimeMillis() + ".jpg");
        file.getParentFile().mkdirs();
        //改变Uri com.fhx.property.provider注意和xml中的一致
        Uri uri = FileProvider.getUriForFile(this, "com.fhx.wateraffairs.provider", file);
        //添加权限
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    /**
     * 选择图片回调
     *
     * @param data
     */
    private void showContent(Intent data) {
        List<String> paths = ImageSelector.getImagePaths(data);

        if (paths.isEmpty()) {
            for (int i = 0; i < paths.size(); i++) {
                mImageList.add(paths.get(i));
            }
            return;
        }

        for (int i = 0; i < paths.size(); i++) {
            File file = new File(paths.get(i));
            Luban(file);
        }

    }

    private void chooseSize() {
        chooseAdapter.notifyDataSetChanged();
    }

    /**
     * 鲁班图片压缩
     *
     * @param file
     */
    private void Luban(File file) {
        Luban.with(ReportedInformationActivity.this)
                .load(file)
                .ignoreBy(100)
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {
                        Log.e("luban", "onStart");
                    }

                    @Override
                    public void onSuccess(File file) {
                        Log.e("luban", file.getAbsolutePath());
//                        upImage(file);
                        mImageList.add(file.getAbsolutePath());
                        chooseSize();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("luban", e.getMessage());

                    }
                })
                .launch();
    }
}
