package calculator.instructions;

public class Add implements InstructionInt {

    private Double value;

    Add(Double value) {
        this.value = value;
    }

    public double calculate(double number) {
        return number + value;
    }
}
