package calculator.instructions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InstructionsTest {

    @Test
    public void addTest() {
        Add add = new Add(20d);
        assertThat(add.calculate(0d), is(20d));
        assertThat(add.calculate(5d), is(25d));
        assertThat(add.calculate(-8d), is(12d));
    }

    @Test
    public void subtractTest() {
        Subtract subtract = new Subtract(20d);
        assertThat(subtract.calculate(0d), is(-20d));
        assertThat(subtract.calculate(5d), is(-15d));
        assertThat(subtract.calculate(-8d), is(-28d));
    }

    @Test
    public void multiplyTest() {
        Multiply multiply = new Multiply(20d);
        assertThat(multiply.calculate(0d), is(0d));
        assertThat(multiply.calculate(5d), is(100d));
        assertThat(multiply.calculate(-8d), is(-160d));
    }

    @Test
    public void divideTest() {
        Divide divide = new Divide(20d);
        assertThat(divide.calculate(1d), is(0.05d));
        assertThat(divide.calculate(0d), is(0d));
        assertThat(divide.calculate(5d), is(0.25d));
        assertThat(divide.calculate(-8d), is(-0.4d));
    }

    @Test
    public void divideByZeroTest() {
        Divide divide = new Divide(0d);

        assertThat(divide.calculate(1d), is(Double.POSITIVE_INFINITY));
        assertThat(divide.calculate(0d), is(Double.NaN));
        assertThat(divide.calculate(-3d), is(Double.NEGATIVE_INFINITY));
    }

    @Test
    public void applyTest() {
        Apply apply = new Apply(10d);

        assertThat(apply.calculate(0d), is(10d));
        assertThat(apply.calculate(5d), is(10d));
        assertThat(apply.calculate(-8d), is(10d));
    }

}