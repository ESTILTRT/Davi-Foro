CREATE TABLE usuarios(
    id bigint not null auto_increment,
    nombre_usuario varchar(100) not null,
    clave varchar(400) not null,
    correo varchar(100) not null unique,
    activo tinyint not null,
    primary key(id)
);