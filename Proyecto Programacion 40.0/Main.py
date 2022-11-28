import PySimpleGUI as sg
import Op1
import pymysql

class Main():

    def __init__(self):
        self.Text1 = [sg.Text('Bienvenido!!!')]
        self.Text2 = [sg.Text('Este es el Menu Principal')]
        self.Text3 = [sg.Text('Escoja una Opcion:')]
        self.OP1 = [sg.Button('Cargar Empleados',key="Uno"),sg.Button('Mostrar Empleados [Cuidado]',key="Dos")]
        self.OP2 = [sg.Button("Buscar Empleados",key="Tres")]

sg.theme('DarkAmber')
m = Main()
layout = [m.Text1,m.Text2,m.Text3,m.OP1,m.OP2]
window = sg.Window('Menu Principal',layout,background_color='')
while True:
    event,values = window.read()
    if event == sg.WIN_CLOSED:
        break
    elif event == "Uno":
        Op1.Cargar()     
    elif event == "Dos":
        Op1.Mostrar()
    elif event == "Tres":
        Op1.Buscar()
    elif event == "Cuatro":
        Op1.Rango()

