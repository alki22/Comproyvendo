# Compro y Vendo: Readme

## ¿Qué es Compro y Vendo?
Compro y Vendo es una aplicación de inventario para llevar un registro de los productos que el usuario tiene a la venta y calcular sus márgenes de ganancia.
## ¿Cómo funciona?
### Estructura básica:
Compro y Vendo funciona en base a Java y una base de datos SQLite (detallado en *DBHandler*). El usuario ingresa a a aplicación y se le presentan tres opciones:
- Añadir un producto nuevo ingresando sus parámetros por *EditText*, envía Toasts si los parámetros no son correctos.
- Visualizar su inventario. Éste se genera en base al modelo de producto en **product_info.xml**.
- Ver sus datos económicos. 

### Clases:
- **MainActivity**: Clase principal, se encarga de seleccionar una de las otras activities cuando se selecciona el boton correspondiente.
- **AddProduct**: Actividad encargada de agregar productos a la base de datos, toma cuatro parámetros ingresados mediante *EditText*.
- **ProductList**: Actividad que muestra una lista de los objetos publicados.
- **EarningData**: Actividad que muestra datos sobre los objetos publicados : *ganancia total*, *ganancia promedio*
- **DBHandler**: Métodos básicos para el manejo de una base de datos.
- **Product**: Estructura de un producto.
- **Earnings**: Estructura para mostrar los datos respecto a las ganancias de una manera más fácil.

## Información
### Versión
**1.0**


