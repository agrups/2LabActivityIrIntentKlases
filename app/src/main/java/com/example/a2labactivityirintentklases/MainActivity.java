package com.example.a2labactivityirintentklases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button enterTextButton;
    Button countWordsButton;
    Button sendTextButton;
    TextView enteredText;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent currentIntent = this.getIntent();
        data = (String) currentIntent.getSerializableExtra("data");

        enterTextButton = findViewById(R.id.enterTextButton);
        countWordsButton = findViewById(R.id.countWordsButton);
        sendTextButton = findViewById(R.id.sendTextButton);
        enteredText = findViewById(R.id.text);

        if(data != null){
            enteredText.setText(data);
        }

        enterTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEnterTextWindow(v);
            }
        });

        countWordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCountWordsWindow(v);
            }
        });

        sendTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSendTextWindow(v);
            }
        });
    }

    private void openEnterTextWindow(View v) {
        Intent enterTextWindow = new Intent(MainActivity.this, EnterTextWindow.class);
        startActivity(enterTextWindow);
    }

    private void openCountWordsWindow(View v) {
        Intent openCountWordsWindow = new Intent(MainActivity.this, OpenCountWordsWindow.class);
        openCountWordsWindow.putExtra("data", data);
        startActivity(openCountWordsWindow);
    }

    private void openSendTextWindow(View v) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, data);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}