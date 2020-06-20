package poo;

public enum EnumNodeNames {
    wan(1),router(2),sw(3),desktop(4),server(5), ipCamera(6),firewall(7), rackServer(8);

    public int tipoNodeNames;

    EnumNodeNames(int tipo) {
        this.tipoNodeNames = tipo;
    }

    public static EnumNodeNames getByCodigo(int c){
        for (EnumNodeNames tipo: EnumNodeNames.values()){
            if (c == tipo.tipoNodeNames){
                return tipo;
            }
        }
        throw new IllegalArgumentException("ćodigo inv́alido");
    }


}