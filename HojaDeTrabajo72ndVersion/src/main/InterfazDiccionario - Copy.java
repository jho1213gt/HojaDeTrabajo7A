/*
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Ing. DOuglas Barrios
* Miembros:
* - Max de Leon 13012
* - Javier Bucaro 13033
* - Kuk Ho Chung 13279
*/

package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class InterfazDiccionario {
// Atributos definidos para la interfaz gráfica del diccionario
	private JFrame ventana;
	private JPanel panel;
	private JLabel lMensaje, lTraduccion, lBienvenida;
	private JButton bTraducir, bNuevo;
	private JTextField xPalabra; 
	private JTextArea tTraduccion;
	private BinaryTree<Association<String,String>> valor;
	private ArrayList<String> palabra = new ArrayList<String>();
// Se inicializan variables utilizadas para los archivos de texto
	private File archivo = null;
	private FileReader lectura = null;
	private BufferedReader buffer = null;
// Se crea la nueva interfaz gráfica 
	public InterfazDiccionario(){
/*
 * Métodos a utilizar para llenar el diccionario y también para traducir la
 * oracion que se ingrese en el JTextField
 */
		llenado();
		valor = new BinaryTree<Association<String,String>>(null, null, null, null);
		ventana = new JFrame();
		panel = new JPanel();
		ventana.setPreferredSize(new Dimension(400, 300));
		ventana.setTitle("DICCIONARIO");
		panel.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
// Label's utilizadas en la interfaz
		lMensaje = new JLabel("Ingrese abajo lo que desee traducir: ");
		lMensaje.setBounds(5, 35, 250, 25);
		lTraduccion = new JLabel("El texto traducido es el siguiente:");
		lTraduccion.setBounds(5, 90, 200, 25);
		lBienvenida = new JLabel("Bienvenido al traductor");
		lBienvenida.setBounds(50, 5, 200, 25);
// TextField de la interfaz 
		xPalabra = new JTextField(50);
		xPalabra.setBounds(5, 60, 200, 25);
// Boton para traducir y para ingresar una nueva palabra
		bTraducir = new JButton("TRADUCIR");
		bTraducir.setEnabled(true);
		bTraducir.addActionListener(new ButtonListener());;
		bTraducir.setBounds(210, 60, 100, 25);
		bNuevo = new JButton("NUEVA PALABRA");
		bNuevo.setEnabled(false);
		bNuevo.addActionListener(new ButtonListener());
		bNuevo.setBounds(210, 120, 150, 25);
// Area de texto donde se presetara el texto traducido
		tTraduccion = new JTextArea(10, 5);
		tTraduccion.setBounds(5, 120, 200, 70);
		tTraduccion.setEditable(false);
		tTraduccion.setVisible(true);
		tTraduccion.setLineWrap(true);
		tTraduccion.setWrapStyleWord(true);
// Se agrega todo al panel
		panel.add(lMensaje);
		panel.add(lTraduccion);
		panel.add(lBienvenida);
		panel.add(xPalabra);
		panel.add(bTraducir);
		panel.add(bNuevo);
		panel.add(tTraduccion);
		ventana.setContentPane(panel);
		mostrar();
	}
// Definimos esto para hacer visible la interfaz gráfica	
	public void mostrar(){
// Definimos el JFrame de forma visible para mostrar la interfaz gráfica
		ventana.pack();
		ventana.setVisible(true);
	}
// Método para limpiar los TextField's y poder guardar nuevos datos	
	public void refresh(){
		xPalabra.setText("");
		tTraduccion.setText("");
	}
/*
 * Metodo que implementa el BinaryTree para llenar el diccionario leyendo
 * todo lo que se encuentre en el archivo de texto
 */
	public void llenado(){
		JOptionPane.showMessageDialog(null,"Entrando a llenado");
		ArrayList<String> palabras = new ArrayList<String>();
		ArrayList<Association<String,String>> asociacion = new ArrayList<Association<String,String>>();
		try{
			File archivo = new File("diccionario.txt");
			FileReader lectura = new FileReader(archivo);
			BufferedReader buffer = new BufferedReader(lectura);
			String linea;
			JOptionPane.showMessageDialog(null,"Creando todo lo de archivo de texto");
			while((linea = buffer.readLine())!=null){
				palabras.add(linea);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(null!=lectura){
					lectura.close();
				}
			}catch(Exception e2){
			e2.printStackTrace();
			}
		}
		for(int i=0; i<palabras.size(); i++){
			JOptionPane.showMessageDialog(null,"Guardando las palabras del archivo");
			int posicion = palabras.get(i).indexOf(',');
			JOptionPane.showMessageDialog(null, posicion);
			String orig = palabras.get(i).substring(0,posicion);
			JOptionPane.showMessageDialog(null,orig);
			String trad = palabras.get(i).substring(posicion+1,palabras.get(i).length());
			JOptionPane.showMessageDialog(null,trad);
			asociacion.add(new Association(orig, trad));
			JOptionPane.showMessageDialog(null,"Se ha guardado exitosamente las palabras");
			JOptionPane.showMessageDialog(null,asociacion.get(i));
		}
// AQUI SE DEBE DE INSERTAR AL BINARY TREE CADA PALABRA Y SU TRADUCCION
		JOptionPane.showMessageDialog(null,"Cargando datos");
		valor.setValue(asociacion.get(0));
	}
// Método para insertar un nodo
	private void insertarNodo(BinaryTree<Association<String,String>> principal, Association<String,String> dato){
		Association<String,String> asociacion = principal.value();
		String llavePrincipal = asociacion.getKey();
		String llaveDato = dato.getKey();
		int num = llavePrincipal.compareToIgnoreCase(llaveDato);
		if(num>0 && principal.left()==principal){
			principal.setLeft(new BinaryTree<Association<String,String>>(dato));
		}else if(principal.left()!=principal){
			insertarNodo(principal.left(),dato);
		}
		if(num<0 && principal.right() == principal){
			principal.setLeft(new BinaryTree<Association<String,String>>(dato));
		}else if(principal.right()!=principal){
			insertarNodo(principal.right(),dato);
		}
	}
/*
 * Método para traducir cada palabra al español, este método es utilizado
 * por el método "traduccion"
 */
	private String tradPal(BinaryTree<Association<String,String>> principal, String palabra){
		JOptionPane.showMessageDialog(null, "Dentro de TradPal");
		String traducida = "";
		Association<String,String> asociacion = principal.value();
		String llavePrincipal = asociacion.getKey();
		int cont = llavePrincipal.compareToIgnoreCase(palabra);
		if(cont==0){
			traducida = principal.value().getValue();
		}
		if(cont<0){
			if(principal.right()!=principal){
				traducida = tradPal(principal.right(),palabra);
			}else{
				return("*"+palabra+"*");
			}
		}
		if(cont>0){
			if(principal.left()!=principal){
				traducida = tradPal(principal.left(),palabra);
			}else{
				return("*"+palabra+"*");
			}
		}
		return traducida;
	}
/* 
 * Método utilizado para leer lo que el usuario ingrese en el JTextField 
 * de la interfaz gráfica
 */
	private void lectura(){
		String palabras = xPalabra.getText();
		while(palabras.compareTo("")!=0){
			int lugar = palabras.indexOf(' ');
			if(lugar!=-1){
				palabra.add(palabras.substring(0,lugar));
				palabras = palabras.substring(lugar+1);
			}else{
				palabra.add(palabras);
				palabras="";
			}
		}
	}
/* 
 * Método para traducir toda la oracion que ingrese el usuario
 */
	public void traduccion(){
		JOptionPane.showMessageDialog(null, "Método traducción");
		lectura();
		JOptionPane.showMessageDialog(null, "LECTURA BIEN");
		String resultado = "";
		for(int i=0; i<palabra.size();i++){
			JOptionPane.showMessageDialog(null, "Entrando a TradPal");
			resultado+=tradPal(valor,palabra.get(i).trim())+" ";
			JOptionPane.showMessageDialog(null, resultado);
		}
		tTraduccion.append(resultado);
		
	}
/*
 * Clase definida para la implementación y definición de la acción de cada botón	
 */
	private class ButtonListener implements ActionListener{
// Se define como "mouse" la acción de nuestro botón
		public void actionPerformed(ActionEvent mouse){
// Se traduce la palabra u oracion deseada
			if(mouse.getSource() == bTraducir){
				JOptionPane.showMessageDialog(null,"Traduciendo");
				tTraduccion.append(xPalabra.getText());
				bNuevo.setEnabled(true);
				traduccion();
			}
// Se limpia el JTextField para ingresar una nueva palabra u oracion
			if(mouse.getSource() == bNuevo){
				JOptionPane.showMessageDialog(null,"Nueva palabra");
				refresh();
				bNuevo.setEnabled(false);
			}
		}
	}
}
		
