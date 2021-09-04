# Proyecto SpringBoot con H2
![image](https://user-images.githubusercontent.com/20958764/132104654-07348c4b-39ac-4e8e-9fb4-21c559a432c9.png)


Se añadieron los siguientes servicios:
- Crear Empleado
- Actualizar Empleado
- Eliminar Empleado
- Listar todos los empleados (Este Endpoint debe permitir filtrar por cargo o nombre)
estos parámetros son opcionales, si no se envía alguno de estos, debe traer todos los
empleados
- Retornar una lista con todos los cargos, y dentro de los cargos todos los empleados
ordenados por salario de mayor a menor

![image](https://user-images.githubusercontent.com/20958764/132104660-e2c6846b-df45-4228-9a39-2caa4f42bd78.png)

Para manejar las posiciones se tienen estos servicios:
![image](https://user-images.githubusercontent.com/20958764/132104677-dd4cc54b-cab4-4374-8113-9e22e8475df7.png)

Para manejar las personas se tienen estos servicisos:
![image](https://user-images.githubusercontent.com/20958764/132104688-26aea0ec-1d86-4a0e-bd75-abc1ea0acf65.png)

Testing: 

![image](https://user-images.githubusercontent.com/20958764/132104698-aa892636-17dd-4584-9290-f2fc9e137638.png)

- Se añadieron Test Unitarios para probar la inyeccion de dependencias y el funcionamiento de la capa Repository - JPA
- Se añadieron Test de integración para el file PositionRestControllerTest, para probar flujos a modo de ejemplo.


Detalles :
- Código escrito en inglés
- Comentarios escritos en español
- Filtrados por Query
- Para el servicio para listar empleados por filtros, solo se está usando el de nombre, como se puede ver en la imagen el empleado y la persona son un entidad como una sola separadas solo por el salario,
si se desea filtrar por nombre solo seria por el nombre de la "posicion" por lo que filtrar por "cargo" seria lo mismo.

Entonces un ejemplo sería llamar a esta ruta http://localhost:8080/v1/api/employe?name=dev

![image](https://user-images.githubusercontent.com/20958764/132104746-4df9f58c-bbaf-4203-b312-003e16267567.png)


Gracias!


