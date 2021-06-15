package unitTests;

import devcalc.Calc;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class TestaCalc {

    @Test
    public void testarSomarDoisNumeros () {
        // 1° Parte do teste é o PREPARAR - CONFIGURAR -GIVEN
        int num1 = 5;
        int num2 = 7;
        int resultadoEsperado = 12;

        //2° EXECUTAR - WHEN
        int resultadoAtual = Calc.somarDoisNumeros(num1, num2);

        //3° VALIDAR -THEN
        System.out.println("O resultado Esperado é " + resultadoEsperado + "\n O resultado Atual foi " + resultadoAtual);

        assertEquals(resultadoEsperado, resultadoAtual);

    }

    @Test
    public void testarMain(){

    }
}
