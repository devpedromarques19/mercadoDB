CREATE TABLE produto (
id bigint(20) not null,
nome varchar(255) not null,
preco double not null,
quantidade int default 0,
mercado_id bigint (20) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE produto add primary key(id);

ALTER TABLE produto MODIFY id bigint(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE produto add foreign key(mercado_id) references mercado (id) on delete cascade;