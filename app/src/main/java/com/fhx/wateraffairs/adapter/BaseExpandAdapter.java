package com.fhx.wateraffairs.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.bean.BaseGroup;

import java.util.List;

import io.vov.vitamio.utils.Log;

public class BaseExpandAdapter extends BaseExpandableListAdapter {

    private List<BaseGroup> mGroupList;
    //    private List<Item> mItemList;
    private Context mContext;

    public BaseExpandAdapter(List<BaseGroup> mGroupList, Context mContext) {
        this.mGroupList = mGroupList;
        this.mContext = mContext;
    }

    @Override
    public int getGroupCount() {
        return mGroupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mGroupList.get(groupPosition).getItemList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mGroupList.get(groupPosition).getItemList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.expand_item_group, parent, false);
        TextView tv_group_title = convertView.findViewById(R.id.tv_group_title);
        tv_group_title.setText(mGroupList.get(groupPosition).getTitle());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expand_item_child, parent, false);
        TextView tvChildLeft = convertView.findViewById(R.id.tv_child_left);
        EditText editChild = convertView.findViewById(R.id.edit_child);
        tvChildLeft.setText(mGroupList.get(groupPosition).getItemList().get(childPosition).getText());
        editChild.setHint(mGroupList.get(groupPosition).getItemList().get(childPosition).getEidt());
//        editChild.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (hasFocus){
//                    Log.e("选中" +groupPosition +"------"+childPosition);
//                }
//            }
//        });

        editChild.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String msg =s.toString();
                Log.e("huoqudao",msg);
                mGroupList.get(groupPosition).getItemList().get(childPosition).setEditMsg(msg);
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
