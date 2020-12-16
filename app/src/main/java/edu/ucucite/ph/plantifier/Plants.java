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

public class Plants extends AppCompatActivity {

    private rAdapter4Plant mAdapter4Plant;
    private ArrayList<PlantDB> mPlantDB;
    RecyclerView recyclerView;

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants);
        recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        myRef = FirebaseDatabase.getInstance().getReference("Plants");
//          Arraylist
        mPlantDB = new ArrayList<>();




    myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            for (DataSnapshot postSnapshot : snapshot.getChildren()){
                PlantDB plantDB = postSnapshot.getValue(PlantDB.class);
                mPlantDB.add(plantDB);

            }
            mAdapter4Plant = new rAdapter4Plant(Plants.this, mPlantDB);
            recyclerView.setAdapter(mAdapter4Plant);


        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            Toast.makeText(Plants.this, error.getMessage(), Toast.LENGTH_SHORT).show();

        }
    });




}





    public void onClickabout(View view) {
        startActivity(new Intent(this, About.class));

    }
    public void onClicktoppicks(View view) {
        startActivity(new Intent(this, Home.class));

    }
    public void onClicktrees(View view) {
        startActivity(new Intent(this, Trees.class));

    }
    public void onClickflowers(View view) {
        startActivity(new Intent(this, Flowers.class));

    }
    public void onClickprofile(View view) {
        startActivity(new Intent(this, Adminlogin.class));

    }
}