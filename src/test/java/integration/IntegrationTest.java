package integration;

import calculator.Calculator;
import calculator.instructions.InstructionBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IntegrationTest {
    private Calculator calculator = new Calculator();

    @Test
    public void example1() throws IOException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/examples/example1");
        assertThat(calculator.calculate(InstructionBuilder.readFromStream(resourceAsStream)), is(36d));
    }

    @Test
    public void example2() throws IOException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/examples/example2");
        assertThat(calculator.calculate(InstructionBuilder.readFromStream(resourceAsStream)), is(32d));
    }

    @Test
    public void example3() throws IOException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/examples/example3");
        assertThat(calculator.calculate(InstructionBuilder.readFromStream(resourceAsStream)), is(1d));
    }
}
