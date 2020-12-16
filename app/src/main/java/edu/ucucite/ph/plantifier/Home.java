package edu.ucucite.ph.plantifier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;



public class Home extends AppCompatActivity {

//  ADDED
    private rAdapter mAdapter;
    private ArrayList<TopPicksDB> mTopPicksDb;

    //Widget
        RecyclerView recyclerView;

//    Firebase
    private DatabaseReference myRef;
    StorageReference storageReference;
//Variables
//    private ArrayList<TopPicksDbRetrieve> TopPicksDB;
    private RecyclerAdapter recyclerAdapter;
    private Context mContext;

//
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


        recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        // get the reference of RecyclerView



//        Firebase

          myRef = FirebaseDatabase.getInstance().getReference("Top Picks");
//          Arraylist
        mTopPicksDb = new ArrayList<>();
//          Clear Arraylist
//        ClearAll();
//        Get Data Method
//        GetDataFromFirebase();



//            ADDED



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()){
                    TopPicksDB topPicksDB = postSnapshot.getValue(TopPicksDB.class);
                    mTopPicksDb.add(topPicksDB);

                }
                mAdapter = new rAdapter(Home.this, mTopPicksDb);
                recyclerView.setAdapter(mAdapter);




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Home.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
//        ADDED



    }

//    private void GetDataFromFirebase() {
//
//        Query query = myRef.child("Top Picks");
//        query.addListenerForSingleValueEvent(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//
//
//                    TopPicksDbRetrieve toppicksDB = new TopPicksDbRetrieve();
//                    toppicksDB.setImageurl(snapshot.child("imageurl").getValue().toString());
//                    toppicksDB.settype(snapshot.child("type").getValue().toString());
//                    toppicksDB.setName(snapshot.child("name").getValue().toString());
//                    toppicksDB.setFamily(snapshot.child("family").getValue().toString());
//                    toppicksDB.setFloweringTime(snapshot.child("floweringTime").getValue().toString());
//                    toppicksDB.setHabitat(snapshot.child("habitat").getValue().toString());
//                    toppicksDB.setDescription(snapshot.child("description").getValue().toString());
//                    TopPicksDB.add(toppicksDB);
//
//
//                    recyclerAdapter = new RecyclerAdapter(mContext, TopPicksDB);
//                    recyclerView.setAdapter(recyclerAdapter);
//
//                    recyclerAdapter.notifyDataSetChanged();
//                }
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//
//
//            }
//        });



//    }
//    private void ClearAll(){
//        if (TopPicksDB !=null){
//            TopPicksDB.clear();
//
//        }
//        TopPicksDB = new ArrayList<>();
//    }

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
    public void broadCast(){
        conStatus();
        if(isConnected){
            if(isConnectionSignal){
                startActivity(new Intent(this, Adminlogin.class));
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