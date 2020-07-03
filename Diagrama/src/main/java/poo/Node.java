package poo;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Classe responsável pela Agenda da Pessoa
 * @author Renan Rodolfo da Silva
 */

public class Node implements Serializable {


    private static final int NASSOCIACOES = 10;
    private static final int RESTRICAO2 = 2;
    private static final int RESTRICAO1 = 1;
    private static final int FONTEPADRAO = 10;
    private static final String SHAPEPADRAO = "none";
    private static final String LABELLOCPADRAONODE = "c";
    private static final String CORPADRAO = "black";
    private static final String CORPADRAOARCO = "black";


    private String nomeNode;
    private String label;
    private String labelLoc="";  // place the label at the top (b seems to be default)
    private String shape="";     // box, polygon, ellipse, oval, circle, diamond
    private String image;     //
    private String fillColor;
    private String colorArco="";
    private String color="";
    private int fontSize=0;
    private ArrayList<String> arcos = new ArrayList<>();
    private int minAssociacao;
    private int maxAssociacao;
    private int contRestricao =0;

    /**
     *
     * @param label que o nó vai ter
     */
    public Node(String label) {
        this.label = label;
        this.nomeNode = label;
    }
    public Node() {
    }

    /**
     *
     * @return label do nó
     */
    public  String getLabel() {
        return label;
    }

    /**
     *
     * @param label recebe novo valor
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     *
     * @return labelloc do nó
     */
    public String getLabellLoc() {
        return labelLoc;
    }

    /**
     *
     * @param labellLoc recebe novo valor
     */
    public void setLabellLoc(String labellLoc) {
        this.labelLoc = labellLoc;
    }

    /**
     *
     * @return shape do nó
     */
    public String getShape() {
        return shape;
    }

    /**
     *
     * @param shape recebe novo valor
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     *
     * @return caminho da imagem do nó
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @param image altera o caminho da imagem do nó
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     *
     * @return fill color do nó
     */
    public String getFillColor() {
        return fillColor;
    }

    /**
     *
     * @param fillColor recebe novo valor
     */
    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    /**
     *
     * @return valor de color do nó
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @param color recebe novo valor
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *
     * @return fontsize do nó
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     *
     * @param fontSize recebe novo valor
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     *
     * @return nome do nó
     */
    public String getNomeNode() {
        return nomeNode;
    }

    /**
     *
     * @param nomeNode recebe novo valor
     */
    public void setNomeNode(String nomeNode) {
        this.nomeNode = nomeNode;
    }

    /**
     *
     * @return valor minimo de associação que o nó pode ter
     */
    public int getMinAssociacao() {
        return minAssociacao;
    }

    /**
     *
     * @param minAssociacao altera o valor mínimo de associação que o nó pode te
     */
    public void setMinAssociacao(int minAssociacao) {
        this.minAssociacao = minAssociacao;
    }

    /**
     *
     * @return valor máximo de associação que o nó pode ter
     */
    public int getMaxAssociacao() {
        return maxAssociacao;
    }

    /**
     *
     * @param maxAssociacao altera valor máximo de associação que o node pode ter
     */
    public void setMaxAssociacao(int maxAssociacao) {
        this.maxAssociacao = maxAssociacao;
    }

    /**
     *
     * @return os arcos do nó
     */
    public ArrayList<String> getArcos() {
        return arcos;
    }

    /**
     *
     * @param arcos recebe array de arcos
     */
    public void setArcos(ArrayList<String> arcos) {
        this.arcos = arcos;
    }

    /**
     *
     * @return número máximo de associação que o nó pode ter
     */
    public int getNASSOCIACOES() {
        return NASSOCIACOES;
    }

    /**
     *
     * @return recebe valor da restrição2 que é 2 associações
     */
    public static int getRESTRICAO2() {
        return RESTRICAO2;
    }
    /**
     *
     * @return recebe valor da restrição1 que é 1 associações
     */
    public static int getRESTRICAO1() {
        return RESTRICAO1;
    }

    /**
     *
     * @return valor da fonte padrão do nó
     */
    public static int getFONTEPADRAO() {
        return FONTEPADRAO;
    }

    /**
     *
     * @return valor do shape padrão do nó
     */
    public static String getSHAPEPADRAO() {
        return SHAPEPADRAO;
    }

    /**
     *
     * @return valor do labelloc padrão do nó
     */
    public static String getLABELLOCPADRAONODE() {
        return LABELLOCPADRAONODE;
    }

    /**
     *
     * @return recebe cor do arco
     */
    public String getColorArco() {
        return colorArco;
    }

    /**
     *
     * @param colorArco recebe novo valor
     */
    public void setColorArco(String colorArco) {
        this.colorArco = colorArco;
    }

    /**
     *
     * @return cor padrão do nó
     */
    public static String getCORPADRAO() {
        return CORPADRAO;
    }

    /**
     *
     * @return quantidade de associações que o nó possui
     */
    public int getContRestricao() {
        return contRestricao;
    }

    /**
     *
     * @param contRestricao altera valor de associação do nó
     */
    public void setContRestricao(int contRestricao) {
        this.contRestricao = contRestricao;
    }
    /**
     *
     * @return Retorna uma String com todos os valores que não estão vazios ou no valor padrão
     */
    private String toStringNotNull(){
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

    /**
     *
     * @return nome do nó e seus valores
     */
    @Override
    public String toString() {
        return this.getNomeNode() + " [" +toStringNotNull() + "]";
    }
}
