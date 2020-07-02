package poo;

public class Internet extends Node{

    private static int internetCreated;
    public static final String CLOUDIMG = "/img/cloud.png";


    public Internet(String label,EnumNodeNames tipo) {
        super(label);
        if(tipo.equals(EnumNodeNames.wan)) {
            internetCreated++;
            this.setImage(CLOUDIMG);
            this.setNomeNode(EnumNodeNames.wan + String.valueOf(internetCreated));
            this.setMinAssociacao(getRESTRICAO1());
            this.setMaxAssociacao(getNASSOCIACOES());
        }
    }

    public static int getInternetCreated() {
        return internetCreated;
    }




}
