package poo;
/**
 * Classe responsável por gerar um nó do tipo endpoint
 * @author Renan Rodolfo da Silva
 */
public class EndPoint extends Node{

    public final String DESKTOPIMG = "../img/desktop.png";
    public final String IPCAMERAIMG = "../img/ip-camera.png";
    public final String SERVERGENERICIMG = "../img/network-server-generic.png";
    public final String RACKSERVERIMG = "../img/rack-server.png";

    private static int desktoptCreated;
    private static int ipCameraCreated;
    private static int servidorCreated;

    /**
     *
     * @param label utilizado para definir um label para endpoint
     * @param tipo recebe tipo desktop,server,ipCamera da EnumNodeNames
     */
    public EndPoint(String label, EnumNodeNames tipo) {
        super(label);
        this.setMinAssociacao(getRESTRICAO1());
        this.setMaxAssociacao(getRESTRICAO1());
        if(tipo.equals(EnumNodeNames.desktop)){
            desktoptCreated++;
            this.setImage(DESKTOPIMG);
            this.setNomeNode(tipo.name()+String.valueOf(desktoptCreated));
        }else if(tipo.equals(EnumNodeNames.ipCamera)){
            ipCameraCreated++;
            this.setImage(IPCAMERAIMG);
            this.setNomeNode(tipo.name()+String.valueOf(ipCameraCreated));
        }else if(tipo.equals(EnumNodeNames.server)){
            servidorCreated++;
            this.setImage(SERVERGENERICIMG);
            this.setNomeNode(tipo.name()+String.valueOf(servidorCreated));
        }else if(tipo.equals(EnumNodeNames.rackServer)){
            servidorCreated++;
            this.setImage(RACKSERVERIMG);
            this.setNomeNode(tipo.name()+String.valueOf(RACKSERVERIMG));
        }


    }






}
