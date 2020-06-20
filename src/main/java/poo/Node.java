package poo;

import java.util.ArrayList;

public class No{

    private static final int FONTEPADRAO = 10;
    private static final String SHAPEPADRAO = "none";
    private static final String LABELLOCPADRAO = "c";

    private String idNo;
    private String label;
    private String labelLoc;  // place the label at the top (b seems to be default)
    private String shape;     // box, polygon, ellipse, oval, circle, diamond
    private String image;     //
    private String fillColor;
    private String color;
    private int fontSize;
    private static int noCreates;


    public No(String label) {
        this.label = label;
        this.labelLoc = LABELLOCPADRAO;
        this.fontSize = FONTEPADRAO;
        this.shape = SHAPEPADRAO;
    }
    public No() {
    }

    public void criarNo(){};
    public void modificarNo(){};
    public void visualisarNo(){};



    public  String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabellLoc() {
        return labelLoc;
    }

    public void setLabellLoc(String labellLoc) {
        this.labelLoc = labellLoc;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
}
