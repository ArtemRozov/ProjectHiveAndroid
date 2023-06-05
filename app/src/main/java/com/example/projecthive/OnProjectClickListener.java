package com.example.projecthive;

import android.content.Context;
import android.content.Intent;

import com.example.projecthive.Objects.Project;

public class OnProjectClickListener implements ProjectsAdapter.OnItemClickListener {

    private final Context mContext;

    public OnProjectClickListener(Context context) {
        mContext = context;
    }

    @Override
    public void onItemClick(Project item) {
        Intent intent = new Intent(mContext, OneProjectActivity.class);
        intent.putExtra("title", item.getTitle());
        mContext.startActivity(intent);
    }

}