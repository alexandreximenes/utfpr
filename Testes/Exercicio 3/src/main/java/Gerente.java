public class Gerente implements Tributavel {
    @Override
    public Double calcula(Double salario) {
        if(salario == null) return 0.0;
        return salario >= 5000 ? salario - (salario * 0.30) : salario - (salario * 0.20);
    }
}
