package utils;

import model.Matrix;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CardanoHelper {

    public static boolean isCardanoGrid(Matrix matrix) {
        Matrix matrixR90 = Matrices.rotateMatrixRight(matrix);
        Matrix matrixR180 = Matrices.rotateMatrixRight(matrixR90);
        Matrix matrixR270 = Matrices.rotateMatrixRight(matrixR180);

        List<Matrix> matrices = Arrays.asList(matrix, matrixR90, matrixR180, matrixR270);
        return !isMatricesIntersects(matrices);
    }

    private static boolean isMatricesIntersects(Matrix matrix1, Matrix matrix2) {

        if (!Objects.equals(matrix1.getDimensionSize(), matrix2.getDimensionSize())){
            throw new RuntimeException("Matrices has different dimension size");
        }

        int dimSize = matrix1.getDimensionSize();

        for (int i = 0; i < dimSize; ++i) {
            for (int j = 0; j < dimSize; ++j) {
                if (i == j)
                    continue;
                if (matrix1.getCell(i,j) == 1 && matrix2.getCell(i,j) == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isMatricesIntersects(List<Matrix> matrices) {
        for (int i = 0; i < matrices.size() - 1; ++i) {
            for (int j = i+1; j < matrices.size(); j++) {
                if (isMatricesIntersects(matrices.get(i), matrices.get(j))){
                    return true;
                }
            }
        }
        return false;
    }
}
