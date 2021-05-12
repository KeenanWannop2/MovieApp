package com.example.nikeapp.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.example.nikeapp.R;
import com.example.nikeapp.model.MovieResponse;
import com.example.nikeapp.viewmodel.MainActivityViewModel;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Handler;
import android.view.View;

import android.widget.ImageView;
import android.widget.LinearLayout;

//TODO Add select movie, show trailer
public class MainActivity extends AppCompatActivity {
    MainActivityViewModel mViewModel;
    private DiscreteScrollView scrollView;
    private boolean adapterSet = false;
    private ImageView coverImage1;
    private ImageView coverImage2;
    private LinearLayout coverImageContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
        scrollView = findViewById(R.id.movieCarousel);
        coverImage1 = findViewById(R.id.coverImage1);
        coverImage2 = findViewById(R.id.coverImage2);
        coverImageContainer = findViewById(R.id.coverImageContainer);
        mViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        //Set the full screen doors
        Drawable doors = getResources().getDrawable(R.drawable.doors);
        //Setup the half doors
        getCropBitmaps(((BitmapDrawable)doors).getBitmap());
        //Populate the cards, call api
        getMovieData();
    }


    private void getMovieData() {
        mViewModel.getMovieData().observe(this, new Observer<MovieResponse>() {
            @Override
            public void onChanged(MovieResponse movieResponse) {
                if (movieResponse != null && movieResponse.getResults() != null && movieResponse.getResults().size() > 0) {
                    if (!adapterSet) {
                        adapterSet = true;
                        MovieAdapter movieAdapter = new MovieAdapter(movieResponse);
                        //Setup OSX Dock Magnification functionality
                        scrollView.setItemTransformer(new ScaleTransformer.Builder()
                                .setMaxScale(0.9f)
                                .setMinScale(0.6f)
                                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                                .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
                                .build());
                        //Setup Infinite Carousel, Wrap adapter
                        InfiniteScrollAdapter wrapper = InfiniteScrollAdapter.wrap(movieAdapter);
                        scrollView.setAdapter(wrapper);
                    }
                }
            }
        });
    }

    public void getCropBitmaps(Bitmap bitmap) {
        int with = bitmap.getWidth(); // Get the width and height of the picture
        int height = bitmap.getHeight();

        int nw, nh, retX;
        nw = with / 2;
        nh = height;
        retX = with / 2;

        // a container of two pictures
        Bitmap[] bitmaps = new Bitmap[2];
        // The first picture is cut at half the width starting from the X coordinate 0
        Bitmap bmp = Bitmap.createBitmap(bitmap, 0, 0, nw, nh, null,
                false);
        // The second picture starts at the half of the width of the X coordinate and intercepts half the width
        Bitmap bmp1 = Bitmap.createBitmap(bitmap, retX, 0, nw, nh, null,
                false);

        bitmaps[0] = bmp;//picture on the left
        bitmaps[1] = bmp1;//The picture on the right
        handleBitmaps(bitmaps);
    }

    private void handleBitmaps(Bitmap[] bitmaps) {
        coverImage1.setImageBitmap(bitmaps[0]);
        coverImage2.setImageBitmap(bitmaps[1]);

        Handler handler = new Handler();
        //Play Welcome
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.my_sound);
        mediaPlayer.start();
        //Start animation after 3.5 seconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //The halves are set, remove the combined doors image, animate the halves
                coverImageContainer.setBackground(null);
                coverImage1.animate()
                        .setDuration(1500)
                        .translationX(-(bitmaps[0].getWidth()+1000))
                        .start();
                coverImage2.animate()
                        .setDuration(1500)
                        .translationX(bitmaps[1].getWidth()+1000)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                mediaPlayer.release();
                                coverImageContainer.setVisibility(View.GONE);
                            }
                        })
                        .start();
            }
        }, 3200);

    }


}