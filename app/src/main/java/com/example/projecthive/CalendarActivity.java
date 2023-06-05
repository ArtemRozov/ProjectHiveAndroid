package com.example.projecthive;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarActivity extends AppCompatActivity implements CalendarAdapter.OnItemClickListener {

    private TextView monthText;
    private Calendar calendar;

    private CalendarAdapter calendarAdapter;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        monthText = findViewById(R.id.month_text);
        ImageView prevMonthArrow = findViewById(R.id.prev_month_arrow);
        ImageView nextMonthArrow = findViewById(R.id.next_month_arrow);

        calendar = Calendar.getInstance();

        updateMonthText();

        prevMonthArrow.setOnClickListener(v -> {
            // Переключение на предыдущий месяц
            calendar.add(Calendar.MONTH, -1);
            updateMonthText();
            updateDays();
        });

        nextMonthArrow.setOnClickListener(v -> {
            // Переключение на следующий месяц
            calendar.add(Calendar.MONTH, 1);
            updateMonthText();
            updateDays();
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 7)); // Настраиваем сетку для 7 дней в неделе
        List<Integer> days = generateDays(); // Создаем список чисел от 1 до 31
        calendarAdapter = new CalendarAdapter(this, days, calendar);
        calendarAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(calendarAdapter);

        // go to the profile from profile button
        Button profileButton = findViewById(R.id.profile_button);
        profileButton.setOnClickListener(view -> {
            Intent intent = new Intent(CalendarActivity.this, ProfileActivity.class);
            startActivity(intent);
        });


        // go to the project
        Button projectButton = findViewById(R.id.create_project);
        projectButton.setOnClickListener(view -> {
            Intent intent = new Intent(CalendarActivity.this, ProjectActivity.class);
            startActivity(intent);
        });
    }

    private void updateMonthText() {
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        String monthName = new DateFormatSymbols().getMonths()[month];
        String monthYearText = monthName + " " + year;
        monthText.setText(monthYearText);
    }

    private List<Integer> generateDays() {
        List<Integer> days = new ArrayList<>();

        // Set the calendar to the first day of the month
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // Get the starting day of the month (e.g., 1 for Sunday, 2 for Monday, etc.)
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);

        // Calculate the shift amount to start from Monday
        int shiftAmount = startDay - Calendar.MONDAY;

        if (shiftAmount < 0) {
            shiftAmount = 7 + shiftAmount; // Adjust shift amount to start from Monday
        }

        // Add empty days before the start day
        for (int i = 1; i <= shiftAmount; i++) {
            days.add(null); // Use null to represent empty days
        }

        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Generate the list of days for the month
        for (int i = 1; i <= maxDays; i++) {
            days.add(i);
        }

        return days;
    }

    private void updateDays() {
        List<Integer> days = generateDays();
        calendarAdapter.setDays(days);
    }

    @Override
    public void onItemClick(int day) {
        showInfoPopup(day);
    }

    private void showInfoPopup(int day) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Інформація про день");

        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        @SuppressLint("DefaultLocale") String date = String.format("%02d.%02d.%d", day, month + 1, year);

        if (day == 6 && month == 5 && year == 2023) {
            builder.setMessage("Обрано день: " + date + "\nЗакінчується дедлайн завдання 'Task1' проекту 'Project1'!");
        } else if (day == 17 && month == 5 && year == 2023) {
            builder.setMessage("Обрано день: " + date + "\nЗакінчується дедлайн завдання 'First task' проекту 'Project2'!");
        } else {
            builder.setMessage("Обрано день: " + date + "\nЗустрічей або дедлайнів на обраний день немає!");
        }

        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}