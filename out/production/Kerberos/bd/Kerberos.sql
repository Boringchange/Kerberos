Drop database if exists Kerberos;
create database Kerberos;
use Kerberos;

create table Registro_cli(
idcli int primary key not null auto_increment,
adc varchar(15)
);

insert into Registro_cli values(1,'192.168.0.8');