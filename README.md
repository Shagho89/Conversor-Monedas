# Conversor-Monedas
Challenge Conversor Monedas
En la clase principal tenemos un menu:
1. Poner la 1era moneda a convertir
2. Poner la 2da moneda a convertir
3. poner el valor a convertir
4. Salir
La forma de utilizar el menu es a traves de un Scanner, como entrada de usuario, escoge entre 1 y 4 dependiendo de lo que se quiera realizar.

La clase solicitudes, utiliza el HttpClient y el HttpResponse, como comunicarse con la API de Exchange rate y tomar el valor de la conversicón entre las monedas

La clase datos es un record, que utilizamos para guardar los datos de moneda base, moneda convertida, monto y tasa para poderlos utilizar 
en la clase principal en el bloque try catch

La clase convertir archivo, utiliza la biblioteca Writer, para crear un arcicho Json que permita guardar las monedas convertidas.


