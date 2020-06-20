package poo;

import java.util.ArrayList;

public class Grafo {

    private EndPoint endpoint;
    private Roteador roteador;
    protected ArrayList<No> nos = new ArrayList<>();


    public Grafo() {
    }

    public void addEndpoint() {
        nos.add(new EndPoint("Desktop"));

    }
    public void addRoteador() {
        nos.add(new Roteador("Tp link"));

    }

    @Override
    public String toString() {
        return "Grafo{" +
                "nos=" + nos +
                '}';
    }
}
