package com.liufeismart.weibo.attention.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liufeismart.weibo.R;
import com.liufeismart.weibo.attention.adapter.AttentionListAdapter;
import com.liufeismart.weibo.attention.model.AttentionModel;
import com.liufeismart.weibo.attention.model.AttentionModelImpl;
import com.liufeismart.weibo.attention.view.AttentionView;
import com.liufeismart.weibo.attention.viewmodel.AttentionViewModel;
import com.liufeismart.weibo.base.BaseActivity;
import com.liufeismart.weibo.bean.WeiboBeanInWeibo;
import com.liufeismart.weibo.databinding.ActivityAttentionBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 展示当前登录用户的微博和其关注的其他用户的微博的列表
 */
public class AttentionActivity extends BaseActivity implements AttentionView {

    private RecyclerView attentionList;

    private AttentionModel mAttentionModel;
    private AttentionViewModel mAttentionViewModel;
    private List<WeiboBeanInWeibo> dataList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAttentionBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_attention);
        mAttentionViewModel = new AttentionViewModel(this);
        binding.setAttentionViewModel(mAttentionViewModel);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.rcAttentionList.setLayoutManager(layoutManager);
        dataList = new ArrayList<WeiboBeanInWeibo>();
        binding.rcAttentionList.setAdapter(new AttentionListAdapter(dataList));

        mAttentionViewModel.loadData();
    }


    @Override
    public void addData(List<WeiboBeanInWeibo> data) {
        dataList.addAll(data);
    }

    @Override
    public void refreshData(List<WeiboBeanInWeibo> data) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String error) {

    }
}
