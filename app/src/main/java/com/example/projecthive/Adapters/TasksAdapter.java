package com.example.projecthive.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projecthive.Objects.Project;
import com.example.projecthive.Objects.Task;
import com.example.projecthive.OneProjectActivity;
import com.example.projecthive.ProfileActivity;
import com.example.projecthive.R;

import java.util.HashMap;
import java.util.List;

public class TasksAdapter extends BaseExpandableListAdapter {

    private final Context context;
    private final List<String> listGroup;
    private final HashMap<String, List<Task>> listItem;

    public TasksAdapter(Context context, List<String> listGroup, HashMap<String, List<Task>> listItem) {
        this.context = context;
        this.listGroup = listGroup;
        this.listItem = listItem;
    }

    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listItem.get(listGroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listItem.get(listGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String groupTitle = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group_task, null);
        }

        TextView groupTextView = convertView.findViewById(R.id.list_group_text);
        groupTextView.setText(groupTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Task task = (Task) getChild(groupPosition, childPosition);
        String taskTitle = task.getTitle();
        String taskDeadline = task.getDeadline();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_task, null);
        }

        TextView titleTextView = convertView.findViewById(R.id.task_title);
        TextView deadlineTextView = convertView.findViewById(R.id.task_deadline);
        Button detailButton = convertView.findViewById(R.id.list_item_button);

        titleTextView.setText(taskTitle);
        deadlineTextView.setText(taskDeadline);

//        detailButton.setOnClickListener(v -> {
//            // Запуск ProfileActivity
//            Intent intent = new Intent(context, ProfileActivity.class);
//            context.startActivity(intent);
//        });

        // Добавляем слушатель кликов для кнопки "Детальніше"
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Обработка нажатия на кнопку
                // Получаем задачу, соответствующую позиции группы и дочернего элемента
                Task selectedTask = listItem.get(listGroup.get(groupPosition)).get(childPosition);
                // Получаем данные задачи
                String selectedTaskTitle = selectedTask.getTitle();
                String selectedTaskDeadline = selectedTask.getDeadline();

                // Выводим данные задачи в Toast
                String message = "Нажата кнопка 'Детальніше' для задачи:\n" +
                        "Заголовок: " + selectedTaskTitle + "\n" +
                        "Дедлайн: " + selectedTaskDeadline;

                System.out.println(message);
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

}

