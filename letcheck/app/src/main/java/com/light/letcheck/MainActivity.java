package com.light.letcheck;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


ListView list;
	String[] itemname ={
			"HTC 10",
			"Google Nexus 6P",
			"One Plus 3",
			"Xiomi Mi 5",
			"Samsung edge S7 edge",
			"Apple Iphone 6s",
			"Moto g4+",
			"Lenova Vibe X3"
		};


    Integer[] imgid={
            R.drawable.htc10,
            R.drawable.nexus,
            R.drawable.one3,
            R.drawable.mi5,
            R.drawable.edge,
            R.drawable.iphone,
            R.drawable.g4,
            R.drawable.x3,

    };

    int[] price= {50000,37000,27000,24000,55000,60000,15000,20000};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid,price);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();


                Integer img = imgid[+position];
                int pric = price[+position];
                Intent i = new Intent(MainActivity.this, ShowProduct.class);
                i.putExtra("name",Slecteditem);
                i.putExtra("price",pric);
                i.putExtra("pos",position);
                i.putExtra("image",img);
                startActivity(i);

            }
        });
    }
    public void checkcart(View view){

        startActivity(new Intent(MainActivity.this,ShowCart.class));
    }
}