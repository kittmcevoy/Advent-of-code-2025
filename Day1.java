import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.IOException;

class Day1 {

    int[] arr = new int[99];

    private void defineArray() {
        for (int i = 0; i < 99; i++) {
            arr[i] = i + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        Day1 d = new Day1();
        d.defineArray();
        String[] instuctions = d.loadInstructions();
        ArrayList<Integer> positions = d.solvePromlem(instuctions);
        int position = d.ammountOfTimePositionIsZero(positions);
        System.out.println(position);
    }

    ArrayList<Integer> solvePromlem(String[] instructions) {
        int position = 50;
        ArrayList<Integer> positions = new ArrayList<Integer>();

        for (String s : instructions) {
            char direction = s.charAt(0); // 'R' or 'L'
            int value = Integer.parseInt(s.substring(1));

            // 0.....99
            if (value >= 100) {
                while (value >= 100) {
                    value -= 100;
                }
            }

            if (direction == 'R') {
                if (position + value > 99) {
                    position = (position + value) - 100;
                } else {
                    position += value;
                }
            } else if (direction == 'L') {
                if (position - value < 0) {
                    int difference = position - value;
                    position = 100 - Math.abs(difference);
                } else {
                    position -= value;
                }
            }
            positions.add(position);
        }
        return positions;
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