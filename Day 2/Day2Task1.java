import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.math.BigInteger;

public class Day2Task1 {
    public static void main(String[] args) throws IOException {
        Day2Task1 d = new Day2Task1();
        String[] instuctions = d.loadInstructions();
        BigInteger answer = d.solvePromlem(instuctions);
        System.out.println(answer);
    }

    BigInteger solvePromlem(String[] instructions) {
        String[] SplitByComma = null;
        String[] SplitByDash = null;
        BigInteger count = BigInteger.ZERO;
        for (String string : instructions) {
            SplitByComma = string.split(",");
        }

        if (SplitByComma != null) {
            for (String string : SplitByComma) {
                SplitByDash = string.split("-");

                BigInteger start = new BigInteger(SplitByDash[0]);
                BigInteger end = new BigInteger(SplitByDash[1]);

                for (BigInteger i = start; i.compareTo(end) <= 0; i = i.add(BigInteger.ONE)) {

                    String s = i.toString();

                    if (s.length() < 2 || s.length() % 2 != 0) {

                    } else {
                        int mid = s.length() / 2;

                        BigInteger firstHalf = new BigInteger(s.substring(0, mid));
                        BigInteger secondHalf = new BigInteger(s.substring(mid));

                        if (firstHalf.equals(secondHalf)) {
                            count = count.add(i);
                        }

                    }

                }
            }
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
