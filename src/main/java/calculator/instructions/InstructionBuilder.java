package calculator.instructions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InstructionBuilder {
    private List<InstructionInt> instructionInts = new ArrayList<>(); //Тут список инструкций. Получаеются всякие мат. действия сюда с числами сюда складываются. смотри где происходит instructionInts.add()

    public static List<InstructionInt> readFromStream(InputStream inputStream) throws IOException {
        Reader reader = new InputStreamReader(inputStream);
        return readFromReader(reader);
    }

    public static List<InstructionInt> readFromReader(Reader reader) throws IOException {
        InstructionBuilder builder = new InstructionBuilder();
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine()) != null) { //bufferedReader в отличии от других Reader-ов умеет читать построчно. Потму да, в переменную line записывается прочетнная строка. Как только дойдем до конца файла - прочтется null и следовательно следующей итерации while не будет
            String[] split = line.split(" "); // Не совсем. split бьет строку на кусочки. В данном случае разбивка происходит по пробелу " "
            Double value = Double.valueOf(split[1]); // и берется второй по счету (по индексу 1) кусочек из прочтенной строки и парсится в дабл
            builder.addInstruction(split[0], value); // а тут берется первый по счету (нулевой по индексу) кусочек из строки. Видимо строка является инструкцией, где 1 кусочек - действие, 2 кусочек - число

        }
        return builder.build(); // Типичный шаблон проектирования builder. Когда ты для того чтобы построить готовый объект вызываешь промежуточные методы, а когда закончил наполнение данными, вызвал build и на основании введеных даных сконструируется объект
    }

    public InstructionBuilder addInstruction(String instruction, Double value) {
        if (instruction.equals("add")) {
            return add(value);
        } else if (instruction.equals("subtract")) {
            return subtract(value);
        } else if (instruction.equals("multiply")) {
            return multiply(value);
        } else if (instruction.equals("divide")) {
            return divide(value);
        } else if (instruction.equals("apply")) {
            return apply(value);
        } else {
            throw new UnsupportedOperationException("Operation " + instruction + " is not supported");
        }
    }

    public InstructionBuilder apply(Double value) {
        instructionInts.add(new Apply(value));
        return this;
    }

    public InstructionBuilder add(Double value) {
        instructionInts.add(new Add(value));
        return this;
    }

    public InstructionBuilder divide(Double value) {
        instructionInts.add(new Divide(value));
        return this;
    }

    public InstructionBuilder multiply(Double value) {
        instructionInts.add(new Multiply(value));
        return this;
    }

    public InstructionBuilder subtract(Double value) {
        instructionInts.add(new Subtract(value));
        return this;
    }

    public List<InstructionInt> build() { // Видимо автор решил использовать шаблон проектирования builder
        return instructionInts;
    }
}
