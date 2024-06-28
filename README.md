<h1>API Rest de Davi_Foro</h1>
Este es un proyecto hecho con **Java** y **Spring** 
Se comunica por medio de los protocolos http

<h2>Usuario</h2>
  Es un modelo de API Rest que simula un foro en el cual se pueden generar usuarios con sus respectivos campos.
  ![2024-06-27-22-52-53](https://github.com/ESTILTRT/Davi-Foro/assets/157448750/7e810fad-f48c-43fd-a372-a19e5a1c0aaf)

  Tambien tiene el metodo de autenticacion del usuario que funciona por medio del email quie se introdujo
    Este genera un **Token** que es el que permitira lograr entrar dentro de los controller.
  ![2024-06-27-23-17-12](https://github.com/ESTILTRT/Davi-Foro/assets/157448750/86c6fbb5-9f76-4e07-8bf6-6de1ff361911)

  Ejemplo de cómo usar el barrer para la documentación.
  ![barer](https://github.com/ESTILTRT/Davi-Foro/assets/157448750/f44b119a-734d-4a85-a5c9-2c81dd1dbc58)


<h2>Controllers</h2>
  Esta zona está basada por 2 controllers principales que son: Cursos y Tópicos, el cual es el principal de este proyecto.

  <h3>Cursps</h3>
    Este es el generador de cursos, el cual trabaja con el tipo de curso que es (backend, frontend, base de datos, ciberseguridad).
  ![curso](https://github.com/ESTILTRT/Davi-Foro/assets/157448750/482da478-ef12-46e7-93d7-31a084337cbc)

  <h2>**Topicos**</h2>
    Aquí es donde más se enfoca el proyecto, ya que este tiene varios métodos que se encargan de hacer el **CRUD** de los mismos.
  
  <h4>Crear topico</h4>
    Este pide el título, mensaje, usuario y curso al que pertenece el usuario para generar el tópico de la pregunta, además
      de que directamente guarda la fecha y hora de la publicación.
  ![CrearForo](https://github.com/ESTILTRT/Davi-Foro/assets/157448750/a38a534f-e0a5-4428-80d2-1c3d13d174fa)

  <h4>Paginado y detalle de un solo topico</h4>
    Como el nombbre indica aqui se muestra el como se ve la paginacion de todos los topicos       
  ![paginacion](https://github.com/ESTILTRT/Davi-Foro/assets/157448750/3d420c11-937f-4ec0-a61c-e616c6022482)
    
  Esto es el detalle de un solo topico
  ![id](https://github.com/ESTILTRT/Davi-Foro/assets/157448750/0f46b863-46b5-4956-ac36-553de54e9fb2)

  <h4>Eliminar</h4>
    Este se encarga de eliminar el tópico de la base de datos por medio del ID.
  ![2024-06-28 00-13-24](https://github.com/ESTILTRT/Davi-Foro/assets/157448750/dac6be91-f424-479a-b29d-b8ba40a0b1ad)

  <h4>modificacion</h4>
    Este, al igual que el anterior, se maneja por el ID y solo se puede modificar el título o el mensaje del tópico.
    ![2024-06-28 00-23-50](https://github.com/ESTILTRT/Davi-Foro/assets/157448750/b0c5e8a8-554b-4a10-abda-7517e54b7d52)
