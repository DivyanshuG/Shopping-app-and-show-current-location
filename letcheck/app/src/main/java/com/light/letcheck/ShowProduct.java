package com.light.letcheck;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ShowProduct extends ActionBarActivity {
    float x1,x2;
    float y1, y2;
    String desc = "Specification: \n Camera :13 MP + \n Ram: 3GB " ;
    public static String data;
    public static int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);

        data= getIntent().getStringExtra("name");
        int pos =getIntent().getIntExtra("pos", 0);
        Integer image = getIntent().getIntExtra("image",0);
        price = getIntent().getIntExtra("price",0);
        TextView txt = (TextView) findViewById(R.id.nameview);
        txt.setText(data + "");
        ImageView imgv = (ImageView) findViewById(R.id.imageView);
        imgv.setImageResource(image);
        TextView txtp = (TextView) findViewById(R.id.priceview);
        txtp.setText("Rs " + price);
        TextView spec = (TextView) findViewById(R.id.des);
        spec.setText(desc+"");


    }

    public boolean onTouchEvent(MotionEvent touchevent)
    {
        switch (touchevent.getAction())
        {

            case MotionEvent.ACTION_DOWN:
            {
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                x2 = touchevent.getX();
                y2 = touchevent.getY();

                //if left to right sweep event on screen
                if (x1 < x2)
                {
                    Toast.makeText(this, "Add to Cart", Toast.LENGTH_SHORT).show();
                    final MyCart crt = (MyCart) getApplicationContext();
                    crt.add(data, price);
                    startActivity(new Intent(this, MainActivity.class));


                }

                // if right to left sweep event on screen
                if (x1 > x2)
                {
                    Toast.makeText(this, "Dislike", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, MainActivity.class));
                }

                // if UP to Down sweep event on screen

            }
        }
        return false;
    }


}


