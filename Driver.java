//Yong Bum Park 20117
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver{
    
    /** 
     * @param args
     */
    public static void main (String[] args){
        ArrayList<ArrayList<String>> dic = new ArrayList<ArrayList<String>>();
        ArrayList<String> text = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        //lectura del diccionario
        try{
            File datos = new File("diccionario.txt");
            Scanner lectura = new Scanner(datos);

            while(lectura.hasNextLine()){
                String expresion = lectura.nextLine();
                String[] strsplit = expresion.split(",");
                ArrayList<String> words = new ArrayList<>();
                for(int i=0;i<strsplit.length;i++){
                    words.add(strsplit[i]);
                }
                dic.add(words);                
            }
            lectura.close();
        }catch(FileNotFoundException e){
            System.out.println("No se encontro el archivo");
            e.printStackTrace();
        }
        System.out.println("___________________________________");
        //lectura del texto.txt
        try{
            File datos = new File("texto.txt");
            Scanner lectura = new Scanner(datos);

            while(lectura.hasNextLine()){
                String expresion = lectura.nextLine();
                System.out.println("Palabra ingresada");
                System.out.println(expresion);
                String[] strsplit = expresion.split(" ");
                for(int i=0;i<strsplit.length;i++){
                    if(strsplit[i].contains(".")){
                        StringBuilder sb = new StringBuilder(strsplit[i]);
                        sb.deleteCharAt(strsplit[i].length()-1);
                        text.add(sb.toString());
                    }else{
                        text.add(strsplit[i]);
                    }
                }                
            }
            lectura.close();
        }catch(FileNotFoundException e){
            System.out.println("No se encontro el archivo");
            e.printStackTrace();
        }
        //BinarySearchTree
        BinaryTree tree = new BinaryTree();
        for(ArrayList<String> palabra : dic){
            tree.insert(palabra);
        }
        //imprimit el diccionario
        System.out.println("Imprimir el diccionario en orden por ingles");
        tree.inorder();

        //mostrar la palabra traducida
        //pedir primero por cual lenguaje lo desea traducir
        //entre ingles, espanol o frances
        boolean ciclo = true;
        do{
            System.out.println("______________________________________");
            System.out.println("1. English");
            System.out.println("2. Spanish");
            System.out.println("3. French");
            int op = elegirMenu();
            //par ingles
            if(op==1){
                for(int i=0;i<dic.size();i++){
                    for(int j=0;j<text.size();j++){
                        if(dic.get(i).contains(text.get(j))){
                            text.set(j, dic.get(i).get(0));
                        }
                    }
                }
                ciclo=false;
            //para espanol
            }else if(op==2){
                for(int i=0;i<dic.size();i++){
                    for(int j=0;j<text.size();j++){
                        if(dic.get(i).contains(text.get(j))){
                            text.set(j, dic.get(i).get(1));
                        }
                    }
                }
                ciclo=false;
            //para frances
            }else if(op==3){
                for(int i=0;i<dic.size();i++){
                    for(int j=0;j<text.size();j++){
                        if(dic.get(i).contains(text.get(j))){
                            text.set(j, dic.get(i).get(2));
                        }
                    }
                }
                ciclo=false;
            }else{
                ciclo=false;
            }
        }while(ciclo);
        System.out.println("______________________________________");
        //mostrar el resultado de la palabra traducida
        System.out.println("Palabra traducida");
        String palabraConvertida="";
        text.set(text.size()-1, (text.get(text.size()-1) + "."));
        for(int i=0;i<text.size();i++){
            palabraConvertida += (text.get(i) + " ");
        }
        System.out.println(palabraConvertida);
        System.out.println("____________________________________");
    }

    
    /** 
     * @return int
     */
    public static int elegirMenu(){
        //pedir el numero de opcion
        Scanner scanner = new Scanner(System.in);
        boolean ciclo_numero=true;
        int opcion_numero=0;
        do{
            try{
                String opcion = scanner.next();
                //verificar que sea una opcion adecuada
                opcion_numero = Integer.parseInt(opcion);
                if(opcion_numero>=1 && opcion_numero<=3){
                    ciclo_numero=false;
                }else{
                    System.out.println("Porfavor escoja una de las opcioens que se presentan en el menu");
                }
            }catch(Exception e){
                System.out.println("Ingersa solo datos numericos");
            }
        }while(ciclo_numero);
        return opcion_numero;
    }
}