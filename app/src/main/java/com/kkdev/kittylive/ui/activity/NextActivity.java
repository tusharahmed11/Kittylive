package com.kkdev.kittylive.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.kkdev.kittylive.R;

public class NextActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();

        int height = intent.getIntExtra("height",150);
        int width = intent.getIntExtra("width",150);

        imageView.requestLayout();
        imageView.getLayoutParams().height = height;
        imageView.getLayoutParams().width = width;
    }
}