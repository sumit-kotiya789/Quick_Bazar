package com.sumitkotiya.quickbazar.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sumitkotiya.quickbazar.R;
import com.sumitkotiya.quickbazar.models.CategoryResponseModel;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    List<CategoryResponseModel> dataList;

    public CategoryAdapter(List<CategoryResponseModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cat_name.setText(dataList.get(position).getCat_name());

//        Glide.with(holder.cat_icon.getContext())
//                .load("http://192.168.43.148/ecommapi/images/"+dataList.get(position).getCat_img())
//                .diskCacheStrategy(DiskCacheStrategy.NONE) // Disable caching
//                .skipMemoryCache(true) // Skip memory cache
//                .error(R.drawable.holder)
//                .into(holder.cat_icon);

        Glide.with(holder.cat_icon.getContext()).load("http://10.0.2.2/ecommapi/admin/images/"+dataList.get(position).getCat_img()).into(holder.cat_icon);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView cat_icon;
        TextView cat_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cat_icon = itemView.findViewById(R.id.cat_icon);
            cat_name = itemView.findViewById(R.id.cat_name);

        }
    }
}
