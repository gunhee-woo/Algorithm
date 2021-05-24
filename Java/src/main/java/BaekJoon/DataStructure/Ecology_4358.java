package BaekJoon.DataStructure;

import java.io.FileInputStream;
import java.util.*;

import static Util.Constants.INPUT;

public class Ecology_4358 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        Scanner sc = new Scanner(System.in);
        SortedMap<String, Double> sortedMap = new TreeMap<>();
        int total = 0;
        while(sc.hasNext()) {
            String str = sc.nextLine();
            if(sortedMap.containsKey(str)) {
                sortedMap.put(str, sortedMap.get(str) + 1);
            } else {
                sortedMap.put(str, 1.0);
            }
            total++;
        }
        for(String key : sortedMap.keySet()) {
            System.out.println(key + " " + String.format("%.4f", sortedMap.get(key) / total * 100));
        }
    }
}
