import java.nio.file.Path;
import java.nio.file.Paths;
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

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);

        int ans = scanner.nextInt();
        myHost.setDifficulty(ans);
        QuestionFiles qf = new QuestionFiles("java/src/content/questions/" + myHost.getDifficulty());
        // reads out the file - good for testing but not for release:
        qf.ReadFromFile();




    }

}


