package e4;

public enum Operation {     //Enumerado de operaciones donde comparten todas la implementacion de la funcion perform
    ADD {
        @Override
        public float perform(float operand1, float operand2) throws ArithmeticException{
            return operand1 + operand2;
        }
    },//Realiza una suma
    SUBSTRACT {
        @Override
        public float perform(float operand1, float operand2) throws ArithmeticException{
            return operand1 - operand2;
        }
    },//Realiza una resta
    MULTIPLY {
        @Override
        public float perform(float operand1, float operand2) {
            return operand1 * operand2;
        }
    },//Realiza una multiplicacion
    DIVIDE{
        @Override
        public float perform(float operand1, float operand2) throws ArithmeticException{
            if(operand2==0) throw new ArithmeticException("División por cero"); //Comprueba que no sea division por 0
            return operand1 / operand2;
        }
    };//Realiza una division



    public abstract float perform(float operand1, float operand2)throws ArithmeticException;
}
