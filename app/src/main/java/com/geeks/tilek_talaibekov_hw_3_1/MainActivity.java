package com.geeks.tilek_talaibekov_hw_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etMail, etTheme, etText;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        onClick();
    }

    private void findId() {
        etMail = findViewById(R.id.mail);
        etTheme = findViewById(R.id.theme);
        etText = findViewById(R.id.text);
        btnSend = findViewById(R.id.send);
    }

    private void onClick() {
        btnSend.setOnClickListener(v -> {
            navigateNext();
        });
    }
    private void navigateNext() {
        String mail = etMail.getText().toString();
        String theme = etTheme.getText().toString();
        String text = etText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{mail});
        intent.putExtra(Intent.EXTRA_SUBJECT, theme);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(Intent.createChooser(intent, "text"));
    }
}