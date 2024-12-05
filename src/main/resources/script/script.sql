-- Criação do Banco de Dados
CREATE DATABASE investiMais;
USE investiMais;

CREATE TABLE carteira (
    id INT PRIMARY KEY,
    nome VARCHAR(64) NOT NULL
);

CREATE TABLE balanceamento_ativo (
	id INT PRIMARY KEY,
    id_carteira INT,
    tipo_ativo VARCHAR(64) NOT NULL,
    percentual_ideal DECIMAL(5, 2) NOT NULL,
    FOREIGN KEY (id_carteira) REFERENCES carteira(id) ON DELETE CASCADE
);


CREATE TABLE ativo (
    id INT PRIMARY KEY,
    id_carteira INT NOT NULL,
    tipo_ativo VARCHAR(64) NOT NULL,   
    ativo VARCHAR(64) NOT NULL,
    -- RENDA FIXA
    tipo_titulo VARCHAR(20),
    forma_titulo VARCHAR(20),
    indexador VARCHAR(20),
    emissor VARCHAR(64),
    data_vencimento DATE,
    FOREIGN KEY (id_carteira) REFERENCES carteira(id) ON DELETE CASCADE
);

CREATE TABLE lancamento (
    id INT PRIMARY KEY,
    id_carteira INT,
    id_ativo INT NOT NULL,
    data DATE NOT NULL,
    tipo_lancamento VARCHAR(20) NOT NULL,  
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(15, 2) NOT NULL,
    taxa_corretagem DECIMAL(15, 2) NOT NULL,
    taxa_emolumento DECIMAL(15, 2) NOT NULL,
    taxa_imposto DECIMAL(15, 2) NOT NULL,
    outras_taxas DECIMAL(15, 2) NOT NULL,
    valor_total DECIMAL(15, 2) NOT NULL, 
    FOREIGN KEY (id_carteira) REFERENCES carteira(id_carteira) ON DELETE CASCADE,
    FOREIGN KEY (id_ativo) REFERENCES ativo(id) ON DELETE CASCADE
);