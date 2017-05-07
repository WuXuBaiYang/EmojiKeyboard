package com.jtech.emojidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.jtech.emojikeyboardlibrary.EmojiView;

public class MainActivity extends AppCompatActivity {
    private EmojiView emojiView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emojiView = (EmojiView) findViewById(R.id.emojiView);
        editText = (EditText) findViewById(R.id.edittext);
        emojiView.setupWithEditText(editText);
    }
}
