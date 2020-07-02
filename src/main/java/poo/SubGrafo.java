package poo;

import java.io.Serializable;
import java.util.ArrayList;

public class SubGrafo implements Serializable {
    private static final String LABELLOCPADRAOSUBGRAFO = "b";
    private static final String STYLEPADRAO = "filled";
    private static final String BGCOLORPADRAO = "green";

    ArrayList<String> subGraph = new ArrayList<>();

    private String labelLoc;
    private String style;
    private String bgcolor;
    private String label;

    public SubGrafo(String label, String... nodes) {
        this.label = label;
        this.labelLoc = LABELLOCPADRAOSUBGRAFO;
        this.style = STYLEPADRAO;
        this.bgcolor = BGCOLORPADRAO;
        for (int i = 0; i < nodes.length; i++) {
            subGraph.add(nodes[i]);
        }
    }

    public String getLabelLoc() {
        return labelLoc;
    }
    public void setLabelLoc(String labelLoc) {
        this.labelLoc = labelLoc;
    }
    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public String getBgcolor() {
        return bgcolor;
    }
    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

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
