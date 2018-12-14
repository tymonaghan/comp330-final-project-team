import java.io.*;

public class QuestionFiles {

    private String fileURL;
    private String line = null;

            QuestionFiles(String fileUrl)
            {
                this.fileURL = fileUrl;
            }

            public String ReadFromFile(int lineNo) {
                String lineString = null;
                try {
                    // FileReader reads text files in the default encoding.
                    FileReader fileReader =
                            new FileReader(fileURL);

                    // Always wrap FileReader in BufferedReader.
                    BufferedReader bufferedReader =
                            new BufferedReader(fileReader);

                    for (int i = 0; i < lineNo; ++i) {
                        bufferedReader.readLine();
                    }
                    lineString = bufferedReader.readLine();

                    // Always close files.
                    bufferedReader.close();
                } catch (FileNotFoundException ex) {
                    System.out.println(
                            "Unable to open file '" +
                                    fileURL + "'");
                } catch (IOException ex) {
                    System.out.println(
                            "Error reading file '"
                                    + fileURL + "'");
                    // Or we could just do this:
                    // tm: why not both?
                    // ex.printStackTrace();
                }
                //added return so I can get strings and manipulate them outside QuestionFiles class
                return lineString;
            }
}