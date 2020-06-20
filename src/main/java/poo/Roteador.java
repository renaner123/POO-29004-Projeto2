package poo;

public class Roteador extends Node {

    public final String BLUEROUTERIMG = "img/blue-router.png";
    public final String GREENROUTERIMG = "img/green-router.png";
    private static int routerCreated;

    public Roteador(String label) {
        super(label);
        routerCreated ++;
        this.setImage(BLUEROUTERIMG);
        this.setNomeNode(EnumNodeNames.router+String.valueOf(routerCreated));
        this.setMinAssociacao(getRESTRICAO2());
        this.setMaxAssociacao(getNASSOCIACOES());
    }

    public static int getRouterCreated() {
        return routerCreated;
    }



}
