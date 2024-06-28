CREATE TABLE topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(400),
    autor_id bigint not null,
    curso_id bigint not null,
    fecha datetime not null,
    status tinyint not null,
    primary key(id),
    constraint fk_topicos_autor_id foreign key(autor_id) references usuarios(id),
    constraint fk_topicos_curso_id foreign key(curso_id) references cursos(id)
);