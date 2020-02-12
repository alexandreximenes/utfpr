/**
 * Alexandre Tiago Ximenes
 */

public class Passeio extends Veiculo implements Calc{

    private int qtdeDePassageiros;

    public Passeio(){}
    public Passeio(String placa, String marca, String modelo, String cor, int qtdeDeRodas, int velocMax, Motor motor, int qtdeDePassageiros) {
        super(placa, marca, modelo, cor, qtdeDeRodas, velocMax, motor);
        this.qtdeDePassageiros = qtdeDePassageiros;
    }

    public int getQtdeDePassageiros() {
        return qtdeDePassageiros;
    }

    public void setQtdeDePassageiros(int qtdeDePassageiros) {
        this.qtdeDePassageiros = qtdeDePassageiros;
    }

    @Override
    public void calcVel() {

    }


    @Override
    public double calcular() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + "\nQtde de Passageiros: " + qtdeDePassageiros;
    }
}
