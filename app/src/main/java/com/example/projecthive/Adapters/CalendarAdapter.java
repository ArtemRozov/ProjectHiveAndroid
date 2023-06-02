package com.example.projecthive.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthive.R;

import java.util.Calendar;
import java.util.List;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder> {

    private final Context context;
    private List<Integer> days;
    private OnItemClickListener onItemClickListener;
    private final Calendar calendar;
    public CalendarAdapter(Context context, List<Integer> days, Calendar calendar) {
        this.context = context;
        this.days = days;
        this.calendar = calendar;
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.calendar_emty_day, parent, false);
        return new CalendarViewHolder(view, calendar);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Integer day = days.get(position);

        if (day != null) {
            holder.dayTextView.setText(String.valueOf(day));
            holder.itemView.setOnClickListener(v -> {
                if (onItemClickListener != null) {
                    int day1 = days.get(position);
                    onItemClickListener.onItemClick(day1);
                }
            });

            holder.itemView.setEnabled(true);

            Calendar currentDate = Calendar.getInstance();
            int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
            int currentMonth = currentDate.get(Calendar.MONTH);
            int currentYear = currentDate.get(Calendar.YEAR);

            int month = calendar.get(Calendar.MONTH);
            int year = calendar.get(Calendar.YEAR);

            if (day == currentDay && month == currentMonth && year == currentYear) {
                // Установка фона текущего дня в красный цвет
                holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.red_color));
            } else if (day == 17) {
                // Установка фона дня 17 в зеленый цвет
                holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.green_color));
            } else {
                // В противном случае, используйте обычный фон
                holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.second_color));
            }
        } else {
            holder.dayTextView.setText("");
            holder.itemView.setOnClickListener(null);
            holder.itemView.setEnabled(false);
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        }
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public static class CalendarViewHolder extends RecyclerView.ViewHolder {
        TextView dayTextView;
        Calendar calendar;
        public CalendarViewHolder(@NonNull View itemView, Calendar calendar) {
            super(itemView);
            dayTextView = itemView.findViewById(R.id.dayTextView);
            this.calendar = calendar;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int day);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void setDays(List<Integer> days) {
        this.days = days;
        notifyDataSetChanged();
    }

}
