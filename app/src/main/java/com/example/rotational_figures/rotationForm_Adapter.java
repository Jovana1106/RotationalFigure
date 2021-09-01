package com.example.rotational_figures;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class rotationForm_Adapter extends BaseAdapter {
    private Context mContext;
    ArrayList<Rotation_figure> figureList;

    public rotationForm_Adapter (Context c, ArrayList<Rotation_figure> objects){
        mContext = c;
        this.figureList = objects;
    }

    @Override
    public int getCount(){
        return figureList.size();
    }

    @Override
    public Object getItem (int position){
        return position;
    }

    @Override
    public long getItemId (int position){
        return 0;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridV;
        if(convertView == null){
            gridV = new View(mContext);
            gridV = inflater.inflate(R.layout.gird_items,null);
            TextView textView = (TextView) gridV.findViewById(R.id.textView);
            textView.setText(figureList.get(position).getRotationFigure());
            ImageView imageView = (ImageView) gridV.findViewById(R.id.imageView);
            imageView.setImageResource(figureList.get(position).getRotationImage());
        }
        else {
            gridV = (View) convertView;
        }
        return gridV;
    }
}
