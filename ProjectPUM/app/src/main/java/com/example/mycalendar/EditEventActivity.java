package com.example.mycalendar;

import static com.example.mycalendar.util.CalendarUtils.selectedDate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mycalendar.util.CalendarUtils;

import java.time.LocalTime;

public class EditEventActivity extends AppCompatActivity {

    private EditText eventNameEditText;
    private TextView eventDateTextView;
    private TextView eventTimeTextView;
    private LocalTime time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_event);
        initWidgets();
        time = LocalTime.now();
        eventDateTextView.setText("Date: "+ CalendarUtils.formattedDate(selectedDate));
        eventTimeTextView.setText("Time: "+ CalendarUtils.formattedTime(time));

    }

    private void initWidgets() {
        eventNameEditText = findViewById(R.id.eventNameEditText);
        eventDateTextView = findViewById(R.id.eventDateTextView);
        eventTimeTextView = findViewById(R.id.eventTimeTextView);
    }

    public void addEventAction(View view) {
        String eventName = eventNameEditText.getText().toString();
        Event newEvent = new Event(eventName, selectedDate, time);
        Event.listOfEvents.add(newEvent);
        finish();
    }
}