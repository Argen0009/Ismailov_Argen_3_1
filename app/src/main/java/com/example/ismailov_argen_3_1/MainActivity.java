package com.example.ismailov_argen_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText reipient;
    private EditText subject;
    private EditText messege;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reipient = findViewById(R.id.reipient);
        subject = findViewById(R.id.subject);
        messege = findViewById(R.id.messege);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button buttonSend = findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });


    }
    private void sendMail(){
        String recipientList = reipient.getText().toString();
        String[] recipients = recipientList.split(",");

        String subjects = subject.getText().toString();
        String messages = messege.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,subjects);
        intent.putExtra(Intent.EXTRA_TEXT,messages);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an email client "));


    }

    }