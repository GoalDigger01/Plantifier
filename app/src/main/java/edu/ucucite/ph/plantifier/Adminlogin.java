package edu.ucucite.ph.plantifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Adminlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
    }

    public void cancelbtn(View view) {
        startActivity(new Intent(this, Login.class));
    }

    public void adminloginbtn(View view) {
        startActivity(new Intent(this, Adminhome.class));
    }
}