package poo;

import java.io.IOException;
import java.util.Scanner;

public class Principal {


    public static void menu(){
        Scanner teclado_int = new Scanner(System.in);
        Scanner teclado_string = new Scanner(System.in);

        Grafo grafo = new Grafo("Rede");

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
                    System.out.println("1. Adicionar nó no grafo");
                    System.out.println("2. Adicionar arcos no grafo");
                    System.out.println("3. Adicionar subgrafo no grafo");
                    System.out.println("4. Editar nó do grafo");
                    System.out.println("5. Editar arcos do grafo");
                    System.out.println("6. Editar subgrafo do grafo");
                    System.out.println("7. Listar os nós salvos");
                    System.out.println("8. Listar os arcos entre nós salvos");
                    System.out.println("9. Menu principal");

                    op = teclado_int.nextInt();

                   if(op == 1) {
                        System.out.println("1. Adicionar endpoint");
                        System.out.println(("2. Adicionar firewall"));
                        System.out.println("3. Adicionar internet");
                        System.out.println("4. Adicionar roteador");
                        System.out.println("5. Adicionar switch");
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
                            System.out.println("Digite um label para o nó");
                            args = teclado_string.nextLine();
                            grafo.addNode(args,EnumNodeNames.firewall);
                        }else if(op==3){
                            System.out.println("Digite um label para o nó");
                            args = teclado_string.nextLine();
                            grafo.addNode(args,EnumNodeNames.wan);
                        }else if(op==4){
                            System.out.println("Digite um label para o nó");
                            args = teclado_string.nextLine();
                            grafo.addNode(args,EnumNodeNames.router);
                        }else if(op==5){
                            System.out.println("Digite um label para o nó");
                            args = teclado_string.nextLine();
                            grafo.addNode(args,EnumNodeNames.sw);
                        }

                    } else if (op == 2) {
                       grafo.mostrarNodesSalvos();
                       String origem="";
                       String[] destino;
                       System.out.println("Digite nó de origem");
                       origem = teclado_string.nextLine();
                       System.out.println("Digite nó(s) de destino separado por vírgula(,) Ex.: router1,war1");
                       args = teclado_string.nextLine();
                       destino = args.split(",");
                       System.out.println(grafo.addNodeOrigemToDestino(origem,destino));

                    } else if (op == 3) {
                       String label="";
                       String[] destino;
                       System.out.println("Digite label para o subgrafo");
                       label = teclado_string.nextLine();
                       System.out.println("Digite nó(s)  do subgrafo separado por vírgula(,) Ex.: router1,war1");
                       args = teclado_string.nextLine();
                       destino = args.split(",");
                       grafo.addSubGrafo(label,destino);

                    } else if (op == 4) {
                       Node aux;
                       System.out.println("Digite nome interno do nó para editar");
                       args = teclado_string.nextLine();
                       System.out.println("1. Alterar imagem");
                       System.out.println(("2. Alterar cor"));
                       System.out.println("3. Alterar tamanho da fonte");
                       op = teclado_int.nextInt();

                       for(Node run : grafo.getNos()){
                           if(run.getNomeNode().equals(args)){
                               if(op==1){
                                   System.out.println("Digite a nova imagem");
                                   args = teclado_string.nextLine();
                                   run.setImage(args);
                               }else if(op==2){
                                   System.out.println("Digite a nova cor");
                                   args = teclado_string.nextLine();
                                   run.setColor(args);
                               }else if(op==3){
                                   System.out.println("Digite o novo tamanho da fonte");
                                   op = teclado_int.nextInt();
                                   run.setFontSize(op);
                               }

                           }
                       }




                    }else if (op == 5) {
                        System.out.println("cinco");

                    } else if (op == 6) {
                        System.out.println("seis");

                    } else if (op == 7) {
                       grafo.mostrarNodesSalvos();

                    }else if(op == 9){

                   }
                   else if(op == 8){
                       System.out.println(grafo.arcosEntreNosdoGrafo());
                   }
                }else if(op ==2){
                    System.out.println("1. Exportar diagrama no formato .Dot");
                    System.out.println("2. Salvar diagrama em disco");
                    System.out.println("3. Ler diagrama do disco");
                    op = teclado_int.nextInt();
                    Diagrama diagrama = new Diagrama(grafo);
                    if(op==1){
                        System.out.println("Digite o nome do arquivo");
                        args = teclado_string.nextLine();
                        diagrama.exportarDiagramaFormatoDot(args);
                        System.out.println("Arquivo exportado, programa encerrado!");
                    }else if(op ==2){
                        System.out.println("Digite o nome do arquivo");
                        args = teclado_string.nextLine();
                        diagrama.salvarDiagramaEmDisco(args);
                        System.out.println("Arquivo salvo, programa encerrado!");
                    }else if(op ==3){
                        System.out.println("Digite o nome do arquivo");
                        args = teclado_string.nextLine();
                        diagrama.lerDiagramaDoDisco(args);
                        grafo = diagrama.getGrafos();
                    }

                }else if(op == 3){
                    System.out.println("Aplicativo encerrado!");
                    break;
                }

            }catch (java.util.InputMismatchException e) {
                System.out.printf("Erro " + e.toString() + " ### " + "Digite um número interno \n");
                menu();
            }catch(Exception e) {
                menu();
            }

        }
    }
    public static void main(String[] args){
        menu();


    }


}
