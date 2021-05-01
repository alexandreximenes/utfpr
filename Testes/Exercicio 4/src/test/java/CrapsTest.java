import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CrapsTest {

    @Test
    public void testRolarDados_1(){
        Dado dado = mock(Dado.class);
        when(dado.rolar()).thenReturn(1);
        Craps craps = new Craps();
        craps.setDado(dado);
        craps.rolarDados();
        assertTrue(craps.isFimDeJogo());
        assertEquals(2, craps.getVencedor());
    }

    @Test
    public void testRolarDados_2(){
        Dado dadoMock = mock(Dado.class);
        when(dadoMock.rolar()).thenReturn(5, 2);
        Craps craps = new Craps();
        craps.setDado(dadoMock);
        craps.rolarDados();
        assertTrue(craps.isFimDeJogo());
        assertEquals(1, craps.getVencedor());
    }

    @Test
    public void testRolarDados_3(){
        Dado dadoMock = mock(Dado.class);
        Craps craps = new Craps();
        craps.setDado(dadoMock);

        when(dadoMock.rolar()).thenReturn(3, 5);
        craps.rolarDados();
        assertFalse(craps.isFimDeJogo());

        when(dadoMock.rolar()).thenReturn(6, 5);
        craps.rolarDados();
        assertFalse(craps.isFimDeJogo());
        when(dadoMock.rolar()).thenReturn(5, 2);
        craps.rolarDados();

        assertTrue(craps.isFimDeJogo());
        assertEquals(2, craps.getVencedor());
    }

    @Test
    public void testRolarDados_4(){
        Dado dadoMock = mock(Dado.class);
        Craps craps = new Craps();
        craps.setDado(dadoMock);

        when(dadoMock.rolar()).thenReturn(1, 3);
        craps.rolarDados();
        assertFalse(craps.isFimDeJogo());

        when(dadoMock.rolar()).thenReturn(2, 2);
        craps.rolarDados();

        assertTrue(craps.isFimDeJogo());
        assertEquals(1, craps.getVencedor());
    }

    @Test
    public void testRolar_primeiro_jogador_Ganha(){
        Dado dadoMock = mock(Dado.class);
        Craps craps = new Craps();
        craps.setDado(dadoMock);

        when(dadoMock.rolar()).thenReturn(5, 2);
        craps.rolarDados();
        assertTrue(craps.isFimDeJogo());

        when(dadoMock.rolar()).thenReturn(10, 1);
        craps.rolarDados();
        assertTrue(craps.isFimDeJogo());

        assertEquals(1, craps.getVencedor());
    }

    @Test
    public void testRolar_segundo_jogador_ganha(){
        Dado dadoMock = mock(Dado.class);
        Craps craps = new Craps();
        craps.setDado(dadoMock);

        when(dadoMock.rolar()).thenReturn(1, 1);
        craps.rolarDados();
        assertTrue(craps.isFimDeJogo());

        when(dadoMock.rolar()).thenReturn(1, 2);
        craps.rolarDados();
        assertTrue(craps.isFimDeJogo());

        when(dadoMock.rolar()).thenReturn(10, 2);
        craps.rolarDados();
        assertTrue(craps.isFimDeJogo());

        assertEquals(2, craps.getVencedor());
    }

    @Test
    public void testRolar_ninguem_ganha(){
        Dado dadoMock = mock(Dado.class);
        Craps craps = new Craps();
        craps.setDado(dadoMock);

        when(dadoMock.rolar()).thenReturn(0, 1);
        craps.rolarDados();
        assertFalse(craps.isFimDeJogo());

        craps.rolarDados();

        assertEquals(1, craps.getVencedor());
    }

    @Test
    public void testRolar_primeiro_jogador_ganha_segunda_rodada(){
        Dado dadoMock = mock(Dado.class);
        Craps craps = new Craps();
        craps.setDado(dadoMock);

        when(dadoMock.rolar()).thenReturn(0, 1);
        craps.rolarDados();

        when(dadoMock.rolar()).thenReturn(0, 1);
        craps.rolarDados();

        assertTrue(craps.isFimDeJogo());

        assertEquals(1, craps.getVencedor());
    }

    @Test
    public void testRolar_verificando_2_chamadas_rolar_dados(){
        Dado dadoMock = mock(Dado.class);
        Craps craps = mock(Craps.class);
        craps.setDado(dadoMock);

        when(dadoMock.rolar()).thenReturn(0, 1);
        craps.rolarDados();

        when(dadoMock.rolar()).thenReturn(0, 1);
        craps.rolarDados();

        verify(craps, times(2)).rolarDados();
    }
}
