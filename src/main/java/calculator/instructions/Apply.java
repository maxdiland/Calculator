package calculator.instructions;

public class Apply implements InstructionInt {

    private Double value;

    public Apply(Double value) {
        this.value = value;
    }

    public double calculate(double number) {
        return value;
    }
}
