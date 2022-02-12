import model.Matrix;
import utils.CardanoHelper;

public class Main {
    public static void main(String[] args) {
        Matrix grid = CardanoHelper.createGrid(50);
        System.out.println(grid);
        System.out.println(CardanoHelper.isCardanoGrid(grid));
    }
}
