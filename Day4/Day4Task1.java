import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day4Task1 {
    public static void main(String[] args) throws IOException {
        Day4Task1 d = new Day4Task1();
        String[] instuctions = d.loadInstructions();
        int answer = d.solvePromlem(instuctions);
        System.out.println(answer);
    }

    int solvePromlem(String[] grid) {
        int rows = grid.length;
        if (rows == 0)
            return 0;
        int cols = grid[0].length();

        char[][] matrix = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = grid[r].toCharArray();
        }

        int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

        int accessibleCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] != '@')
                    continue;

                int neighbors = 0;
                for (int k = 0; k < 8; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                        if (matrix[nr][nc] == '@')
                            neighbors++;
                    }
                }

                if (neighbors < 4) {
                    accessibleCount++;
                }
            }
        }

        return accessibleCount;
    }

    String[] loadInstructions() throws IOException {
        String[] instructions = Files
                .readAllLines(Paths.get("input.txt"))
                .toArray(new String[0]);

        return instructions;

    }
}
