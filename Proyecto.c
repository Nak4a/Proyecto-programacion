#include <stdio.h>
#include <stdbool.h>
#include<stdlib.h>
void cargarSueldos(int lista_sueldos[], int tamano){
    printf("Escriba el sueldo para cada empleado\n");
    for(int i=0; i< tamano; i++){
        printf("\nEmpleado %d Sueldo >> ",i);
        scanf("%d",&lista_sueldos[i]);
    }
}

void mostrarSueldos(int lista_sueldos[],int tamano){
    printf("SUELDOS\n");
    for(int i = 0; i < tamano;i++){
        
        printf("\nEmpleado %d Sueldo >> %d",i,lista_sueldos[i]);
    }
}

bool buscar(int lista_sueldos[], int tamano){
    int id;
    printf("Escriba el ID del empleado: ");
    scanf("%d",&id);
    for(int i = 0; i< tamano; i++){
        if(i == id){
            printf("Empleado %d Sueldo >> %d",i,lista_sueldos[i]);
            return true;
        }
    }
    return true;
}


void rangoSueldos(int lista_sueldos[], int tamano){
    int num1;
    int num2;
    printf("Escriba el numero mas bajo del rango: ");
    scanf("%d",&num1);
    printf("Escriba el numero mas alto del rango: ");
    scanf("%d",&num2);
    for(int i = 0 ; i < tamano ; i++ ){
        if( lista_sueldos[i] >= num1 && lista_sueldos[i] <= num2){
            printf("\nEmpleado %d Sueldo >> %d\n",i,lista_sueldos[i] );
        }

    }
    
}

float promedio(int lista_sueldos[], int tamano){
        int total = 0;
        for(int i = 0; i < tamano; i++){
            total += lista_sueldos[i];
        }
        printf("El promedio de los sueldos es: %d",total/tamano);
        return total/tamano;
}

float aumentar(int lista_sueldos[], int  tamano){
    int porcentaje;
    int id;
    while (true){
    id = 0;
    printf("\nEscriba el id del empleado con un sueldo entre 15000 y 25000\n");
    printf("Escriba -1 para salir\n");
    scanf("%d",&id);
    if(id == -1){system("clear");return 0.0;}
    else if (id > tamano || id < 0){printf("\nERROR -> ID invalido\n"); continue;}
    else if (lista_sueldos[id] < 15000 || lista_sueldos[id] > 25000){printf("\nERROR -> Sueldo del empleado invalido\n"); continue;}
    else
    printf("Escriba el porcentaje a aumentar, este debe estar entre 5% y 10%\n");
    scanf("%d",&porcentaje);
    if(porcentaje < 5 || porcentaje > 10){printf("\nERROR -> Porcentaje fuera de rango\n"); continue;}
    else
    printf("\nSUELDO ANTIGUO -> %d\n",lista_sueldos[id]);
    lista_sueldos[id] = lista_sueldos[id] + lista_sueldos[id]*porcentaje/100;
    printf("\nSUELDO NUEVO -> %d\n",lista_sueldos[id]);
    }
    return lista_sueldos[id];
}

int main(){
    int op;
    int cantidad;
    printf("\nBienvenido al Sistema\n");
    printf("\nEscriba la cantidad de empleados: \n");
    scanf("%d",&cantidad);
    system("clear");
    int empleados[cantidad];
    int tamano = sizeof(empleados) / sizeof(empleados[0]);
    while (true){
        
    
    printf("\nMENU PRINCIPAL \n");
    printf("Escoja una opcion:\n");
    printf("1- Cargar Sueldos\n");
    printf("2- Mostrar sueldos\n");
    printf("3- Buscar Sueldo\n");
    printf("4- Buscar por rango\n");
    printf("5- Promedio\n");
    printf("6- Aumentar\n");
    scanf("%d",&op);
    system("clear");
    if(op == 1){cargarSueldos(empleados,tamano);}
    else if(op == 2){mostrarSueldos(empleados,tamano);}
    else if(op == 3){buscar(empleados,tamano);}
    else if(op == 4){rangoSueldos(empleados,tamano);}
    else if(op == 5){promedio(empleados,tamano);}
    else if(op == 6){aumentar(empleados,tamano);}
    
    }
    return 0;
}