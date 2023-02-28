
set foreign_key_checks = 0;

delete from production;
delete from polling;

set foreign_key_checks = 1;

insert into production (id,MerchantApiHost,GrantType,ClientId,ClientSecret) values (1,'https://merchant-api.ifood.com.br', 'client_credentials','e3d39334-dc18-4658-905b-07a41103a062','n5rb7x3rvb90fd0zyokv0v3pjlirvyi8kyds3ijjh2t5696tohj28grjwo96krtntnqvgeb2wwzgzkazih8riamall5qxcea02l');

insert into polling (polling_id, orderid,txtimportado) values (1,'1a8f34cf-e4b5-4cbd-af8f-15bf856076f3','0');

