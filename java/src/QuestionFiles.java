import java.io.*;
import java.util.Scanner;

public class QuestionFiles{

        private String fileName;




        // The name of the file to open.

        // This will reference one line at a time

        public void getFile()
        {
            try {
                Scanner scanner = new Scanner(new File(fileName));
                while (scanner.hasNextLine()) {
                    //System.out.println(scanner.nextLine());
                   // System.out.println()
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void switchPath(String path)
        {
            fileName = path;
        }

        
    }

