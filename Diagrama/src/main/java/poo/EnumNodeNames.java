package poo;

/**
 * Enum responsável por definir os nomes internos dos nós
 * @author Renan Rodolfo da Silva
 */
public enum EnumNodeNames {
    wan(1),router(2),sw(3),desktop(4),server(5), ipCamera(6),firewall(7), rackServer(8);

    public int tipoNodeNames;

    /**
     *
     * @param tipo
     */
    EnumNodeNames(int tipo) {
        this.tipoNodeNames = tipo;
    }

    /**
     *
     * @param c recebe um valor interno
     * @return retornar o tipo relacionado com o valor c
     */
    public static EnumNodeNames getByCodigo(int c){
        for (EnumNodeNames tipo: EnumNodeNames.values()){
            if (c == tipo.tipoNodeNames){
                return tipo;
            }
        }
        throw new IllegalArgumentException("ćodigo inv́alido");
    }





}