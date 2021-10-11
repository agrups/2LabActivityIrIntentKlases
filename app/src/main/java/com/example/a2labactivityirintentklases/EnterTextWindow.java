package com.example.a2labactivityirintentklases;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterTextWindow extends AppCompatActivity {
    EditText enterTextField;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_text_window);

        enterTextField = (EditText) findViewById(R.id.enterText);

        saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnResult(v);
            }
        });
    }

    public void returnResult(View w){
        String enteredText = enterTextField.getText().toString();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("enteredText", enteredText);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}