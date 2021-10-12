package com.github.rostSmartApps.BrojacPunti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.github.rostSmartApps.BrojacPunti.Treseta_package.Treseta;
import com.github.rostSmartApps.BrojacPunti.Briskula_package.Briskula;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void Treseta( View v)
    {
        Intent intent=new Intent(this, Treseta.class);
        startActivity(intent);
}

    public void Briskula(View v) {
        Intent intent=new Intent(this, Briskula.class);
        startActivity(intent);
    }

    public void Credits(View view) {
        Intent intent=new Intent(this, Credits.class);
        startActivity(intent);
    }

    public void Upute(View view) {
        Intent intent=new Intent(this, Upute.class);
        startActivity(intent);
    }
}
