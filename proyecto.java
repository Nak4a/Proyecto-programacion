import java.util.Arrays;
import java.util.Scanner;
public class Proyecto{
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    
    public static void menu(){
            
        System.out.println(ANSI_BLUE + "\n------------------------|======================"+ANSI_YELLOW +"[ MENU PRINCIPAL ]"+ANSI_BLUE+"=====================|");
        System.out.println("\t\t\t| 01- Cargar sueldos           | 02- Mostrar sueldos          |");
        System.out.println("\t\t\t| 03- Buscar sueldos           | 04- Rango de sueldos         |");
        System.out.println("\t\t\t| 05- Sueldo promedio          | 06- Aumentar sueldo          |");
        System.out.println("\t\t\t| 07- Mostrar sueldo mas bajo  | 08- Mostrar sueldo mas alto  |");
        System.out.println("\t\t\t| "+ ANSI_PURPLE+ "09- Otros" +ANSI_BLUE+ "                    |                              |");
        System.out.println("------------------------|_________________________/"+ ANSI_RED + "10- Salir"+ ANSI_RESET + ANSI_BLUE +"\\_________________________|");
        System.out.print("\n\t\t\t>>> " + ANSI_RESET);
    }
    
    public static void limpiar(){
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }
    
    public static void cargarSueldo(String[] nombres,int[] lista_sueldos){
        Scanner sc = new Scanner(System.in);
        System.out.println(ANSI_GREEN + "======[  Escriba el sueldo  para cada empleado  ]======"); 
        System.out.println("        ======[  Escriba 0 para volver  ]======");
        for(int i = 0;i<nombres.length;i++){
            System.out.print("Empleado " +ANSI_YELLOW+ nombres[i] +ANSI_GREEN+ " Sueldo ==> ");
            int sueldo = sc.nextInt();
            if(sueldo == 0){
                break;
            }else
                lista_sueldos[i] = sueldo;
        }
        System.out.println(ANSI_RESET);
        limpiar();
    }
    public static void mostrarSueldo(String[] nombres,int[] lista_sueldos){
        System.out.println(ANSI_YELLOW+ "\t\t\t\t\t     ======[  Sueldos  ]======"+ANSI_RESET );
        for(int i = 0;i<lista_sueldos.length;i++){
            System.out.println(ANSI_GREEN + "\t\t\t\t       ====[  Empleado " + ANSI_YELLOW +nombres[i] +ANSI_GREEN+ " Sueldo >> "+ ANSI_YELLOW + lista_sueldos[i] + ANSI_GREEN+"$  ]====");
        }System.out.println(ANSI_RESET);
    }

    public static void rangoSueldos(String[] nombres, int[] lista_sueldos){
        Scanner sc = new Scanner(System.in);
        System.out.println(ANSI_YELLOW + "============[  MENU BUSCAR RANGO  ]============" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "====[  Buscar valor entre [...] y [...]  ]===="+ ANSI_RESET);
        int num1 = sc.nextInt();
        limpiar();
        System.out.println(ANSI_YELLOW + "============[  MENU BUSCAR RANGO  ]============" + ANSI_RESET);
        System.out.println(ANSI_BLUE+"====[  Buscar valor entre " + ANSI_YELLOW + num1+ ANSI_BLUE + " y [...]  ]====" + ANSI_RESET);
        int num2 = sc.nextInt();
        limpiar();
        System.out.println(ANSI_BLUE+"\n\t\t\t\t====[  Los sueldos entre " + ANSI_YELLOW +num1 +ANSI_BLUE +" y " +ANSI_YELLOW  +num2 + ANSI_BLUE+" son:  ]====");
        int cantidad = 0;
        for (int i = 0; i < lista_sueldos.length; i++ ){
            if(lista_sueldos[i] > num1-1 && lista_sueldos[i] < num2-1){
                System.out.println("\t\t\t\tEmpleado " +ANSI_YELLOW + nombres[i] +ANSI_RESET+ANSI_BLUE+ " Sueldo >> " + lista_sueldos[i]);
                cantidad ++;
            }
        }
        if(cantidad == 0){
            System.out.println(ANSI_RED + "\t\t\t\t\t====[  Ningun sueldo entra en el rango  ]====" + ANSI_RESET);
        }
        else
        System.out.println("\t\t\t\t===================================================");
        System.out.println(ANSI_PURPLE+"\n\t\t\t\t\t==[  Total de sueldos en el rango: " + cantidad +"  ]=="+ANSI_RESET);
        System.out.println(ANSI_RESET);
        
        
    }

    public static boolean buscar(String[] nombres, int[] lista_sueldos){
        Scanner sc = new Scanner(System.in);
        String empleado = "";
        while(!empleado.equals("salir")){
        System.out.print(ANSI_CYAN+"======[  Escriba el nombre del empleado o SALIR para volver  ]======\n>>>"+ANSI_RESET);
        empleado = sc.nextLine().toLowerCase().replace(" ", "");
        Boolean encontrado = false;
        limpiar();
        for(int i = 0; i < lista_sueldos.length;i++){
            if(empleado.equals(nombres[i].toLowerCase().replace(" ", ""))){
                encontrado = true;
                System.out.println(ANSI_GREEN+"======[  Nombre: " + ANSI_YELLOW +nombres[i] +ANSI_GREEN+ " Sueldo >> " +ANSI_YELLOW+ lista_sueldos[i] +ANSI_GREEN+ "$  ]======");
                break;
            }
            
        }
        if(encontrado == false){
            System.out.println(ANSI_RED + "     ======[  ERROR  ]======");
            System.out.println("===[  Empleado no encontrado  ]===" + ANSI_RESET);
        }
        }limpiar();
        
        
        return true;
    }
    public static float aumentar(String[] nombres,int[] lista_sueldos){
        Scanner sc = new Scanner(System.in);
        int index = 0;
        int porcentaje = 0;
        Boolean salir,valido;
        salir = false;
        limpiar();
        while(!salir){
            valido=false;
            System.out.println(ANSI_BLUE + "\n\t\t\t======[  Para volver escriba salir  ]======");
            System.out.println("======[  Tenga en cuenta que solo puede aumentar entre"+ANSI_RESET+ANSI_YELLOW+" 5% "+ANSI_BLUE+"y "+ANSI_YELLOW+"10%"+ANSI_BLUE+" a sueldos entre "+ANSI_GREEN+"15000$"+ANSI_BLUE+" y "+ANSI_GREEN+"25000$"+ANSI_BLUE+"  ]======"+ANSI_RESET);
            System.out.print(ANSI_GREEN+"\n======[ Escriba el "+ANSI_YELLOW+"Nombre/Cedula/ID"+ANSI_GREEN+" del empleado ]==== \n>>> "+ANSI_RESET);
            String empleado = "" + sc.nextLine().toLowerCase().replace(" ","").replace("\n", "");
            if(empleado.length() == 0){limpiar();continue;}
            
            
            limpiar();
            
            for(int i = 0; i<nombres.length;i++){if(nombres[i].toLowerCase().replace(" ", "").equals(empleado)){ index = i; valido = true;}}
            if (empleado.equals("salir")){
                limpiar();
                salir = true;
                return lista_sueldos[index];
            }else if(lista_sueldos[index] > 25000 || lista_sueldos[index] < 15000 && valido == true){
                System.out.println(ANSI_RED + "\t\t======[  ERROR  ]======");
                System.out.println("======[  El sueldo del empleado no cumple los requisitos  ]======");
                System.out.println("======[  El sueldo actual del empleado "+ANSI_YELLOW + nombres[index] + ANSI_RED +" es " +ANSI_GREEN +lista_sueldos[index]+"$" + ANSI_RED+"  ]======"+ANSI_RESET);
                continue;
            }else if(valido == false){
                System.out.println(ANSI_RED+"\n\t======[   ERROR   ]======");
                System.out.println("    ======[  Empleado no existe  ]======");
                continue;
            }
            else
            limpiar();
            while(true){
                System.out.println(ANSI_BLUE+"======[  Para volver escriba 0  ]======");
                System.out.println("======[  Empleado seleccionado: "+ ANSI_YELLOW + nombres[index] + ANSI_BLUE + "  ]======");    
                System.out.println("\n======[  Escriba el porcentaje a aumentar  ]======"+ANSI_RESET);
                porcentaje = sc.nextInt();
                if(porcentaje == 0){limpiar();break;}
                else if(lista_sueldos[index] > 25000 ){limpiar();break;}
                else if (5 > porcentaje || 10 < porcentaje){
                    limpiar();
                    System.out.println(ANSI_RED+"======[  ERROR  ]======");
                    System.out.println("======[  Solo aumento entre "+ANSI_YELLOW+ "5%"+ANSI_RED+" y"+ANSI_YELLOW+ " 10% "+ANSI_RED+ " ]======"+ANSI_RESET);
                    continue;                   
                }
                else;
                limpiar();
                lista_sueldos[index] = lista_sueldos[index] + lista_sueldos[index]*porcentaje/100;
                System.out.println(ANSI_GREEN+"====[   Sueldo aumentado con exito  ]====");
                System.out.println("====[  Empleado " +ANSI_YELLOW+ nombres[index] + ANSI_GREEN+" Sueldo >> " + lista_sueldos[index] + "$  ]===="+ANSI_RESET);

            }
    }
        return lista_sueldos[index];
        
    }

    public static float promedio(int[] lista_sueldos){
        float suma = 0;
        for(int i = 0; i < lista_sueldos.length;i++){
            suma += lista_sueldos[i];
        }
        System.out.println(ANSI_CYAN + "\t\t\t\t=====[  El promedio de todos los sueldos es:  ]=====");
        System.out.println("\t\t\t\t======> "+ANSI_RESET+ANSI_GREEN+ suma / lista_sueldos.length + "$"+ANSI_RESET);
        return suma;
    }
    
    public static void min(String[] nombres, int[] lista_sueldos,int[] ordenados){
        System.out.println(ANSI_CYAN + "\n\t\t\t======[  Sueldos mas bajos:  ]======");
        for(int i = 0; i<lista_sueldos.length; i++){
            if(lista_sueldos[i] == ordenados[0]){
                System.out.println("\t\t\t Empleado " + nombres[i] + " Sueldo >> " + lista_sueldos[i] + "$");
            }
        }System.out.println("\t\t\t====================================" + ANSI_RESET);
    }

    public static void max(String[] nombres, int[] lista_sueldos,int[] ordenados){
        System.out.println(ANSI_CYAN + "\n\t\t\t======[  Sueldos mas altos:  ]======");
        for(int i = 0; i<lista_sueldos.length; i++){
            if(lista_sueldos[i] == ordenados[ordenados.length-1]){
                System.out.println("\t\t\t Empleado " + nombres[i] + " Sueldo >> " + lista_sueldos[i] + "$");
            }
        }System.out.println("\t\t\t====================================" + ANSI_RESET);
    }

    public static void ascendente(String[] nombres,int[] lista_sueldos,int[] ordenados){
        System.out.println(ANSI_CYAN+"\t\t\t  ======[  Sueldos ordenados de forma Ascendente  ]=======");
        for(int i = 0; i<ordenados.length;i++){
            for(int j = 0;j<ordenados.length;j++){
                if(lista_sueldos[j] == ordenados[i]){
                System.out.println("\t\t\t\t Empleado " + nombres[j] +" Sueldo >> "+ordenados[i]);
                }
            }
        }System.out.println("\t\t\t  ========================================================");
        System.out.println(ANSI_RESET);
    }


    public static void descendente(String[] nombres,int[] lista_sueldos,int[] ordenados){
        System.out.println(ANSI_CYAN+"\t\t\t  ======[  Sueldos ordenados de forma Descendente  ]======");
        for(int i = ordenados.length-1; i >= 0; i--){
            for(int j = 0;j<ordenados.length;j++){
                if(lista_sueldos[j] == ordenados[i]){
                System.out.println("\t\t\t\t Empleado " + nombres[j] +" Sueldo >> "+ordenados[i]);
                }
            }
        }System.out.println("\t\t\t  ========================================================");
        System.out.println(ANSI_RESET);
    }


    public static void submenu(){
        System.out.println(ANSI_BLUE + "\n------------------------|========================"+ANSI_YELLOW +"[ MENU OTROS ]"+ANSI_BLUE+"=======================|");
        System.out.println("\t\t\t| 01- Ordenar Ascendente       | 02- Ordenar Descendente      |");
        System.out.println("\t\t\t| 03- Sueldos a dolares        |                              |");
        System.out.println("------------------------|_________________________/"+ ANSI_RED + "04- Atras"+ ANSI_RESET + ANSI_BLUE +"\\_________________________|");
        System.out.print("\n\t\t\t>>> " + ANSI_RESET);
    }

    public static void dolar(String[] nombres,int[] lista_sueldos){
        System.out.println(ANSI_YELLOW + "\t\t\t\t======[  SUELDOS A DOLARES  ]======" + ANSI_CYAN);
        for(int i = 0; i < lista_sueldos.length; i++){
            System.out.println("\t\t\t\t Empleado " + nombres[i] + " Sueldo >> " + String.format("%.2f", lista_sueldos[i] / 40.92) + " Usd$");
        }System.out.println(ANSI_YELLOW+"\t\t\t\t==================================="+ANSI_RESET);

    }


    

    public static void main(String[] args) {
        limpiar();
        Scanner sc = new Scanner(System.in);
        System.out.println(ANSI_GREEN + "=======[  Bienvenido al sistema  ]=======" + ANSI_RESET);       
        System.out.print(ANSI_BLUE + "\n====[  Escriba la cantidad de empleados  ]=====\n>>> ");
        String[] nombres = new String[sc.nextInt()];
        int sueldos[] = new int[nombres.length];
        String numeros[] = {"0","1","2","3","4","5","6","7","8","9"};
        String nombre, apellido;
        Boolean cedula;
        System.out.println("======[  Escriba el nombre, cedula o id para cada empleado  ]======"+ANSI_RESET);
        for(int i = 0; i<nombres.length;i++){
            cedula = false;
            System.out.print(ANSI_GREEN + "\nNombre: ");
            nombre =  sc.next();
            for(int y = 0;y<numeros.length;y++){
                if(nombre.contains(numeros[y])){
                    nombres[i] = nombre;
                    cedula = true;
                    break;
                }
            }
            if(!cedula){
                System.out.print("Apellido: ");
                apellido = sc.next();
                nombres[i] = "" + nombre + " " + apellido;
            }
        }
        
        limpiar();
        System.out.println(ANSI_RESET);
        int op = 0;
        while (op != 10){
            int ordenados[] = new int[sueldos.length];
            for(int i = 0;i<ordenados.length;i++){ordenados[i] = sueldos[i];}
            Arrays.sort(ordenados);
            menu();
            op = sc.nextInt();
            limpiar();
            if (op == 1){
                limpiar();
                cargarSueldo(nombres,sueldos);
            }else if (op == 2){
                limpiar();
                mostrarSueldo(nombres,sueldos);
            }else if (op == 3){
                limpiar();
                buscar(nombres,sueldos);
            }else if (op == 4){
                limpiar();
                rangoSueldos(nombres,sueldos);
            }else if (op == 5){
                limpiar();
                promedio(sueldos);
            }else if (op == 6){
                limpiar();
                aumentar(nombres,sueldos);
            }else if (op == 7){
                limpiar();
                min(nombres,sueldos,ordenados);
            }else if (op == 8){
                limpiar();
                max(nombres,sueldos,ordenados);
            }else if (op == 9){
                while (true){
                submenu();
                int subop = sc.nextInt();
                limpiar();
                if(subop == 1){ascendente(nombres, sueldos, ordenados);}
                else if(subop == 2){descendente(nombres, sueldos, ordenados);}
                else if(subop == 3){dolar(nombres,sueldos);}
                else if(subop == 4){break;}

            }
            }
            
        }
        
    
    }
        
}
