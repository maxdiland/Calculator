package calculator.instructions;

public class Subtract implements InstructionInt {
    private Double value;

    Subtract(Double value) {
        this.value = value;
    }

    public double calculate(double number) {
        return number - value;
    }
}
