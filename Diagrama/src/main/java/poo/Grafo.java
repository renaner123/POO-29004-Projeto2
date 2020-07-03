package poo;

import java.io.Serializable;
import java.util.*;
/**
 * Classe responsável por gerar um grafo
 * @author Renan Rodolfo da Silva
 */

public class Grafo implements Serializable{

    private static final String LABELLOCPADRAOGRAFO = "t";
    private static final String RANKDIRPADRAO = "TB";

    private String label;
    private String labelLoc;
    private String 	rankdir;
    private int fontSize =0;
    private Node node;
    private ArrayList<Node> nos = new ArrayList<>();
    private ArrayList<SubGrafo> subGraph = new ArrayList<>();

    /**
     *
     * @param label utilizado no grafo para identificação
     */
    public Grafo(String label) {
        this.label = label;
        this.labelLoc = LABELLOCPADRAOGRAFO;
        this.rankdir = RANKDIRPADRAO;
    }

    public Grafo(){

    }

    /**
     *
     * @param label do nó a sers criado
     * @param tipo do nó a ser criado, de acordo com a EnumNodeNames
     */
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

    /**
     *
     * @param label para identificar o subgrafo
     * @param nodes nós que estarão no subgrafo
     * @return true se conseguir criar o subgrafo
     */
    public boolean addSubGrafo(String label, String... nodes){
        if (nodes.length > 1) {
            for (int i = 0; i < nodes.length; i++) {
                if (verificaNodeExiste(nodes[i]));
                else return false;
            }
            subGraph.add(new SubGrafo(label, nodes));
        }else{
            if (verificaNodeExiste(nodes[0])) subGraph.add(new SubGrafo(label, nodes));
        }
        return true;
    }

    /**
     *
     * @return label do grafo
     */
    public String getLabel() {
        return label;
    }
    /**
     *
     * @param label altera o label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     *
     * @return labelLoc do grafo
     */
    public String getLabelLoc() {
        return labelLoc;
    }

    /**
     *
     * @return rankdir do grafo
     */
    public String getRankdir() {
        return rankdir;
    }

    /**
     *
     * @param rankdir altera rankdir do grafo
     */
    public void setRankdir(String rankdir) {
        this.rankdir = rankdir;
    }

    /**
     *
     * @param labelLoc altera labelloc do grafo
     */
    public void setLabelLoc(String labelLoc) {
        this.labelLoc = labelLoc;
    }

    /**
     *
     * @return lista com todos os nós criados
     */
    public ArrayList<Node> getNos() {
        return nos;
    }

    /**
     *
     * @return labelloc padrão do grafo
     */
    public static String getLABELLOCPADRAOGRAFO() {
        return LABELLOCPADRAOGRAFO;
    }

    /**
     *
     * @return rankdir padrão do grafo
     */
    public static String getRANKDIRPADRAO() {
        return RANKDIRPADRAO;
    }

    /**
     *
     * @return a fontsize do grafo
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     *
     * @param fontSize altera a fontsize
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     *
     * @return os subgrafos criados
     */
    public ArrayList<SubGrafo> getSubGraph() {
        return subGraph;
    }

    /**
     *
     * @param subGraph recebe lista de subgrafo
     */
    public void setSubGraph(ArrayList<SubGrafo> subGraph) {
        this.subGraph = subGraph;
    }

    /**
     *
     * @param nomeNode nome do nó a ser removido de nos
     * @return true se conseguir remover, caso contrário false
     */
    public boolean removerNode(String nomeNode){
        Iterator<Node> iteracao = nos.iterator();
        while(iteracao.hasNext()){
            Node elemento = iteracao.next();
            if (elemento.getNomeNode().equals(nomeNode)){
                iteracao.remove();
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param labelSubGrafo label do subgrafo a ser removido
     * @return true se conseguir remover, caso contrário false
     */
    public boolean removerSubGrafo(String labelSubGrafo){
        Iterator<SubGrafo> iteracao = subGraph.iterator();
        while(iteracao.hasNext()){
            SubGrafo elemento = iteracao.next();
            if (elemento.getLabel().equals(labelSubGrafo)){
                iteracao.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * imprime na tela o nome interno dos nós criados
     */
    public void mostrarNodesSalvos(){
        for(Node aux : this.nos){
            System.out.println("Nó com label= \'"+aux.getLabel() + "\' possui nome intero ="+aux.getNomeNode());
        }
    }

    /**
     *
     * @return true caso todos os nós atendam a suas restrições, caso contrário retorna false
     */
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

    /**
     *
     * @param nodeOrigem recebe nó de origem
     * @param nodesDestinos recebe nó(s) de destino para gerar um arco
     * @return true os nós existam, caso contrário retorna false
     */
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

    /**
     * método interno para adicionar nodes
     * @param destinos recebe nodes de destino a serem inseridos no nó
     * @param auxNode node que terá os arcos
     */
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

    /**
     *
     * @return todos os arcos criados
     */
    public String arcosEntreNosdoGrafo(){
        String toReturn="";
        for(Node aux : nos) {
                if(aux.getArcos().size()>=1) {
                    if(!aux.getColorArco().isEmpty()){
                        toReturn += "" +
                                "\t" + aux.getNomeNode() + " -- " + aux.getArcos().toString().replace(",", "").replace("[", "{").replace("]", "}") +" [color=" + aux.getColorArco() + "]"+"\n" +
                                "";
                    }else{
                        toReturn += "" +
                                "\t" + aux.getNomeNode() + " -- " + aux.getArcos().toString().replace(",", "").replace("[", "{").replace("]", "}") +"\n" +
                                "";
                    }

                }
        }
        return toReturn;
    }

    /**
     *
     * @return todos os nós criados
     */
    private String nosDoGrafro(){
        String toReturn="";
        for(Node aux : nos) {
            toReturn += "\t" +aux.toString() + "\n";
        }
        return toReturn;
    }

    /**
     * método interno
     * @return o padrão do grafo a ser gerador no diagrama
     */
    private String padraoGafro(){
        String auxReturn = "";
        auxReturn += "\n"+"\t" +"label = \"" + this.getLabel() + "\"" +'\n' +
                "\t" +"labelloc=" + " " + this.getLabelLoc() +";\n" +
                "\t" +"rankdir=" + " " + this.getRankdir() +";\n" +
                "\n"+
                "\t" +"node " + "[labelloc=" +node.getLABELLOCPADRAONODE() + " fontsize=" + node.getFONTEPADRAO() +  " shape=" + node.getSHAPEPADRAO() + "]\n"+
                "\t" +"edge " + "[color=" +node.getCORPADRAO()+"]";

        return auxReturn;
    }

    /**
     * método interno
     * @return o padrão do subgrafo a ser gerado no diagrama
     */
    private String getPadraoSubGrafo(){
        String auxReturn = "";
        for(SubGrafo aux : this.subGraph){
            auxReturn += aux.padraoSubGrafo();
        }
        return auxReturn;
    }

    /**
     *
     * @param nomeNode recebe nome do nó
     * @return true caso o nó exista, false caso não exista.
     */
    private boolean verificaNodeExiste(String nomeNode){
        for(Node aux : nos){
            if(aux.getNomeNode().equals(nomeNode)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return um grafo no formato dot
     */
    @Override
    public String toString() {
        return "graph "+ this.getLabel().toLowerCase().replace(" ","") +"{" +
                this.padraoGafro() + "\n" + this.nosDoGrafro() + "\n"  + this.arcosEntreNosdoGrafo() +"\n" + this.getPadraoSubGrafo()+"\n" +
                "}";
    }




}