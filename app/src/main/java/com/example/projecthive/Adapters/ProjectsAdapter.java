package com.example.projecthive.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthive.Objects.Project;
import com.example.projecthive.R;

import java.util.List;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder> {

    private List<Project> mProjects;

    public ProjectsAdapter(List<Project> projects) {
        mProjects = projects;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ProjectViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        Project project = mProjects.get(position);

        holder.projectTitle.setText(project.getTitle());
        holder.projectInfo1.setText(project.getInfo1());
        holder.projectInfo2.setText(project.getInfo2());
    }

    @Override
    public int getItemCount() {
        return mProjects.size();
    }

    public static class ProjectViewHolder extends RecyclerView.ViewHolder {
        public TextView projectTitle;
        public TextView projectInfo1;
        public TextView projectInfo2;

        public ProjectViewHolder(View itemView) {
            super(itemView);

            projectTitle = (TextView) itemView.findViewById(R.id.project_title);
            projectInfo1 = (TextView) itemView.findViewById(R.id.project_info_1);
            projectInfo2 = (TextView) itemView.findViewById(R.id.project_info_2);
        }
    }

}
