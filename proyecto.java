import java.util.*;
public class proyecto{
    
    //========[  CARGAR SUELDOS  ]==========//
    public static void cargarSueldo(int[] lista_sueldos){
        Scanner sc = new Scanner(System.in);
        System.out.println("====[  Escriba el sueldo  ]====");
        for(int i= 0; i<lista_sueldos.length;i++){
            System.out.print(     "Empleado " + i + " Sueldo >> ");
            lista_sueldos[i] = sc.nextInt();
        
        }
        
    }

    //========[  MOSTRAR SUELDOS  ]==========//
    public static void mostrarSueldo(int[] lista_sueldos){
        System.out.println("      ======[  Sueldos  ]======");
        for(int i=0;i < lista_sueldos.length; i++){
            System.out.println("====[  Empleado " + i + " Sueldo >> " + lista_sueldos[i] + "$  ]====");
        }
    }


    //=========[  BUSCAR SUELDOS ]============//
    public static boolean buscar(int[] lista_sueldos){
        Scanner sc = new Scanner(System.in);
        
        while (true){
        System.out.println("\n======[  Escriba -1 para volver al menu  ]======");
        System.out.print("====[  Escriba el ID del empleado:  ]====\n>>> ");
        int num_emp = sc.nextInt();
        if (num_emp > lista_sueldos.length -1 ){
            System.out.println("====[  ERROR  ]====");
            System.out.println("=[ No existe empleado con ID " + num_emp + " ]=");
            continue;
        }else if(num_emp == -1){return false;}
        else{
            System.out.println("====[  Empleado " + num_emp +" Sueldo >> " + lista_sueldos[num_emp] + "  ]====");
            continue;
          }}
        }
    

        
    //=========[  BUSCAR RANGO DE SUELDOS  ]=========//
    public static void rangoSueldos(int[] lista_sueldos){
        Scanner sc = new Scanner(System.in);
        System.out.println("====[  Buscar valor entre [...] y [...]  ]====");
        
        int num1 = sc.nextInt();
        System.out.println("========[  Buscar valor entre " + num1 + " y [...]  ]========" );
        int num2 = sc.nextInt();
        System.out.println("========[  Los sueldos entre " + num1 + " y " + num2 + " son:  ]========");
        for(int i = 0; i < lista_sueldos.length ; i++){
            if (lista_sueldos[i] > num1-1 && lista_sueldos[i] < num2+1){
                System.out.println("Empleado " + i + " Sueldo >> " + lista_sueldos[i]);
            }
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
        int ordenados[] = new int[lista_sueldos.length];
        for(int i = 0; i<lista_sueldos.length;i++)
        {
            ordenados[i] = lista_sueldos[i];
            
        }
        Arrays.sort(ordenados);
        System.out.println("\n=======[  Sueldos mas bajos:  ]==========");
        for(int i = 0 ; i < lista_sueldos.length ; i++){
            if (lista_sueldos[i] == ordenados[0]){
                System.out.println("Empleado " + i + " Sueldo >> " + lista_sueldos[i] + "$");
            }
       }System.out.println("=========================================");
    }


    //==============[  SUELDO MAXIMO  ]============//
    
    public static void max(int[] lista_sueldos){
        int ordenados[] = new int[lista_sueldos.length];
        for(int i = 0; i<lista_sueldos.length;i++)
        {
            ordenados[i] = lista_sueldos[i];
            
        }
        Arrays.sort(ordenados);
        System.out.println("\n=======[  Sueldos mas altos:  ]==========");
        for(int i = 0 ; i < lista_sueldos.length ; i++){
            if (lista_sueldos[i] == ordenados[ordenados.length-1]){
                
                System.out.println("Empleado " + i + " Sueldo >> " + lista_sueldos[i] + "$");
                
            }
       }System.out.println("=========================================");
    }
    
    public static void menu(){
            System.out.println("\n=======[ MENU PRINCIPAL ]=======");
            System.out.println("| 01- Cargar sueldos           |");
            System.out.println("| 02- Mostrar sueldos          |");
            System.out.println("| 03- Buscar sueldos           |");
            System.out.println("| 04- Rango de sueldos         |");
            System.out.println("| 05- Sueldo promedio          |");
            System.out.println("| 06- Aumentar sueldo          |");
            System.out.println("| 07- Mostrar sueldo mas bajo  |");
            System.out.println("| 08- Mostrar sueldo mas alto  |");
            System.out.println("| 09- Salir                    |");
            System.out.print("================================\n>>> ");
    }




//================================//
//===========[  MAIN  ]===========//
//================================//
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        int op = 0; 
        System.out.println("=======[  Bienvenido al sistema  ]=======");       
        System.out.print("\n====[  Escriba la cantidad de empleados  ]=====\n>>> ");
        int empleados[] = new int[sc.nextInt()];
        while (op != 9){
            menu();
            
            op = sc.nextInt();
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
