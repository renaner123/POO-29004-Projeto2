package poo;

import java.io.*;
import java.util.*;

public class Diagrama {

    Grafo grafos;

    public Diagrama(Grafo g) {
        this.grafos = g;
    }
    public boolean exportarDiagramaFormatoDot(String nomeDoArquivo){
        File arquivo = new File(nomeDoArquivo+".dot");
        String texto = "";

        texto = this.grafos.toString();

        FileWriter fwArquivo = null;
        try {
            fwArquivo = new FileWriter(arquivo, arquivo.exists());
            BufferedWriter bwArquivo = new BufferedWriter(fwArquivo);

            bwArquivo.write(texto + "\n");
            bwArquivo.close();
            fwArquivo.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return false;
    }

    public void salvarDiagramaEmDisco(String nomeDoArquivo) {
        try (
             FileOutputStream fout = new FileOutputStream(new File(nomeDoArquivo));
             ObjectOutputStream oos = new ObjectOutputStream(fout);
        ) {
            oos.writeObject(this.grafos);
            oos.flush();
            oos.close();
            fout.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Grafo lerDiagramaDoDisco(String nomeDoArquivo) {
        Grafo nova = null;
        try (FileInputStream fout = new FileInputStream(new File(nomeDoArquivo));
             ObjectInputStream oos = new ObjectInputStream(fout);
        ) {
            nova = (Grafo) oos.readObject();
            return nova;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return nova;
    }


    public Grafo getGrafos() {
        return grafos;
    }

    public void setGrafos(Grafo grafos) {
        this.grafos = grafos;
    }
}
