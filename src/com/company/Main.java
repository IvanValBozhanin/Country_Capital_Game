package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        getCap();
        int result = 0;

        Object[] list = map.keySet().toArray();
        Scanner in = new Scanner(System.in);
        while(true){
            String k = (String) list[(int) (Math.random()*(list.length))];
            System.out.print(k + " enter capital: ");
            String c = in.next();
            if(c.equals(map.get(k))){
                ++result;
                System.out.println("Correct");
            }
            else{
                System.out.println("Incorrect, the answer was: " + map.get(k));
            }
            System.out.println(result);
        }
    }

    public static void getCap() throws FileNotFoundException {
        File file = new File("src/com/company/cap.txt");
        if(file.exists()){
            Scanner in = new Scanner(file);
            while(in.hasNext()){
                String s = in.nextLine();
                map.put(s.substring(0, s.indexOf("—") - 1), s.substring(s.indexOf("—") + 2));
            }
        }
        else{
            System.out.println("FILE DOES NOT EXIST!");
        }
    }
}
