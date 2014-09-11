
/*
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Ing. DOuglas Barrios
* Miembros:
* - Max de Leon 13012
* - Javier Bucaro 13033
* - Kuk Ho Chung 13279
*/

import java.io.*;


public class main {	
    public static void main(String[] args) {
        InterfazDiccionario programa = new InterfazDiccionario();
		
		/*
		* Para leida de los textos de un texto
		*/
        File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try{
			archivo = new File("Texto.txt"); /*Esto se modificaria*/
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
