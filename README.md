# angularjs-backend
angularjs-backend


Backend de soporte para la sección 06 curso de udemy Angular js

https://www.udemy.com/course/angularjs-en-espanol/

Hay que modificar el fichero application.properties para configurar la conexión con Mysql.

Dentro del curso está la información para crear la base de datos de Mysql

Esta aplicación usa la libreria lombok. Si usas eclipse hay que seguir las instrucciones para añadir lombok al entorno de desarrollo.

https://projectlombok.org/download

La url del endpoint para bajar los alumnos:
http://localhost:8080/universidad/api/students/

CORS ORIGINS 
Por defecto está configurado para la url:
http://localhost

Para modificarlo hay que cambiar la clase:
/angularjs-backend/src/main/java/org/chuix/training/universidad/backend/config/ApplicationConstant.java
