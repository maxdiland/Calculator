package calculator;

import calculator.instructions.*;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class InstructionIntBuilderTest {

    @Test
    public void checkBuildingFromString() {
        InstructionBuilder builder = new InstructionBuilder();

        List<InstructionInt> instructionInts =
                builder
                        .addInstruction("subtract", 10d)
                        .addInstruction("apply", 11d)
                        .addInstruction("multiply", 2d)
                        .addInstruction("divide", 6d)
                        .addInstruction("add", 1d)
                        .build();

        assertThat(instructionInts.get(0) instanceof Subtract, is(true));
        assertThat(instructionInts.get(1) instanceof Apply, is(true));
        assertThat(instructionInts.get(2) instanceof Multiply, is(true));
        assertThat(instructionInts.get(3) instanceof Divide, is(true));
        assertThat(instructionInts.get(4) instanceof Add, is(true));

        assertThat(instructionInts.get(0).calculate(3), is(-7d));
        assertThat(instructionInts.get(1).calculate(3), is(11d));
        assertThat(instructionInts.get(2).calculate(3), is(6d));
        assertThat(instructionInts.get(3).calculate(3), is(0.5d));
        assertThat(instructionInts.get(4).calculate(3), is(4d));
    }

    @Test
    public void checkBuildingDirectly() {
        InstructionBuilder builder = new InstructionBuilder();

        List<InstructionInt> instructionInts =
                builder
                        .subtract(10d)
                        .apply(11d)
                        .multiply(2d)
                        .divide(6d)
                        .add(1d)
                        .build();

        assertThat(instructionInts.get(0) instanceof Subtract, is(true));
        assertThat(instructionInts.get(1) instanceof Apply, is(true));
        assertThat(instructionInts.get(2) instanceof Multiply, is(true));
        assertThat(instructionInts.get(3) instanceof Divide, is(true));
        assertThat(instructionInts.get(4) instanceof Add, is(true));

        assertThat(instructionInts.get(0).calculate(3), is(-7d));
        assertThat(instructionInts.get(1).calculate(3), is(11d));
        assertThat(instructionInts.get(2).calculate(3), is(6d));
        assertThat(instructionInts.get(3).calculate(3), is(0.5d));
        assertThat(instructionInts.get(4).calculate(3), is(4d));
    }
}