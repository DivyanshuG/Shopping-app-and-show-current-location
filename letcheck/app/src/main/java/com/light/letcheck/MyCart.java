package com.light.letcheck;

import android.app.Application;

/**
 * Created by light_ on 18-06-2016.
 */
public class MyCart extends Application {


    public static String Cart = new String();
    public static int total  ;

    static void add(String addname, int addprice){
        Cart = Cart +"\n" +addname + " :  Rs " + addprice;
        total= total+addprice;
    }
    static String getcart(){
        return Cart;
    }
    static int getTotal(){
        return total;
    }
}
