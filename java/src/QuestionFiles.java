import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;


public class QuestionFiles {

    private String fileURL;
    private String line = null;


            QuestionFiles(String fileUrl)
            {
                this.fileURL = fileUrl;
            }

            public void ReadFromFile(int lineNo)
            {

                try {
                    // FileReader reads text files in the default encoding.
                    FileReader fileReader =
                            new FileReader(fileURL);

                    // Always wrap FileReader in BufferedReader.
                    BufferedReader bufferedReader =
                            new BufferedReader(fileReader);


                    for(int i = 0; i < lineNo; ++i) {
                        bufferedReader.readLine();
                    }
                    String lineString = bufferedReader.readLine();
                    System.out.println(lineString);
                    //String lineString;
                    //lineString = bufferedReader.readAllLines().get(lineNo);
                    //System.out.println(lineString);

                    //while((line = bufferedReader.readLine()) != null) {
                    //    System.out.println(line);
                    //}

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
                    // tm: why not both?
                    // ex.printStackTrace();
                }
            }
}














