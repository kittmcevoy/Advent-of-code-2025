import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Day3Task2 {
    public static void main(String[] args) throws IOException {
        Day3Task2 d = new Day3Task2();
        String[] instuctions = d.loadInstructions();
        long answer = d.solvePromlem(instuctions);
        System.out.println(answer);
    }

    long solvePromlem(String[] instructions) {
        String[][] result = new String[instructions.length][];
        long count = 0;
        for (int i = 0; i < instructions.length; i++) {
            result[i] = instructions[i].split("");
        }

        for (String[] string : result) {
            int[] joltage = new int[12];
            int pos = 0;
            joltage[0] = Integer.parseInt(string[0]);
            for (int i = 1; i < string.length; i++) {
                boolean added = false;
                for (int j = 0; j < joltage.length; j++) {
                    if (Integer.parseInt(string[i]) > joltage[j] && (string.length - i) > (11 - j) && added == false) {

                        joltage[j] = Integer.parseInt(string[i]);
                        added = true;

                        for (int k = j + 1; k < joltage.length; k++) {
                            joltage[k] = 0;
                        }

                    }

                }
                // if (Integer.parseInt(string[i]) >= joltage[pos] && (string.length - i) > (11
                // - pos)) {
                // joltage[pos] = Integer.parseInt(string[i]);
                // } else {
                // if (pos < 11) {
                // pos += 1;
                // }
                // joltage[pos] = Integer.parseInt(string[i]);
                // }
            }

            long number = 0;

            for (int num : joltage) {
                number = (number * 10) + num;
            }

            System.out.println(number);

            count = count + number;

        }

        return count;
    }

    String[] loadInstructions() throws IOException {
        String[] instructions = Files
                .readAllLines(Paths.get("input.txt"))
                .toArray(new String[0]);

        return instructions;

    }
}
