package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {


MediaPlayer mediaPlayer;

private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mp) {
        releaseMediaPlayer();
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_item);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("lutti","one",R.raw.phrase_are_you_coming));
        words.add(new Word("otiiko","two",R.raw.phrase_come_here));
        words.add(new Word("tolookosu","three",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("oyyisa","four",R.raw.phrase_im_coming));
        words.add(new Word("massokka","five",R.raw.phrase_im_feeling_good));
        words.add(new Word("temmokka","six",R.raw.phrase_lets_go));
        words.add(new Word("kenekaku","seven",R.raw.phrase_my_name_is));
        words.add(new Word("kawinta","eight",R.raw.phrase_what_is_your_name));
        words.add(new Word("wo'e","nine",R.raw.phrase_where_are_you_going));
        words.add(new Word("na'aacha","ten",R.raw.phrase_yes_im_coming));

        WordAdapter wordAdapter = new WordAdapter(this,words,R.color.color_phrases);
        ListView listView = findViewById(R.id.list_item);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                MediaPlayer mediaPlayer = MediaPlayer.create(PhrasesActivity.this,word.getmMediaResourceId());
                mediaPlayer.start();

               mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if ( mediaPlayer!= null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

}
