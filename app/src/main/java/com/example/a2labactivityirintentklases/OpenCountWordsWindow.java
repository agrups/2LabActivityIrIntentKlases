package com.example.a2labactivityirintentklases;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OpenCountWordsWindow extends AppCompatActivity {

    String data;
    TextView text;
    int wordCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_count_words_window);

        Intent currentIntent = this.getIntent();
        data = (String) currentIntent.getSerializableExtra("data");

        text = findViewById(R.id.textView);

        if (data != null){
            String[] words = data.split("\\s+");
            wordCount = words.length;

            text.setText(getString(R.string.finalText, data, wordCount));
        }
    }
}