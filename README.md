# proyectofinal
proyecto Final java Fundamentas
### Endpoints

1. getAll
2. insert x request
3. update x id y request
4. activa x id
5. delete x id 
6. getById

### Uso de Aplicacion.
Ojo al ejecutar la aplicacion esta debe crear las respectivas tablas Usuario y Telefono.
1. Cambiar el usuario, clave y nombre de la BD en el archivo properties del proyecto java.
2. Ejecutar el siguiente script de creacion de BD.

CREATE TABLE telefonos(
telefono_id INT NOT NULL AUTO_INCREMENT,
numero INT NULL,
cod_ciudad INT NULL,
cod_pais INT NULL,
PRIMARY KEY (telefono_id)
);

CREATE TABLE usuario(
usuario_id INT NOT NULL AUTO_INCREMENT,
telefono_id INT NOT NULL,
UID VARCHAR(50) NULL,
nombre VARCHAR(50) NULL,
password VARCHAR(50) NULL,
correo VARCHAR(50) NULL,
PRIMARY KEY (usuario_id),
CONSTRAINT fk_usuarios_telefonos FOREIGN KEY (telefono_id)
REFERENCES telefonos(telefono_id)
);

commit;

3. (Opcional), Si se genera un error al ejecutar el Insertar usuario.

ALTER TABLE scalab.usuario ADD id INT auto_increment NOT NULL PRIMARY KEY;
ALTER TABLE scalab.usuario CHANGE id usuario_id int auto_increment NOT NULL;

4. importar el archivo collection en postman. ( si no funciona hay una carpeta en el interior del proyecto con el respectivo archivo postman)
   Link collection https://api.postman.com/collections/13440228-5af6f834-bfee-4aa4-9e7a-f75803653562?access_key=PMAT-01H434F12KF3KN71DF4S90VRYD

### Actuactor Link
http://localhost:8080/actuator/health

http://localhost:8080/actuator/metrics

http://localhost:8080/actuator/info

http://localhost:8080/actuator/env

