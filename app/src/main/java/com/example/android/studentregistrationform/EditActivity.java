package com.example.android.studentregistrationform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    EditText nameEditActivity, emailEditActivity;
    TextView departmentText, currentMoodText,seekbarResultText;
    RadioGroup radioGroup;
    RadioButton sisRadio, csRadio, bioRadio, othersRadio;
    SeekBar seekBar;
    Button saveButton;
    LinearLayout seekLinearLayout;
    String value = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Student student = (Student) getIntent().getExtras().getSerializable(DisplayActivity.STUDENT_DISPLAY_KEY);
        final String choice = getIntent().getExtras().getString(DisplayActivity.CHOICE_KEY);

        nameEditActivity = (EditText) findViewById(R.id.secondNameEdit);
        emailEditActivity = (EditText) findViewById(R.id.secondEmailEdit);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupEditAct);
        switch (student.getDept()){
            case "SIS":
                radioGroup.check(R.id.sisRadioButtonEditAct);
                break;
            case "CS":
                radioGroup.check(R.id.csRadioButtonEditAct);
                break;
            case "BIO":
                radioGroup.check(R.id.bioRadioButtonEditAct);
                break;
            case "Others":
                radioGroup.check(R.id.othersRadioButtonEditAct);
                break;
        }
        sisRadio = (RadioButton) findViewById(R.id.sisRadioButtonEditAct);
        csRadio = (RadioButton) findViewById(R.id.csRadioButtonEditAct);
        bioRadio = (RadioButton) findViewById(R.id.bioRadioButtonEditAct);
        othersRadio = (RadioButton) findViewById(R.id.othersRadioButton);
        departmentText = (TextView) findViewById(R.id.departmentTextView);
        seekBar = (SeekBar) findViewById(R.id.moodSeekBarEditAct);
        seekLinearLayout = (LinearLayout) findViewById(R.id.moodLinearLayout);
        seekBar.setProgress(student.getMood());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setProgress(progress);
                seekbarResultText.setText(seekBar.getProgress() + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        currentMoodText = (TextView) findViewById(R.id.textView2);
        seekbarResultText = (TextView) findViewById(R.id.seekbarResultEditAct);
        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                switch (choice){
                    case "NAME":
                        value = nameEditActivity.getText().toString();
                        intent.putExtra(DisplayActivity.VALUE, value);
                        setResult(RESULT_OK, intent);
                        break;
                    case "EMAIL":
                        value = emailEditActivity.getText().toString();
                        intent.putExtra(DisplayActivity.VALUE,value);
                        setResult(RESULT_OK, intent);
                        break;
                    case "DEPT":
                        switch (radioGroup.getCheckedRadioButtonId()){
                            case R.id.sisRadioButtonEditAct:
                                value = "SIS";
                                intent.putExtra(DisplayActivity.VALUE, value);
                                setResult(RESULT_OK, intent);
                                break;
                            case R.id.csRadioButtonEditAct:
                                value = "CS";
                                intent.putExtra(DisplayActivity.VALUE, value);
                                setResult(RESULT_OK, intent);
                                break;
                            case R.id.bioRadioButtonEditAct:
                                value = "BIO";
                                intent.putExtra(DisplayActivity.VALUE, value);
                                setResult(RESULT_OK, intent);
                                break;
                            case R.id.othersRadioButtonEditAct:
                                value = "Others";
                                intent.putExtra(DisplayActivity.VALUE, value);
                                setResult(RESULT_OK, intent);
                                break;
                        }
                        break;

                    case "MOOD":
                        value = Integer.toString(seekBar.getProgress());
                        intent.putExtra(DisplayActivity.VALUE, value);
                        setResult(RESULT_OK,intent);
                        break;
                    default:
                        setResult(RESULT_CANCELED, intent);
                }
                finish();
            }
        });


          switch (choice){
              case "NAME":
                  nameEditActivity.setVisibility(View.VISIBLE);
                  break;
              case "EMAIL":
                  emailEditActivity.setVisibility(View.VISIBLE);
                  break;
              case "DEPT":
                    departmentText.setVisibility(View.VISIBLE);
                  radioGroup.setVisibility(View.VISIBLE);
                  break;
              case "MOOD":
                  seekLinearLayout.setVisibility(View.VISIBLE);
                  currentMoodText.setVisibility(View.VISIBLE);
                  seekbarResultText.setVisibility(View.VISIBLE);
                  seekbarResultText.setText(seekBar.getProgress() + "%");
                  break;
          }
    }
}
