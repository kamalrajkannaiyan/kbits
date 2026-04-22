package org.kml.graph;

import java.util.Arrays;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] dict = {"baa","abcd","abca","cab","cad"};
        String order = findOrder(dict);
    }

    static String findOrder(String[] dict){
        String last = dict[0];
        char[][] edges = new char[dict.length - 1][2];
        for (int idx = 1; idx < dict.length; idx++){
            int pos = 0;
            String curr = dict[idx];
            while(pos < Math.min(last.length(), curr.length())){
                if(last.charAt(pos) != curr.charAt(pos)){
                    edges[idx - 1][0] = last.charAt(pos);
                    edges[idx - 1][1] = curr.charAt(pos);
                    last = curr;
                    break;
                }
                pos++;
            }
        }
        for (char[] edge: edges){
            System.out.println(Arrays.toString(edge));
        }
        return null;
    }
}
