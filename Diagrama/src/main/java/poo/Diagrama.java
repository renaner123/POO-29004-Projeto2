package poo;

import java.io.*;
import java.util.*;
/**
 * Classe responsável por exportar arquivo dot e salvar em disco
 * @author Renan Rodolfo da Silva
 */

public class Diagrama {

    Grafo grafos;

    /**
     *
     * @param g recebe um grafo que tera seu diagrama salvo/exportado
     */
    public Diagrama(Grafo g) {
        this.grafos = g;
    }

    /**
     *
     * @param nomeDoArquivo recebe nome que o arquivo vai ter
     * @return false
     */
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

    /**
     *
     * @param nomeDoArquivo nome que tera o arquivo quando salvo em disco
     */
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

    /**
     *
     * @param nomeDoArquivo nome do arquivo que se deseja ler do disco
     * @return um grafo caso consiga ler do disco
     */
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

    /**
     *
     * @return o grafo utilizado
     */
    public Grafo getGrafos() {
        return grafos;
    }

    /**
     *
     * @param grafos muda o grafo a ser usado
     */
    public void setGrafos(Grafo grafos) {
        this.grafos = grafos;
    }
}
