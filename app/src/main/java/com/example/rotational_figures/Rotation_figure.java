package com.example.rotational_figures;

public class Rotation_figure {
    String rotationFigure;
    int rotationImage;

    public Rotation_figure (String rotationFigure, int rotationImage){
        this.rotationFigure = rotationFigure;
        this.rotationImage = rotationImage;
    }

    public String getRotationFigure(){
        return rotationFigure;
    }

    public void setRotationFigure (String rotationFigure){
        this.rotationFigure = rotationFigure;
    }

    public  int getRotationImage() {
        return rotationImage;
    }

    public void setRotationImage (int rotationImage){
        this.rotationImage = rotationImage;
    }



}
