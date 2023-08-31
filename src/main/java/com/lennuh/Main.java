package com.lennuh;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Base64;

public class Main {
    
    static ArrayList<Integer> readData() {
        ArrayList<Integer> data = new ArrayList<Integer>();
        try {
            FileInputStream read_file = new FileInputStream("D:/Code/Per/Java/vimTest/vim/src/main/java/com/lennuh/assets/MegaFrog.jpg");
            boolean eof = false;
            while(!eof) {
                int byteValue = read_file.read();
                //System.out.print(byteValue + " ");
                data.add(byteValue);
                if (byteValue == -1) eof = true;
            }
            read_file.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        return data;
    }

    static void writeData(ArrayList<Integer> data) {
        try {
            FileOutputStream write_file = new FileOutputStream("D:/Code/Per/Java/vimTest/vim/src/main/java/com/lennuh/assets/MegaFrog_Copy.jpg");
            for (int i = 0; i < data.size(); i++) {
                write_file.write(data.get(i));
            }
            write_file.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    static String readTextFile() {
        /* 
        -> Perfect for small text files
        try {
            FileReader read_file = new FileReader("D:/Code/Per/Java/vimTest/vim/src/main/java/com/lennuh/assets/data.txt");
            int d = 0;
            while (d != -1) {
                d = read_file.read();
                System.out.print((char)d);
            }
            read_file.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } 
        */ 
        String file = "";
        try {
            FileReader read_file = new FileReader("D:/Code/Per/Java/vimTest/vim/src/main/java/com/lennuh/assets/data3.txt");
            BufferedReader buffered_file = new BufferedReader(read_file);
            String data = "";
            while (data != null) {
                data = buffered_file.readLine();
                if (data != null) file = file + data + "\n";//System.out.println(data);
            }
            buffered_file.close();
            read_file.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        System.out.println(file);   
        return file;
    }

    static void writeTextFile(String text) {
        try {
            FileWriter write_file = new FileWriter("D:/Code/Per/Java/vimTest/vim/src/main/java/com/lennuh/assets/data2.txt");
            write_file.write(text);
            write_file.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    static void encodeFileBase64() {
        try {
            FileInputStream read_file = new FileInputStream("D:/Code/Per/Java/vimTest/vim/src/main/java/com/lennuh/assets/MegaFrog.jpg");
            byte[] data = read_file.readAllBytes();
            String encoder = Base64.getEncoder().encodeToString(data);
            System.out.println(encoder);
            read_file.close();
            writeTextFile(encoder);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    static void decodeFileBase64() {
        try {
            FileInputStream read_file = new FileInputStream("D:/Code/Per/Java/vimTest/vim/src/main/java/com/lennuh/assets/data2.txt");
            byte[] data = Base64.getDecoder().decode(new String(read_file.readAllBytes()));
            FileOutputStream write_file = new FileOutputStream("D:/Code/Per/Java/vimTest/vim/src/main/java/com/lennuh/assets/MegaFrog_Copy.jpg");
            write_file.write(data);
            write_file.close();
            read_file.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void main(String[] args) {
        //ArrayList<Integer> bytes = readData();
        //writeData(bytes);
        //encodeFileBase64();
        //readTextFile();
        //writeTextFile("Today is a good day");
        //decodeFileBase64();
    }
}