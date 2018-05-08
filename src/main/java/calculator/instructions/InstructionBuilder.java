package calculator.instructions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InstructionBuilder {
    private List<InstructionInt> instructionInts = new ArrayList<>();

    public static List<InstructionInt> readFromStream(InputStream inputStream) throws IOException {
        Reader reader = new InputStreamReader(inputStream);
        return readFromReader(reader);
    }

    public static List<InstructionInt> readFromReader(Reader reader) throws IOException {
        InstructionBuilder builder = new InstructionBuilder();
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(" ");
            Double value = Double.valueOf(split[1]);
            builder.addInstruction(split[0], value);

        }
        return builder.build();
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

    public List<InstructionInt> build() {
        return instructionInts;
    }
}
