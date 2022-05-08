package mpoop12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal.
 * @author Gómez Segovia David Israel y Montoya Colón David Fernando
 */
public class MPOOP12 {

    public static void main(String[] args) {
        
        
        //CREACIÒN DE ARCHIVOS
        System.out.println("\n----CREACIÓN DE ARCHIVOS----");
        File archivo = new File("archivo.txt");
        System.out.println(archivo.exists());//NO HAY NINGÚN ARCHIVO PUES TODAVÍA NO SE CREA
        try {
            //CREANDO EL ARCHIVO
            archivo.createNewFile();
            boolean seCreo = archivo.createNewFile();
            System.out.println("Se creó = "+seCreo);
            System.out.println(archivo.exists());
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //INGRESAR DATOS DESDE EL TECLADO
        System.out.println("\n----FILE WRITER-INGRESO DE DATOS DESDE EL TECLADO------");
        /*UN FLUJO DE CRACTERES DESDE EL TECLADO SE GUARDA EN UNA CADENA DE TEXTO
         * LUEGO SE DEBE ESCRIBIR EN EL BUFFER
         */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escriba el texto para el archivo.");
            String texto = br.readLine();//SE ESCRIBEN CARACTERES HASTA QUE HAY UN ENTER
            
            //CREAR UN BUFFER PARA ESCRIBIR EN UN ARCHIVO
            FileWriter fw = new FileWriter("fw.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            salida.println(texto);
            /*
            *LEER DE ABAJO HACIA ARRIBA EL FRAGMENTO DE CÓDIGO ANTERIOR
            */
            for (int i = 0; i < 10; i++) {
                salida.println("Linea del for "+i);
            }
            salida.close();//CERRRAR ARCHIVO DE TEXTO
            
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("\n----FILE READER-LEER ARCHIVOS------");
        try {
             FileReader fr = new FileReader("fw.csv");
             BufferedReader br = new BufferedReader(fr);
             System.out.println("El texto del archivo es: ");
             String linea = br.readLine();
             while(linea!=null){//MIENTRAS SEA DIFERENTE DE NULL, O SEA, HAY INFORMACIÓN
                 System.out.println(linea);
                 linea = br.readLine();
             }
             br.close();
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //DIVIDIR EN TOKENS UNA CADENA
        System.out.println("\n---String Tokenizer-----");
        Platillo platillo = new Platillo();//OBJETO QUE GUARDA LA INFORMACIÓN EN TOKENS
        float temp=0;//BANDERA TEMPORAL QUE INICIA EN 0
        String textoTemporal;
        String linea = "Enchiladas,50.44,Pollo/crema/queso";
        StringTokenizer tokenizador = new StringTokenizer(linea,",");
        
        while(tokenizador.hasMoreTokens()){//MIENTRAS HAYA MÁS TOKENS
            textoTemporal=tokenizador.nextToken();
            if(temp==0){
                platillo.setNombre(textoTemporal);
            }
            else if(temp==1){
                platillo.setPrecio(Double.parseDouble(textoTemporal));
            }
            else if(temp==2){
                platillo.setIngredientes(textoTemporal);
            } 
            
            temp++;
        }
        System.out.println(platillo);
        
        //ACTIVIDADES EXTRA 
        System.out.println("\n----ACTIVIDADES EXTRA----");
        
        //1. CREAR ARREGLO CON 10 OBJETOS PLATILLO INICIALIZADOS
        ArrayList <Platillo> arregloDePlatillos = new ArrayList <> ();//LISTA QUE CONTENDRÁ LOS PLATILLOS
        String [] losPlatillos = new String[10];//ARREGLO DE CADENAS, CADA CADENA ES UN PLATILLO
        
        //INICIALIZAR OBJETOS PLATILLO
        losPlatillos[0]="Mole,80,Pollo en mole madre";
        losPlatillos[1]="Pozole,75,Carne de puerco en caldo";
        losPlatillos[2]="Cochinita pibil,90,Carne de puerco al vapor con recado rojo";
        losPlatillos[3]="Chiles en nogada,150,Chiles rellenos con nogada tradicionales";
        losPlatillos[4]="Barbacoa,200,Barbacoa de hoyo";
        losPlatillos[5]="Carnitas,120,Tacos de carnitas con variedad de salsas";
        losPlatillos[6]="Pescado a la talla,110,Huachinango con salsa de guajillo";
        losPlatillos[7]="Lengua a la Veracruzana,100,Lengua de res con salsa veracruzana";
        losPlatillos[8]="Tlayudas,70,Tortilla grande con cama de frijoles y quesillo con tasajo y chorizo";
        losPlatillos[9]="Tacos de pastor,30,Tacos de pastor con pinia y salsa roja";
        
        //AÑADIR OBJETOS PLATILLO A LA LISTA
        String lineaAuxiliar = null;//LINEA QUE SERÁ TOKENIZADA
        String unAtributo = null; //CADENA QUE GUARDA UN ATRIBUTO COMO TOKEN DE UN PLATILLO
        
        float banderaDeAtributo=0;
        for (int i = 0; i < 10; i++) {
            Platillo platilloAuxiliar = new Platillo();//OBJETO QUE GUARDA LA INFORMACIÓN EN TOKENS
            lineaAuxiliar = losPlatillos[i];
            StringTokenizer tokenizerAuxiliar = new StringTokenizer(lineaAuxiliar,",");
            banderaDeAtributo = 0;
            while(tokenizerAuxiliar.hasMoreTokens()){
                unAtributo = tokenizerAuxiliar.nextToken();
                if(banderaDeAtributo==0){
                    platilloAuxiliar.setNombre(unAtributo);
                }
                else if  (banderaDeAtributo==1){
                    platilloAuxiliar.setPrecio(Double.parseDouble(unAtributo));
                }
                else if  (banderaDeAtributo==2){
                    platilloAuxiliar.setIngredientes(unAtributo);
                }
                banderaDeAtributo++;
            }
            //System.out.println(platilloAuxiliar);
            arregloDePlatillos.add(platilloAuxiliar);    
        }//TERMINA FOR
        System.out.println("Se han añadido los 10 platillos a un ArrayList.");
  
        //2.ESCRIBIR LOS 10 OBJETOS PLATILLO EN UN ARCHIVO DE TEXTO .csv
        try {
            //CREAR UN BUFFER PARA ESCRIBIR EN UN ARCHIVO
            
            FileWriter fw1 = new FileWriter ("archivoActExtra.csv");
            BufferedWriter bw1 = new BufferedWriter(fw1);
            PrintWriter lineaPorEscribir = new PrintWriter (bw1);
            
            for (int i = 0; i < 10; i++) {
                lineaPorEscribir.println(arregloDePlatillos.get(i));
                //System.out.println(arregloDePlatillos.get(i));
            }
            lineaPorEscribir.close();
            System.out.println("Se han escrito los 10 platillos en el archivo.");
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //3.LEER EL ARCHIVO DE TEXTO, TOKENIZAR LAS LÍNEAS Y RESUBIR A OTRA LISTA
        String [] losPlatillos2 = new String[10];//ARREGLO DE CADENAS, CADA CADENA ES UN PLATILLO
        int indice=0;
        try {
            FileReader fr1 = new FileReader("archivoActExtra.csv");
            BufferedReader br1 = new BufferedReader(fr1);
            String lineaLeyendose = br1.readLine();
            while(lineaLeyendose != null){
                losPlatillos2[indice]=lineaLeyendose;
                lineaLeyendose = br1.readLine();
                indice++;
            }
            br1.close();
            System.out.println("Se han extraído los datos del archivo.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList <Platillo> arregloDePlatillos2 = new ArrayList <> ();//LISTA 2 QUE CONTENDRÁ LOS PLATILLOS
        //AÑADIR OBJETOS PLATILLO A LA LISTA
        String lineaAuxiliar2 = null;//LINEA QUE SERÁ TOKENIZADA
        String unAtributo2 = null; //CADENA QUE GUARDA UN ATRIBUTO COMO TOKEN DE UN PLATILLO
        
        float banderaDeAtributo2=0;
        for (int i = 0; i < 10; i++) {
            Platillo platilloAuxiliar2 = new Platillo();//OBJETO QUE GUARDA LA INFORMACIÓN EN TOKENS
            lineaAuxiliar2 = losPlatillos2[i];
            StringTokenizer tokenizerAuxiliar2 = new StringTokenizer(lineaAuxiliar2,",");
            banderaDeAtributo2 = 0;
            while(tokenizerAuxiliar2.hasMoreTokens()){
                unAtributo2 = tokenizerAuxiliar2.nextToken();
                if(banderaDeAtributo2==0){
                    platilloAuxiliar2.setNombre(unAtributo2);
                    
                }
                else if  (banderaDeAtributo2==1){
                    platilloAuxiliar2.setPrecio(Double.parseDouble(unAtributo2));
                    
                }
                else if  (banderaDeAtributo2==2){
                    platilloAuxiliar2.setIngredientes(unAtributo2);
                    
                }
                banderaDeAtributo2++;
            }
            //System.out.println(platilloAuxiliar);
            arregloDePlatillos2.add(platilloAuxiliar2);    
        }//TERMINA FOR
        
        System.out.println("Se han añadido los 10 platillos a un ArrayList.");    
        System.out.println("Se han añadido los 10 platillos a un segundo ArrayList.");
        System.out.println("\nImpresión de los archivos extraídos desde el archivo:");
        for (Platillo platillo1 : arregloDePlatillos2) {
            System.out.println(platillo1);
        }
    }
}