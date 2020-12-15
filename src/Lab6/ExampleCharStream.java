package Lab6;

import java.io.*;

public class ExampleCharStream {
    public static void main(String[] args) throws IOException {
        InputStream in = null ;
        Reader file = null;
        BufferedReader buf =null;

        try{
            in = new FileInputStream("C:\\Java\\text.txt");
            file = new InputStreamReader(in, "cp1251");
            buf = new BufferedReader(file);
            String line="";
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException ie){
            System.out.println("Error " + ie);
        }
        finally {
            in.close();
            file.close();
            buf.close();
        }
    }
}
