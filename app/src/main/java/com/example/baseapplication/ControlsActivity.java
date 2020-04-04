package com.example.baseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ControlsActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private EditText editText;
    private RadioGroup radioGroup;
    private ImageView imageView1, imageView2;
    private int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controls);
        button = findViewById(R.id.button2);
        textView = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);
        radioGroup = findViewById(R.id.radioGroup);
        imageView1 = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit = editText.getText().toString();
                textView.setText(edit);
                if (count % 2 == 0){
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                } else {
                    imageView1.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                }
                count++;
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton){
                    Toast.makeText(getApplicationContext(), "RadioButton1被选中", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "RadioButton2被选中", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
