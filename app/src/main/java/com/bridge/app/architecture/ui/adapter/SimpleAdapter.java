package com.bridge.app.architecture.ui.adapter;

import android.support.annotation.NonNull;

import com.bridge.base.adapter.recyclerview.BaseViewHolder;
import com.bridge.base.adapter.recyclerview.RecyclerBaseAdapter;

import java.util.List;

/**
 * Created by jeanboy on 2017/8/3.
 */

public class SimpleAdapter extends RecyclerBaseAdapter<String> {

    public SimpleAdapter(@NonNull List<String> dataList, int itemLayoutId) {
        super(dataList, itemLayoutId);
    }

    @Override
    public void convert(BaseViewHolder holder, String s, int position) {

    }
}
