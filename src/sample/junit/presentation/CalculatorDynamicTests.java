package sample.junit.presentation;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import sample.junit.Calculator;

public class CalculatorDynamicTests {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @TestFactory
    Stream<DynamicTest> generateTests() {
        return IntStream.iterate(1, i -> i + 1)
            .limit(10)
            .mapToObj(n -> dynamicTest(
                		"Double " + n,
                		() -> assertEquals(2 * n, calculator.add(n, n))));
    }
}
