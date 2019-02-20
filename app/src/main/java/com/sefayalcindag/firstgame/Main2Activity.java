package com.sefayalcindag.firstgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
      static  int puan;
      static  int highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textViewnew = findViewById(R.id.textViewscore);
        TextView textView = findViewById(R.id.textView2);
        ImageView ımageView = findViewById(R.id.imagetavsan);



        if(Main2Activity.highscore < Main2Activity.puan){
            Main2Activity.highscore = Main2Activity.puan;
            textViewnew.setText("High Score : " + Main2Activity.highscore);
        }
        else{
            textViewnew.setText("High Score : " + Main2Activity.highscore);
        }

    }

    public void oyunabasla(View view ){
       Intent ıntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(ıntent);

    }
}
