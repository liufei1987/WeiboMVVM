package com.liufeismart.weibo.attention.viewmodel;

import com.liufeismart.weibo.attention.model.AttentionModel;
import com.liufeismart.weibo.attention.model.AttentionModelImpl;
import com.liufeismart.weibo.attention.view.AttentionView;
import com.liufeismart.weibo.bean.WeiboBeanInWeibo;

import java.util.List;

public class AttentionViewModel {
    private AttentionView mAttentionView;
    private AttentionModel mAttentionModel = new AttentionModelImpl();

    public AttentionViewModel(AttentionView attentionView) {
        this.mAttentionView = attentionView;
    }

    public void loadData() {
        mAttentionView.showProgress();
        mAttentionModel.loadData(new AttentionModel.Callback() {
            @Override
            public void onSuccess(List<WeiboBeanInWeibo> weiboList) {
                mAttentionView.hideProgress();
                mAttentionView.addData(weiboList);
            }

            @Override
            public void onFailure(String reason) {
                mAttentionView.hideProgress();
            }
        });
    }
}
