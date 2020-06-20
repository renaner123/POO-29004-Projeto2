package poo;

public class Firewall extends Node{

    private static int firewallCreated;
    public final String FIREWALLIMG = "img/firewall.png";

    public Firewall(String label) {
        super(label);
        firewallCreated ++;
        this.setImage(FIREWALLIMG);
        this.setNomeNode(EnumNodeNames.firewall+String.valueOf(firewallCreated));
        this.setMinAssociacao(getRESTRICAO2());
        this.setMaxAssociacao(getNASSOCIACOES());
    }

    public static int getFirewallCreated() {
        return firewallCreated;
    }



}
