package com.liufeismart.weibo.attention.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liufeismart.weibo.R;
import com.liufeismart.weibo.bean.WeiboBeanInWeibo;
import com.liufeismart.weibo.databinding.ItemAttentionListBinding;

import java.util.List;

public class AttentionListAdapter extends RecyclerView.Adapter<AttentionListAdapter.VH> {
    private List<WeiboBeanInWeibo> data;


    public AttentionListAdapter(List<WeiboBeanInWeibo> data) {
        this.data = data;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        ItemAttentionListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_attention_list, viewGroup, false);
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_attention_list, viewGroup, false);
        return new VH(binding);
    }

    @Override
    public void onBindViewHolder(VH vh, int i) {
        WeiboBeanInWeibo bean = data.get(i);
//        vh.tv_content.setText(bean.getText());
        vh.binding.setWeiboBeanInWeibo(bean);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class VH extends RecyclerView.ViewHolder {
        public TextView tv_content;
        ItemAttentionListBinding binding;
        public VH(ItemAttentionListBinding binding) {
            super(binding.getRoot());
           this.binding = binding;
        }
    }
}
