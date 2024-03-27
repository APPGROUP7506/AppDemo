package com.hku.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AppCompatActivity {

    private ListView lv;
    private ListViewAdapter adapter;
    private List<Course> courseList = new ArrayList<>();

    private String[] courseName = {"COMP 7506", "COMP 7507", "COMP 7508", "COMP 7509", "COMP 7510"};
    private String[] teacherName = {"T1", "T2", "T3", "T4", "T5"};
    private String[] rating = {"4.5", "4.0", "3.5", "3.0", "2.5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        // 创建课程列表
        for (int i = 0; i < courseName.length; i++) {
            Course course = new Course(courseName[i], teacherName[i], rating[i]);
            courseList.add(course);
        }

        // Create the adapter
        adapter = new ListViewAdapter(this, R.layout.course_item, courseList);

        // Set the adapter to the ListView
        lv = findViewById(R.id.lv);
        lv.setAdapter(adapter);
    }
}