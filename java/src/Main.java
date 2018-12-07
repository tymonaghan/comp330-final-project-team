import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private int difficulty;
    public static void main(String[] args) {

        host myHost = new host();
        myHost.displayIntro();
        Scanner scanner = new Scanner(System.in);
        int ans = scanner.nextInt();
        myHost.setDifficulty(ans);
        QuestionFiles qf = new QuestionFiles("/Users/ivankavanagh/Desktop/" + myHost.getDifficulty());
        qf.ReadFromFile();




    }

}


