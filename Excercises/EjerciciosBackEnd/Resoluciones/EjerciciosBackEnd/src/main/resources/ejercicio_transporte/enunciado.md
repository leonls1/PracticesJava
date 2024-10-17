### Enunciado Practica Vectores y Objetos ###

Una empresa de logística nos ha solicitado el desarrollo de un programa bajo el enfoque del Paradigma Orientado a Objetos con el propósito de conocer información referida al transporte de distintas mercaderías en sus diferentes rutas. Se detallan las clases identificadas para el dominio bajo estudio:

* **Transporte:** matrícula, precio base, nombre.
* **Aereo:** es un Transporte que además contiene total bultos, precio del combustible
* **Maritimo:** es un Transporte que además contiene tipo de buque (1 Cerealero, 2 Tanquer, 3 Containers) y total de toneladas transportada,
* **HojaRuta:** que contiene un código, un origen, un destino, el nombre del cliente, y el transporte que se usará para enviar la mercadería
* **Logistica:** un vector de objectos de hojas de ruta  mes y año en que se realizaron los envíos

Con lo expuesto anteriormente, usted deberá implementar:

1. Crear todas las clases y jerarquias presentes en el enunciado
2. Procesar un archivo csv con todas las hojas de rutas que se deben cargar en el vector de objetos que tiene la clase Logistica
3. Inocorporar  la posibilidad de Agregar una hoja de Ruta 
4. Realizar el total de carga por la hoja de ruta por los siguientes criterios:
    1. Transporte Aereo: Al precio base del transporte se le suma el precio del combustible y se le suman 250 dolares por cada bulto que se transporta
    2. Transporte Maritimo: Al precio base del tranporte se le suma 450 dolares por tonelada transportada y adicionalmente se le cobra un seguro por tipo de barco de una suma igaul a el 40 % del precio base 


