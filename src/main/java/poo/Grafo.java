package poo;

import java.io.Serializable;
import java.util.*;

public class Grafo implements Serializable{

    private static final String LABELLOCPADRAOGRAFO = "t";
    private static final String RANKDIRPADRAO = "TB";

    private String label;
    private String labelLoc;
    private String 	rankdir;
    private int fontSize =0;
    private boolean prontoParaGerarDiagrama;

    private Node node;
    private SubGrafo subGrafo;
    private ArrayList<Node> nos = new ArrayList<>();
    private ArrayList<SubGrafo> subGraph = new ArrayList<>();

    public Grafo(String label) {
        this.label = label;
        this.labelLoc = LABELLOCPADRAOGRAFO;
        this.rankdir = RANKDIRPADRAO;
    }

    public Grafo(){

    }

    public void addNode(String label, EnumNodeNames tipo){
        switch(tipo){
            case wan:
                nos.add(new Internet(label,tipo));
                break;
            case router:
                nos.add(new Roteador(label,tipo));
                break;
            case sw:
                nos.add(new Switch(label,tipo));
                break;
            case desktop:
            case ipCamera:
            case rackServer:
            case server:
                nos.add(new EndPoint(label,tipo));
                break;
            case firewall:
                nos.add(new Firewall(label,tipo));
                break;

            default:
                break;

        }

    }

    public boolean addSubGrafo(String label, String... nodes){
        if (nodes.length > 1) {
            for (int i = 0; i < nodes.length; i++) {
                if (verificaNodeExiste(nodes[i]));
                else return false;
            }
            subGraph.add(new SubGrafo(label, nodes));
        }else{
            if (verificaNodeExiste(nodes[0]));
            subGraph.add(new SubGrafo(label, nodes));
        }
        return true;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelLoc() {
        return labelLoc;
    }

    public String getRankdir() {
        return rankdir;
    }

    public void setRankdir(String rankdir) {
        this.rankdir = rankdir;
    }

    public void setLabelLoc(String labelLoc) {
        this.labelLoc = labelLoc;
    }

    public ArrayList<Node> getNos() {
        return nos;
    }

    public static String getLABELLOCPADRAOGRAFO() {
        return LABELLOCPADRAOGRAFO;
    }

    public static String getRANKDIRPADRAO() {
        return RANKDIRPADRAO;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public ArrayList<SubGrafo> getSubGraph() {
        return subGraph;
    }

    public void setSubGraph(ArrayList<SubGrafo> subGraph) {
        this.subGraph = subGraph;
    }

    public SubGrafo getSubGrafo() {
        return subGrafo;
    }

    public void mostrarNodesSalvos(){
        for(Node aux : this.nos){
            System.out.println("Nó com label= \'"+aux.getLabel() + "\' possui nome intero ="+aux.getNomeNode());
        }
    }


//    O nó endpoint (desktop, câmera IP, servidor) poderá estar associado a no máximo a um outro nó
//    O nó roteador poderá estar associado com 2 ou N outros nós
//    O nó firewall poderá estar associado com 2 ou N outros nós
//    O nó switch (comutador) poderá estar associado com 1 ou N outros nós
//    O nó Internet poderá estar associado com 1 ou N outros nós
//    wan -- router
//    router -- sw1
//    sw1 -- serverWWW
//    sw1 -- {desktop1 desktop2 desktop3} 1 ou N

    public boolean validarRestricoes(){
        if(getNos().size()!=0){
            for (Node auxNode : nos) {
                if (auxNode.getContRestricao() != 0) {
                    if ((auxNode.getContRestricao() >= auxNode.getMinAssociacao() && auxNode.getContRestricao() <= auxNode.getMaxAssociacao())) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }else{
            return false;
        }
        return true;
    }

    public boolean addNodeOrigemToDestino(String nodeOrigem, String... nodesDestinos) {
        ArrayList<String> destinos = new ArrayList<>();
        //Precisa verificar se o destino é valido

        if (nodesDestinos.length > 1) {
            for (int i = 0; i < nodesDestinos.length; i++) {
                if(verificaNodeExiste(nodesDestinos[i])) destinos.add(nodesDestinos[i]);
                else return false;
            }
        } else {
            if(verificaNodeExiste(nodesDestinos[0]))destinos.add(nodesDestinos[0]);
            else{
                return false;
            }
        }

        for (Node auxNode : nos) {
            if(auxNode.getNomeNode().equals(nodeOrigem)) {
                //se o node for o nome do nodeOrigem, incrementa a restricao de acordo com tamanho da lista de destinos + o que já tem
                if (auxNode.getArcos().size()>=1){
                    auxNode.setContRestricao(auxNode.getArcos().size()+destinos.size());
                }else {
                    auxNode.setContRestricao(destinos.size());
                }
            }
            for(String aux : destinos){
                if(auxNode.getNomeNode().equals(aux)){
                    auxNode.setContRestricao(auxNode.getContRestricao()+1);
                }
            }
        }
        for (Node auxNode : nos) {
            if (auxNode.getNomeNode().equals(nodeOrigem)) {
                addList(destinos, auxNode);
            }
        }
        return true;
    }

    private void addList(ArrayList<String> destinos, Node auxNode) {
        if (auxNode.getArcos().size() >= 1) {
            ArrayList<String> resultArray = new ArrayList<>(auxNode.getArcos().size() + destinos.size());
            resultArray.addAll(auxNode.getArcos());
            resultArray.addAll(destinos);
            auxNode.setArcos(resultArray);
        }else{
            auxNode.setArcos(destinos);
        }
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
    private String nosDoGrafro(){
        String toReturn="";
        for(Node aux : nos) {
            toReturn += "\t" +aux.toString() + "\n";
        }
        return toReturn;
    }
    //Padrao para montar um Grafo
    private String padraoGafro(){
        String auxReturn = "";
        auxReturn += "\n"+"\t" +"label = \"" + this.getLabel() + "\"" +'\n' +
                "\t" +"labelloc=" + " " + this.getLabelLoc() +";\n" +
                "\t" +"rankdir=" + " " + this.getRankdir() +";\n" +
                "\n"+
                "\t" +"node " + "[labelloc=" +node.getLABELLOCPADRAONODE() + " fontsize=" + node.getFONTEPADRAO() +  " shape=" + node.getSHAPEPADRAO() + "]\n";
        return auxReturn;
    }
    private String getPadraoSubGrafo(){
        String auxReturn = "";
        for(SubGrafo aux : this.subGraph){
            auxReturn += aux.padraoSubGrafo();
        }
        return auxReturn;
    }
    private boolean verificaNodeExiste(String nomeNode){
        for(Node aux : nos){
            if(aux.getNomeNode().equals(nomeNode)){
                return true;
            }
        }
        return false;
    }

    public String gerarDiagrama(){


        return "graph "+ this.getLabel().toLowerCase().replace(" ","") +"{" +
                this.padraoGafro() + "\n" + this.nosDoGrafro() + "\n"  + this.arcosEntreNosdoGrafo() +"\n" + this.getPadraoSubGrafo()+"\n" +
                "}";
    }




    @Override
    public String toString() {
        return "graph "+ this.getLabel().toLowerCase().replace(" ","") +"{" +
                this.padraoGafro() + "\n" + this.nosDoGrafro() + "\n"  + this.arcosEntreNosdoGrafo() +"\n" + this.getPadraoSubGrafo()+"\n" +
                "}";
    }




}