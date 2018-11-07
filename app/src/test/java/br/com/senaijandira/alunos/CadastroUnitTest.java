package br.com.senaijandira.alunos;

import org.junit.Test;

import br.com.senaijandira.alunos.util.DateUtil;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CadastroUnitTest {
    @Test
    public void addition_isCorrect() {

        assertEquals(4, 2 + 2);

    }


    // Teste de Conversão de Data de Nascimento
    @Test
    public void conversao_data_esta_correta (){
        DateUtil util = new DateUtil();
        String input = "01/01/2000";
        int outputEsperado = 20000101;


        int resposta = util.coverteToInt(input);


        assertEquals(outputEsperado,resposta);
    }
}

