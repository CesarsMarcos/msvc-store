INSERT INTO tb_categorias (id, nombre) VALUES (1, 'shoes');
INSERT INTO tb_categorias (id, nombre) VALUES (2, 'books');
INSERT INTO tb_categorias (id, nombre) VALUES (3, 'electronics');

INSERT INTO tb_productos (id, nombre, descripcion, stock,precio,estado, create_at,categoria_id)
VALUES (1, 'adidas Cloudfoam Ultimate','Walk in the air in the black / black CLOUDFOAM ULTIMATE running shoe from ADIDAS',5,178.89,'CREATED','2018-09-05',1);

INSERT INTO tb_productos (id, nombre, descripcion, stock,precio,estado, create_at,categoria_id)
VALUES (2, 'under armour Men ''s Micro G Assert – 7','under armour Men ''Lightweight mesh upper delivers complete breathability . Durable leather overlays for stability ',4,12.5,'CREATED','2018-09-05',1);


INSERT INTO tb_productos (id, nombre, descripcion, stock,precio,estado, create_at,categoria_id)
VALUES (3, 'Spring Boot in Action','under armour Men '' Craig Walls is a software developer at Pivotal and is the author of Spring in Action',12,40.06,'CREATED','2018-09-05',2);