INSERT INTO bibliotecajwt.users(
	email, password, user_name)
	VALUES ('jc@gm.com', '12345', 'jccastillo');

INSERT INTO bibliotecajwt.rol(rol)
	VALUES ('ADMIN'), ('CLIENT');

INSERT INTO bibliotecajwt.user_role(id_user, id_role)
	VALUES (2, 3);

INSERT INTO bibliotecajwt.autor (id_autor, nombre, pais_origen)
VALUES
    (1, 'J.K. Rowling', 'Reino Unido'),
    (2, 'Stephen King', 'Estados Unidos'),
    (3, 'George Orwell', 'Reino Unido');

INSERT INTO bibliotecajwt.categoria (id_categoria, nombre_categoria, descripcion)
VALUES
    (1, 'Fantasía', 'Libros de magia y criaturas míticas'),
    (2, 'Terror', 'Libros que causan miedo'),
    (3, 'Ciencia Ficción', 'Libros ambientados en futuros o mundos alternativos');

INSERT INTO bibliotecajwt.libro (id_libro, titulo, anio_publicacion, disponibilidad, descripcion, id_categoria, id_autor)
VALUES
    (1, 'Harry Potter y la Piedra Filosofal', 1997, 1, 'El comienzo de una aventura mágica', 1, 1),
    (2, 'It', 1986, 1, 'Un payaso malvado aterroriza a un grupo de niños', 2, 2),
    (3, '1984', 1949, 1, 'Una distopía sobre un futuro totalitario', 3, 3),
    (4, 'El Señor de los Anillos: La Comunidad del Anillo', 1954, 1, 'El comienzo de una épica fantasía', 1, 1),
    (5, 'El Resplandor', 1977, 1, 'Un hotel encantado aterroriza a una familia', 2, 2),
    (6, 'Fahrenheit 451', 1953, 1, 'Un mundo donde los libros están prohibidos', 3, 3),
    (7, 'El Hobbit', 1937, 1, 'La aventura de un hobbit para recuperar un tesoro', 1, 1),
    (8, 'Misery', 1987, 1, 'Una escritora es secuestrada por un fan obsesivo', 2, 2),
    (9, 'Un Mundo Feliz', 1932, 1, 'Una sociedad distópica controlada por drogas', 3, 3),
    (10, 'El Silmarillion', 1977, 1, 'La historia de la Tierra Media antes de El Señor de los Anillos', 1, 1);

INSERT INTO bibliotecajwt.cliente (id_cliente, nombre, correo, telefono, estado_cuenta)
VALUES
    (1, 'Juan Pérez', 'juan@example.com', 12345678, true),
    (2, 'María López', 'maria@example.com', 98765432, true),
    (3, 'Pedro Gómez', 'pedro@example.com', 55555555, false),
	(4, 'Fernando King', 'fe@example.com', 11115555, false);

INSERT INTO bibliotecajwt.prestamo (id_prestamo, id_cliente, fecha_inicio_prestamo, fecha_fin_prestamo)
VALUES
    (1, 1, '2023-11-01', '2023-11-15'),
    (2, 2, '2023-11-05', '2023-11-20'),
    (3, 1, '2023-11-10', '2023-11-25'),
    (4, 2, '2023-11-15', '2023-11-30'),
    (5, 3, '2023-11-08', '2023-11-23');

INSERT INTO bibliotecajwt.prestamo_libro (id_prestamo, id_libro)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);
