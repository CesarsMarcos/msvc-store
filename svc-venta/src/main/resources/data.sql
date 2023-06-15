INSERT INTO tb_factura (id, numero_factura, descripcion, cliente_id, create_at, estado) VALUES(1, '0001', 'invoice office items', 1, NOW(),'CREATED');

INSERT INTO tb_factura_items ( factura_id, producto_id, cantidad, precio ) VALUES(1, 1 , 1, 178.89);
INSERT INTO tb_factura_items ( factura_id, producto_id, cantidad, precio)  VALUES(1, 2 , 2, 12.5);
INSERT INTO tb_factura_items ( factura_id, producto_id, cantidad, precio)  VALUES(1, 3 , 1, 40.06);