package Lab6;

import java.io.*;

public class ReadClass {
    private static String gw = "аоиеёэыуюя";

    public static boolean checkWord(String word) {
        char[] gl = gw.toCharArray();
        char firstChar = word.charAt(0);

        for (int i = 0; i < gl.length; i++) {
            if (gl[i] == firstChar) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        InputStream in = null;
        Reader file = null;
        BufferedReader buf = null;

        OutputStream out = null;
        Writer wr = null;

        try {
            in = new FileInputStream("C:\\Java\\in.txt");
            file = new InputStreamReader(in, "cp1251");
            buf = new BufferedReader(file);
            String line = " ";
            String[] words;

            File f1 = new File("C:\\Java\\out.txt");
            if (f1.exists()) {
                out = new FileOutputStream(f1);
                wr = new OutputStreamWriter(out, "Unicode");

                while ((line = buf.readLine()) != null) {
                    words = line.split(" ");
                    int length = words[0].length();
                    for (int i = 1; i < (words.length-1); i++) {
                       if(words[i].length()>length){

                       }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error IO");
        } finally {
            buf.close();
            file.close();
            in.close();
            wr.flush();
            wr.close();

        }
    }
}
