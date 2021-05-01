public class Desenvolvedor implements Tributavel {
    @Override
    public Double calcula(Double salario) {
        if(salario == null) return 0.0;
        return salario >= 3000 ? salario - (salario * 0.20) : salario - (salario * 0.10);
    }
}
