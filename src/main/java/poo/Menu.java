package poo;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {


    public Menu() {
    }

    public void showMenu(){
        Scanner teclado_int = new Scanner(System.in);
        Scanner teclado_string = new Scanner(System.in);
        Grafo grafo = new Grafo();
        int op=0;
        String args = "";

        System.out.println("Bem vindo ao gerador de diagramas de rede");
        System.out.println("Ele possui as seguintes restrições de associações");
        System.out.println("-- O nó endpoint (desktop, câmera IP, servidor) poderá estar associado a no máximo a um outro nó");
        System.out.println("-- O nó roteador poderá estar associado com 2 ou N outros nós");
        System.out.println("-- O nó firewall poderá estar associado com 2 ou N outros nós");
        System.out.println("-- O nó switch (comutador) poderá estar associado com 1 ou N outros nós");
        System.out.println("-- Nó Internet poderá estar associado com 1 ou N outros nós\n");

        while (true) {
            System.out.println("1. Grafo");
            System.out.println("2. Diagrama");
            System.out.println("3. Sair");
            try {
                op = teclado_int.nextInt();
                if(op == 1) {
                    System.out.println("0. Criar um digrama");
                    System.out.println("1. Adicionar nó no grafo");
                    System.out.println("2. Adicionar arcos no grafo");
                    System.out.println("3. Adicionar subgrafo no grafo");
                    System.out.println("4. Editar nó do grafo");
                    System.out.println("5. Editar arcos do grafo");
                    System.out.println("6. Editar subgrafo do grafo");
                    System.out.println("7. Menu principal");
                    System.out.println("8. Listar os nós salvos");
                    op = teclado_int.nextInt();

                    if(op ==0){
                        System.out.println("zero");
                        System.out.println("Digite um label para o grafo");
                        args = teclado_string.nextLine();
                        grafo = new Grafo(args);
                        System.out.println(grafo.getLabel());

                    }else if(op == 1) {
                        System.out.println("1. Adicionar endpoint");
                        System.out.println(("2. Adicionar firewall"));
                        System.out.println("3. Adicionar internet");
                        System.out.println("4. Editar roteador");
                        System.out.println("5. Editar switch");
                        op = teclado_int.nextInt();
                        if(op==1){
                            System.out.println("1. Adicionar desktop");
                            System.out.println(("2. Adicionar Camera Ip"));
                            System.out.println("3. Adicionar server");
                            op = teclado_int.nextInt();

                            if(op==1){
                                System.out.println("Digite um label para o nó");
                                args = teclado_string.nextLine();
                                grafo.addNode(args,EnumNodeNames.desktop);

                            }else if(op==2){
                                System.out.println("Digite um label para o nó");
                                args = teclado_string.nextLine();
                                grafo.addNode(args,EnumNodeNames.ipCamera);

                            }else if(op == 3){
                                System.out.println("Digite um label para o nó");
                                args = teclado_string.nextLine();
                                grafo.addNode(args,EnumNodeNames.server);
                            }

                        }else if(op==2){
//                            args = teclado.nextLine();
//                            System.out.println("Digite um label para o nó");
//                            args = teclado.nextLine();
                        }else if(op==3){
//                            args = teclado.nextLine();
//                            System.out.println("Digite um label para o nó");
//                            args = teclado.nextLine();
                        }else if(op==4){
//                            args = teclado.nextLine();
//                            System.out.println("Digite um label para o nó");
//                            args = teclado.nextLine();
                        }else if(op==5){
//                            args = teclado.nextLine();
//                            System.out.println("Digite um label para o nó");
//                            args = teclado.nextLine();
                        }else if(op==6){

                        }else if(op==7){

                        }else if(op==8){
                            System.out.println("oito");
                            System.out.println(grafo.getLabel());
                        }



                    } else if (op == 2) {
                        System.out.println("Digite node origem e o(s) nó(s) de destino");

                    } else if (op == 3) {
                        System.out.println("tres");

                    } else if (op == 4) {
                        System.out.println("quatro");

                    }else if (op == 5) {
                        System.out.println("cinco");

                    } else if (op == 6) {
                        System.out.println("seis");

                    } else if (op == 7) {
                        System.out.println("sete");

                    }else if(op == 8){
                        System.out.println("oito");

                    }
                }else if(op ==2){
                    System.out.println("1. Exportar diagrama no formato .Dot");
                    System.out.println("2. Salvar diagrama em disco");
                    System.out.println("3. Ler diagrama do disco");
                    op = teclado_int.nextInt();

                    if(op==1){

                    }else if(op ==2){

                    }else if(op ==3){

                    }

                }else if(op == 3){
                    System.out.println("Aplicativo encerrado!");
                    break;
                }

            }catch (java.util.InputMismatchException e) {
                System.out.printf("Erro " + e.toString() + " ### " + "Digite um número interno \n");
                showMenu();
            }catch(Exception e) {
                showMenu();
            }

        }
    }

}