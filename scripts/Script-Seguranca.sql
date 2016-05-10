create database dbSeguranca;
use dbSeguranca;


insert into tb_sistema(nm_sistema,ds_url) 
values -- ('Sistema Ecommerce','http://localhost:8080/SistemaEcommerce/'),
	   ('Seguranca','http://localhost:8080/Seguranca'),
	   ('SistemaAlugaBicicleta','http://localhost:8080/SistemaAlugaBicicleta');

insert into tb_usuario(ds_login,fl_ativo,ds_email,ds_senha)
values ('carloseduardo',1,'carloseduardodantas@iftm.edu.br','e4UXW0VQYOMjfpJfAjBTypUV6Ggqg8iwmRHHJKH4t18='),
       ('roberto',1,'roberto@iftm.edu.br','pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM=');
       
              
insert into tb_role(nm_role,cd_sistema)
values ('BIC_admin',1),
       ('BIC_cadastro',1),
       ('BIC_consulta',1),
       ('SEG_admin',2),
       ('SEG_cadastro',2),
       ('SEG_consulta',2);
       
insert into tb_usuario_role(cd_role,ds_login)
values (1,'roberto'),
       (4,'roberto'),
       (3,'carloseduardo'),
       (6,'carloseduardo'); 
       
	   
       
SELECT NM_ROLE, 'Roles'  
FROM TB_ROLE R,TB_USUARIO_ROLE UR          
WHERE R.CD_ROLE = UR.CD_ROLE
AND UR.DS_LOGIN='roberto';

select DS_SENHA
from TB_USUARIO
where DS_LOGIN='roberto';