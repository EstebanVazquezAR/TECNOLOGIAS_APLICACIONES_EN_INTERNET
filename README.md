# TECNOLOGIAS_APLICACIONES_EN_INTERNET
Proyecto Final Unidad 03

### Vazquez Rivera Angel Esteban
### 1930445

# INSTRUCCIONES
- 3 Mesas y Meseros minimo 

El proyecto que tiene que realizar es el siguiente:

Una aplicación que realice un punto de venta de una cafetería, 
dicha aplicación contendrá las siguientes características:

# Tres menús, dependiendo la hora se mostrará un menú:

------COMPLETO--------de las 8:00 a las  12:00 de manera automática se mostrará el menú de desayunos, 
------COMPLETO--------de las 12:01 a las 18:00 se mostrará el menú de comidas y 
------COMPLETO--------de las 18:01 a las 23:00 se mostrará el menú de las cenas.


COMENSAL 
--- VISTA   Contemplar el # de ma mesa
---- Con la lista de comida y monto total de consumo 
--COMPLETO--  donde puede colocar pedido de antojos extras
--COMPLETO--  donde puede agregar mas refrescos 
--COMPLETO--  donde puede agregar mas comida del menu 
---- Cuando termina de comer debe de pedir cerrar la cuenta (mesero debe de confirmar el pago para cerrar la cuenta)

MESERO 
---VISTA 
-----COMPLETO (API-Agrupar por pedidos de mesa Consumir api Acciones)------  Mesero para hacer orden 
-----COMPLETO----  donde puede agregar mas refrescos 
-----COMPLETO----  donde puede agregar mas comida del menu 
--COMPLETO (API-Agrupar por pedidos de mesa Consumir api Acciones)--- las mesas con sus respectivas ordenes
--COMPLETO (API-Agrupar por pedidos de mesa Consumir api Acciones)--- cada mesa debera de tener el monto total a cobrar 
--FALTA--- boton de pedir Orden cambiar status en todas las RER a 2 en preparacion
--FALTA---/ Mesero debe de realizar cobro a mesa y confirmar el pago para cambiar status a 5 Pagado
--FALTA---/ Mesero debe de limpiar mesa y order todo cambiar status a 6 Mesa Libre 

COCINERO 
--COMPLETO (API-Agrupar por pedidos de mesa Consumir api Acciones)-- Vista de los pedidos que debe de realizar por mesa (Ver detalle de la orden)
---- Comida y antojos que solicita cada mesa -- directo al cocinero Status 2
---- Cuando esta listo el antojo -- pasa al mesero  status 3
----//  Notificación cuando las ordenes estan listas para comida extra (antojitos)

ADMIN
---VISTA
--COMPLETO-- Registrar Empleados con password
---- Los empleados solo podrán cambiar la contraseña de su cuenta.




APi que cambie status por mesa 
APi que cambie status por bebida, comida, comida extra 