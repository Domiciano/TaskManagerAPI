INSERT INTO students (name, code)
VALUES ('Vanessa Sanchez', 'A00397949');


SET
@vanessa_id = (SELECT id FROM students WHERE code = 'A00397949');

INSERT INTO tasks (title, status, description, student_id)
VALUES ('Planificar proyecto final', 'To Do', 'Investigar temas y hacer un cronograma.', @vanessa_id),
       ('Investigar Spring Boot Security', 'To Do', 'Recopilar información sobre autenticación y autorización.',
        @vanessa_id),
       ('Comprar materiales de arte', 'To Do', 'Adquirir lienzos, pinturas y pinceles.', @vanessa_id),
       ('Preparar presentación', 'To Do', 'Crear diapositivas para la reunión del equipo.', @vanessa_id),
       ('Enviar correo electrónico importante', 'Doing', 'Comunicado urgente sobre la fecha límite del proyecto.',
        @vanessa_id);