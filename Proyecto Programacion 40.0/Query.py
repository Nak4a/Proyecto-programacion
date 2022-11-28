import pymysql
def sql(query):
    connection = pymysql.connect(
        host="localhost",
        user="root",
        passwd="Pelotudo123",
        db="empleados"
    )
    cursor = connection.cursor()
    cursor.execute('USE empleados')
    connection.commit()
    query = cursor.execute(query)
    connection.commit()
    result = cursor.fetchall()  
    return result