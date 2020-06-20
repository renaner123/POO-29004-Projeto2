package poo;

public class Principal {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

          grafo.addEndpoint();
          grafo.addRoteador();

          System.out.println(grafo.toString());



    }
}
