package poo;
/**
 * Classe responsável por gerar um nó do tipo Internet
 * @author Renan Rodolfo da Silva
 */

public class Internet extends Node{

    private static int internetCreated;
    public static final String CLOUDIMG = "../img/cloud.png";

    /**
     *
     * @param label utilizado como label do nó
     * @param tipo recebe tipo Internet da EnumNodeNames
     */
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

    /**
     *
     * @return quantidade de nó do tipo internet criado
     */
    public static int getInternetCreated() {
        return internetCreated;
    }




}
