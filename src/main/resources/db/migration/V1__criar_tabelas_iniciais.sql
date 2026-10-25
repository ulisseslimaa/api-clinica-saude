CREATE TABLE medicos (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     nome VARCHAR(150) NOT NULL,
     email VARCHAR(100) NOT NULL UNIQUE,
     crm VARCHAR(20) NOT NULL UNIQUE,
     especialidade VARCHAR(50) NOT NULL
);

CREATE TABLE pacientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL
);

CREATE TABLE consultas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    medico_id BIGINT NOT NULL,
    paciente_id BIGINT NOT NULL,
    data VARCHAR(10) NOT NULL,
    hora INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    motivo_cancelamento TEXT,
    CONSTRAINT fk_consultas_medico FOREIGN KEY (medico_id) REFERENCES medicos(id),
    CONSTRAINT fk_consultas_paciente FOREIGN KEY (paciente_id) REFERENCES pacientes(id)
);