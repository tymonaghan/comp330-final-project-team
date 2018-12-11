import java.io.*;

public class QuestionFiles {

    private String fileURL;
    private String line = null;


            QuestionFiles(String fileUrl)
            {
                this.fileURL = fileUrl;
            }




            public void ReadFromFile()
            {

                try {
                    // FileReader reads text files in the default encoding.
                    FileReader fileReader =
                            new FileReader(fileURL);

                    // Always wrap FileReader in BufferedReader.
                    BufferedReader bufferedReader =
                            new BufferedReader(fileReader);

                    while((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }

                    // Always close files.
                    bufferedReader.close();
                }
                catch(FileNotFoundException ex) {
                    System.out.println(
                            "Unable to open file '" +
                                    fileURL + "'");
                }
                catch(IOException ex) {
                    System.out.println(
                            "Error reading file '"
                                    + fileURL + "'");
                    // Or we could just do this:
                    // ex.printStackTrace();
                }
            }
}














