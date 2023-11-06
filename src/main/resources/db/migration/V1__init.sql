CREATE TABLE IF NOT EXISTS vehiculo (
    id SERIAL,
    modelo VARCHAR(100) NOT NULL,
    motor VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS marcas (
    id SERIAL,
    modelo VARCHAR(100) NOT NULL,
    ano VARCHAR(100) NOT NULL,
    vehiculo_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (vehiculo_id ) REFERENCES vehiculo(id)
    );