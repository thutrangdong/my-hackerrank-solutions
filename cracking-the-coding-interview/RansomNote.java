// https://www.hackerrank.com/challenges/ctci-ransom-note

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }

        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }

        HashMap<String, Integer> magazineMap = createOccurrences(magazine);
        HashMap<String, Integer> ransomMap = createOccurrences(ransom);

        boolean isPossible = compareWords(magazineMap, ransomMap);

        if (isPossible){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static HashMap<String, Integer> createOccurrences(String a[]){
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int i = 0; i < a.length; i++){
            String e = a[i];
            Integer value = map.get(e);
            if(value != null){
                map.put(e, new Integer(value+1));
            } else {
                map.put(e, 1);
            }
        }
        return map;
    }

    public static boolean compareWords(HashMap<String, Integer> m, HashMap<String, Integer> r){
        for(Map.Entry<String, Integer> entry : r.entrySet()){
            String k = entry.getKey();
            Integer v = entry.getValue();
            if(m.get(k)==null || v > m.get(k)){
                return false;
            }
        }
        return true;
    }
}