package com.example.kyoantrovice.learningenglish;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by KyoAntrovice on 12/7/2015.
 */
public class AudioLesson1 extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button resetbtn,startbtn,pausebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audiolesson);

        startbtn = (Button) findViewById(R.id.startbtn);
        resetbtn = (Button) findViewById(R.id.resetbtn);
        pausebtn = (Button) findViewById(R.id.pausebtn);
        String [] listLesson = {
            "THE LION AND THE RABIT",
                "A cruel lion lived in the forest",
                "Every day, he killed and ate a lot of animals",
                "The other animals were afraid the lion would kill them all",
                "The animals told the lion,Let’s make a deal",
                "If you promise to eat only one animal each day, then one of us will come to you every day",
                "Then you don’t have to hunt and kill us",
                "The plan sounded well thought-out to the lion",
                "so he agreed, but he also said",
                "If you don’t come every day, I promise to kill all of you the next day!",
                "Each day after that, one animal went to the lion so that the lion could eat it",
                "Then, all the other animals were safe.",
                "Finally, it was the rabbit’s turn to go to the lion",
                "The rabbit went very slowly that day",
                "so the lion was angry when the rabbit finally arrived",
                "The lion angrily asked the rabbit",
                "Why are you late?",
                "I was hiding from another lion in the forest",
                "That lion said he was the king, so I was afraid",
                "The lion told the rabbit",
                "I am the only king here! Take me to that other lion and I will kill him",
                "The rabbit replied, “I will be happy to show you where he lives.",
                "The rabbit led the lion to an old well in the middle of the forest",
                "The well was very deep with water at the bottom",
                "The rabbit told the lion, “Look in there. The lion lives at the bottom",
                "When the lion looked in the well, he could see his own face in-the water",
                "He thought that was the other lion. Without waiting another moment",
                "the lion jumped into the well to attack the other lion",
                "He never came out",
                "All of the other animal in the forest were very pleased with the rabbit’s clevpriirick."
        };

        final ArrayAdapter<String> Lessons = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listLesson
        );

        ListView myLessons = (ListView) findViewById(R.id.listview_audio);
        myLessons.setAdapter(Lessons);

        mediaPlayer = MediaPlayer.create(this,R.raw.lionrabit);
        pausebtn.setEnabled(false);
        resetbtn.setEnabled(false);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AudioLesson1.this, "Playing Sound", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                pausebtn.setEnabled(true);
                resetbtn.setEnabled(true);
                startbtn.setEnabled(false);
            }
        });

        pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AudioLesson1.this, "Sound stopped",Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                startbtn.setEnabled(true);
                resetbtn.setEnabled(true);
                pausebtn.setEnabled(false);
            }
        });

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AudioLesson1.this,"Reset sound",Toast.LENGTH_SHORT).show();
                mediaPlayer.reset();
                startbtn.setEnabled(true);
                pausebtn.setEnabled(false);
                resetbtn.setEnabled(false);
            }
        });


    }
}
