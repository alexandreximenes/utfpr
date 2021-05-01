import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MyRandomNumberTest {

    @Test(expected = IntervaloInvalidoException.class)
    public void geraNumero_e_lanca_excecao_parametro1_menor_que_zero() throws IntervaloInvalidoException {

        MyRandomNumber myRandomNumber = new MyRandomNumber();
        myRandomNumber.nextRandomNumber(-1, 1);

    }

    @Test(expected = IntervaloInvalidoException.class)
    public void geraNumero_e_lanca_excecao_numeros_iguais() throws IntervaloInvalidoException {

        MyRandomNumber myRandomNumber = new MyRandomNumber();
        myRandomNumber.nextRandomNumber(1, 1);

    }

    @Test(expected = IntervaloInvalidoException.class)
    public void geraNumero_e_lanca_excecao_numeros_parametro1_maior_que_parametro2() throws IntervaloInvalidoException {

        MyRandomNumber myRandomNumber = new MyRandomNumber();
        myRandomNumber.nextRandomNumber(5, 1);

    }


    @Test(expected = IntervaloInvalidoException.class)
    public void geraNumero_e_lanca_excecao_parametro2_menor_que_zero() throws IntervaloInvalidoException {

        MyRandomNumber myRandomNumber = new MyRandomNumber();
        myRandomNumber.nextRandomNumber(1, -1);

    }

    @Test
    public void geraNumero_com_sucesso() throws IntervaloInvalidoException {

        GeradorDeNumeroRandomico geradorDeNumeroRandomico = mock(GeradorDeNumeroRandomico.class);

        when(geradorDeNumeroRandomico.gera()).thenReturn(1);

        MyRandomNumber myRandomNumber = new MyRandomNumber(geradorDeNumeroRandomico);

        int numero = myRandomNumber.nextRandomNumber(1, 5);

        assertEquals(1, numero);

    }

    @Test
    public void geraNumero_também_com_sucesso() throws IntervaloInvalidoException {

        GeradorDeNumeroRandomico geradorDeNumeroRandomico = mock(GeradorDeNumeroRandomico.class);

        when(geradorDeNumeroRandomico.gera()).thenReturn(5);

        MyRandomNumber myRandomNumber = new MyRandomNumber(geradorDeNumeroRandomico);

        int numero = myRandomNumber.nextRandomNumber(1, 5);

        assertEquals(5, numero);
    }

    @Test
    public void geraNumero_chama_pelo_menos_2_vezes() throws IntervaloInvalidoException {

        GeradorDeNumeroRandomico geradorDeNumeroRandomico = mock(GeradorDeNumeroRandomico.class);

        when(geradorDeNumeroRandomico.gera()).thenReturn(2, 4);

        MyRandomNumber myRandomNumber = new MyRandomNumber(geradorDeNumeroRandomico);

        int numero = myRandomNumber.nextRandomNumber(10, 15);

        assertEquals(4, numero);

        verify(geradorDeNumeroRandomico, atLeast(2)).gera();

    }

    @Test
    public void geraNumero_chama_pelo_menos_10_vezes_erro_loop_infinito() throws IntervaloInvalidoException {

        GeradorDeNumeroRandomico geradorDeNumeroRandomico = mock(GeradorDeNumeroRandomico.class);

        when(geradorDeNumeroRandomico.gera()).thenReturn(2, 4);

        MyRandomNumber myRandomNumber = new MyRandomNumber(geradorDeNumeroRandomico);

        int numero = myRandomNumber.nextRandomNumber(10, 15);

        verify(geradorDeNumeroRandomico, times(10)).gera();

    }

    @Test
    public void geraNumero_chama_pelo_no_maximo_10_vezes_erro() throws IntervaloInvalidoException {

        GeradorDeNumeroRandomico geradorDeNumeroRandomico = mock(GeradorDeNumeroRandomico.class);

        when(geradorDeNumeroRandomico.gera()).thenReturn(2, 4);

        MyRandomNumber myRandomNumber = new MyRandomNumber(geradorDeNumeroRandomico);

        int numero = myRandomNumber.nextRandomNumber(10, 15);

        verify(geradorDeNumeroRandomico, atMost(10)).gera();

    }


    @Test
    public void geraNumero_chama_passa_na_terceira_tentativa() throws IntervaloInvalidoException {

        GeradorDeNumeroRandomico geradorDeNumeroRandomico = mock(GeradorDeNumeroRandomico.class);

        when(geradorDeNumeroRandomico.gera()).thenReturn(2, 4, 11);

        MyRandomNumber myRandomNumber = new MyRandomNumber(geradorDeNumeroRandomico);

        int numero = myRandomNumber.nextRandomNumber(10, 15);

        verify(geradorDeNumeroRandomico, times(3)).gera();

        assertEquals(11, numero);

    }
}
