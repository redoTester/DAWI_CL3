create database ec3_palomino;
use ec3_palomino;

create table tb_programador
(
cod_programador int primary key auto_increment,
nom_programador varchar(25),
ape_programador varchar(25),
dni_programador int,
num_hijos int,
sueldo double,
cod_proyecto int
);

create table tb_proyecto
(
cod_proyecto int primary key auto_increment,
nom_proyecto varchar(25)
);

alter table tb_programador add constraint FK01 foreign key(cod_proyecto) references tb_proyecto(cod_proyecto);

insert into tb_proyecto values(null,'Gestión de Supermercados');
insert into tb_proyecto values(null,'Gestion de PACs');
insert into tb_proyecto values(null,'Gestion de Database');
insert into tb_programador values(null,'Renzzo Omar','Palomino de la Vega',73966456,5,1250.66,2);

 select*from tb_proyecto;
 select*from tb_programador;
 

 