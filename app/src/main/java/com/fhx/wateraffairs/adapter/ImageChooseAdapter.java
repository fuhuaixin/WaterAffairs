package com.fhx.wateraffairs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fhx.wateraffairs.R;

import java.util.List;

public class ImageChooseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> data;

    private static final int ITEM_ONE=1;
    private static final int ITEM_TWO=2;

    public ImageChooseAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }


    private OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface OnItemClickListener {
        void onAdd(View view, int position);
        void onDel(View view, int position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder;
        if(viewType==ITEM_TWO){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_image_choose_add,parent,false);
            holder = new AnoViewHolder(view);
        }else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_image_choose_item,parent,false);
            holder = new ViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AnoViewHolder) {
//            ((AnoViewHolder) holder).image_add
        }else {
            Glide.with(context).load(data.get(position)).into( ((ViewHolder) holder).image);
        }
    }

    @Override
    public int getItemCount() {
        if (data.size()>2){
            return data.size();
        }else {
            return data.size()+1;
        }
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image_del;
        private ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            image_del = itemView.findViewById(R.id.image_del);
            image = itemView.findViewById(R.id.image);
            image_del.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener!=null){
                clickListener.onDel(itemView, getAdapterPosition());
            }
        }
    }

    public class AnoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image_add;

        public AnoViewHolder(@NonNull View itemView) {
            super(itemView);
            image_add = itemView.findViewById(R.id.image_add);
            image_add.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener!=null){
                clickListener.onAdd(itemView, getAdapterPosition());
            }
        }
    }
    @Override
    public int getItemViewType(int position) {
        if(position>data.size()-1){
            return ITEM_TWO;
        }else {
            return ITEM_ONE;
        }
    }
}
