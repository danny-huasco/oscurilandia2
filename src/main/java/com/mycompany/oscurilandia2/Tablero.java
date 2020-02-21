/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.oscurilandia2;

import java.util.ArrayList;
import java.util.Scanner;

        /**
 *
 * @author Daniel
 */
//clase principal, contiene metodo main
public class Tablero {
    static ArrayList<Espacio> listablero;
    static ArrayList<Carro> carros;
    static ArrayList<Huevo> disparos;
    
   
    /**
     * metodo main, encargado de interactuar con el usuario y llamar a los 
     * metodos pertinentes para cada acción
     * @param args 
     */
    public static void main(String args[]){
        listablero = new ArrayList<>();
        carros = new ArrayList<>();
        disparos = new ArrayList<>();
        int contCarros=0; //para reducir cantidad de carros mientras se juega y terminar el juego al llegar a 0
        int contK=0, contC=0, contT=0; // para saber cuantos carros hay  de cada tipo en el arreglo de carros
        int opcMenu;
        Scanner sc = new Scanner(System.in);
        boolean bo=true;//para validar salida del bucle que envuelve al menu 
        //cargar mapa 
        cargarMapa(listablero);
        do{
            do{
                System.out.println("***MENU***");
                System.out.println("Escoja una opción");
                System.out.println("1. Jugar rápidamente");//carga carros rapidamente y los posiciona para jugar
                System.out.println("2. Llenar arreglo de carros manualmente");//llena el arreglo uno por uno, aún falta validar cantidad de carros por tipo
                System.out.println("3. Jugar");//lanza el juego cuando el arraylist de carros ya está lleno
                System.out.println("4. Calcular Puntaje obtenido hasta ahora");//retorna el puntaje acumulado en base a arraylist de disparos
                System.out.println("5. Salir");//sale del juego
                opcMenu = sc.nextInt();
                if(opcMenu<1 || opcMenu>5){
                    System.out.println("opción incorrecta, intente de nuevo");
                }
            }while(opcMenu<1 || opcMenu>5);

            switch(opcMenu){
                case 1:
                    cargarCarrosRapido(carros, contK, contC, contT);//carga carros vacios
                    posicionarCarros(listablero);//posiciona carros en mapa
                    lanzarJuego(contCarros);//ejecuta el juego
                    System.out.println("¿Desea ejecutar otra acción? (s/n)");
                    if(sc.next().equals("n")){
                        bo = false;
                    }
                    break;
                case 2:
                    carros.clear();//libera el arraylist de todo contenido para ingresar nuevos carros    
                   
                    System.out.println("puede ingresar hasta 18 carros, divididos en:\nhasta 3 kromis\nhasta 5 caguanos\nhasta 10 trupallas");
                    while(carros.size()<18){
                        crearCarro(contK, contC, contT);
                        System.out.println("¿desea ingresar otro carro? (s/n)");
                        if(sc.next().equals("n") || sc.next().equals("N"))
                            break;
                    }
                    System.out.println("¿Desea ejecutar otra acción? (s/n)");
                    if(sc.next().equals("n") || sc.next().equals("N")){
                        bo = false;
                    }
                    break;
                case 3:
                    if(carros.isEmpty()){//advierte en caso de que arreglo de carros esté vacio
                        System.out.println("no se puede jugar sin carros!!\n debe llenar la lista primero o escoger la opcion 1");
                        break;
                    }else{//resetea mapa y lanza el juego con los carros que ya hay en el arreglo
                        cargarMapa(listablero);
                        posicionarCarros(listablero);
                        /*cambiar a reinstanciar el arreglo
                        */                    
                        disparos.clear();//resetea el arreglo de disparos para registrar el nuevo juego
                        lanzarJuego(contCarros);
                        System.out.println("¿Desea ejecutar otra acción? (s/n)");
                        if(sc.next().equals("n") || sc.next().equals("N")){
                            bo = false;
                        }
                        break;
                    }
                case 4:
                    System.out.println("tu puntaje hasta el momento es: " + calcularPuntaje());
                    System.out.println("¿Desea ejecutar otra acción? (s/n)");
                    if(sc.next().equals("n") || sc.next().equals("N")){
                        bo = false;
                    }
                    break;
                case 5:
                    System.out.println("Hasta Pronto!");
                    bo = false;
                    break;                
            }       
        }while(bo);
    }
    
    /**
     * muestra el mapa y da opcion de lanzar huevos
     * @param contCarros utilizado para tener control sobre cuando se debe
     * terminar el juego por ausencia de carros que atacar
     */
    public static void lanzarJuego(int contCarros){
        Scanner sc = new Scanner(System.in);
        String op;
        
        contCarros = carros.size();//da valor a contador de carros
        //ciclo do while para lanzar hasta que el usuario decida salir
        do{
            mostrarMatriz(listablero);
            contCarros = lanzarHuevo(disparos, listablero, contCarros);
            //da un mensaje de exito al no haber más carros que atacar
            if(contCarros==0){
                System.out.println("***no quedan más carros que atacar***\n ¡GANASTE!");
                break;
            }
            System.out.println("desea lanzar otro huevo? (s/n)");
             op = sc.next();
        }while(op.equals("s") || op.equals("S"));
    }
    
    /**
     * crea UN carro y lo ingresa en el arreglo de carros
     * @param kr contador que controla la cantidad de kromis que se pueden ingresar
     * @param ca contador que controla la cantidad de caguanos que se pueden ingresar
     * @param tr contador que controla la cantidad de trupallas que se pueden ingresar
     */
    public static void crearCarro(int kr, int ca, int tr){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("que tipo de carro desea crear? \n1.Kromi\n2.Caguano\n3.Trupalla");
        int op = sc.nextInt();
        switch(op){
            case 1:
                if(kr==3){
                    System.out.println("no puede agregar mas kromis");
                    break;
                }                    
                Kromi k = new Kromi();
                System.out.println("***ingrese los siguientes datos***");
                System.out.print("Cantidad de ocupantes: ");
                k.setCantOcupantes(sc.nextInt());
                System.out.print("Fecha de ingreso: ");
                k.setFechaIngreso(sc.next());
                System.out.print("Año de fabricación: ");
                k.setAnioFabricacion(sc.nextInt()); 
                System.out.print("Marca: ");
                k.setMarca(sc.next());
                carros.add(k);
                kr++;
                break;
                
            case 2:
                if(ca==5){
                    System.out.println("no puede agregar mas caguanos");
                    break;
                }
                Caguano c = new Caguano();
                System.out.println("***ingrese los siguientes datos***");
                System.out.print("Cantidad de ocupantes: ");
                c.setCantOcupantes(sc.nextInt());
                System.out.print("Fecha de ingreso: ");
                c.setFechaIngreso(sc.next());
                System.out.print("Alcance de tiro: ");
                c.setAlcanceTiro(sc.nextInt());  
                System.out.print("Color de confeti: ");
                c.setColorConfeti(sc.next());
                carros.add(c);
                ca++;
                break;
            case 3: 
                if(tr==10){
                    System.out.println("no puede agregar mas trupallas");
                    break;
                }
                Trupalla t = new Trupalla();
                System.out.println("***ingrese los siguientes datos***");
                System.out.print("Cantidad de ocupantes: ");
                t.setCantOcupantes(sc.nextInt());
                System.out.print("Fecha de ingreso: ");
                t.setFechaIngreso(sc.next());
                //validación de ingreso acotado
                int n;
                do{
                    System.out.print("Nivel de armadura (enteros entre 1 y 5): ");
                    n = sc.nextInt();
                    if(n!=1 && n!=2 && n!=3 && n!=4 && n!=5){
                        System.out.println("ingreso incorrecto, vuelva  a intentarlo");
                    }else{
                        t.setArmadura(n);
                    }                
                }while(n!=1 && n!=2 && n!=3 && n!=4 && n!=5);
                System.out.print("Nombre chofer: ");
                t.setNombreChofer(sc.next());
                carros.add(t);
                tr++;
                break;
            default:
                System.out.println("ingrese una opción correcta");                              
        }
    }
    
    /**
     * simula un disparo, evalua si impacta un carro y reemplaza valores de ser necesario
     * @param disparos ArrayList que contiene todos los disparos ejecutados por el usuario
     * @param tablero ArrayList que contiene el tablero de juego
     * @param contadorCarros lleva el numero de carros que no han sido eliminados
     * @return la cantidad de carros que quedan sin ser eliminados en el juego
     */
    public static int lanzarHuevo(ArrayList<Huevo> disparos, ArrayList<Espacio> tablero, int contadorCarros){
        Huevo bala = new Huevo();
        Scanner sc = new Scanner(System.in);        
        int opc;
        
        System.out.println("ingrese un numero del tablero donde desea lanzar un huevo\n Use numeros del 1 al 225");
        opc = sc.nextInt();
        
        //asigno numero de tablero
        bala.getPos().setNumTablero(opc);
        //asigno fila, recuperando desde objeto espacio en tablero
        bala.getPos().setFila(tablero.get(opc-1).getFila());
        //asigno columna, recuperando desde objeto espacio en tablero
        bala.getPos().setColumna(tablero.get(opc-1).getColumna());
        //evaluar qué impacta
        switch(tablero.get(opc-1).getContenido()){
            
            case "H":
                //ya había impactado
                System.out.println("esta casilla ya había sido impactada");
                break;
                
            case "K":
                //hay kromi y debo asignar puntaje, evaluar si la micro está completamente atacada
                System.out.println("impactó una kromi!");
                bala.setPuntaje(3);
                tablero.get(opc-1).setMuestra("H");
                tablero.get(opc-1).setContenido("H");
                //evaluar en rango si hay algún objeto
                for(int i=0;i<carros.size();i++){
                    if(carros.get(i) instanceof Kromi){
                        //evalúa si la ubicación corresponde a la primera guardada en el carro
                        if(carros.get(i).getUbicacion().getNumTablero() == tablero.get(opc-1).getNumTablero()){
                            //evalúa dos casillas hacia abajo para ver su contenido
                            if(tablero.get(opc+14).getContenido().equals("H") && tablero.get(opc+29).getContenido().equals("H")){
                                bala.setPuntaje(13);
                                disparos.add(bala);
                                contadorCarros--;
                                break;
                            }
                        }
                        //evalúa si el que corresponde al carro está una ubicación arriba
                        if(opc>15){
                            if(carros.get(i).getUbicacion().getNumTablero() == tablero.get(opc-16).getNumTablero()){
                                //evalúa una casilla arriba y una abajo
                                if(tablero.get(opc-16).getContenido().equals("H") && tablero.get(opc+14).getContenido().equals("H")){
                                    bala.setPuntaje(13);
                                    disparos.add(bala);
                                    contadorCarros--;
                                    break;
                                }
                            }
                        }
                        //evalúa si el correspondiente al carro está dos posiciones arriba
                        if(opc>30){                        
                            if(carros.get(i).getUbicacion().getNumTablero() == tablero.get(opc-31).getNumTablero()){
                                //evalúa dos posiciones arriba
                                if(tablero.get(opc-16).getContenido().equals("H") && tablero.get(opc-31).getContenido().equals("H")){
                                    bala.setPuntaje(13);
                                    disparos.add(bala);
                                    contadorCarros--;
                                    break;
                                }
                            }
                        }
                    }
                }
                disparos.add(bala);
                break;
                                
            case "C":
                //hay caguano, asigno puntaje y evaluo si está totalmente atacado
                System.out.println("impactó un caguano!");
                bala.setPuntaje(2);
                tablero.get(opc-1).setMuestra("H");
                tablero.get(opc-1).setContenido("H");
                //evaluar si está totalmente atacado
                for(int i=0; i<carros.size(); i++){
                    //evalúa solo instancias de Caguanos
                    if(carros.get(i) instanceof Caguano){
                        //evalúa si coinciden ubicaciones con la del carro en arreglo
                        if(carros.get(i).getUbicacion().getNumTablero() == tablero.get(opc-1).getNumTablero()){
                            //evalúa la segunda posición del carro
                            if(tablero.get(opc).getContenido().equals("H")){
                                bala.setPuntaje(9);
                                disparos.add(bala);
                                contadorCarros--;
                                break;
                            }
                        }else{
                            if(tablero.get(opc-2).getContenido().equals("H")){
                                bala.setPuntaje(9);
                                disparos.add(bala);
                                contadorCarros--;
                                break;
                            }
                        }                        
                    } 
                }
                disparos.add(bala);
                break;
                
            case "T":
                //hay trupalla, asignar puntaje, reducir contador de carros derrotados
                System.out.println("impactó una trupalla!");
                tablero.get(opc-1).setMuestra("H");
                tablero.get(opc-1).setContenido("H");
                bala.setPuntaje(1);                
                disparos.add(bala);
                contadorCarros--;
                break;
                
            case "*":
                //calle, no hay puntaje, solo se cambia el contenido del mapa
                tablero.get(opc-1).setMuestra("H");
                tablero.get(opc-1).setContenido("H");
                System.out.println("impactó calle, mas suerte la próxima vez");
                break;
        }
        return contadorCarros;        
    }
    
    /**
     * genera una visualizacion de la matriz
     * @param listablero arraylist que contiene el tablero de juego 
     */
    public static void mostrarMatriz(ArrayList<Espacio> listablero){
        int cont=0;
        while(cont<225){
            System.out.print(listablero.get(cont).getMuestra() + " ");
            if((cont+1)%15==0)
                System.out.print("\n");
            cont++;           
        }
    }
    
    /**
     * posiciona todos los carros contenidos en el arraylist aleatoriamente en el
     * tablero antes de comenzar a correr el juego
     * @param tablero arraylist que contiene el tablero de juego
     */
    public static void posicionarCarros(ArrayList<Espacio> tablero){
        boolean aux;
        int numAl;
        
        for(int i=0; i<carros.size();i++){
            aux=true;
            if(carros.get(i) instanceof Kromi){
                do{
                    //usar funcion random para encontrar una posicion entre 1 y 195
                    numAl = (int) (Math.random()*195+1);
                    //evaluar si la posición está desocupada
                    if(tablero.get(numAl-1).getContenido().equals("*")){
                        if(tablero.get(numAl+14).getContenido().equals("*") && tablero.get(numAl+29).getContenido().equals("*")){
                            // asignar valores en tablero y pasar al siguiente carro
                            carros.get(i).setUbicacion(tablero.get(numAl-1));
                            tablero.get(numAl-1).setContenido("K");
                            tablero.get(numAl+14).setContenido("K");
                            tablero.get(numAl+29).setContenido("K");
                            aux=false;
                        }
                    }
                }while(aux);
            }
            if(carros.get(i) instanceof Caguano){
                //evaluar posicion segun atributo columna del espacio
                do{
                    numAl = (int) (Math.random()*225+1);
                    if(tablero.get(numAl-1).getColumna() == 15){
                        //no se puede posicionar caguano en la ultima columna
                    }else{
                        if(tablero.get(numAl-1).getContenido().equals("*") && tablero.get(numAl).getContenido().equals("*")){
                            tablero.get(numAl-1).setContenido("C");
                            tablero.get(numAl).setContenido("C");
                            aux=false;
                        }
                    }
                    
                }while(aux);
            }
            if(carros.get(i) instanceof Trupalla){
                do{
                    numAl = (int) (Math.random()*225+1);
                    if(tablero.get(numAl-1).getContenido().equals("*")){
                        carros.get(i).setUbicacion(tablero.get(numAl-1));
                        tablero.get(numAl-1).setContenido("T");
                        aux=false;
                    }
                }while(aux);
            }
        }        
    }
    
    /**
     * calcula el puntaje total acumulado de todos los lanzamientos 
     * hechos hasta el momento en que es llamado 
     * @return la suma de todos los puntajes obtenidos del arraylist de disparos
     */
    public static int calcularPuntaje(){
        int acum=0;
        
        for(int i=0; i<disparos.size(); i++){
            acum+= disparos.get(i).getPuntaje();
        }
        return acum;
    }
    
    /**
     * instancia los 225 objetos de tipo espacio que componen el tablero de juego
     * cada uno de ellos con los datos alusivos a la posicion, pero con su contenido
     * no definido aún
     * @param tablero 
     */
    public static void cargarMapa(ArrayList<Espacio> tablero){
        int contador=1;
        for(int i=0; i<15; i++){
            for(int j=0; j<15; j++){
                Espacio esp = new Espacio(i, j, contador);
                tablero.add(esp);
                contador++;
            }
        }
    }
    
    /**
     * genera 18 carros "vacios" y los carga en el arraylist de carros para jugar
     * sin necesidad de llenar toda la información de cada carro antes de lanzar 
     * el juego
     * @param carros arraylist que contiene todos los carros creados
     * @param kr contador para kromis creadas
     * @param ca contador para caguanos creados
     * @param tr contador para trupallas creadas
     */    
    public static void cargarCarrosRapido(ArrayList<Carro> carros, int kr, int ca, int tr){
        for(int i=0;i<3;i++){
            Kromi k = new Kromi();//llenar con kromis
            carros.add(k);
            kr++;
        }
        for(int i=0;i<5;i++){
            Caguano c = new Caguano();//llenar con caguanos
            carros.add(c);
            ca++;
        }
        for(int i=0;i<10;i++){
            Trupalla t = new Trupalla();//llenar con trupallas
            carros.add(t);
            tr++;
        }
    }
    
}
