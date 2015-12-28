package com.example.kyoantrovice.learningenglish;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainPage extends AppCompatActivity {

    ListView list;

    static final String [] listMainPage = {
            "Audio Lesson",
            "Essential Words",
            "Exercises",
            "Games",
            "Favorite Words",
            "Settings"
    };


    Integer[] imageID = {
            R.drawable.audiolesson_logo,
            R.drawable.essentialwords_logo,
            R.drawable.exercises_logo,
            R.drawable.games_logo,
            R.drawable.favoritewords_logo,
            R.drawable.settings_logo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        final ListArrayAdapter adapter = new
                ListArrayAdapter(MainPage.this,listMainPage,imageID);
        list = (ListView)findViewById(R.id.listView_mainpage);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = adapter.getItem(position);
                Toast.makeText(MainPage.this,text + " selected",Toast.LENGTH_SHORT).show();
                if (text == "Essential Words"){
                    Intent intent1 = new Intent(MainPage.this,EssentialWords.class);
                    startActivity(intent1);
                }
                if (text == "Exercises"){
                    Intent intent2 = new Intent(MainPage.this,ExerciseList.class);
                    startActivity(intent2);
                }

                if(text == "Audio Lesson"){
                    Intent intent3 = new Intent(MainPage.this,AudioList.class);
                    startActivity(intent3);
                }

                if(text == "Games"){
                    Intent intent4 = new Intent(MainPage.this,MemoryGame.class);
                    startActivity(intent4);
                }
            }
        });
    }
}
