package calculator;

import calculator.instructions.InstructionInt;
import calculator.instructions.InstructionBuilder;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void calculateTest() throws Exception {
        Calculator calculator = new Calculator();

        List<InstructionInt> instructionInts = new InstructionBuilder().subtract(3d).apply(10d).build();

        assertThat(calculator.calculate(instructionInts), is(7d));
    }

    @Test
    public void calculateLongListTest() throws Exception {
        Calculator calculator = new Calculator();

        List<InstructionInt> instructionInts = new InstructionBuilder()
                .subtract(5d)
                .add(2d)
                .multiply(2d)
                .add(10d)
                .subtract(9d)
                .divide(5d)
                .apply(30d).build();

        assertThat(calculator.calculate(instructionInts), is(11d));     // ((30-5+2)*2 + 10 -9)/5 = 11
    }
}