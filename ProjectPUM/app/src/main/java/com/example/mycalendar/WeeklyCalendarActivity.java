package com.example.mycalendar;

import static com.example.mycalendar.util.CalendarUtils.daysInMonthArray;
import static com.example.mycalendar.util.CalendarUtils.daysInWeekArray;
import static com.example.mycalendar.util.CalendarUtils.monthYearDate;
import static com.example.mycalendar.util.CalendarUtils.selectedDate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycalendar.adapter.CalendarAdapter;
import com.example.mycalendar.adapter.EventAdapter;
import com.example.mycalendar.util.CalendarUtils;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeeklyCalendarActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener{

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private ListView eventListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_calendar);
        initWidgets();
        setWeekView();
    }

    private void initWidgets() {

        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTextView);
        eventListView = findViewById(R.id.eventCellListView);


    }

    private void setWeekView() {

        monthYearText.setText(monthYearDate(selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
        setEventAdapter();

    }



    public void previousWeekAction(View view) {
        selectedDate = selectedDate.minusWeeks(1);
        setWeekView();
    }

    @Override
    public void onItemClick(int position, LocalDate date) {

        selectedDate = date;
        setWeekView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setEventAdapter();
    }

    private void setEventAdapter() {
        ArrayList<Event> dailyEvents = Event.eventsForDate(selectedDate);
        EventAdapter eventAdapter = new EventAdapter(getApplicationContext(), dailyEvents);
        eventListView.setAdapter(eventAdapter);
    }

    public void nextWeekAction(View view) {
        selectedDate = selectedDate.plusWeeks(1);
        setWeekView();
    }

    public void newEventAction(View view) {
        startActivity(new Intent(this, EditEventActivity.class));
    }
}