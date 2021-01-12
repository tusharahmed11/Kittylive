package com.kkdev.kittylive.ui.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kkdev.kittylive.R;
import com.kkdev.kittylive.ui.activity.NextActivity;

public class UserFragment extends Fragment {

    private ImageView imageView;

    public UserFragment() {
        // Required empty public constructor
    }
    long FirstTouchTime ;
    long duration ;
    int w = 1;
    int h = 1;
    private Handler handler = new Handler();
    ConstraintLayout.LayoutParams layoutParams;
    int height;
    int width ;
    int afterHeight;
    int afterWidth;

    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        imageView = view.findViewById(R.id.imageView);
        height = 150;
        width = 150;
        imageView.requestLayout();
        imageView.getLayoutParams().height = height;
        imageView.getLayoutParams().width = width;

        AppCompatButton nextAct = (AppCompatButton) view.findViewById(R.id.nextActivity);
        nextAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NextActivity.class);
                intent.putExtra("height",afterHeight);
                intent.putExtra("width",afterWidth);
                startActivity(intent);
            }
        });

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();

                //Code to convert height and width in dp.
                int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 35, getResources().getDisplayMetrics());
                int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 140, getResources().getDisplayMetrics());


                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    FirstTouchTime = System.currentTimeMillis();
                    startExtending();


                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    duration = System.currentTimeMillis() - FirstTouchTime ;
                    stopRepeating();
                    afterHeight = imageView.getLayoutParams().height;
                    afterWidth = imageView.getLayoutParams().width;
                    Log.d("Height", "onTouch: "+imageView.getLayoutParams().height);
                    Log.d("Height", "onTouch: "+imageView.getLayoutParams().width);

//                    Log.d("UserFragment", "onTouch: "+duration);
//                    h++;
//                    w++;
//                    layoutParams.width = width + w;
//                    layoutParams.height = height + h;
//                    imageView.setLayoutParams(layoutParams);
                }
                else if (event.getAction() == MotionEvent.ACTION_POINTER_DOWN){
                    /*Log.d("UserFragment", "onTouch: "+duration);
                    h++;
                    w++;
                    layoutParams.width = width + w;
                    layoutParams.height = height + h;
                    imageView.setLayoutParams(layoutParams);*/
                }
                return false;
            }
        });
        return view;

    }

    private void startExtending(){
        extendRunnable.run();
    }
    private void stopRepeating(){
        handler.removeCallbacks(extendRunnable);
    }
    private Runnable extendRunnable = new Runnable() {
        @Override
        public void run() {
            if (h < 100){
                h++;
                w++;
            }

            imageView.requestLayout();

            imageView.getLayoutParams().height = height+ h;
            imageView.getLayoutParams().width = height + w;
            Animation animShake = AnimationUtils.loadAnimation(requireContext(), R.anim.shake);
            imageView.startAnimation(animShake);
            handler.postDelayed(this,0);
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        imageView.requestLayout();
        w = 1;
        h = 1;
        imageView.getLayoutParams().height = 150;
        imageView.getLayoutParams().width = 150;
    }
}