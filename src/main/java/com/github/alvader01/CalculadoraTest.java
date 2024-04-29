package com.github.alvader01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {
    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;


    public static void setUpClass(){
        miCalculadora = new Calculadora();
    }


    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2,3));
        assertEquals(0, miCalculadora.multiplica(3,4));
    }


    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() throws Exception {
        assertEquals(2, miCalculadora.divide(8,2));
        assertEquals(2.5, miCalculadora.divide(10,4));

    }


    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() throws Exception {
        assertTrue(miCalculadora.divide(4,-2)< 0);
        assertTrue(miCalculadora.divide(-4,2) < 0);
    }


    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.divide(0,5);
        });

        assertEquals("El divisor es 0", thrown.getMessage());
    }

    @Test
    public void testRaizCuadradaDeUno() {
        Calculadora calc = new Calculadora();
        double resultado = calc.raizCuadrada(1);
        assertEquals(1.0, resultado, 0.001);
    }

    @Test
    public void testRaizCuadradaDeCero() {
        Calculadora calc = new Calculadora();
        double resultado = calc.raizCuadrada(0);
        assertEquals(0.0, resultado, 0.001);
    }
    @Test
    public void testRaizCuadradaDeCuatro() {
        Calculadora calc = new Calculadora();
        double resultado = calc.raizCuadrada(4);
        assertEquals(2.0, resultado, 0.001);
    }

    @Test
    public void testRadicandoNegativoLanzaExcepcion() {
        Calculadora calc = new Calculadora();
        try {
            calc.raizCuadradaN(-1);
            fail("Se esperaba que lanzara una OperacionInvalidaException");
        } catch (OperacionInvalidaException e) {
            assertEquals("El radicando no puede ser negativo", e.getMessage());
        }
    }

}

