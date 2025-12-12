import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day3Task1 {
    public static void main(String[] args) throws IOException {
        Day3Task1 d = new Day3Task1();
        String[] instuctions = d.loadInstructions();
        int answer = d.solvePromlem(instuctions);
        System.out.println(answer);
    }

    int solvePromlem(String[] instructions) {
        String[][] result = new String[instructions.length][];
        int count = 0;
        for (int i = 0; i < instructions.length; i++) {
            result[i] = instructions[i].split("");
        }

        for (String[] string : result) {
            int firstNum = 0;
            int secondNum = 0;
            for (int i = 0; i < string.length; i++) {
                if (Integer.parseInt(string[i]) > firstNum && i != string.length - 1) {
                    firstNum = Integer.parseInt(string[i]);
                    secondNum = 0;
                } else if (Integer.parseInt(string[i]) > secondNum) {
                    secondNum = Integer.parseInt(string[i]);
                }
            }
            count = count + ((firstNum * 10) + secondNum);
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
