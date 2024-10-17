### Un Simple Enunciado - La perfumeria ###

Una perfumería desea un programa que procese los datos de las ventas que realiza. En cada Venta se 
registran los siguientes datos: el número de factura, importe de la factura, el tipo de factura (A, B, C o E), 
el nombre de la persona que realiza la compra, y el tipo del perfume vendido (un número entero para indicar su marca,
entre 1 y 17, por ejemplo: 1: Chanel, 2: Paco Rabanne, etc.). Se desea almacenar la información referida a las ventas 
que realiza la perfumería en una coleccion de tipo Venta (definir el tipo Venta y cargar n por teclado).



1- Cargar una colección de objetos del tipo Venta el archivo "ventas.csv".
2- Mostrar todos los datos de las ventas cuyo importe de factura sea mayor a x y el tipo de la factura sea distinto 
de t (x y t son valores que se cargan por teclado). El listado debe salir ordenado el nombre de las personas que 
realizaron la compra.
3- Determinar y mostrar el importe total facturado para uno de los 17 tipos posibles.
4- Mostrar por pantalla el número de factura, el comprador y el importe, de todas las ventas cuyo tipo de perfume 
se encuentre entre 5 y 12 y que no sean con factura de tipo C. Si no existe ninguna venta que cumpla con ese criterio 
disparar NoSuchElementException.
5- Obtener una sublista de ventas, para aquellas ventas de un tipo de factura determinada. Si no existen elementos,
disparar NoSuchElementException 