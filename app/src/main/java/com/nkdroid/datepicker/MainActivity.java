package com.nkdroid.datepicker;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button displayDate;
    TextView textview1;
    private int selectedDate,selectedMonth,selectedYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview1=(TextView)findViewById(R.id.textView1);
        displayDate=(Button)findViewById(R.id.button1);

        displayDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                // custom dialog
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.datepickerview);
                dialog.setTitle("");

                DatePicker datePicker = (DatePicker) dialog.findViewById(R.id.datePicker1);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                selectedDate=calendar.get(Calendar.DAY_OF_MONTH);
                selectedMonth=calendar.get(Calendar.MONTH);
                selectedYear=calendar.get(Calendar.YEAR);
                datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

                    @Override
                    public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        Log.e("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);

                        Log.e("selected date", selectedDate+"");
                        Log.e("selected date", dayOfMonth+"");
                        Log.e("selected month", selectedMonth+"");
                        Log.e("selected month", month+"");

                        Log.e("selected year", selectedYear+"");
                        Log.e("selected year", year+"");
                        if(selectedDate ==dayOfMonth && selectedMonth==month && selectedYear==year) {

                            textview1.setText("Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
                            dialog.dismiss();
                        }else {

                            if(selectedDate !=dayOfMonth){
                                textview1.setText("Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
                                dialog.dismiss();
                            }else {
                                if(selectedMonth !=month){
                                        textview1.setText("Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
                                        dialog.dismiss();
                                }
                            }
                        }
                        selectedDate=dayOfMonth;
                        selectedMonth=(month);
                        selectedYear=year;
                    }
                });


                dialog.show();
            }

        });
    }

}
