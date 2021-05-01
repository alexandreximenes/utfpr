public class Principal {

    public static void main(String[] args) {

        Identifier identifier = new Identifier("abcd");
        if(identifier.validate())
            System.out.println("Identificador valido");
        System.out.println("Identificador invalido");
    }
}
