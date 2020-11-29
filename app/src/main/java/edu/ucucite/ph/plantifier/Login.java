package edu.ucucite.ph.plantifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Cancel(View view) {
        startActivity(new Intent(this, Home.class));
    }

    public void loginbtn(View view) {

            startActivity(new Intent(this, Adminlogin.class));


    }
}