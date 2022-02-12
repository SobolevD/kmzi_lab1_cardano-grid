import model.Matrix;
import utils.CardanoHelper;
import utils.Matrices;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = Matrices.createMatrixFromElements
                (
                        0,1,0,1,0,0,1,0,
                        0,0,0,0,1,0,0,0,
                        1,0,1,0,0,0,1,0,
                        0,0,0,1,0,0,0,0,
                        0,1,0,0,0,1,0,0,
                        1,0,0,0,1,0,0,0,
                        0,0,1,0,0,0,1,0,
                        0,0,0,1,0,0,0,1
                );
        String message = String.format("Matrix is Cardano grid: %s", CardanoHelper.isCardanoGrid(matrix));
        System.out.println(message);
    }
}
