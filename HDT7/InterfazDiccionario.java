package HojadeTrabajo_7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class InterfazDiccionario {
// Atributos definidos para la interfaz gr�fica del diccionario
	private JFrame ventana;
	private JPanel panel;
	private JLabel lMensaje, lTraduccion, lBienvenida;
	private JButton bTraducir, bNuevo;
	private JTextField xPalabra; 
	private JTextArea tTraduccion;
	private BinaryTree<Association<String,String>> valor;
	private ArrayList<String> palabra = new ArrayList<String>();
// Se inicializan variables utilizadas para los archivos de texto
	File archivo = null;
	FileReader lectura = null;
	BufferedReader buffer = null;
// Se crea la nueva interfaz gr�fica 
	public InterfazDiccionario(){
/*
 * M�todos a utilizar para llenar el diccionario y tambi�n para traducir la
 * oracion que se ingrese en el JTextField
 */
		valor = new BinaryTree<Association<String,String>>();
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
// Definimos esto para hacer visible la interfaz gr�fica	
	public void mostrar(){
// Definimos el JFrame de forma visible para mostrar la interfaz gr�fica
		ventana.pack();
		ventana.setVisible(true);
	}
// M�todo para limpiar los TextField's y poder guardar nuevos datos	
	public void refresh(){
		xPalabra.setText("");
		tTraduccion.setText("");
	}
/*
 * Metodo que implementa el BinaryTree para llenar el diccionario leyendo
 * todo lo que se encuentre en el archivo de texto
 */
	public void llenado(){
		ArrayList<String> palabras = new ArrayList<String>();
		ArrayList<Association<String,String>> asociacion = new ArrayList<Association<String,String>>();
		try{
			FileReader lectura = new FileReader("diccionario.txt");
			BufferedReader buffer = new BufferedReader(lectura);
			String linea;
			int cont = 0;
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
			}catch(Exception r){
			r.printStackTrace();
			}
		}
		for(int i=0; i<palabras.size()-1; i++){
			int posicion = palabras.get(i).indexOf(',');
			String orig = palabras.get(i).substring(0,posicion);
			String trad = palabras.get(i).substring(posicion,palabra.get(i).length()-1);
			asociacion.add(new Association(orig, trad));
		}
		valor.setValue(asociacion.get(0));
		for(int i=1; i<asociacion.size(); i++){
			insertarNodo(valor,asociacion.get(i));
		}
	}
// M�todo para insertar un nodo
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
 * M�todo para traducir cada palabra al espa�ol, este m�todo es utilizado
 * por el m�todo "traduccion"
 */
	private String tradPal(BinaryTree<Association<String,String>> principal, String palabra){
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
 * M�todo utilizado para leer lo que el usuario ingrese en el JTextField 
 * de la interfaz gr�fica
 */
	private void lectura(){
		String palabras = "";
		try{
			FileReader lectura = new FileReader("nuevo.txt");
			BufferedReader buffer = new BufferedReader(lectura);
			String linea;
			int cont=0;
			while((linea=buffer.readLine())!=null){
				palabras = linea;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(null!=lectura){
					lectura.close();
				}
			}catch(Exception r){
				r.printStackTrace();
			}
		}
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
 * M�todo para traducir toda la oracion que ingrese el usuario
 */
	public void traduccion(){
		lectura();
		String resultado = "";
		for(int i=0; i<palabra.size();i++){
			resultado+=tradPal(valor,palabra.get(i).trim())+" ";
		}
		tTraduccion.append(resultado);
		
	}
/*
 * Clase definida para la implementaci�n y definici�n de la acci�n de cada bot�n	
 */
	private class ButtonListener implements ActionListener{
// Se define como "mouse" la acci�n de nuestro bot�n
		public void actionPerformed(ActionEvent mouse){
// Se traduce la palabra u oracion deseada
			if(mouse.getSource() == bTraducir){
				JOptionPane.showMessageDialog(null,"Traduciendo");
				tTraduccion.append(xPalabra.getText());
				bNuevo.setEnabled(true);
				//llenado();
				//traduccion();
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
		
