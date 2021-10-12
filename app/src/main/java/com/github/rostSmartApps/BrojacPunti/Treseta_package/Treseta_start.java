package com.github.rostSmartApps.BrojacPunti.Treseta_package;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.github.rostSmartApps.BrojacPunti.Briskula_package.Briskula;
import com.github.rostSmartApps.BrojacPunti.MainActivity;
import com.github.rostSmartApps.BrojacPunti.R;


public class Treseta_start extends AppCompatActivity {
    String HoldLastValue,HoldLastValue2;
    int flag=0;
    String temp;
    String BOD;
    Bundle bundle;
    TextView tim1,tim2,tim3,tim4,bod1,bod2,bod3,bod4;
    Button but1,but2,but3,but4;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treseta_start);
        //editText.setText("0);
        bundle=getIntent().getExtras();
        BOD=bundle.getString(Treseta.BODOVI);
        BOD = BOD.replaceAll("\\D+","0");
        TextView textView=(TextView) findViewById(R.id.Bodovitext);
        textView.setText("Igra se do "+BOD);
        switch(Treseta.count)
        {
            case 4:temp=bundle.getString(Treseta.TIM4);
                tim4=(TextView) findViewById(R.id.timStart4);
                tim4.setText(temp);
                but4=(Button)findViewById(R.id.timPotvrdi4);
                but4.setVisibility(View.VISIBLE);
                but4.setText(temp);
                 bod4=(TextView) findViewById(R.id.bodStart4);
                bod4.setText("0");
                but4=(Button)findViewById(R.id.akuza3tim4);
                but4.setVisibility(View.VISIBLE);
                but4=(Button)findViewById(R.id.akuza4tim4);
                but4.setVisibility(View.VISIBLE);

            case 3:temp=bundle.getString(Treseta.TIM3);
                 tim3=(TextView) findViewById(R.id.timStart3);
                tim3.setText(temp);
                but3=(Button)findViewById(R.id.timPotvrdi3);
                but3.setText(temp);
                but3.setVisibility(View.VISIBLE);
                 bod3=(TextView) findViewById(R.id.bodStart3);
                bod3.setText("0");
                but3=(Button)findViewById(R.id.akuza3tim3);
                but3.setVisibility(View.VISIBLE);
                but3=(Button)findViewById(R.id.akuza4tim3);
                but3.setVisibility(View.VISIBLE);

            case 2:temp=bundle.getString(Treseta.TIM2);
                 tim2=(TextView) findViewById(R.id.timStart2);
                tim2.setText(temp);
                but2=(Button)findViewById(R.id.timPotvrdi2);
                but2.setText(temp);
                but2.setVisibility(View.VISIBLE);
                 bod2=(TextView) findViewById(R.id.bodStart2);
                bod2.setText("0");
                but2=(Button)findViewById(R.id.akuza3tim2);
                but2.setVisibility(View.VISIBLE);
                but2=(Button)findViewById(R.id.akuza4tim2);
                but2.setVisibility(View.VISIBLE);


            case 1:temp=bundle.getString(Treseta.TIM1);
                 tim1=(TextView) findViewById(R.id.timStart1);
                tim1.setText(temp);
                but1=(Button)findViewById(R.id.timPotvrdi1);
                but1.setText(temp);
                but1.setVisibility(View.VISIBLE);
                bod1=(TextView) findViewById(R.id.bodStart1);
                bod1.setText("0");
                but1=(Button)findViewById(R.id.akuza3tim1);
                but1.setVisibility(View.VISIBLE);
                but1=(Button)findViewById(R.id.akuza4tim1);
                but1.setVisibility(View.VISIBLE);
                break;

        }

    }

    public void Dodajbod1(View view) {
        editText = (EditText) findViewById(R.id.editText);
        if (Integer.parseInt(editText.getText().toString()) > 11 || Integer.parseInt(editText.getText().toString()) < -11) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Unos mora biti između -11 i 11!");
            alertDialogBuilder.setNegativeButton("Uredu", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    editText.setText("0");
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        } else {
            if (Treseta.count > 2) {
                HoldLastValue = bod1.getText().toString();

                if (Integer.parseInt(editText.getText().toString()) > 11 || Integer.parseInt(editText.getText().toString()) < -11) {
                }

                temp = editText.getText().toString();
                if (temp.matches("0")) {

                } else {
                    int sum = Integer.parseInt(bod1.getText().toString()) + Integer.parseInt(temp);
                    bod1.setText("0" + sum);
                    editText.setText("0");
                }

                flag = 1;
            } else {
                HoldLastValue = bod1.getText().toString();
                HoldLastValue2 = bod2.getText().toString();

                temp = editText.getText().toString();
                if (temp.matches("0")) {

                } else {
                    int sum = Integer.parseInt(bod1.getText().toString()) + Integer.parseInt(temp);
                    bod1.setText("0" + sum);
                    sum = Integer.parseInt(bod2.getText().toString()) + (11 - Integer.parseInt(temp));
                    bod2.setText("0" + sum);
                    editText.setText("0");
                    flag = 5;
                    if (Integer.parseInt(bod1.getText().toString()) >= Integer.parseInt(BOD) && Integer.parseInt(bod1.getText().toString()) > Integer.parseInt(bod2.getText().toString())) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                        alertDialogBuilder.setMessage("Pobjednik je " + bundle.getString(Treseta.TIM1) + "!");
                        alertDialogBuilder.setNegativeButton("Uredu", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Treseta.count = 0;
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        });
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    } else if (Integer.parseInt(bod2.getText().toString()) >= Integer.parseInt(BOD) && Integer.parseInt(bod2.getText().toString()) > Integer.parseInt(bod1.getText().toString())) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                        alertDialogBuilder.setMessage("Pobjednik je " + bundle.getString(Treseta.TIM2) + "!");
                        alertDialogBuilder.setNegativeButton("Uredu", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Treseta.count = 0;
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        });
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                }
            }
        }
    }

    public void Dodajbod2(View view) {
        editText = (EditText) findViewById(R.id.editText);
        if (Integer.parseInt(editText.getText().toString()) > 11 || Integer.parseInt(editText.getText().toString()) < -11) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Unos mora biti između -11 i 11!");
            alertDialogBuilder.setNegativeButton("Uredu", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    editText.setText("0");
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        } else {
            if (Treseta.count > 2) {
                HoldLastValue = bod2.getText().toString();
                temp = editText.getText().toString();
                if (temp.matches("0")) {

                } else {
                    int sum = Integer.parseInt(bod2.getText().toString()) + Integer.parseInt(temp);
                    bod2.setText("0" + sum);
                    editText.setText("0");
                }
                flag = 2;
            } else {
                HoldLastValue = bod1.getText().toString();
                HoldLastValue2 = bod2.getText().toString();
                temp = editText.getText().toString();
                if (temp.matches("0")) {

                } else {
                    int sum = Integer.parseInt(bod2.getText().toString()) + Integer.parseInt(temp);
                    bod2.setText("0" + sum);
                    sum = Integer.parseInt(bod1.getText().toString()) + (11 - Integer.parseInt(temp));
                    bod1.setText("0" + sum);
                    editText.setText("0");
                    flag = 5;
                    if (Integer.parseInt(bod1.getText().toString()) >= Integer.parseInt(BOD) && Integer.parseInt(bod1.getText().toString()) > Integer.parseInt(bod2.getText().toString())) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                        alertDialogBuilder.setMessage("Pobjednik je " + bundle.getString(Treseta.TIM1) + "!");
                        alertDialogBuilder.setNegativeButton("Uredu", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Treseta.count = 0;
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        });
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    } else if (Integer.parseInt(bod2.getText().toString()) >= Integer.parseInt(BOD) && Integer.parseInt(bod2.getText().toString()) > Integer.parseInt(bod1.getText().toString())) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                        alertDialogBuilder.setMessage("Pobjednik je " + bundle.getString(Treseta.TIM2) + "!");
                        alertDialogBuilder.setNegativeButton("Uredu", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Treseta.count = 0;
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        });
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                }
            }
        }
    }

    public void Dodajbod3(View view) {
        editText = (EditText) findViewById(R.id.editText);
        if (Integer.parseInt(editText.getText().toString()) > 11 || Integer.parseInt(editText.getText().toString()) < -11) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Unos mora biti između -11 i 11!");
            alertDialogBuilder.setNegativeButton("Uredu", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    editText.setText("0");
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        } else {
            HoldLastValue = bod3.getText().toString();
            temp = editText.getText().toString();
            if (temp.matches("0")) {

            } else {
                int sum = Integer.parseInt(bod3.getText().toString()) + Integer.parseInt(temp);
                bod3.setText("0" + sum);
                editText.setText("0");
            }
            flag = 3;

        }
    }
    public void Dodajbod4(View view) {
        editText = (EditText) findViewById(R.id.editText);
        if (Integer.parseInt(editText.getText().toString()) > 11 || Integer.parseInt(editText.getText().toString()) < -11) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Unos mora biti između -11 i 11!");
            alertDialogBuilder.setNegativeButton("Uredu", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    editText.setText("0");
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        } else {
            HoldLastValue = bod4.getText().toString();
            temp = editText.getText().toString();
            if (temp.matches("0")) {

            } else {
                int sum = Integer.parseInt(bod4.getText().toString()) + Integer.parseInt(temp);
                bod4.setText("0" + sum);
                editText.setText("0");
            }
            flag = 4;
        }
    }

    public void Kraj(View view) {
        Treseta.count=0;
        flag=0;
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
            case 5:bod1.setText(HoldLastValue);
                 bod2.setText(HoldLastValue2);
                 flag=0;
                 break;
            default:
                break;
        }
    }

    public void Dodaj3tim1(View view) {
        HoldLastValue= bod1.getText().toString();
        int sum = Integer.parseInt(bod1.getText().toString()) + 3;
        bod1.setText("0" + sum);
        flag=1;
    }


    public void Dodaj4tim1(View view) {
        HoldLastValue= bod1.getText().toString();
        int sum = Integer.parseInt(bod1.getText().toString()) + 4;
        bod1.setText("0" + sum);
        flag=1;
    }

    public void Dodaj3tim2(View view) {
        HoldLastValue= bod2.getText().toString();
        int sum = Integer.parseInt(bod2.getText().toString()) + 3;
        bod2.setText("0" + sum);
        flag=2;
    }

    public void Dodaj4tim2(View view) {
        HoldLastValue= bod2.getText().toString();
        int sum = Integer.parseInt(bod2.getText().toString()) + 4;
        bod2.setText("0" + sum);
        flag=2;
    }



    public void Dodaj3tim3(View view) {
        HoldLastValue= bod3.getText().toString();
        int sum = Integer.parseInt(bod3.getText().toString()) + 3;
        bod3.setText("0" + sum);
        flag=3;
    }
    public void Dodaj4tim3(View view) {
        HoldLastValue= bod3.getText().toString();
        int sum = Integer.parseInt(bod3.getText().toString()) + 4;
        bod3.setText("0" + sum);
        flag=3;
    }



    public void Dodaj3tim4(View view) {
        HoldLastValue= bod4.getText().toString();
        int sum = Integer.parseInt(bod4.getText().toString()) + 3;
        bod4.setText("0" + sum);
        flag=4;
    }
    public void Dodaj4tim4(View view) {
        HoldLastValue= bod4.getText().toString();
        int sum = Integer.parseInt(bod4.getText().toString()) + 4;
        bod4.setText("0" + sum);
        flag=4;
    }
}
