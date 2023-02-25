package com.example.mycalendar.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycalendar.adapter.CalendarAdapter;
import com.example.mycalendar.R;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public final TextView dayOfMonth;
    private final CalendarAdapter.OnItemListener onItemListener;
    public final View calendarCell;
    private final ArrayList<LocalDate> days;

    public CalendarViewHolder(@NonNull View itemView, CalendarAdapter.OnItemListener onItemListener, ArrayList<LocalDate> days) {
        super(itemView);
        dayOfMonth = itemView.findViewById(R.id.cellDayText);
        this.onItemListener = onItemListener;
        calendarCell = itemView.findViewById(R.id.calendarCell);
        itemView.setOnClickListener(this);
        this.days = days;
    }

    @Override
    public void onClick(View view) {

        onItemListener.onItemClick(getAdapterPosition(), days.get(getAdapterPosition()));

    }
}
