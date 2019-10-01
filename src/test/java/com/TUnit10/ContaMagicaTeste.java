package com.TUnit10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ContaMagicaTeste {

    private ContaMagica cm;
    @BeforeEach
    private void startup (){

        cm = new ContaMagica();

    }

    @ParameterizedTest
    @CsvSource({"100","1000000","94883893638"})
    public void getSaldoTest(double valor) {

        assertEquals(valor, cm.getSaldo());

    }

    @ParameterizedTest
    @CsvSource({"1","0","2"})
    public void getStatusTest(double valor) {

        assertEquals(valor, cm.getStatus());

    }

    @ParameterizedTest
    @CsvSource({"100, 0","1000000, 2000","94883893638, 1000000"})
    public void depositoTest(int valor, double saldo) {

        cm.deposito(valor);
        assertEquals((valor+saldo), cm.getSaldo());

    }


    
}