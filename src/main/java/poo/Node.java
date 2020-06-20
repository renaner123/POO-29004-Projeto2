package poo;

import java.util.ArrayList;

public abstract class Node {


    private static final int NASSOCIACOES = 10;
    private static final int RESTRICAO2 = 2;
    private static final int RESTRICAO1 = 1;

    private String nomeNode;
    private String label;
    private String labelLoc="";  // place the label at the top (b seems to be default)
    private String shape="";     // box, polygon, ellipse, oval, circle, diamond
    private String image;     //
    private String fillColor;
    private String color="";
    private int fontSize=0;
    private ArrayList<String> arcos = new ArrayList<>();
    private int minAssociacao;
    private int maxAssociacao;

/*
    O nó endpoint (desktop, câmera IP, servidor) poderá estar associado a no máximo a um outro nó
    O nó roteador poderá estar associado com 2 ou N outros nós
    O nó firewall poderá estar associado com 2 ou N outros nós
    O nó switch (comutador) poderá estar associado com 1 ou N outros nós
    O nó Internet poderá estar associado com 1 ou N outros nós
 */

    public Node(String label) {
        this.label = label;
        this.nomeNode = label;
    }
    public Node() {
    }

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

    public String getNomeNode() {
        return nomeNode;
    }

    public void setNomeNode(String nomeNode) {
        this.nomeNode = nomeNode;
    }


    public int getMinAssociacao() {
        return minAssociacao;
    }

    public void setMinAssociacao(int minAssociacao) {
        this.minAssociacao = minAssociacao;
    }

    public int getMaxAssociacao() {
        return maxAssociacao;
    }

    public void setMaxAssociacao(int maxAssociacao) {
        this.maxAssociacao = maxAssociacao;
    }

    public ArrayList<String> getArcos() {
        return arcos;
    }

    public void setArcos(ArrayList<String> arcos) {
        this.arcos = arcos;
    }

    public int getNASSOCIACOES() {
        return NASSOCIACOES;
    }

    public static int getRESTRICAO2() {
        return RESTRICAO2;
    }

    public static int getRESTRICAO1() {
        return RESTRICAO1;
    }

    /**
     *
     * @return Retorna uma String com todos os valores que não estão vazios ou no valor padrão
     */
    public String toStringNotNull(){
        String auxReturn = "";
        if(!this.getLabel().equals("null")){
            auxReturn += "label=\"" + this.getLabel() + "\" ";
        }if(!this.getLabellLoc().isEmpty()){
            auxReturn += "labelloc " + this.getLabellLoc() + " ";
        }if(!this.getShape().isEmpty()){
            auxReturn += "shape=\"" + this.getShape() + "\" ";
        }if(!this.getImage().equals("null")){
            auxReturn += "image=\"" + this.getImage() + "\" ";
        }if(!this.getColor().isEmpty()){
            auxReturn += "color=\"" + this.getColor() + "\" ";
        }if(!this.getShape().isEmpty()){
            auxReturn += "shape=\"" + this.getShape() + "\" ";
        }
        if(this.getFontSize()!=0){
            auxReturn += "fontsize=" + this.getFontSize() ;
        }
        return auxReturn;

    }


    @Override
    public String toString() {
        return this.getNomeNode() + " [" +toStringNotNull() + "]";
    }
}
