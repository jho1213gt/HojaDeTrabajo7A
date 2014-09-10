

package main;
import java.io.*;
/**
 *
 * @author GNXN000000
 */
public class main {	
    public static void main(String[] args) {
        InterfazDiccionario programa = new InterfazDiccionario();
        ///////////////////////////////////////////////////////////
        File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try{
			archivo = new File("Aqui se pondria el nombre del archivo y la locaclizacion"); /*Esto se modificaria*/
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			while((linea=br.readLine())!=null)
				System.out.println(linea);
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(null!=fr){
					fr.close();
				}
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}	
	}
}
