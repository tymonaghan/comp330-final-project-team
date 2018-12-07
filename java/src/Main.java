import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args){
        try{
            File file = new File("/Users/ivankavanagh/Desktop/questions.txt");
            System.out.println(file.getCanonicalPath());
            FileInputStream ft = new FileInputStream(file);

            DataInputStream in = new DataInputStream(ft);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strline;

            while((strline = br.readLine()) != null){
                System.out.println(strline);
            }
            in.close();
        }catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}


