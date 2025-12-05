package Day1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.IOException;

class Day1Task2 {

    public static void main(String[] args) throws IOException {
        Day1Task2 d = new Day1Task2();
        String[] instuctions = d.loadInstructions();
        int answer = d.solvePromlem(instuctions);
        // int position = d.ammountOfTimePositionIsZero(positions);
        System.out.println(answer);
    }

    int solvePromlem(String[] instructions) {
        int position = 50;
        int countDialIsAtZero = 0;
        ArrayList<Integer> positions = new ArrayList<Integer>();

        for (String s : instructions) {
            char direction = s.charAt(0); // 'R' or 'L'
            int value = Integer.parseInt(s.substring(1));

            // 0.....99
            if (value >= 100) {
                while (value >= 100) {
                    value -= 100;
                    countDialIsAtZero += 1;
                }
            }

            if (direction == 'R') {
                if (position + value > 99) {
                    position = (position + value) - 100;
                    if (position != 0) {
                        countDialIsAtZero += 1;
                    }
                } else {
                    position += value;
                }
            } else if (direction == 'L') {
                if (position - value < 0) {
                    if (position != 0) {
                        countDialIsAtZero += 1;
                    }
                    int difference = position - value;
                    position = 100 - Math.abs(difference);
                } else {
                    position -= value;
                }
            }

            if (position == 0) {
                countDialIsAtZero += 1;
            }
            positions.add(position);
        }
        return countDialIsAtZero;
    }

    String[] loadInstructions() throws IOException {
        String[] instructions = Files
                .readAllLines(Paths.get("direction.txt"))
                .toArray(new String[0]);

        return instructions;

    }

    int ammountOfTimePositionIsZero(ArrayList<Integer> positions) {
        int count = 0;
        for (Integer integer : positions) {
            if (integer == 0) {
                count++;
            }
        }

        return count;
    }
}