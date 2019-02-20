package com.sefayalcindag.firstgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView ımageView;
    ImageView ımageView2;
    ImageView ımageView3;
    ImageView ımageView4;
    ImageView ımageView5;
    ImageView ımageView6;
    ImageView ımageView7;
    ImageView ımageView8;
    ImageView ımageView9  ;
    TextView textviewTime ;
    TextView textviewPuan ;
    int puan;
    Handler handler;
    Runnable runnable;
    ImageView [] ımageArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         ımageView=findViewById(R.id.sirin);
         ımageView2=findViewById(R.id.sirin2);
         ımageView3=findViewById(R.id.sirin3);
         ımageView4=findViewById(R.id.sirin4);
         ımageView5=findViewById(R.id.sirin5);
         ımageView6=findViewById(R.id.sirin6);
         ımageView7=findViewById(R.id.sirin7);
         ımageView8=findViewById(R.id.sirin8);
         ımageView9=findViewById(R.id.sirin9);


        Main2Activity.puan = 0;
         ımageArray = new ImageView[]{ımageView, ımageView2, ımageView3, ımageView4, ımageView5, ımageView6, ımageView7, ımageView8, ımageView9};
        hideImages();
         new CountDownTimer(15000,1000){

             @Override
             public void onTick(long l) {
                 textviewTime =findViewById(R.id.textViewTime);
                 textviewTime.setText("TİME : " +l/1000 );
             }

             @Override
             public void onFinish() {
                textviewTime.setText("TİME : 0 ");
                Toast.makeText(getApplicationContext(), " Süreniz bitti !!!", Toast.LENGTH_LONG).show();
                handler.removeCallbacks(runnable);
                for(ImageView image : ımageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                Intent ıntent1 = new Intent(getApplicationContext(),Main2Activity.class);
                 startActivity(ıntent1);


             }
         }.start();

    }

    public void scoreText(View view){
        textviewPuan =findViewById(R.id.textViewPuan);

        Main2Activity.puan++;
        textviewPuan.setText("PUAN : " + Main2Activity.puan);

    }


    public void hideImages(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                for(ImageView image : ımageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random r = new Random();
                int i = r.nextInt(8-0);
                ımageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this, 400);
            }
        };
        handler.post(runnable);
    }



}
