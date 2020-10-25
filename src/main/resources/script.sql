create database tokyo;

create table veiculos(
	id int not null auto_increment prmary key,
	marca varchar(40),
    modelo varchar(40),
    ano int,
    valor double,
    risco int)

}