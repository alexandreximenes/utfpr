import java.util.Random;

public class MyRandomNumber {

    private int numeroAnterior = 0;
    private int contador = 0;

    private GeradorDeNumeroRandomico geradorDeNumeroRandomico;

    public MyRandomNumber() {
    }

    public MyRandomNumber(GeradorDeNumeroRandomico geradorDeNumeroRandomico) {
        this.geradorDeNumeroRandomico = geradorDeNumeroRandomico;
    }

    public int getNumeroAnterior() {
        return numeroAnterior;
    }

    /**
     *
     * @param begin inicio do intervalo
     * @param end fim do intervalo
     * @return retornar um numero aleatorio entre [begin, end]
     * o numero aleatorio retornado nao pode ser igual ao anterior
     * @throws IntervaloInvalidoException
     * essa excecao eh lancada quando begin >= end ou (begin<0 || end<0)
     *
     */

    public int nextRandomNumber(int begin, int end) throws IntervaloInvalidoException {

        if(begin < 0) throw new IntervaloInvalidoException("begin eh menor que zero");
        if(begin >= end) throw new IntervaloInvalidoException("begin eh não pode igual ou maior que end");
        if(end < 0) throw new IntervaloInvalidoException("end eh menor que zero");

        int numero = 0;

            do{
                ++contador;
                numero = geradorDeNumeroRandomico.gera();
                if(contador >= 10)
                    break;
            }while (numero == numeroAnterior || (numero < begin || numero > end));


        numeroAnterior = numero;



        //TODO implementar o codigo aqui
        return numero;
    }
}
