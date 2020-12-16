package edu.ucucite.ph.plantifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Adminlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
    }

    public void cancelbtn(View view) {
        startActivity(new Intent(this, Home.class));
    }

    public void adminloginbtn(View view) {
        startActivity(new Intent(this, Adminhome.class));
    }
}