package com.example.projecthive;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthive.Objects.Project;

import java.util.List;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder> {

    private List<Project> mProjects;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(Project item);
    }

    public ProjectsAdapter(List<Project> projects, OnItemClickListener listener) {
        mProjects = projects;
        mListener = listener;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_item, parent, false);
        return new ProjectViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        Project project = mProjects.get(position);

        holder.projectTitle.setText(project.getTitle());
        holder.projectInfo1.setText(project.getInfo1());
        holder.projectInfo2.setText(project.getInfo2());
        holder.projectImage.setImageResource(project.getPhotoResId());

        holder.goToButton.setOnClickListener(view -> {
            if (mListener != null) {
                mListener.onItemClick(project);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProjects.size();
    }

    public static class ProjectViewHolder extends RecyclerView.ViewHolder {
        public TextView projectTitle;
        public TextView projectInfo1;
        public TextView projectInfo2;

        public ImageView projectImage;

        public Button goToButton;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);

            projectTitle = itemView.findViewById(R.id.project_title);
            projectInfo1 = itemView.findViewById(R.id.project_info_1);
            projectInfo2 = itemView.findViewById(R.id.project_info_2);
            projectImage = itemView.findViewById(R.id.project_image);
            goToButton = itemView.findViewById(R.id.go_to_button);
        }
    }

}
