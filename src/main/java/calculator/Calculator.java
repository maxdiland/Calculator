package calculator;

import calculator.instructions.Apply;
import calculator.instructions.InstructionInt;
import calculator.instructions.InstructionBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Calculator {

    public static void main(String[] args) {
        if (args.length != 1) {
            warningMethod();
            return;
        }
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(args[0]); // мы же обсуждали это. Что параметры переданные при запуске пихаются в массив args. Вот из этого массива берется самый первый элемент, т.е. ожидается что это имя файла, отуда будут браться инструкции для рассчетов
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            warningMethod();
            return;
        }

        Calculator calculator = new Calculator();

        double result;
        try {
            result = calculator.calculate(InstructionBuilder.readFromStream(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
            warningMethod();
            return;
        }
        System.out.println(result);

    }

    private static void warningMethod() {
        System.out.println("This program have to use one of examples file. " +
                "Please add it in Edit Configuration (see the screenshot)");
    }

    public double calculate(List<InstructionInt> instructionInts) {
        confirmScript(instructionInts);
        double value = instructionInts.remove(instructionInts.size() - 1).calculate(0d);
        for (InstructionInt instructionInt : instructionInts) {
            value = instructionInt.calculate(value);
        }
        System.out.print("Calculated value is: ");
        return value;
    }

    private void confirmScript(List<InstructionInt> instructionInts) {
        checkNotNull(instructionInts);
        checkArgument(instructionInts.get(instructionInts.size() - 1) instanceof Apply); //тут берется самая последняя инструкция (instructionInts.size() - 1 - это самый последний индекс в массиве) и проверяется, является ли эта инструкция применяющей. Если нет, я так понимаю, все вычитаное из файла не будет выполнено. Т.е. это как бы приказ выполнить все инструкции что были описаны в файле. Само выполнение происходит в другом месте. Тут же просто проверяется что последняя команда Apply. Если нет - будет выброшена ошибка скорее всего
    }
}
