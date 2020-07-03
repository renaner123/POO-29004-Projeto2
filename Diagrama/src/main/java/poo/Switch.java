package poo;
/**
 * Classe responsável por gerar um nó do tipo switch
 * @author Renan Rodolfo da Silva
 */

public class Switch extends Node {

    private static int switchCreated;
    public static final String SWITCHGENERICIMG = "../img/switch.png";

    /**
     *
     * @param label utilizado para definir um label para switch
     * @param tipo recebe tipo sw da EnumNodeNames
     */
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
