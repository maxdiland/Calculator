package calculator.instructions;

public class Divide implements InstructionInt {

    private Double value;

    Divide(Double value) {
        this.value = value;
    }

    public double calculate(double number) {
        return number / value;
    }
}
