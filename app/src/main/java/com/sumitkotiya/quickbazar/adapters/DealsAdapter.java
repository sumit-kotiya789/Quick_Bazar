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
import com.sumitkotiya.quickbazar.models.DealsResponseModel;

import java.util.List;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.ViewHolder>{
    List<DealsResponseModel> dataList;

    public DealsAdapter(List<DealsResponseModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public DealsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deals_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealsAdapter.ViewHolder holder, int position) {
        String offStr = dataList.get(position).getOff()+"% off";
        holder.deal_off.setText(offStr);
        Glide.with(holder.deal_img.getContext()).load("http://10.0.2.2/ecommapi/admin/images/"+dataList.get(position).getItem_img()).into(holder.deal_img);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView deal_img;
        TextView deal_off;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            deal_img = itemView.findViewById(R.id.deal_img);
            deal_off = itemView.findViewById(R.id.deal_off);

        }
    }
}
