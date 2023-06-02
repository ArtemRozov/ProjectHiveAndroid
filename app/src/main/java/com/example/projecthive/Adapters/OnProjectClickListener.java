package com.example.projecthive.Adapters;

import android.content.Context;
import android.content.Intent;

import com.example.projecthive.MainActivity;
import com.example.projecthive.Objects.Project;
import com.example.projecthive.OneProjectActivity;
import com.example.projecthive.ProfileActivity;
import com.example.projecthive.ProjectActivity;

public class OnProjectClickListener implements ProjectsAdapter.OnItemClickListener {
    private Context mContext;

    public OnProjectClickListener(Context context) {
        mContext = context;
    }

    @Override
    public void onItemClick(Project item) {
        // Здесь вы можете реализовать действия при нажатии на кнопку, например,
        // перейти к активности с подробной информацией о проекте.
        Intent intent = new Intent(mContext, OneProjectActivity.class);
        //intent.putExtra("project_id", item.getId());
        mContext.startActivity(intent);
    }
}