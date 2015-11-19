package com.example.admin.learningesstenialenglishwords;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void essentialWords(View view){
        // Tesst
        Intent intent = new Intent(this,EssentialWordsScreen2.class);
        intent.putExtra("message",message);
        startActivity(intent);
    }
}
