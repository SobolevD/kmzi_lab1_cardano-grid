import model.Matrix;
import utils.Matrices;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = Matrices.createOrderedMatrix(8);
        Matrix rotated90 = Matrices.rotateMatrixRight(matrix);
        Matrix rotated180 = Matrices.rotateMatrixRight(rotated90);
        Matrix rotated270 = Matrices.rotateMatrixRight(rotated180);
        Matrix rotated360 = Matrices.rotateMatrixRight(rotated270);
        System.out.println(matrix);
        System.out.println(rotated90);
        System.out.println(rotated180);
        System.out.println(rotated270);
        System.out.println(rotated360);
    }
}
