package org.kml.matrix;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TransposeDiffSize {
    public static void main(String[] args) {
        List<List<Integer>> mat = new ArrayList<>();
        mat.add(Arrays.asList(1, 2, 3, 4));
        mat.add(Arrays.asList(5, 6, 7, 8));
        mat.add(Arrays.asList(9, 10, 11, 12));
        mat.add(Arrays.asList(13, 14, 15, 16));

        print(mat);
        transpose(mat);
        print(mat);

        List<List<Integer>> mat1 = new ArrayList<>();
        //mat1.add(Arrays.asList(1, 2, 3, 4));
        mat1.add(new ArrayList<>());
        mat1.get(0).add(1);
        mat1.get(0).add(2);
        mat1.get(0).add(3);
        mat1.get(0).add(4);
        //mat1.add(Arrays.asList(5, 6, 7, 8));
        mat1.add(new ArrayList<>());
        mat1.get(1).add(5);
        mat1.get(1).add(6);
        mat1.get(1).add(7);
        mat1.get(1).add(8);


        print(mat1);
        transpose(mat1);
        print(mat1);

        List<List<Integer>> mat2 = new ArrayList<>();
        //mat1.add(Arrays.asList(1, 2));
        mat2.add(new ArrayList<>());
        mat2.get(0).add(1);
        mat2.get(0).add(2);
        //mat1.add(Arrays.asList(3, 4));
        mat2.add(new ArrayList<>());
        mat2.get(1).add(3);
        mat2.get(1).add(4);
        //mat1.add(Arrays.asList(5, 6));
        mat2.add(new ArrayList<>());
        mat2.get(2).add(5);
        mat2.get(2).add(6);
        //mat1.add(Arrays.asList(7, 8));
        mat2.add(new ArrayList<>());
        mat2.get(3).add(7);
        mat2.get(3).add(8);


        print(mat2);
        transpose(mat2);
        print(mat2);
    }

    private static void transpose(List<List<Integer>> mat)
    {
        int origRows = mat.size();
        int origCols = mat.get(0).size();
        int rows = Math.min(origRows, origCols);
        int cols = rows;
        for (int row = 0; row < rows; row++)
        {
            for (int col = row + 1; col < cols; col++)
            {
                int tmp = mat.get(row).get(col);
                mat.get(row).set(col, mat.get(col).get(row));
                mat.get(col).set(row, tmp);
            }
        }

        if(origRows != origCols)
        {
            int diagMatSize = Math.min(origRows, origCols);
            if (origCols > origRows)
            {
                for (int rows1 = 0; rows1 < origRows; rows1++)
                {
                    for (int col1 = diagMatSize; col1 < mat.get(rows1).size(); col1++)
                    {
                        int data = mat.get(rows1).get(diagMatSize);
                        if(mat.size() < mat.get(0).size())
                        {
                            mat.add(new ArrayList<>());
                        }
                        mat.get(col1).add(data);
                    }
                    for (int col1 = mat.get(rows1).size() - 1; col1 >= diagMatSize; col1--)
                    {
                        mat.get(rows1).remove(col1);
                    }
                }
            }
            else
            {
                for (int col1 = diagMatSize; col1 < origCols; col1++)
                {
                    for (int row1 = diagMatSize; row1 < origRows; row1++)
                    {
                        mat.get(row1).set(col1, mat.get(cols).get(row1));
                    }
                }
                for (int row1 = mat.size() - 1; row1 >= diagMatSize; row1--) {
                    mat.remove(row1);
                }
            }
        }
    }
    private static void print(List<List<Integer>> mat)
    {
        for (List<Integer> row: mat)
        {
            System.out.println(row);
        }
        System.out.println("-------------------------------");
    }
}
