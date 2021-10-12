package com.github.rostSmartApps.BrojacPunti.Briskula_package;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.github.rostSmartApps.BrojacPunti.R;
public class Briskula_createtim extends AppCompatActivity {

    String x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treseta_create_tim);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .2));


        if(Briskula.count>=4)
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Maksimalan broj timova!");
            alertDialogBuilder.setNegativeButton("Uredu",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
    }



    public void Potvrdi(View v) {
        EditText editText=(EditText)findViewById(R.id.ImeTima);
        x = editText.getText().toString();
        if(x.matches(""))
        {

            AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(this);
            alertDialogBuilder1.setMessage("Tim mora imati ime!");
            alertDialogBuilder1.setNegativeButton("Uredu",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            AlertDialog alertDialog1 = alertDialogBuilder1.create();
            alertDialog1.show();
        }
        else {
            Intent intent = new Intent();
            intent.putExtra("ImeTima", x);
            setResult(RESULT_OK, intent);
            finish();
            this.finish();
        }
    }

}