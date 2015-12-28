package com.example.kyoantrovice.learningenglish;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

/**
 * Created by KyoAntrovice on 11/26/2015.
 */
public class Lesson1 extends AppCompatActivity {
    private TextToSpeech tts;
    ListView myLesson1;
    String[] listword1 = {
            "afraid \n /əˈfreɪd/ verb \n sợ hãi",
            "agree \n /əˈɡri/ verb \n đồng ý",
            "angry \n /ˈæŋɡri/ adjective \n tức giận",
            "arrive \n /əˈraɪv/ verb \n đến",
            "attack \n /əˈtæk/ verb \n tấn công",
            "bottom \n /ˈbɒtəm/ noun \n đáy ",
            "clever \n /ˈklevə(r)/ adjective \n thông minh",
            "cruel  \n /ˈkruːəl/ adjective \n độc ác",
            "finally \n  /ˈfaɪnəli/ adverb \n cuối cùng",
            "hide \n  /haɪd/ verb \n trốn",
            "hunt \n /hʌnt/ verb \n săn bắn",
            "lot \n  /lɒt/ noun \n số lượng lớn",
            "middle \n /ˈmɪdl/ noun \n giữa ",
            "moment \n  /ˈməʊmənt/ noun \n khoảng thời gian rất ngắn",
            "pleased \n /pliːzd/ adjective \n hài lòng",
            "promise \n /ˈprɒmɪs/ verb \n hứa",
            "reply \n /rɪˈplaɪ/ verb \n phản hồi",
            "safe \n /seɪf/ adjective \n an toàn",
            "well \n  /wel/ adverb \n tốt, giởi",
    };

    Integer[] imageID = {
            R.drawable.afraid,
            R.drawable.agree,
            R.drawable.angry,
            R.drawable.arrival,
            R.drawable.attack,
            R.drawable.bottom,
            R.drawable.clever,
            R.drawable.cruel,
            R.drawable.finaal,
            R.drawable.hide,
            R.drawable.hunt,
            R.drawable.lot,
            R.drawable.middle,
            R.drawable.moment,
            R.drawable.pleased,
            R.drawable.promise,
            R.drawable.reply,
            R.drawable.safe,
            R.drawable.well
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

       final ListArrayAdapter lesson1 = new ListArrayAdapter(Lesson1.this,listword1,imageID);
        myLesson1 = (ListView) findViewById(R.id.listView_mainpage);
        myLesson1.setAdapter(lesson1);
        myLesson1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = (String) lesson1.getItem(position);
                String[] parts = text.split(" ", 2);
                final String neededword = parts[0];
                tts = new TextToSpeech(Lesson1.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            int result = tts.setLanguage(Locale.US);
                            if (result == TextToSpeech.LANG_MISSING_DATA ||
                                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                Log.e("error", "This Language is not supported");
                            } else {
                                tts.speak(neededword, TextToSpeech.QUEUE_FLUSH,null);
                                Toast.makeText(getApplicationContext(),neededword + " has been read",Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.e("error", "Initilization failed!");
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onPause() {
        if(tts!=null){
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }
}
