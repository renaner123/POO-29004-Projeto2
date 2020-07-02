package poo;

public class Switch extends Node {

    private static int switchCreated;
    public static final String SWITCHGENERICIMG = "/img/switch.png";

    public Switch(String label, EnumNodeNames tipo) {
        super(label);

        if(tipo.equals(EnumNodeNames.sw)){
            switchCreated++;
            this.setImage(SWITCHGENERICIMG);
            this.setNomeNode(EnumNodeNames.sw+String.valueOf(switchCreated));
            this.setMinAssociacao(getRESTRICAO1());
            this.setMaxAssociacao(getNASSOCIACOES());
        }


    }

    public static int getSwitchCreated() {
        return switchCreated;
    }


}
