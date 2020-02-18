/**
 * Alexandre Tiago Ximenes
 */

public abstract class Veiculo {

    private Integer id;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private int qtdeDeRodas;
    private int velocMax;
    private Motor motor;

    public abstract void calcVel();

    public Veiculo(){}
    public Veiculo(String placa, String marca, String modelo, String cor, int qtdeDeRodas, int velocMax, Motor motor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.qtdeDeRodas = qtdeDeRodas;
        this.velocMax = velocMax;
        this.motor = motor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQtdeDeRodas() {
        return qtdeDeRodas;
    }

    public void setQtdeDeRodas(int qtdeDeRodas) {
        this.qtdeDeRodas = qtdeDeRodas;
    }

    public int getVelocMax(){
        return this.velocMax;
    }

    public void setVelocMax(int velocMax) throws VelocException{
        if(velocMax < 100 || velocMax > 250){
            throw new VelocException("A velocidade máxima está fora dos limites brasileiros");
        }
        this.velocMax = velocMax;
    };

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "----------------------------------" +
                "\nVeiculo" +
                "\nplaca:"  + placa +
                "\nmarca: " + marca +
                "\nmodelo: " + modelo +
                "\ncor: " + cor +
                "\nQuantidade de rodas: " + qtdeDeRodas +
                "\n" +motor;
    }
}
