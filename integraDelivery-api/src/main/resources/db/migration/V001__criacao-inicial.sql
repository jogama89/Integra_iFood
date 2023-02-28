create table Production (
	id 							bigint not null auto_increment,
  
	merchantApiHost 			varchar(100),
	accessToken 					LONGTEXT,
	clientId 					varchar(100),
	clientSecret 				varchar(200),
	grantType 					varchar(100),
	authorizationCode 			varchar(100),
	authorizationCodeVerifier 	varchar(100),
	refreshToken 				varchar(100),
	merchantId 					varchar(100),
	operation 					varchar(100),
	interruptionId 				varchar(100),
	orderId 					varchar(100),
	cancellationCode 			varchar(100),
	cancellationReason 			varchar(100),
	changePreparationTime 		varchar(100),
	changePreparationReason 	varchar(100),
	catalogId 					varchar(100),
	categoryId 					varchar(100),
	productId 					varchar(100),
	pizzaId 					varchar(100),
	optionGroupId 				varchar(100),
  
  
  primary key (id)
) engine=InnoDB default charset=utf8;
