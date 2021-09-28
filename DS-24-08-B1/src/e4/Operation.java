package e4;

public enum Operation {
    ADD("+") {
        @Override
        public float perform(float operand1, float operand2) throws ArithmeticException{
            return operand1 + operand2;
        }
    },
    SUBSTRACT("-") {
        @Override
        public float perform(float operand1, float operand2) throws ArithmeticException{
            return operand1 - operand2;
        }
    },
    MULTIPLY("*") {
        @Override
        public float perform(float operand1, float operand2) {
            return operand1 * operand2;
        }
    },
    DIVIDE("/") {
        @Override
        public float perform(float operand1, float operand2) throws ArithmeticException{
            if(operand2==0) throw new ArithmeticException("División por cero");
            return operand1 / operand2;
        }
    };


    private final String operator;

    Operation(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public abstract float perform(float operand1, float operand2)throws ArithmeticException;
}
