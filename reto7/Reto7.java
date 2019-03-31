package reto7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Reto7 {
    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String caracter="";
        int nivel=0;
        String palabraBase="";
        String palabraX="";
        boolean comprobacion=false;
        try{
            System.out.println("Indique el nivel: ");
            nivel = Integer.parseInt(entrada.readLine());
            palabraBase=getPalabraAleatoria(nivel);
            palabraX=getPalabraX(nivel);
            
        }catch(IOException e){
                System.out.println("Error");

        }
        System.out.println(palabraBase);
        System.out.println(palabraX);
        String[] letras =palabraBase.split("");
        do{
            try{
                System.out.println("Indique una letra: ");
                caracter = entrada.readLine();
            }catch(IOException e){
                System.out.println("Error");
            }
            for(int r=0; r<letras.length; r++){
                if(letras[r].equals(caracter)){
                    char[] tempCharArray=palabraX.toCharArray();
                    tempCharArray[r]=caracter.charAt(0);
                    palabraX=String.valueOf(tempCharArray);
                    comprobacion=true;
                }
            }
            if(!comprobacion){
                System.out.println("No existe la letra en la palabra");
            }

            comprobacion = false;
            System.out.println(palabraX);

            if(palabraX.equals(palabraBase)){
                break;
            }

        }while(!caracter.equals("0"));
        System.out.println("Gracias por participar");
    }
    public static String getPalabraAleatoria(int nivel){
        Random aleatorio = new Random(System.currentTimeMillis());
        int a = aleatorio.nextInt(3);
        String[] palabras = {"gato", "mesa", "lona"};
        String[] palabras_8 = {"positivo", "fabricar", "fabuloso"};
        String[] palabras_12 = {"bachillerato", "habitacion", "laboratorios"};
        String palabra="";

        switch(nivel){
            case 1:
                palabra=palabras[a];
                break;
            case 2:
                palabra=palabras_8[a];
                break;
            case 3:
                palabra=palabras_12[a];
                break;
            default:
                break;
        }
        return palabra;
    }
     public static String getPalabraX (int nivel){
        String palabra = "";

        switch(nivel){
            case 1:
                    palabra = "XXXX";
                break;
            case 2:
                    palabra = "XXXXXXXX";
                break;
            case 3:
                    palabra = "XXXXXXXXXXXX";
                break;
            default: 
                break;
        }
        return palabra;
    }
}