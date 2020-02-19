/**
 * Alexandre Tiago Ximenes
 */

public final class Passeio extends Veiculo implements Calc {

    private int qtdeDePassageiros;

    public Passeio() {
    }

    @Override
    public long getVelocMax() {
        return calcular(super.getVelocMax());
    }

    @Override
    public void setVelocMax(int velocMax) {
        try {
            super.setVelocMax(velocMax);
        } catch (VelocException e) {
            System.out.println(e.getMessage());
            this.setVelocMax(150);
            System.out.println("Velocidade padrão: "+this.getVelocMax());
        }

    }

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
    public String toString() {
        return super.toString()
                + "\nQtde de Passageiros: " + qtdeDePassageiros
                + "\nVelocidade Maxima: " + this.getVelocMax() + " M/h";
    }

    @Override
    public long calcular(long veloMax) {
        return veloMax * 1_000;
    }
}
