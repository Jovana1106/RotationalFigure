package com.example.rotational_figures;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecActivity extends MainActivity {
    ImageView selectedImage;
    TextView dscr,titleFigure, txt1, txt2, txt3,txt4,txt5, txt6;
    Button btn,btn1, btn2;
    EditText ed1, ed2, ed3,ed4,ed5,ed6;
    int pos;
    double  area, volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound);
        selectedImage = (ImageView) findViewById(R.id.imgPhoto);
        dscr = (TextView) findViewById(R.id.txtMsg);
        btn = (Button) findViewById(R.id.btnBack);
        titleFigure = (TextView) findViewById(R.id.titleFigure);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);
        txt5 = (TextView) findViewById(R.id.txt5);
        txt6 = (TextView) findViewById(R.id.txt6);
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        ed3 = (EditText) findViewById(R.id.ed3);
        ed4 = (EditText) findViewById(R.id.ed4);
        ed5 = (EditText) findViewById(R.id.ed5);
        ed6 = (EditText) findViewById(R.id.ed6);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            pos = bundle.getInt("pos", 0);
            if (pos == 0) {
                txt5.setVisibility(View.GONE);
                txt6.setVisibility(View.GONE);
                ed5.setVisibility(View.GONE);
                ed6.setVisibility(View.GONE);
                if (ed2.getText().toString().equals("0")){
                    ed2.setText("");

                }
                selectedImage.setImageResource(R.drawable.cylinder1);
            }
            if (pos == 1){
                txt5.setVisibility(View.GONE);
                ed5.setVisibility(View.GONE);
                if (ed6.getText().toString().equals("0")) {
                    ed6.setText("");
                    ed2.setText("");
                }
                selectedImage.setImageResource(R.drawable.cone1);
            }
            if (pos == 2){
                if (ed5.getText().toString().equals("0")) {
                    ed5.setText("");
                    ed6.setText("");
                    ed2.setText("");
                }
                selectedImage.setImageResource(R.drawable.cut_cone1);
            }
            if (pos == 3){
                txt2.setVisibility(View.GONE);
                txt5.setVisibility(View.GONE);
                txt6.setVisibility(View.GONE);
                ed5.setVisibility(View.GONE);
                ed6.setVisibility(View.GONE);
                ed2.setVisibility(View.GONE);
                selectedImage.setImageResource(R.drawable.sphere);
            }

            dscr.setText(bundle.getString("Im_Descr"));

        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.rotational_figures.SecActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double r = Double.parseDouble(ed1.getText().toString());
                double h = Double.parseDouble(ed2.getText().toString());
                double R = Double.parseDouble(ed5.getText().toString());
                double s = Double.parseDouble(ed6.getText().toString());
                if (pos == 0) {
                    area = 2 * Math.PI * Math.pow(r, 2) + 2 * Math.PI * r * h;
                    volume = Math.PI * Math.pow(r, 2) * h;
                }
                else if (pos == 1){
                   area = Math.PI * r * (r * s);
                   volume = (Math.PI * Math.pow(r, 2) * h) / 3;

                } else if (pos == 2){

                    area = Math.PI * (Math.pow(r, 2) + Math.pow(R,2) + s * (R + r));
                    volume = (Math.PI * (Math.pow(r, 2) + r*R + Math.pow(R, 2)))/3;

                } else {

                        volume = (4 * Math.PI * Math.pow(r,3)) / 3;
                       area = 4 * (Math.PI * Math.pow(r,2));
                }
                ed3.setText(Double.toString(area));
                ed4.setText(Double.toString(volume));

            }
        });

        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

    }


    private void  clear() {
        if (pos == 0 ){
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed4.setText("");
        ed5.setText("0");
        ed6.setText("0");
        }
        if (pos == 1){
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");
                ed5.setText("0");
                ed6.setText("");
        } if (pos == 2) {

                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");
                ed5.setText("");
                ed6.setText("");
        }
        if (pos == 3 ){
            ed1.setText("");
            ed2.setText("0");
            ed3.setText("");
            ed4.setText("");
            ed5.setText("0");
            ed6.setText("0");
        }
    }
}