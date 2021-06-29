CREATE TABLE mercado (
id bigint(20) not null,
nome varchar(255) not null,
cnpj varchar(14) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE mercado add primary key(id);

ALTER TABLE mercado MODIFY id bigint(20) NOT NULL AUTO_INCREMENT;