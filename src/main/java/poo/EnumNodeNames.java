package poo;

package poo;

public enum NodeNames {
    wan(1),router(2),sw(3),desktop(4),server(5), ipCamera(6),firewall(7)

    public int tipoEndPoint;

    NodeNames(int tipo) {
        this.tipoEndPoint = tipo;
    }

    public static EnumEndPoint getByCodigo(int c){
        for (EnumEndPoint tipo: EnumEndPoint.values()){
            if (c == tipo.tipoEndPoint){
                return tipo;
            }
        }
        throw new IllegalArgumentException("ćodigo inv́alido");
    }


}