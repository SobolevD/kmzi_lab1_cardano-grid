import model.Matrix;
import utils.CardanoHelper;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static final int GRID_SIZE = 8;
    private static final String RESULT_FILE_NAME = "cardano_grid.txt";
    private static final String BEAUTY_RESULT_FILE_NAME = "cardano_grid_beauty.txt";

    public static void main(String[] args) throws IOException {
        Matrix grid = CardanoHelper.createGrid(GRID_SIZE);

        // Debug
        System.out.println(grid);
        System.out.println(CardanoHelper.isCardanoGrid(grid));

        FileWriter writer = new FileWriter(RESULT_FILE_NAME, false);
        writer.write(grid.toString());
        writer.close();

        writer = new FileWriter(BEAUTY_RESULT_FILE_NAME, false);
        writer.write(grid.toBeautyString());
        writer.close();
    }
}
