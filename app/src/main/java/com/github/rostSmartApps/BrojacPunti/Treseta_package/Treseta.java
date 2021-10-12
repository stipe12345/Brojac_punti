package com.github.rostSmartApps.BrojacPunti.Treseta_package;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.rostSmartApps.BrojacPunti.R;

public class Treseta extends AppCompatActivity {
    static int count=0;
    public static final String TIM1="TIM1";
    public static final String TIM2="TIM2";
    public static final String TIM3="TIM3";
    public static final String TIM4="TIM4";
    public static final String BODOVI="bodovi";
    public TextView textView;
    public SeekBar seekBar;
    Bundle bundle=new Bundle();
    String strEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treseta);
        textView=(TextView) findViewById(R.id.textseekBar);
        seekBar=(SeekBar) findViewById((R.id.seekBar));
        seekBar.incrementProgressBy(10);
        seekBar.setProgress(41);
        seekBar.setMax(51);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = progress / 10;
                progress = progress * 10+1;
                if(progress<10)
                    progress=11;
                textView.setText("Broj bodova: " +progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        count=0;
        this.finish();
    }
    public void Back( View v)
    {
        count=0;
        this.finish();
    }

    public void CreateTim(View v)
    {
        Intent i = new Intent(this, Treseta_createtim.class);
        startActivityForResult(i, 1);

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                {count=count+1;
                switch(count)
                {
                    case 1:strEditText = data.getStringExtra("ImeTima");
                        TextView tim1=(TextView)findViewById(R.id.tim1);
                        tim1.setText(strEditText);
                        bundle.putString(TIM1,strEditText);
                        break;
                    case 2:strEditText = data.getStringExtra("ImeTima");
                        TextView tim2=(TextView)findViewById(R.id.tim2);
                        tim2.setText(strEditText);
                        bundle.putString(TIM2,strEditText);
                        break;
                    case 3:strEditText = data.getStringExtra("ImeTima");
                        TextView tim3=(TextView)findViewById(R.id.tim3);
                        tim3.setText(strEditText);
                        bundle.putString(TIM3,strEditText);
                        break;
                    case 4:strEditText = data.getStringExtra("ImeTima");
                        TextView tim4=(TextView)findViewById(R.id.tim4);
                        tim4.setText(strEditText);
                        bundle.putString(TIM4,strEditText);
                        break;
                    default:
                        break;
                }

                           }
            }
        }
    }
    public void Zapocni( View v)
    {
        if(count<2)
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Mora biti najmanje 2 tima!");
            alertDialogBuilder.setNegativeButton("Uredu",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        else {
            Intent intent = new Intent(this, Treseta_start.class);
            bundle.putString(BODOVI, textView.getText().toString());
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
