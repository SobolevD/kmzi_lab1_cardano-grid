package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class MathHelper {

    private static final int MAX_NUM = 1000;

    private static List<Integer> numSquares;

    public static boolean isNumSquare(int num) {
        if (Objects.isNull(numSquares)) {
            init();
        }

        for (Integer curSquare : numSquares) {
            if (Objects.equals(num, curSquare)) {
                return true;
            }
        }
        return false;
    }

    private static void init() {
        numSquares = new ArrayList<>();
        for (int i = 0; i < MAX_NUM; ++i) {
            numSquares.add((int)Math.pow(i, 2));
        }
    }
}
