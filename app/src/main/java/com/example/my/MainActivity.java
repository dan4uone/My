package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText email;
    private EditText theme;
    private EditText message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.send);
        email = findViewById(R.id.email);
        theme = findViewById(R.id.theme);
        message = findViewById(R.id.message);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("email",email.getText().toString(),null));
                intent.putExtra(Intent.EXTRA_EMAIL,email.getText().toString());
                intent.putExtra(Intent.EXTRA_SUBJECT,theme.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,message.getText().toString());
                startActivity(Intent.createChooser(intent,"send"));


            }
        });

    }
}