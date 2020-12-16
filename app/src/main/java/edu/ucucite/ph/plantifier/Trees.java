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

public class Trees extends AppCompatActivity {
    private rAdapter4Tree mAdapter4Tree;
    private ArrayList<TreesDB> mTreeDB;
    RecyclerView recyclerView;

    private DatabaseReference myRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trees);
        recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        myRef = FirebaseDatabase.getInstance().getReference("Trees");
//          Arraylist
        mTreeDB = new ArrayList<>();


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()){
                    TreesDB treeDB = postSnapshot.getValue(TreesDB.class);
                    mTreeDB.add(treeDB);

                }
                mAdapter4Tree = new rAdapter4Tree(Trees.this, mTreeDB);
                recyclerView.setAdapter(mAdapter4Tree);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Trees.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });




    }



    public void onClickabout(View view) {
        startActivity(new Intent(this, About.class));

    }

    public void onClickplants(View view) {
        startActivity(new Intent(this, Plants.class));

    }
    public void onClicktoppicks(View view) {
        startActivity(new Intent(this, Home.class));

    }
    public void onClickflowers(View view) {
        startActivity(new Intent(this, Flowers.class));

    }
    public void onClickprofile(View view) {
        startActivity(new Intent(this, Adminlogin.class));

    }
}