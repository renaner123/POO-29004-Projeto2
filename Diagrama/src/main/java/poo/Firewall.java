package poo;
/**
 * Classe responsável por gerar um nó do tipo firewall
 * @author Renan Rodolfo da Silva
 */
public class Firewall extends Node{

    private static int firewallCreated;
    public final String FIREWALLIMG = "../img/firewall.png";

    /**
     *
     * @param label utilizado para definir um label para firewall
     * @param tipo recebe tipo firewall da EnumNodeNames
     */
    public Firewall(String label,EnumNodeNames tipo) {
        super(label);
        if(tipo.equals(EnumNodeNames.firewall)) {
            firewallCreated++;
            this.setImage(FIREWALLIMG);
            this.setNomeNode(EnumNodeNames.firewall + String.valueOf(firewallCreated));
            this.setMinAssociacao(getRESTRICAO2());
            this.setMaxAssociacao(getNASSOCIACOES());
        }
    }

    /**
     *
     * @return retorna quantidade de firewall criado
     */
    public static int getFirewallCreated() {
        return firewallCreated;
    }



}
