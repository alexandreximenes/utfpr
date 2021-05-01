public class Dba implements Tributavel {
    @Override
    public Double calcula(Double salario) {
        if(salario == null) return 0.0;
        return salario >= 2000 ? salario - (salario * 0.25) : salario - (salario * 0.15);
    }
}
