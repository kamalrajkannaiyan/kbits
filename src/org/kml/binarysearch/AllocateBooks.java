package org.kml.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AllocateBooks {

    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n = arr.size(); // size of array
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if(arr.get(i) > pages)
            {
                return Integer.MAX_VALUE;
            }
            if (pagesStudent + arr.get(i) <= pages) {
                // add pages to current student
                pagesStudent += arr.get(i);
            } else {
                // add pages to next student
                students++;
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // book allocation impossible
        if (m > n)
            return -1;

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        low = 0;
int ans = -99999;
        for (int pages = low; pages <= high; pages++) {
            int ddd= countStudents(arr, pages);
            System.out.println(pages + " --- " + ddd);
            if ( ddd == m) {
                //return pages;
                System.out.println("--------------------------------required ans");
                ans = pages;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int n = 5;
        int m = 4;
        System.out.println(arr);
        int ans = findPages(arr, n, m);
        System.out.println("The answer is: " + ans);
    }
}


