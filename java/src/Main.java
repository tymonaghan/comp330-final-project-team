import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int choice;
        String selection;
        String[] questions = new String[10];
         String fileName = "../content/questions.txt";
         QuestionFiles qf = new QuestionFiles(fileName);
         qf.switchPath();




        
    }
    

}
