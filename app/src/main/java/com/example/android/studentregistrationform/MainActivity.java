package com.example.android.studentregistrationform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final static String STUDENT_KEY = "STUDENT";
    EditText nameEdit, emailEdit;
    TextView seekbarResult;
    RadioGroup radioGroup;
    RadioButton sisRadio, csRadio, bioRadio, othersRadio;
    SeekBar moodSeekbar;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        nameEdit = (EditText) findViewById(R.id.nameEditText);
        emailEdit = (EditText) findViewById(R.id.emailEditText);
        seekbarResult = (TextView) findViewById(R.id.seekbarResult);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        sisRadio = (RadioButton) findViewById(R.id.sisRadioButton);
        csRadio = (RadioButton) findViewById(R.id.csRadioButton);
        bioRadio = (RadioButton) findViewById(R.id.bioRadioButton);
        othersRadio = (RadioButton) findViewById(R.id.othersRadioButton);
        moodSeekbar = (SeekBar) findViewById(R.id.moodSeekBar);
        moodSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBar.setProgress(i);
                seekbarResult.setText(i + "%");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(nameEdit.getText().toString().length() == 0)
            Toast.makeText(this,"Please enter a name",Toast.LENGTH_LONG).show();
        else if(emailEdit.getText().toString().length() == 0)
            Toast.makeText(this,"Please enter an email address",Toast.LENGTH_LONG).show();
        else{
            String studentName = nameEdit.getText().toString();
            String studentEmail = emailEdit.getText().toString();
            String department ="";
            int mood = moodSeekbar.getProgress();
            switch (radioGroup.getCheckedRadioButtonId()){
                case R.id.sisRadioButton:
                    department= "SIS";
                    break;
                case R.id.csRadioButton:
                    department ="CS";
                    break;
                case R.id.bioRadioButton:
                   department = "BIO";
                    break;
                case R.id.othersRadioButton:
                   department = "Others";
                    break;
            }
            Student student = new Student(studentName, studentEmail, department, mood);
            Intent intent = new Intent(this, DisplayActivity.class);
            intent.putExtra(STUDENT_KEY, (Student) student);
            startActivity(intent);

        }
    }
}
