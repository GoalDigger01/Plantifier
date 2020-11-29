package edu.ucucite.ph.plantifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Plants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants);
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
        startActivity(new Intent(this, Login.class));

    }
}