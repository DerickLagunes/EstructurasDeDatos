
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FilesReader {

    public static ArrayList<String> 
        getLines(String ruta){

            ArrayList<String> content = new ArrayList<>();

            try(BufferedReader br = new 
            BufferedReader(new FileReader(
                    ruta)
                )
            ){
                String line;
                //Leer cada linea del archivo
                while((line = br.readLine()) != null){
                    content.add(line);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            return content;
    } 

    public static void main(String[] args) {
        ArrayList<String> contenido = getLines("hola.txt");
        for (String s : contenido) {
            System.out.println(s);
        }
    }
    
}
