package utils;

import model.Matrix;

import java.util.ArrayList;
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

    private static List<IntPair> getRestrictedCells(int matrixDimSize, IntPair cell) {

        IntPair cellR90 = new IntPair(cell.getRightValue(), matrixDimSize-1- cell.getLeftValue());
        IntPair cellR180 = new IntPair(cellR90.getRightValue(), matrixDimSize-1- cellR90.getLeftValue());
        IntPair cellR270 = new IntPair(cellR180.getRightValue(), matrixDimSize-1- cellR180.getLeftValue());

        return Arrays.asList(cellR90, cellR180, cellR270);
    }

    private static List<IntPair> getRestrictedCellsForRotate(int matrixDimSize, IntPair cell, int rotateAngle) {

        IntPair cellR90 = new IntPair(cell.getRightValue(), matrixDimSize-1- cell.getLeftValue());
        IntPair cellR180 = new IntPair(cellR90.getRightValue(), matrixDimSize-1- cellR90.getLeftValue());
        IntPair cellR270 = new IntPair(cellR180.getRightValue(), matrixDimSize-1- cellR180.getLeftValue());

        return switch (rotateAngle) {
            case 0 -> Arrays.asList(cellR90, cellR180, cellR270);
            case 90 -> Arrays.asList(cell, cellR180, cellR270);
            case 180 -> Arrays.asList(cellR90, cell, cellR270);
            case 270 -> Arrays.asList(cellR90, cellR180, cell);
            default -> throw new RuntimeException("Unknown rotate angle. Must be 0, 90, 180 or 270");
        };
    }

    private static IntPair rotateCords(IntPair cell, int dimSize, int rotateAngle) {

        if (rotateAngle == 0)
            return cell;

        IntPair cellR90 = new IntPair(cell.getRightValue(), dimSize-1- cell.getLeftValue());
        if (rotateAngle == 90)
            return cellR90;

        IntPair cellR180 = new IntPair(cellR90.getRightValue(), dimSize-1- cellR90.getLeftValue());
        if (rotateAngle == 180)
            return cellR180;

        IntPair cellR270 = new IntPair(cellR180.getRightValue(), dimSize-1- cellR180.getLeftValue());
        if (rotateAngle == 270)
            return cellR180;

        throw new RuntimeException("Bad rotate angle");
    }


    public static Matrix createGrid(int matrixDimSize) {
        List<IntPair> allCoordinates = new ArrayList<>();
        List<IntPair> correctCordsList = new ArrayList<>();
        for (int i = 0; i < matrixDimSize; i++) {
            for (int j = 0; j < matrixDimSize; j++) {
                allCoordinates.add(new IntPair(i,j));
            }
        }

        boolean hasRestrictedElements = true;
        int rotateAngle = 0;

        while (hasRestrictedElements) {


            hasRestrictedElements = false;
            List<IntPair> restrictedCells = null;

            IntPair correctCords = null;

            for (IntPair curCords : allCoordinates) {
                curCords = rotateCords(curCords, matrixDimSize, rotateAngle);
                restrictedCells = getRestrictedCells(matrixDimSize, curCords);

                for (IntPair curRestrictedCell : restrictedCells) {
                    if (allCoordinates.contains(curRestrictedCell)) {
                        rotateAngle = (rotateAngle + 90)%360;
                        hasRestrictedElements = true;
                        break;
                    }
                }

                if (hasRestrictedElements) {
                    correctCordsList.add(curCords);
                    correctCords = curCords;
                    break;
                }
            }

            if (!Objects.isNull(restrictedCells)) {
                allCoordinates.removeAll(restrictedCells);
                allCoordinates.remove(correctCords);
            }
        }
        Matrix result = Matrices.createZeroMatrix(matrixDimSize);
        for (IntPair correctCords : correctCordsList) {
            result.setCell(correctCords.getLeftValue(), correctCords.getRightValue(), 1);
        }
        return result;
    }
}
