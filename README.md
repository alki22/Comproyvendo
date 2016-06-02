# Compro y Vendo: Readme
![Compro y Vendo logo](http://s33.postimg.org/v0r64j373/ic_launcher.png)
## ¿Qué es Compro y Vendo?
Compro y Vendo es una aplicación de inventario para llevar un registro de los productos que el usuario tiene a la venta y calcular sus márgenes de ganancia.
## ¿Cómo funciona?
### Estructura básica:
Compro y Vendo funciona en base a Java y una base de datos SQLite (detallado en *DBHandler*). El usuario ingresa a a aplicación y se le presentan tres opciones:
- Añadir un producto nuevo ingresando sus parámetros por *EditText*, envía Toasts si los parámetros no son correctos.
- Visualizar su inventario y eliminar productos del mismo. Éste se genera en base al modelo de producto en **product_info.xml**.
- Ver datos acerca de las ganancias proyectadas. 
### Clases:
- **MainActivity**: Clase principal, se encarga de seleccionar una de las otras activities cuando se selecciona el boton correspondiente.
- **AddProduct**: Actividad encargada de agregar productos a la base de datos, toma cuatro parámetros ingresados mediante *EditText*.
- **ProductList**: Actividad que muestra una lista de los objetos publicados.
- **EarningData**: Actividad que muestra datos sobre los objetos publicados : *ganancia total*, *ganancia promedio*
- **DBHandler**: Métodos básicos para el manejo de una base de datos.
- **Product**: Estructura de un producto.
- **Earnings**: Estructura para mostrar los datos respecto a las ganancias de una manera más fácil.
## ¿Qué se le puede agregar en el futuro?
- Tengo pensado cambiar pronto el sistema de manejos arcaico por un ORM para eficientizarlo y ahorrarme lineas de código.
- Añadir un campo de imagen a la base de datos para hacer un poco más completa a la aplicación.
- Añadir inicio de sesión con redes sociales y compartir los productos en las mismas mediante una plantilla de imagen.
## Información
### Versión
**1.0**