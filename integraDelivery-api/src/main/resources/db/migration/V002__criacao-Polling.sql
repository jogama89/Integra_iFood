create table polling (
	polling_id 							bigint not null auto_increment,
  
	  id			varchar(100),
	  code			varchar(100),
	  fullcode		varchar(100),
	  orderid		varchar(100),
	  merchantid	varchar(100),
	  createdat   	varchar(100),
	  txtimportado 		 boolean,
  
  primary key (polling_id)
) engine=InnoDB default charset=utf8;
