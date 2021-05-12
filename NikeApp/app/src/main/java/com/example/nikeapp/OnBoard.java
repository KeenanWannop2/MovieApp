package com.example.nikeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class OnBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        Handler handler = new Handler();
        Intent intent = new Intent(this, MainActivity.class);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);

                overridePendingTransition(0,0);
            }
        }, 2000);
    }

    public static Bitmap getImageOfView(View view) {
        int width1 = view.getMeasuredWidth();
        int height1 = view.getMeasuredHeight();
        Bitmap bmp1 = Bitmap.createBitmap(width1, height1,
                Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bmp1));
        Canvas canvas = new Canvas(bmp1);
        Paint paint = new Paint();
        paint.setColor(Color.TRANSPARENT);
        canvas.drawBitmap(bmp1, 0, 0, null);
        return bmp1;
    }
}