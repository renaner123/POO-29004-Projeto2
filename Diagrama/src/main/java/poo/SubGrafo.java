package poo;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Classe responsável por gerar um subgrafo
 * @author Renan Rodolfo da Silva
 */

public class SubGrafo implements Serializable {
    private static final String LABELLOCPADRAOSUBGRAFO = "b";
    private static final String STYLEPADRAO = "filled";
    private static final String BGCOLORPADRAO = "green";

    ArrayList<String> subGraph = new ArrayList<>();
    private String labelLoc;
    private String style;
    private String bgcolor;
    private String label;

    /**
     *
     * @param label que o subgrago vai ter
     * @param nodes nós que fazem parte do subgrafo
     */
    public SubGrafo(String label, String... nodes) {
        this.label = label;
        this.labelLoc = LABELLOCPADRAOSUBGRAFO;
        this.style = STYLEPADRAO;
        this.bgcolor = BGCOLORPADRAO;
        for (int i = 0; i < nodes.length; i++) {
            subGraph.add(nodes[i]);
        }
    }

    /**
     *
     * @return labelloc do subgrafo
     */
    public String getLabelLoc() {
        return labelLoc;
    }

    /**
     *
     * @param labelLoc recebe novo valor
     */
    public void setLabelLoc(String labelLoc) {
        this.labelLoc = labelLoc;
    }

    /**
     *
     * @return style do subgrafo
     */
    public String getStyle() {
        return style;
    }

    /**
     *
     * @param style recebe novo valor
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     *
     * @return valor de bgcolor do subgrafo
     */
    public String getBgcolor() {
        return bgcolor;
    }

    /**
     *
     * @param bgcolor recebe novo valor
     */
    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }

    /**
     *
     * @return valor do label do subgrafo
     */
    public String getLabel() {
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
     * @return padrão que vai ser usado na hora de gerar um diagrama
     */
    public String padraoSubGrafo(){
        String auxReturn = "";
        for(String aux : subGraph){
            auxReturn += "\t\t"+aux +"\n" ;
        }
        return "\tsubgraph "  +"cluster_"+ this.getLabel().toLowerCase()+"{\n" +
                "\t\tlabel=" + this.getLabel() + "\n"+
                "\t\tlabelloc=" + this.getLabelLoc() + "\n"+
                "\t\tstyle=" + this.getStyle() + "\n"+
                "\t\tbgcolor=" + this.getBgcolor() + "\n"+
                "\n"+auxReturn +
                "\t}\n";
    }

    /**
     *
     * @return os atributor de subgrafo
     */
    @Override
    public String toString() {
        return "SubGrafo{" +
                "subGraph=" + subGraph +
                ", labelLoc='" + labelLoc + '\'' +
                ", style='" + style + '\'' +
                ", bgcolor='" + bgcolor + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
