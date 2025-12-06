package text_file_reader;

public class Operation {
    private final double numOne;
    private final double numTwo;
    private final String operator;
    private double result;

    public Operation(double num1, double num2, String operator) {
        this.numOne = num1;
        this.numTwo = num2;
        this.operator = operator;
    }

    public void calculateOperation() {
        if(operator.equals("+")) {
            result = numOne + numTwo;
        }
        else if(operator.equals("-")) {
            result = numOne - numTwo;
        }
        else if(operator.equals("*")) {
            result = numOne * numTwo;
        }
        else {
            if(numTwo == 0) {
                result = Double.POSITIVE_INFINITY;
                System.out.println("Warning: Division by zero detected for operation " + numOne + " / " + numTwo);
            }
            else {
                result = numOne / numTwo;
            }
        }
    }

    public double getNumOne() {
        return numOne;
    }

    public double getNumTwo() {
        return numTwo;
    }

    public String getOperator() {
        return operator;
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return numOne + " " + operator + " " + numTwo + " = " + result;
    }
}
