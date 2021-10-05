package B1_tests;

import e4.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Main test class for Calculator (JUnit 5)
 *
 * @author Iñigo L.R.B
 */

class CalculatorTest_e4 {

    private final static float EPSILON = 0.01f; // We need to consider EPSILON range due to precision constraints (floats)
    private final Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() {
        calculator.cleanOperations();
    }

    //test addition of operations, batch execution and check the internal state of calculator (operands and operations).
    @Test
    void testOperations() {
        float result;

        // Division by zero
        calculator.addOperation("/", 6, 0);
        assertThrows(ArithmeticException.class, calculator::executeOperations);
        // Internal state is restored (even if exception occurs).
        assertEquals("[STATE:]", calculator.toString());

        // The operation does not exist (input string has not a match)
        assertThrows(IllegalArgumentException.class, () -> calculator.addOperation("#", 5, 2));
        // Internal state is restored (even if exception occurs).
        assertEquals("[STATE:]", calculator.toString());

        // Add operations, calculate internal state representation (string pattern) and execute them as a single batch
        calculator.addOperation("+", 4.5f, 6.8f);
        calculator.addOperation("-", 3.1f);
        calculator.addOperation("/", 6f);
        assertEquals("[STATE:[+]4.5_6.8[-]3.1[/]6.0]", calculator.toString());
        result = calculator.executeOperations();
        assertEquals("[STATE:]", calculator.toString()); // state is restored
        assertEquals(1.366f, result, EPSILON);

        // Same, obtaining negative value
        calculator.addOperation("-", 3.7f, 5.8f);
        calculator.addOperation("*", 4.8f);
        calculator.addOperation("/", 2.0f);
        calculator.addOperation("+", 2.04f);
        assertEquals("[STATE:[-]3.7_5.8[*]4.8[/]2.0[+]2.04]", calculator.toString());
        result = calculator.executeOperations();
        assertEquals("[STATE:]", calculator.toString()); // state is restored
        assertEquals(-3f, result, EPSILON);

        // Using clean operations
        calculator.addOperation("-", 5.2f, 4.1f);
        calculator.addOperation("*", 3.256987f);
        assertEquals("[STATE:[-]5.2_4.1[*]3.256987]", calculator.toString());
        calculator.cleanOperations();
        assertEquals("[STATE:]", calculator.toString()); // state is restored
        calculator.addOperation("/", 8.4f, 5.6f);
        calculator.addOperation("+", 15.23f);
        assertEquals("[STATE:[/]8.4_5.6[+]15.23]", calculator.toString());
        result = calculator.executeOperations();
        assertEquals(16.73f, result, EPSILON);

        // Ignore unnecessary second parameter (it is not the first operation to be added), using integer values
        calculator.addOperation("+", 5f, 3f);
        calculator.addOperation("*", 2f, 6f); // 6f is ignored
        assertEquals("[STATE:[+]5.0_3.0[*]2.0]", calculator.toString());
        result = calculator.executeOperations();
        assertEquals(16f, result, EPSILON);
    }
}