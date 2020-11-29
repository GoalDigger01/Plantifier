package edu.ucucite.ph.plantifier;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {



    BroadcastReceiver broadcastReceiver;
    //Object
    ConnectivityManager connectivityManager;


    //Variables
    boolean isConnected;
    boolean isConnectionSignal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



    }
    public void onClickabout(View view) {
        startActivity(new Intent(this, About.class));

    }

    public void onClickplants(View view) {
        startActivity(new Intent(this, Plants.class));

    }
    public void onClicktrees(View view) {
        startActivity(new Intent(this, Trees.class));

    }
    public void onClickflowers(View view) {
        startActivity(new Intent(this, Flowers.class));

    }

    public void onClickprofile(View view) {
        broadCast();


    }
    //Methods
    @Override
    public void onResume(){
        super.onResume();
        registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    public void onPause(){
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }
    public void broadCast(){
        conStatus();
        if(isConnected){
            if(isConnectionSignal){
                startActivity(new Intent(this, Login.class));
            }else{
                swipeStatus("Connecting...");
            }
        }else{
            swipeStatus("No Connection");
        }
    }
    public void swipeStatus(String msg){

        AlertDialog.Builder alertDialog= new AlertDialog.Builder(this);
        alertDialog.setMessage("" + msg);
        alertDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }

    //Methods

    public void conStatus(){
        connectivityManager= (ConnectivityManager)
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        isConnected=networkInfo != null && networkInfo.isConnectedOrConnecting();//Boolean
        if(isConnected){
            isConnectionSignal=conSignal(networkInfo.getType(),networkInfo.getSubtype());
            isConnected=true;
        }else{
            isConnected=false;
        }



    }


    public static boolean conSignal(int type , int subType){
        if(type==ConnectivityManager.TYPE_WIFI){
            return true;
        }else if(type==ConnectivityManager.TYPE_MOBILE){
            switch(subType){
                case TelephonyManager.NETWORK_TYPE_1xRTT:
                    return false; // ~ 50-100 kbps
                case TelephonyManager.NETWORK_TYPE_CDMA:
                    return false; // ~ 14-64 kbps
                case TelephonyManager.NETWORK_TYPE_EDGE:
                    return false; // ~ 50-100 kbps
                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    return true; // ~ 400-1000 kbps
                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                    return true; // ~ 600-1400 kbps
                case TelephonyManager.NETWORK_TYPE_GPRS:
                    return false; // ~ 100 kbps
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                    return true; // ~ 2-14 Mbps
                case TelephonyManager.NETWORK_TYPE_HSPA:
                    return true; // ~ 700-1700 kbps
                case TelephonyManager.NETWORK_TYPE_HSUPA:
                    return true; // ~ 1-23 Mbps
                case TelephonyManager.NETWORK_TYPE_UMTS:
                    return true; // ~ 400-7000 kbps
                case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                default:
                    return false;
            }
        }else{
            return false;
        }
    }
}