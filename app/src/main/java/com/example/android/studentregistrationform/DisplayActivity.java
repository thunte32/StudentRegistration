package com.example.android.studentregistrationform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    final static String STUDENT_DISPLAY_KEY = "STUDENT";
    final static String CHOICE_KEY = "CHOICE";
    final static String VALUE = "VALUE";
    final static int NAME_REQUEST = 1;
    final static int EMAIL_REQUEST = 2;
    final static int DEPT_REQUEST = 3;
    final static int MOOD_REQUEST = 4;


    Student student;
    int type;
    TextView name, email, dept, mood;
    ImageView editNameIcon, editEmailIcon, editDeptIcon, editMoodIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        name = (TextView) findViewById(R.id.studentNameTextView);
        email = (TextView) findViewById(R.id.emailTextView);
        dept = (TextView) findViewById(R.id.departmentTextView);
        mood = (TextView) findViewById(R.id.moodTextView);

        editNameIcon = (ImageView) findViewById(R.id.nameEditIcon);
        editEmailIcon = (ImageView) findViewById(R.id.emailEditIcon);
        editDeptIcon = (ImageView) findViewById(R.id.deptEditIcon);
        editMoodIcon = (ImageView) findViewById(R.id.moodEditIcon);

        if(getIntent().getExtras() != null){
            student = (Student) getIntent().getExtras().getSerializable(MainActivity.STUDENT_KEY);
            name.setText(student.getName());
            email.setText(student.getEmail());
            dept.setText(student.getDept());
            mood.setText(student.getMood() + " % Positive");

            editNameIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DisplayActivity.this,EditActivity.class);
                    intent.putExtra(STUDENT_DISPLAY_KEY,student);
                    intent.putExtra(CHOICE_KEY, "NAME");
                    startActivityForResult(intent, NAME_REQUEST);
                    type = 1;
                }
            });

            editEmailIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DisplayActivity.this,EditActivity.class);
                    intent.putExtra(STUDENT_DISPLAY_KEY, student);
                    intent.putExtra(CHOICE_KEY, "EMAIL");
                    startActivityForResult(intent, EMAIL_REQUEST);
                    type = 2;
                }
            });

            editDeptIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DisplayActivity.this, EditActivity.class);
                    intent.putExtra(STUDENT_DISPLAY_KEY, student);
                    intent.putExtra(CHOICE_KEY, "DEPT");
                    startActivityForResult(intent,DEPT_REQUEST);
                    type = 3;
                }
            });

            editMoodIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DisplayActivity.this, EditActivity.class);
                    intent.putExtra(STUDENT_DISPLAY_KEY, student);
                    intent.putExtra(CHOICE_KEY,"MOOD");
                    startActivityForResult(intent,MOOD_REQUEST);

                }
            });
        }

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK) {
            if (requestCode == NAME_REQUEST) {
                student.setName(data.getExtras().getString(VALUE));
                name.setText(student.getName());
            }
            if (requestCode == EMAIL_REQUEST) {
                student.setEmail(data.getExtras().getString(VALUE));
                email.setText(student.getEmail());
            }
            if (requestCode == DEPT_REQUEST) {
                student.setDept(data.getExtras().getString(VALUE));
                dept.setText(student.getDept());
            }

            if (requestCode == MOOD_REQUEST) {
                student.setMood(Integer.parseInt(data.getExtras().getString(VALUE)));
                mood.setText(student.getMood() + "% positive");
            }
        }
        else{}

    }
}
