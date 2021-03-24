package ru.skillbox;

public class ArithmeticCalculator {
    private double firstOperand;
    private double secondOperand;

    public ArithmeticCalculator(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public double calculate(Operation operator){
        if (operator.equals(Operation.ADD)) {
            return firstOperand + secondOperand;
        }
        if (operator.equals(Operation.SUBTRACT)) {
            return firstOperand - secondOperand;
        }
        if (operator.equals(Operation.MULTIPLY)){
            return firstOperand * secondOperand;
        }
        return 0;
    }
}
