package e4;

import java.util.*;

public class Calculator {

    private List<String> operations = null;
    private List<float[]> operators = null;

    /**
     * Public constructor of the calculator .
     */
    public Calculator() {

        operations = new ArrayList<>(Collections.emptyList());
        operators = new ArrayList<>(Collections.emptyList());
    }

    /**
     * Clean the internal state of the calculator
     */
    public void cleanOperations() {
        operators.clear();
        operations.clear();

    }

    /**
     * Add a new operation to the internal state of the calculator .
     * It is worth mentioning that the calculator behaves in an accumulative way ,
     * thus only first operation has two operands .
     * The rest of computations work with the accumulated value and only an extra
     * new operand . Second input value must be ignored if the operation does not
     * correspond to the first one .
     *
     * @param operation operation to add , as string , "+" , " -" , "*" , "/".
     * @param values    Operands of the new operation ( one or two operands ).
     *                  Uses the varargs feature .
     *                  https :// docs . oracle . com / javase /8/ docs / technotes / guides / language / varargs . html
     * @throws IllegalArgumentException If the operation does not exist .
     */
    public void addOperation(String operation, float... values) throws IllegalArgumentException {
        if (!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("*")) {
            throw new IllegalArgumentException("No existe ese tipo de operación");
        } else {
            operations.add(operation);
            operators.add(values);
        }

    }

    /**
     * Execute the set of operations of the internal state of the calculator .
     * Once execution is finished , internal state ( operands and operations )
     * is restored ( EVEN if exception occurs ).
     * This calculator works with " Batches " of operations .
     *
     * @return result of the execution
     * @throws ArithmeticException If the operation returns an invalid value
     *                             ( division by zero )
     */
    public float executeOperations() throws ArithmeticException {
        Operation op;
        float result = 0;
        int i = 0;
        float x = 0, y = 0;

        for (String operation : operations) {
            switch (operation) {
                case "+" -> op = Operation.ADD;
                case "-" -> op = Operation.SUBSTRACT;
                case "*" -> op = Operation.MULTIPLY;
                case "/" -> op = Operation.DIVIDE;
                default -> {
                    cleanOperations();
                    throw new IllegalArgumentException("Operación no válida");
                }
            }

            if (i == 0) {
                x = operators.get(i)[0];
                y = operators.get(i)[1];
            } else
                y = operators.get(i)[0];
            try {
                result = op.perform(x, y);
            } catch (ArithmeticException e) {
                cleanOperations();
                throw e;
            }

            x = result;
            i++;
        }

        cleanOperations();

        return result;
    }

    /**
     * Current internal state of calculator is printed
     * FORMAT :
     * "[{+/ -/"/"/*}] value1_value2 [{+/ -/"/"/*}] value1 [{+/ -/"/"/*}] value1 {...}"
     * EXAMPLES : JUnit tests
     * <p>
     * assertEquals("[STATE:[-]3.7_5.8[*]4.8[/]2.0[+]2.04]"
     *
     * @return String of the internal state of the calculator
     */
    @Override
    public String toString() {
        String cad = "[STATE:";
        int i = 0;


        for (String op : operations) { //MaL guardadas, PIERDE EL PRIMERO

            cad += "[" + op + "]" + operators.get(i)[0];
            if (i == 0 && operators.get(i).length >= 1) {
                cad += "_" + operators.get(i)[1];
            }
            i++;

        }
        cad += "]";
        return cad;
    }
}
