import java.util.Random;

public class GeradorDeNumeroRandomico {

    Random random = new Random();
    private int numeroAnterior;

    public int getNumeroAnterior() {
        return numeroAnterior;
    }

    public int gera(){
        return random.nextInt();
    }
}
