package calculator.instructions;

public class Multiply implements InstructionInt {

    private Double value;

    Multiply(Double value) {
        this.value = value;
    }

    public double calculate(double number) {
        return number * value;
    }
}
