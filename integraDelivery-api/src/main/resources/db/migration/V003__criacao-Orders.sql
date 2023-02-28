
create table coordinates (
  coordinates_id bigint not null auto_increment,
    
   latitude 		decimal(10,2) not null,
   longitude 		decimal(10,2) not null,
  
  primary key (coordinates_id)
) engine=InnoDB default charset=utf8;


create table card (
  card_id bigint not null auto_increment,
    
  brand		varchar(100),
  
  primary key (card_id)
) engine=InnoDB default charset=utf8;


create table payments (
  payments_id bigint not null auto_increment,
    
  prepaid 		decimal(10,2) 	not null,
  pending		bigint 			not null,
  
  primary key (payments_id)
) engine=InnoDB default charset=utf8;


create table total (
  total_id bigint not null auto_increment,
    
  subTotal 			decimal(10,2) not null,
  deliveryFee 		decimal(10,2) not null,
  benefits 			decimal(10,2) not null,
  orderAmount 		decimal(10,2) not null,
  additionalFees	decimal(10,2) not null,
  
  primary key (total_id)
) engine=InnoDB default charset=utf8;


create table merchant (
  merchant_id bigint not null auto_increment,
    
  id 			varchar(100),
  name 			varchar(200),
  statusCode 	varchar(100),
  
  
  primary key (merchant_id)
) engine=InnoDB default charset=utf8;


create table phone (
  phone_id bigint not null auto_increment,
    
  number 				varchar(100),
  localizer 			varchar(100),
  localizerExpiration 	varchar(100),
  
  primary key (phone_id)
) engine=InnoDB default charset=utf8;


create table customer (
  customer_id bigint not null auto_increment,

	id  			varchar(100),
	name	  		varchar(200),
	
	phone_phone_id		bigint not null,

  primary key (customer_id),

  constraint fk_customer_phone foreign key (phone_phone_id) references phone (phone_id)
  
) engine=InnoDB default charset=utf8;




create table deliveryAddress (
  deliveryaddress_id bigint not null auto_increment,

	streetname  		varchar(100),
	streetnumber  		varchar(100),
	formattedaddress  	varchar(100),
	neighborhood  		varchar(100),
	postalcode  		varchar(100),
	city  				varchar(100),
	state  				varchar(100),
	country  			varchar(100),	
	
	coordinates_coordinates_id		bigint not null,

  primary key (deliveryaddress_id),

  constraint fk_deliveryaddress_coordinates foreign key (coordinates_coordinates_id) references coordinates (coordinates_id)
) engine=InnoDB default charset=utf8;





create table delivery (
  delivery_id bigint not null auto_increment,

	mode  				varchar(100),
	deliveredBy  		varchar(100),
	deliveryDateTime  	varchar(100),
	observations  		varchar(100),
	
	deliveryaddress_deliveryaddress_id	bigint not null,

  primary key (delivery_id),

  constraint fk_delivery_deliveryAddress foreign key (deliveryaddress_deliveryaddress_id) references deliveryAddress (deliveryaddress_id)
) engine=InnoDB default charset=utf8;









create table orders (
  orders_id bigint not null auto_increment,

	id  						varchar(100),
	displayId  					varchar(100),
	createdAt  					varchar(100),
	salesChannel  				varchar(100),
	merchant_merchant_id		bigint not null,
	customer_customer_id		bigint not null,
	total_total_id				bigint not null,
	delivery_delivery_id 		bigint not null,
	payments_payments_id 		bigint not null,

  primary key (orders_id),
 
  constraint fk_orders_merchant 	foreign key (merchant_merchant_id) 	references merchant (merchant_id),
  constraint fk_orders_customer 	foreign key (customer_customer_id) 	references customer (customer_id),
  constraint fk_orders_total 		foreign key (total_total_id) 	  	references total 	(total_id),
  constraint fk_orders_delivery 	foreign key (delivery_delivery_id) 	references delivery (delivery_id),
  constraint fk_orders_payments 	foreign key (payments_payments_id) 	references payments (payments_id)
   
) engine=InnoDB default charset=utf8;


create table items (
  items_id bigint not null auto_increment,
  
  index_  			bigint not null,
  id				varchar(100),
  uniqueId  		varchar(100),
  name_  			varchar(200),
  externalCode  	varchar(100),
  unit  			varchar(100),
  quantity 			decimal(10,2) not null,
  unitPrice 		decimal(10,2) not null,
  optionsPrice 		decimal(10,2) not null,
  totalPrice 		decimal(10,2) not null,
  price 			decimal(10,2) not null,  
  orders_orders_id 		bigint ,
  
  primary key (items_id),

  
  constraint fk_item_orders foreign key (orders_orders_id) references orders (orders_id)

) engine=InnoDB default charset=utf8;



create table methods (
  methods_id bigint not null auto_increment,
  
  
  value 					decimal(10,2) not null,
  currency					varchar(100),
  method  					varchar(100),
  type  					varchar(200),
  

  payments_payments_id 		bigint,
  card_card_id    			bigint not null,
  
  primary key (methods_id),

  constraint fk_methods_payments foreign key (payments_payments_id) references payments (payments_id),
  constraint fk_methods_card 	 foreign key (card_card_id) 		references card 	(card_id)

) engine=InnoDB default charset=utf8;






