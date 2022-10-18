import java.util.*;
public class proyecto{
    
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



    public static void limpiar(){
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }



    //========[  CARGAR SUELDOS  ]==========//
    public static void cargarSueldo(int[] lista_sueldos){
        limpiar();
        Scanner sc = new Scanner(System.in);
        System.out.println(ANSI_GREEN + "====[  Escriba el sueldo  ]====");
        for(int i= 0; i<lista_sueldos.length;i++){
            System.out.print("Empleado " + i + " Sueldo >> ");
            lista_sueldos[i] = sc.nextInt();
        
        }
        System.out.println(ANSI_RESET);
        limpiar();
    }

    //========[  MOSTRAR SUELDOS  ]==========//
    public static void mostrarSueldo(int[] lista_sueldos){
        limpiar();
        System.out.println(ANSI_YELLOW+ "\t\t\t\t\t     ======[  Sueldos  ]======"+ANSI_RESET );
        for(int i=0;i < lista_sueldos.length; i++){
            System.out.println(ANSI_GREEN + "\t\t\t\t       ====[  Empleado " + i + " Sueldo >> " + lista_sueldos[i] + "$  ]====");
        }
        System.out.println(ANSI_RESET);
    }


    //=========[  BUSCAR SUELDOS ]============//
    public static boolean buscar(int[] lista_sueldos){
        Scanner sc = new Scanner(System.in);
        while (true){
        
        System.out.println(ANSI_BLUE +"\n======[  Escriba -1 para volver al menu  ]======" + ANSI_RESET);
        System.out.print(ANSI_YELLOW + "====[  Escriba el ID del empleado:  ]====\n>>> "+ ANSI_RESET);
        int num_emp = sc.nextInt();
        if (num_emp > lista_sueldos.length -1 ){
            limpiar();
            System.out.println(ANSI_RED + "\t====[  ERROR  ]====");
            System.out.println("=[ No existe empleado con ID " + num_emp + " ]=" + ANSI_RESET);
            continue;
        }else if(num_emp == -1){return false;}
        else{
            limpiar();
            System.out.println(ANSI_GREEN + "\t====[  EXITO  ]====");
            System.out.println(ANSI_GREEN + "====[  Empleado " + num_emp +" Sueldo >> " + lista_sueldos[num_emp] + "  ]====" + ANSI_RESET);
            continue;
          }}
        }
    

        
    //=========[  BUSCAR RANGO DE SUELDOS  ]=========//
    public static void rangoSueldos(int[] lista_sueldos){
        Scanner sc = new Scanner(System.in);
        int total = 0;
        System.out.println(ANSI_YELLOW + "============[  MENU BUSCAR RANGO  ]============" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "====[  Buscar valor entre [...] y [...]  ]====");
        int num1 = sc.nextInt();
        limpiar();
        System.out.println("========[  Buscar valor entre " + ANSI_YELLOW + num1+ ANSI_BLUE + " y [...]  ]========" );
        int num2 = sc.nextInt();
        limpiar();
        System.out.println("\t\t\t\t========[  Los sueldos entre " + ANSI_YELLOW +num1 +ANSI_BLUE +" y " +ANSI_YELLOW  +num2 + ANSI_BLUE+" son:  ]========");
        for(int i = 0; i < lista_sueldos.length ; i++){
            
            if (lista_sueldos[i] > num1-1 && lista_sueldos[i] < num2+1){
                System.out.println("\t\t\t\tEmpleado " +ANSI_YELLOW +i +ANSI_RESET+ " Sueldo >> " + lista_sueldos[i]);
                System.out.println("\t\t\t\tTOTAL = " + total);
            }
        }
        if(total == 0){
            System.out.println(ANSI_RED + "\t\t\t\t====[  Ningun sueldo entra en el rango  ]====" + ANSI_RESET);
        }
    }

    //==========[  CALCULAR PROMEDIO DE SUELDOS  ]=========//

    public static void promedio(int[] lista_sueldos){
        float suma = 0;
        for(int i = 0; i < lista_sueldos.length;i++){
            suma += lista_sueldos[i];
        }
        System.out.println("=====[  El promedio de todos los sueldos es:  ]=====");
        System.out.println("======> " + suma / lista_sueldos.length + "$");
        

    }


    //==========[  AUMENTAR SUELDO  ]=========//
    public static float aumentar(int[] lista_sueldos){
        Scanner sc = new Scanner(System.in);
        int id = 0;
        int porcentaje = 1;
        Boolean salir = false;
        System.out.println("\n======[  Para volver escriba -1  ]======");
        System.out.println("======[  Tenga en cuenta que solo puede aumentar entre 5% y 10% a empleados entre 15000$ y 25000$");
        
        while(!salir){
        
        
        System.out.print("\n======[ Escriba el ID del empleado ]==== \n>>> "); 
        id = sc.nextInt();
        
        
        if (id == -1){
            System.out.println("\n=======[  Volviendo al menu...  ]========");
            salir = true;
            break;
            
           
            
        }else if(id > lista_sueldos.length -1){
            System.out.println("\n======[   ERROR   ]======");
            System.out.println("======[  ID del empleado no existe  ]======");
            System.out.println("======[  Rango valido entre 0 y " + (lista_sueldos.length-1) + "  ]======");
            continue;
       
        }else if(25000 < lista_sueldos[id] || 15000 > lista_sueldos[id]){
            System.out.println("======[  ERROR  ]======");
            System.out.println("======[  El sueldo del empleado no cumple los requisitos  ]======");
            System.out.println("======[  El sueldo actual del empleado " + id + " es " + lista_sueldos[id] + "  ]======");
            continue;
        }       
        else;
          
       
        
        while(true){
       
        System.out.println("\n======[  Escriba el porcentaje a aumentar  ]======");
        porcentaje = sc.nextInt();
        if(porcentaje == -1){break;}
        else if(lista_sueldos[id] > 25000 ){System.out.println("======[  El sueldo del empleado a superado el limite  ]======"); break;}
        else if (5 > porcentaje || 10 < porcentaje){
            System.out.println("======[  ERROR  ]======");
            System.out.println("======[  Solo aumento entre 5% y 10%  ]======");
            continue;
            
        }
        else;
        lista_sueldos[id] = lista_sueldos[id] + lista_sueldos[id]*porcentaje/100;
        System.out.println("====[   Sueldo aumentado con exito  ]====");
        System.out.println("====[  " + " Empleado " + id + " Sueldo >> " + lista_sueldos[id] + "$  ]====");
        
        
        
        
    }
    }    
    return porcentaje;
    }


    //===========[  SUELDO MINIMO  ]=========//
     
    public static void min(int[] lista_sueldos){
        limpiar();
        int ordenados[] = new int[lista_sueldos.length];
        for(int i = 0; i<lista_sueldos.length;i++)
        {
            ordenados[i] = lista_sueldos[i];
            
        }
        Arrays.sort(ordenados);
        System.out.println(ANSI_CYAN + "\n=======[  Sueldos mas bajos:  ]==========");
        for(int i = 0 ; i < lista_sueldos.length ; i++){
            if (lista_sueldos[i] == ordenados[0]){
                System.out.println("Empleado " + i + " Sueldo >> " + lista_sueldos[i] + "$");
            }
       }System.out.println("=========================================" + ANSI_RESET);
    }


    //==============[  SUELDO MAXIMO  ]============//
    
    public static void max(int[] lista_sueldos){
        limpiar();
        int ordenados[] = new int[lista_sueldos.length];
        for(int i = 0; i<lista_sueldos.length;i++)
        {
            ordenados[i] = lista_sueldos[i];
            
        }
        Arrays.sort(ordenados);
        System.out.println(ANSI_CYAN + "\n=======[  Sueldos mas altos:  ]==========");
        for(int i = 0 ; i < lista_sueldos.length ; i++){
            if (lista_sueldos[i] == ordenados[ordenados.length-1]){
                
                System.out.println("Empleado " + i + " Sueldo >> " + lista_sueldos[i] + "$");
                
            }
       }System.out.println("=========================================" + ANSI_RESET);
    }
    public static void menu(){
            
            System.out.println(ANSI_BLUE + "\n------------------------|======================"+ANSI_YELLOW +"[ MENU PRINCIPAL ]"+ANSI_BLUE+"=====================|");
            System.out.println("\t\t\t| 01- Cargar sueldos           | 02- Mostrar sueldos          |");
            System.out.println("\t\t\t| 03- Buscar sueldos           | 04- Rango de sueldos         |");
            System.out.println("\t\t\t| 05- Sueldo promedio          | 06- Aumentar sueldo          |");
            System.out.println("\t\t\t| 07- Mostrar sueldo mas bajo  | 08- Mostrar sueldo mas alto  |");
            System.out.println("------------------------|_________________________/"+ ANSI_RED + "09- Salir"+ ANSI_RESET + ANSI_BLUE +"\\_________________________|");
            System.out.print("\n\t\t\t>>> " + ANSI_RESET);
    }




//================================//
//===========[  MAIN  ]===========//
//================================//
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        int op = 0; 
        limpiar();
        System.out.println(ANSI_GREEN + "=======[  Bienvenido al sistema  ]=======" + ANSI_RESET);       
        System.out.print(ANSI_BLUE + "\n====[  Escriba la cantidad de empleados  ]=====\n>>> " + ANSI_RESET);
        int empleados[] = new int[sc.nextInt()];
        limpiar();
        while (op != 9){
            menu();
            
            op = sc.nextInt();
            limpiar();
            if (op == 1){
                cargarSueldo(empleados);
            }else if (op == 2){
               mostrarSueldo(empleados);
            }else if (op == 3){
                buscar(empleados);
            }else if (op == 4){
                rangoSueldos(empleados);
            }else if (op == 5){
                promedio(empleados);
            }else if (op == 6){
                aumentar(empleados);
            }else if (op == 7){
                min(empleados);
            }else if (op == 8){
                max(empleados);
            }
            
        }System.out.println("====[  Cerrando programa...  ]====");
    }

}
