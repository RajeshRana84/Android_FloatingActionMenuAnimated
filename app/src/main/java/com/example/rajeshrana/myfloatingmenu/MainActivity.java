package com.example.rajeshrana.myfloatingmenu;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton mCallBtn;
    FloatingActionButton mSmsBtn;
    FloatingActionButton floatingActionButton;
    String phone = "111-111-1111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCallBtn = (FloatingActionButton)findViewById(R.id.fbCall);
        mSmsBtn = (FloatingActionButton)findViewById(R.id.fbSms);


        final LinearLayout mCallLayout = (LinearLayout)findViewById(R.id.CallLayout);
        final LinearLayout mSmsLayout = (LinearLayout)findViewById(R.id.SmsLayout);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);

        final Animation mshowButton = AnimationUtils.loadAnimation(MainActivity.this, R.anim.show_button);
        final Animation mhideButton = AnimationUtils.loadAnimation(MainActivity.this, R.anim.hide_button);


        final Animation mshowLayout = AnimationUtils.loadAnimation(MainActivity.this, R.anim.show_layout);
        final Animation mhideLayout = AnimationUtils.loadAnimation(MainActivity.this, R.anim.hide_layout);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mCallLayout.getVisibility() == View.VISIBLE && mSmsLayout.getVisibility() == View.VISIBLE){
                    mCallLayout.setVisibility(View.GONE);
                    mSmsLayout.setVisibility(View.GONE);
                    mCallLayout.startAnimation(mhideLayout);
                    mSmsLayout.startAnimation(mhideLayout);
                    floatingActionButton.startAnimation(mhideButton);

                }else{
                    mCallLayout.setVisibility(View.VISIBLE);
                    mSmsLayout.setVisibility(View.VISIBLE);
                    mCallLayout.startAnimation(mshowLayout);
                    mSmsLayout.startAnimation(mshowLayout);
                    floatingActionButton.startAnimation(mshowButton);
                }
            }
        });

        mCallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCallLayout.setVisibility(View.GONE);
                mSmsLayout.setVisibility(View.GONE);
                mCallLayout.startAnimation(mhideLayout);
                mSmsLayout.startAnimation(mhideLayout);
                floatingActionButton.startAnimation(mhideButton);
                Intent mIntent = new Intent(Intent.ACTION_DIAL);
                mIntent.setData(Uri.parse("tel:" + phone));
                if(mIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(mIntent);
                }else{
                    Toast.makeText(MainActivity.this, "No App to Support this action !!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mSmsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCallLayout.setVisibility(View.GONE);
                mSmsLayout.setVisibility(View.GONE);
                mCallLayout.startAnimation(mhideLayout);
                mSmsLayout.startAnimation(mhideLayout);

                Intent mIntent = new Intent(Intent.ACTION_VIEW);
                mIntent.setData(Uri.parse("sms:" + phone));
                if(mIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(mIntent);
                }else{
                    Toast.makeText(MainActivity.this, "No App to Support this action !!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
