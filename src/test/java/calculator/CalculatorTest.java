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

        List<InstructionInt> instructionInts = new InstructionBuilder().subtract(3d).apply(10d).build(); // Так принято, что с листами и сетами и мапами обычно работают на уровне интерфесов. Удобство в том, что сегодня используется ArrayList, а завтра нужно будет перейти на LinkedList. В связи с тем, что оба этих класса являются List-ами, твой код продолжит компилироваться и работать и после подмены реализации. Собственно это и есть пример полиморфизма.

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
