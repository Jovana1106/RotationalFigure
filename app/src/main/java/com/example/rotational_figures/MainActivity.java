package com.example.rotational_figures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView rotFigureList;
    ArrayList<Rotation_figure> figureList;
    rotationForm_Adapter myAdapter;

    int images[] = {R.drawable.cylinder, R.drawable.cone, R.drawable.cut_cone, R.drawable.sphere1};

    String dscr[] = {"Cylinder", "Cone", "Cutted Cone", "Sphere"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rotFigureList = (GridView) findViewById(R.id.gridView);
        figureList = new ArrayList<Rotation_figure>();
        figureList.add(new Rotation_figure("Cylinder",images[0]));
        figureList.add(new Rotation_figure("Cone",images[1]));
        figureList.add(new Rotation_figure("Cutted Cone",images[2]));
        figureList.add(new Rotation_figure("Sphere",images[3]));
        myAdapter = new rotationForm_Adapter(getApplicationContext(),figureList);
        rotFigureList.setAdapter(myAdapter);
        rotFigureList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,SecActivity.class);
                intent.putExtra("pos",position);
                intent.putExtra("Image_ID",images[position]);
                intent.putExtra("Image_Dscr",dscr[position]);
                startActivity(intent);

            }

        });
    }
}