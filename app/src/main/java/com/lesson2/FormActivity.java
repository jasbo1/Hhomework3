package com.lesson2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {
    public static final String RESULT_KEY = "privet";
    private EditText editTitle;
    private EditText editDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        editTitle=findViewById(R.id.editTitle);
        editDesc=findViewById(R.id.editDesc);
    }
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor settings = getSharedPreferences("preferences", MODE_PRIVATE).edit();
        settings.putString("title", editTitle.getText().toString());
        settings.putString("desc", editDesc.getText().toString());
        settings.apply();
    }

    @Override
    protected void onResume() {
        SharedPreferences sharedPreferences = getSharedPreferences("preferences1", MODE_PRIVATE);
        editTitle.setText(sharedPreferences.getString("title", ""));
        String desc = sharedPreferences.getString("desc", "");
        editDesc.setText(desc);
        super.onResume();
    }


    public void onSave(View view) {
        String title = editTitle.getText().toString().trim();
        String desc = editDesc.getText().toString().trim();

        Task task = new Task(title,desc);
        Intent intent = new Intent();
        intent.putExtra(RESULT_KEY,task);
        setResult(RESULT_OK, intent);
        finish();

    }
}
