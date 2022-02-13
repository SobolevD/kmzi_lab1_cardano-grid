package model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@EqualsAndHashCode
public class Matrix {
    private List<List<Integer>> instance;

    public Matrix(int size) {
        this.instance = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            List<Integer> newRow = new ArrayList<>(Collections.nCopies(size, 0));
            this.instance.add(newRow);
        }
    }

    public int getDimensionSize() {
        return instance.size();
    }

    public int getCell(int row, int column) {
        return instance.get(row).get(column);
    }

    public void setCell(int row, int column, int el) {
        instance.get(row).set(column, el);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (List<Integer> row : instance) {
            for (Integer cell : row) {
                builder.append(cell);
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    public String toBeautyString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getDimensionSize(); ++i) {
            for (int j = 0; j < getDimensionSize(); j++) {
                int value = getCell(i,j);
                if (value == 1)
                    builder.append("[ ]");
                else{
                    builder.append("[X]");
                }
            }
            builder.append('\n');
        }
        return builder.toString();
    }

}
