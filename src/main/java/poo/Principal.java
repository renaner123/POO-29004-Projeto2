package poo;


import java.io.FileInputStream;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Grafo inserir = new Grafo("First Grafo");

        ArrayList<Node> teste = new ArrayList<>();

        inserir.addEndPoint("PC1",EnumNodeNames.desktop);
        inserir.addFirewall("Mikrotik");
        inserir.addFirewall("Mikrotik");
        inserir.addRoteador("Router Principal");
        inserir.addInternet("WAN");

        //inserir.mostrarNodes();

    /*
    O nó endpoint (desktop, câmera IP, servidor) poderá estar associado a no máximo a um outro nó
    O nó roteador poderá estar associado com 2 ou N outros nós
    O nó firewall poderá estar associado com 2 ou N outros nós
    O nó switch (comutador) poderá estar associado com 1 ou N outros nós
    O nó Internet poderá estar associado com 1 ou N outros nós */


        inserir.nodeOrigemToDestino("wan1","router1","firewall2");
        inserir.nodeOrigemToDestino("firewall1","firewall2","PC1");
        inserir.nodeOrigemToDestino("firewall2","router1");
        inserir.nodeOrigemToDestino("desktop1","firewall1","firewall2");

        teste = inserir.getNos();

//        System.out.println(inserir.arcosEntreNosdoGrafo());
//        System.out.println(inserir.nosDoGrafro());

        for(Node aux : teste){
            if(aux.getNomeNode().equals("firewall1")){
                aux.setFontSize(14);
            }
        }
        System.out.println(inserir.toString());














    }
}
