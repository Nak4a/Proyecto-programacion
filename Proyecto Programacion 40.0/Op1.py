from Query import sql
import PySimpleGUI as sg
class Cargar():
    def __init__(self):
        #Layout
        self.Text1 = [sg.Text('Para cada empleado, escribe el Nombre, el Apellido, y su Sueldo')]
        self.Nombre = [sg.Text("Nombre: "),sg.InputText(key="Nombre")]
        self.Apellido = [sg.Text("Apellido: "),sg.InputText(key="Apellido")]
        self.Sueldo = [sg.Text("Sueldo: "),sg.InputText(key="Sueldo")]
        self.Send = [sg.Button("Enviar",key="send",size=(5,2))]
        self.Error = [sg.Text("Error, el sueldo no puede contener letras",visible=False,key="Error",text_color="red")]
        self.Vacio = [sg.Text("Error, No puede haber ninguna informacion vacia",visible=False,key="Vacio",text_color="red")]
        layout = [[self.Text1,self.Nombre,
                  self.Apellido,self.Sueldo,self.Send,
                  self.Error,self.Vacio
                  ]
                 ]       
        #Window
        window = sg.Window('Cargar Empleados',
                            layout,margins=(100,100))
        while True:
            event, value = window.read()
            if event == sg.WINDOW_CLOSED:
                break
            if event == "send":
                Valido = True
                for l in value['Sueldo']:
                    for x in "qwertyuiopasdfghjklzxcvbnm":
                        if(l == x):
                            Valido = False
                
                if value["Nombre"].rstrip() == "" or value["Apellido"].rstrip() == "" or value["Sueldo"].rstrip() == "":
                    window["Vacio"].Update(visible=True)            
                elif Valido:
                    window["Vacio"].Update(visible=False)   
                    window["Error"].Update(visible=False)
                    sql(f"INSERT INTO Main(Nombre,Apellido,Sueldo) values('{value['Nombre']}','{value['Apellido']}','{value['Sueldo']}');")
                    window["Nombre"].Update("")
                    window["Apellido"].Update("")
                    window["Sueldo"].Update("")
                else:
                    window["Vacio"].Update(visible=False)   
                    window["Error"].Update(visible=True)



class Mostrar():
    
    def __init__(self):
        self.emple = str(sql("Select * from Main;"))
        self.Text1 = [sg.Text("Mostrando Empleados...")]
        self.Text2 = [sg.Text("{}".format(f"{self.emple}\n"),key="Empleados")]
        layout = [self.Text1,(x for x in self.Text2)]

        window = sg.Window("Mostrar Sueldos",layout)
        while True:
            event, value = window.read()
            if event == sg.WINDOW_CLOSED:
                break
    

class Buscar():

    def __init__(self):
        self.Text1 = [sg.Text("Bienvenido al Menu de Busqueda")]
        self.Text2 = [sg.Text("Escriba el nombre y apellido del Empleado")]
        self.Input = [sg.Text("Nombre y Apellido: "),sg.InputText(key="Identificador")]
        self.Send = [sg.Button("Enviar",key="send")]
        self.Finish = [sg.Text("",key="Mostrar")]
        layout = [self.Text1,self.Text2,self.Input,self.Send,self.Finish]
        window = sg.Window("Menu Busqueda",layout)
        while True:
            event, value = window.read()
            if event == sg.WINDOW_CLOSED:
                break
            elif event == "send":
                identifier = value['Identificador'].split()
                try : 
                    identifier = sql(f"SELECT * FROM Main WHERE Nombre = '{identifier[0]}' and Apellido = '{identifier[1]}';")
                
                    if len(identifier) == 0:
                        window['Mostrar'].Update("Error, empleado no encontrado",text_color="red")
                    else:
                        window["Mostrar"].Update(f"Nombre: {identifier[0][0]} \nApellido: {identifier[0][1]} \nSueldo: {identifier[0][2]}",text_color="Yellow")
                except IndexError:
                    window['Mostrar'].Update("Escriba el Nombre Y el Apellido del Empleado",text_color="red")

class Rango():
    
    def __init__(self):
        self.Text1 = [sg.Text("")]