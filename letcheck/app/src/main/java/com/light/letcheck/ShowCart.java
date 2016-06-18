package com.light.letcheck;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ShowCart extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cart);

        final MyCart crt = (MyCart) getApplicationContext();
        String t = crt.getcart();
        int p =crt.getTotal();
        TextView carttxt = (TextView) findViewById(R.id.carttext);
        carttxt.setText(t);
        TextView carttl = (TextView) findViewById(R.id.carttotalview);
        carttl.setText("Total Price :Rs " + p);


    }


    public void checkout(View view){
        startActivity(new Intent(this,Map.class));
        //AIzaSyA1zRHn1IA3Yn07vTk8QSxSxZY_FlhzG5k
    }

}
