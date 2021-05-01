import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraDeSalariosTest {

    Tributavel tributavel;
    /*
    Caso o cargo seja DESENVOLVEDOR, o funcionário terá desconto de 20% caso o salário seja maior ou igual que 3.000,00,
    ou apenas 10% caso o salário seja menor que isso.
    Caso o cargo seja DBA, o funcionário terá desconto de 25% caso o salário seja maior ou igual que 2.000,00, ou apenas 15% caso o salário seja menor que isso.
    Caso o cargo seja TESTADOR, o funcionário terá desconto de 25% caso o salário seja maior ou igual que 2.000,00, ou apenas 15% caso o salário seja menor que isso.
    Caso o cargo seja GERENTE, o funcionário terá desconto de 30% caso o salário seja maior ou igual que 5.000,00, ou apenas 20% caso o salário seja menor que isso.
    */

    @Test
    public void calculaSalarioDesenvolvedor(){
        tributavel = new Desenvolvedor();

        double salarioTresMil = 3000.00;
        double salarioParam = 5000.00;

        Double salario = tributavel.calcula(salarioParam);

        double salarioEsperado = salarioParam >= salarioTresMil ? salarioParam - (salarioParam * 0.20) : salarioParam - (salarioParam * 0.10);

        assertEquals(salarioEsperado, salario, 0.0);

    }

    @Test
    public void calculaSalarioDBA(){
        tributavel = new Dba();

        double salarioParam = 2500.00;

        Double salario = tributavel.calcula(salarioParam);

        double salarioDoisMil = 2000;

        double salarioEsperado = salarioParam >= salarioDoisMil ? salarioParam - (salarioParam * 0.25) : salarioParam - (salarioParam * 0.15);
        assertEquals(salarioEsperado, salario, 0.0);
    }

    @Test
    public void calculaSalarioTestador(){
        tributavel = new Testador();
        double salarioParam = 550.00;

        Double salario = tributavel.calcula(salarioParam);

        double salarioMileQuinhentos = 1500;

        double salarioEsperado = salarioParam >= salarioMileQuinhentos ? salarioParam - (salarioParam * 0.25) : salarioParam - (salarioParam * 0.15);
        assertEquals(salarioEsperado, salario, 0.0);
    }

    @Test
    public void calculaSalarioGerente(){
        tributavel = new Gerente();
        double salarioParam = 5001;

        Double salario = tributavel.calcula(salarioParam);

        double salarioCincoMil = 5000;

        double salarioEsperado = salarioParam >= salarioCincoMil ? salarioParam - (salarioParam * 0.30) : salarioParam - (salarioParam * 0.20);
        assertEquals(salarioEsperado, salario, 0.0);
    }
}
