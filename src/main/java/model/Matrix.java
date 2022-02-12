package model;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Builder
@Data
@EqualsAndHashCode
public class Matrix {
    private List<List<Integer>> instance;

    public Matrix(int size) {
        this.instance = new ArrayList<List<Integer>>();
        for (int i = 0; i < size; ++i) {
            List<Integer> newRow = new ArrayList<Integer>(Collections.nCopies(size, 0));
            this.instance.add(newRow);
        }
    }

    public Matrix(List<List<Integer>> instance) {
        this.instance = instance;
    }


    public int getElementsCount() {
        int result = 0;
        for (List<Integer> row : instance) {
            result += row.size();
        }
        result += instance.size();
        return result;
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

}
