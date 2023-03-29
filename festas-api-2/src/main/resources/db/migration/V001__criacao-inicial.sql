create table cliente (
	id 							bigint not null auto_increment,
  
	nome 						varchar(100),
	tipopessoa 					varchar(3),
	cpf_cnpj 					varchar(30),
	rg_ie 						varchar(30),
	datacadastro 				date,
	status 						integer,
	telefone1 					varchar(30),
	telefone2 					varchar(30),
	
  primary key (id)
) engine=InnoDB default charset=utf8;
