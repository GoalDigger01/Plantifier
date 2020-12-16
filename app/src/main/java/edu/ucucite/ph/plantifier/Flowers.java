package edu.ucucite.ph.plantifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Flowers extends AppCompatActivity {
    private rAdapter4Flower mAdapter4Flower;
    private ArrayList<FlowersDB> mFlowerDB;
    RecyclerView recyclerView;

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowers);

        recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        myRef = FirebaseDatabase.getInstance().getReference("Flowers");
//          Arraylist
        mFlowerDB = new ArrayList<>();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()){
                    FlowersDB flowersDB = postSnapshot.getValue(FlowersDB.class);
                    mFlowerDB.add(flowersDB);

                }
                mAdapter4Flower = new rAdapter4Flower(Flowers.this, mFlowerDB);
                recyclerView.setAdapter(mAdapter4Flower);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Flowers.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });




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
    public void onClicktoppicks(View view) {
        startActivity(new Intent(this, Home.class));

    }
    public void onClickprofile(View view) {
        startActivity(new Intent(this, Adminlogin.class));

    }
}