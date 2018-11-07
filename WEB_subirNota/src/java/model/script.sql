create database asd;
use asd; -- drop database asd

create table docentes(
    id int auto_increment,
    nombre varchar (100),
    primary key (id)
); -- select * from docentes

insert into docentes values (null, 'Julio');
insert into docentes values (null, 'Fernando');
insert into docentes values (null, 'Andrés');

create table cursos(
    id int auto_increment,
    nombre varchar (100),
    docente int,
    asignar boolean,
    primary key (id),
    foreign key (docente) references docentes (id)
); -- select * from cursos

insert into cursos values (null, 'Lenguaje', 1, true);
insert into cursos values (null, 'Matematicas', 2, true);
insert into cursos values (null, 'Historia', 3, true);
insert into cursos values (null, 'Filosofia', 1, false);

create table alumnos (
    id int auto_increment,
    nombre varchar (100),
    primary key (id)
); -- select * from alumnos

insert into alumnos values (null, 'Pedro');
insert into alumnos values (null, 'Felipe');
insert into alumnos values (null, 'Brayan');

create table alumnoCurso(
    id int auto_increment,
    alumno int,
    curso int,
    primary key (id),
    foreign key (alumno) references alumnos(id),
    foreign key (curso) references cursos(id)
); -- select * from alumnoCurso;

insert into alumnoCurso values (null, 1, 1);
insert into alumnoCurso values (null, 2, 2);
insert into alumnoCurso values (null, 3, 3);
insert into alumnoCurso values (null, 3, 4);
insert into alumnoCurso values (null, 3, 1);

-- Muestra los alumnos en una asignatura
select alumnos.id as 'Id', alumnos.nombre as 'Alumno', cursos.nombre as 'Asignatura' 
from alumnos, cursos, alumnoCurso
where alumnoCurso.alumno = alumnos.id and alumnoCurso.curso = cursos.id
and cursos.nombre like '%Lenguaje%'

-- Muestra los alumnos de una asignatura con la condición True
select alumnos.nombre as 'Alumno', cursos.nombre as 'Asignatura'
from alumnos, cursos, alumnoCurso
where alumnoCurso.alumno = alumnos.id and alumnoCurso.curso = cursos.id
and cursos.asignar like true

-- Muestra las asignaturas que hace un docente
select docentes.nombre as 'Docente', cursos.nombre as 'Asignatura'
from docentes, cursos
where cursos.docente = docentes.id
and docentes.id like '%1%'

select * from cursos where asignar =false
select * from cursos;
update cursos set cursos.asignar = false where id=1;