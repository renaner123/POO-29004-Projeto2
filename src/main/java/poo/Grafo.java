package poo;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Grafo {

    private static final int FONTEPADRAO = 10;
    private static final String SHAPEPADRAO = "none";
    private static final String LABELLOCPADRAOGRAFO = "t";
    private static final String LABELLOCPADRAONODE = "c";
    private static final String CORPADRAO = "black";

    private String label;
    private String labelLocGrafo="";
    private String labelLocNode="";
    private String shape;
    private int fontSize;
    private String color;
    protected ArrayList<Node> nos = new ArrayList<>();

    public Grafo(String label) {
        this.label = label;
        this.fontSize = FONTEPADRAO;
        this.shape = SHAPEPADRAO;
        this.labelLocGrafo = LABELLOCPADRAOGRAFO;
        this.labelLocNode = LABELLOCPADRAONODE;
        this.color = CORPADRAO;
    }


    public void addEndPoint(String label, EnumNodeNames tipo){
        nos.add(new EndPoint(label,tipo));
    }

    public void addRoteador(String label){
        nos.add(new Roteador(label));
    }

    public void addFirewall(String label){
        nos.add(new Firewall(label));
    }

    public void addSwitch(String label){
        nos.add(new Switch(label));
    }

    public void addInternet(String label){
        nos.add(new Internet(label));
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelLocGrafo() {
        return labelLocGrafo;
    }

    public void setLabelLocGrafo(String labelLocGrafo) {
        this.labelLocGrafo = labelLocGrafo;
    }

    public String getLabelLocNode() {
        return labelLocNode;
    }

    public void setLabelLocNode(String labelLocNode) {
        this.labelLocNode = labelLocNode;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }


    public ArrayList<Node> getNos() {
        return nos;
    }

    // Gera um String quase no formato DOT


    public void nodeOrigemToDestino(String nodeOrigem, String... nodesDestinos) {
        ArrayList<String> destinos = new ArrayList<>();
        if(nodesDestinos.length>1) {
            for (int i = 0; i < nodesDestinos.length; i++) {
                destinos.add(nodesDestinos[i]);
            }
        }else{
            destinos.add(nodesDestinos[0]);        }
        for(Node nosAux : nos){
            if(nosAux.getNomeNode().equals(nodeOrigem)){
                if(destinos.size() >= nosAux.getMinAssociacao() && destinos.size() < nosAux.getMaxAssociacao()  ){
                    nosAux.setArcos(destinos);
                }
            }
        }
    }

    public String gerarSubGrafo(){
        return "";
    }

    // Gera uma String contendo os Arcos entre os nós do Grafo
    public String arcosEntreNosdoGrafo(){
        String toReturn="";
        for(Node aux : nos) {
            if(aux.getArcos().size()>=1) {
                toReturn += "" +
                        "\t" + aux.getNomeNode() + " -- " + aux.getArcos().toString().replace(",", "").replace("[", "{").replace("]", "}") + "\n" +
                        "";
            }
        }
        return toReturn;
    }
    //Gera uma String com todos os nós do grafo
    public String nosDoGrafro(){
        String toReturn="";
        for(Node aux : nos) {
            toReturn += "\t" +aux.toString() + "\n";
        }
        return toReturn;
    }

    //Padrao para montar um Grafo
    private String PadraoGafro(){
        String auxReturn = "";
        auxReturn += "\n"+"\t" +"label = \"" + this.getLabel() + "\"" +'\n' +
                "\t" +"labelloc=" + " " + this.getLabelLocGrafo() +";\n" +
                "\n"+
                "\t" +"node " + "[labelloc=" +this.labelLocNode + " fontsize=" + this.fontSize + "]\n";
        return auxReturn;
    }

    public String exportarFormatoDot(){
        return "";
    }
    public void salvarDiagramaNoDisco(String nomeDoArquivo, ArrayList<Grafo> grafo) {

    }
    public void lerDiagramaDoDisco(String nomeDoArquivo) {

    }

    @Override
    public String toString() {
        return "graph rede{" +
                this.PadraoGafro() + "\n" + this.nosDoGrafro() + "\n"  + this.arcosEntreNosdoGrafo() +
                "}";
    }




}
