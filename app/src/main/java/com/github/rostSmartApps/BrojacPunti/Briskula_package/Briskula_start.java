package com.github.rostSmartApps.BrojacPunti.Briskula_package;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.github.rostSmartApps.BrojacPunti.MainActivity;
import com.github.rostSmartApps.BrojacPunti.R;

public class Briskula_start extends AppCompatActivity {
    String temp;

    TextView tim1,tim2,tim3,tim4,bod1,bod2,bod3,bod4;
    Button but1,but2,but3,but4;
    Bundle bundle;
    String BOD;
    String HoldLastValue;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_briskula_start);
        bundle=getIntent().getExtras();
        BOD=bundle.getString(Briskula.BODOVI);
        BOD = BOD.replaceAll("\\D+","");
        TextView textView=(TextView) findViewById(R.id.Bodovitext);
        textView.setText("Igra se do "+BOD);
        switch(Briskula.count)
        {
            case 4:temp=bundle.getString(Briskula.TIM4);
                tim4=(TextView) findViewById(R.id.timStart4);
                tim4.setText(temp);
                but4=(Button)findViewById(R.id.timPotvrdi4);
                but4.setVisibility(View.VISIBLE);
                but4.setText(temp);
                bod4=(TextView) findViewById(R.id.bodStart4);
                bod4.setText("0");

            case 3:temp=bundle.getString(Briskula.TIM3);
                tim3=(TextView) findViewById(R.id.timStart3);
                tim3.setText(temp);
                but3=(Button)findViewById(R.id.timPotvrdi3);
                but3.setText(temp);
                but3.setVisibility(View.VISIBLE);
                bod3=(TextView) findViewById(R.id.bodStart3);
                bod3.setText("0");


            case 2:temp=bundle.getString(Briskula.TIM2);
                tim2=(TextView) findViewById(R.id.timStart2);
                tim2.setText(temp);
                but2=(Button)findViewById(R.id.timPotvrdi2);
                but2.setText(temp);
                but2.setVisibility(View.VISIBLE);
                bod2=(TextView) findViewById(R.id.bodStart2);
                bod2.setText("0");


            case 1:temp=bundle.getString(Briskula.TIM1);
                tim1=(TextView) findViewById(R.id.timStart1);
                tim1.setText(temp);
                but1=(Button)findViewById(R.id.timPotvrdi1);
                but1.setText(temp);
                but1.setVisibility(View.VISIBLE);
                bod1=(TextView) findViewById(R.id.bodStart1);
                bod1.setText(Integer.toString(0));


                break;

        }

    }

    public void Dodajbod1(View view) {
        HoldLastValue= bod1.getText().toString();
        flag=1;
            bod1.setText(Integer.toString(Integer.parseInt(bod1.getText().toString()) + 1));
if(Integer.parseInt(bod1.getText().toString())==Integer.parseInt(BOD))
{
    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
    alertDialogBuilder.setMessage("Pobjednik je "+bundle.getString(Briskula.TIM1)+"!");
    alertDialogBuilder.setNegativeButton("Uredu",new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Briskula.count=0;
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    });
    AlertDialog alertDialog = alertDialogBuilder.create();
    alertDialog.show();
}

    }
    public void Dodajbod2(View view) {
        HoldLastValue= bod2.getText().toString();
        flag=2;
        bod2.setText(Integer.toString(Integer.parseInt(bod2.getText().toString()) + 1));
        if(Integer.parseInt(bod2.getText().toString())==Integer.parseInt(BOD))
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Pobjednik je "+bundle.getString(Briskula.TIM2)+"!");
            alertDialogBuilder.setNegativeButton("Uredu",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Briskula.count=0;
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    public void Dodajbod3(View view) {
        HoldLastValue= bod3.getText().toString();
        flag=3;
        bod3.setText(Integer.toString(Integer.parseInt(bod3.getText().toString()) + 1));
        if(Integer.parseInt(bod3.getText().toString())==Integer.parseInt(BOD))
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Pobjednik je "+bundle.getString(Briskula.TIM3)+"!");
            alertDialogBuilder.setNegativeButton("Uredu",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Briskula.count=0;
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    public void Dodajbod4(View view) {
        HoldLastValue= bod4.getText().toString();
        flag=4;
        bod4.setText(Integer.toString(Integer.parseInt(bod4.getText().toString()) + 1));
        if(Integer.parseInt(bod4.getText().toString())==Integer.parseInt(BOD))
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Pobjednik je "+bundle.getString(Briskula.TIM4)+"!");
            alertDialogBuilder.setNegativeButton("Uredu",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Briskula.count=0;
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    public void Kraj(View view) {
        Briskula.count=0;
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);



    }

    public void Undo(View view) {
        switch(flag)
        {
            case 1:bod1.setText(HoldLastValue);
                flag=0;
                break;
            case 2:bod2.setText(HoldLastValue);
                flag=0;
                break;
            case 3:bod3.setText(HoldLastValue);
                flag=0;
                break;
            case 4:bod4.setText(HoldLastValue);
                flag=0;
                break;
            default:
                break;
        }
    }
}

