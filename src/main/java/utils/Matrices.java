package utils;

import model.Matrix;

import java.util.Random;


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

    public static Matrix createOrderedMatrix(int size) {
        Matrix matrix = new Matrix(size);
        int currentNum = 1;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                matrix.setCell(i,j, currentNum++);
            }
        }
        return matrix;
    }

    public static Matrix createRandomMatrix(int size, int bound) {
        Matrix matrix = new Matrix(size);
        Random rnd = new Random();
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                matrix.setCell(i,j, rnd.nextInt(bound));
            }
        }
        return matrix;
    }
}
