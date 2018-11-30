import java.io.*;

public class QuestionFiles{

        private String fileName;

        QuestionFiles(String fileName)
        {
            this.fileName = fileName;
        }



        // The name of the file to open.

        // This will reference one line at a time

        public void getFile()
        {
                String line = null;

                try {
                    // FileReader reads text files in the default encoding.
                    FileReader fileReader =
                            new FileReader(fileName);

                    // Wrap FileReader in BufferedReader.
                    BufferedReader bufferedReader =
                            new BufferedReader(fileReader);

                    while((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }

                    // Close file.
                    bufferedReader.close();
                }
                catch(FileNotFoundException ex) {
                    System.out.println(
                            "Unable to open file '" + fileName + "'");
                }
                catch(IOException ex) {
                    System.out.println(
                            "Error reading file '" + fileName + "'");
                }
        }

        public void switchPath(String path)
        {
            fileName = path;
        }

        
    }

