package utils;

import model.Matrix;


public abstract class Matrices {

    public static Matrix rotateMatrixRight(Matrix matrix) {
        final int dimSize = matrix.getDimensionSize();
        Matrix ret = new Matrix(matrix.getDimensionSize());
        for (int r = 0; r < dimSize; r++) {
            for (int c = 0; c < dimSize; c++) {
                ret.setCell(c,dimSize-1-r, matrix.getCell(r,c));
            }
        }
        return ret;
    }
}
