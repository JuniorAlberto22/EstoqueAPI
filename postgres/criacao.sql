CREATE ROLE USUARIO_ADMIN WITH PASSWORD '1234' SUPERUSER;
CREATE DATABASE ESTOQUE WITH OWNER USUARIO_ADMIN;
CREATE SCHEMA IF NOT EXISTS SCH_ESTOQUE AUTHORIZATION USUARIO_ADMIN;

CREATE TABLE SCH_ESTOQUE.TIPO_MOVIMENTACAO(
	ID_MOVIMENTCAO INT,
	DESCRICAO_MOVIMENTACAO VARCHAR(100) NOT NULL,
	CONSTRAINT PK_TIPO_MOVIMENTACAO PRIMARY KEY(ID_MOVIMENTCAO)
);

CREATE TABLE SCH_ESTOQUE.CAIXA(
	ID_CAIXA INT,
	DATA_REGISTRO TIMESTAMP,
	VALOR_MOVIMENTACAO DECIMAL NOT NULL,
	TIPO_MOVIMENTACACAO INT NOT NULL,
	CONSTRAINT PK_CAIXA PRIMARY KEY(ID_CAIXA),
	CONSTRAINT FK_MOVIMENTACAO FOREIGN KEY(TIPO_MOVIMENTACACAO) REFERENCES SCH_ESTOQUE.TIPO_MOVIMENTACAO(ID_MOVIMENTCAO),
	CONSTRAINT CK_VALOR_MOVIMENTACAO CHECK (VALOR_MOVIMENTACAO > 0)
);

CREATE TABLE SCH_ESTOQUE.TIPO_ACESSO_USUARIO(
	ID_ACESSO_USUARIO INT,
	DESCRICAO_ACESSO_USUARIO VARCHAR(10) NOT NULL,
	CONSTRAINT PK_ACESSO_USUARIO PRIMARY KEY(ID_ACESSO_USUARIO)
);

CREATE TABLE SCH_ESTOQUE.USUARIO(
	ID_USUARIO INT NOT NULL,
	TIPO_ACESSO_USUARIO INT NOT NULL,
	DATA_REGISTRO TIMESTAMP,
	LOGIN VARCHAR(100) NOT NULL,
	PASSWORD VARCHAR(50) NOT NULL,
	NOME VARCHAR(100) NOT NULL,
	CONSTRAINT PK_USUARIO PRIMARY KEY(ID_USUARIO),
	CONSTRAINT FK_TIPO_ACESSO_USUARIO FOREIGN KEY(TIPO_ACESSO_USUARIO) REFERENCES SCH_ESTOQUE.TIPO_ACESSO_USUARIO(ID_ACESSO_USUARIO),
	CONSTRAINT CK_PASSWORD CHECK(CHAR_LENGTH(PASSWORD) > 5)
);

CREATE TABLE SCH_ESTOQUE.PRODUTO(
	ID_PRODUTO INT,
	NOME_PRODUTO VARCHAR(100) NOT NULL,
	QUANTIDADE_PRODUTO INT NOT NULL,
	VALOR_PRODUTO DECIMAL NOT NULL,
	CONSTRAINT PK_PRODUTO PRIMARY KEY(ID_PRODUTO),
	CONSTRAINT CK_QUANTIDADE_PRODUTO CHECK(QUANTIDADE_PRODUTO > 0),
	CONSTRAINT CK_VALOR_PRODUTO CHECK(VALOR_PRODUTO > 0)
);

CREATE TABLE SCH_ESTOQUE.TIPO_REGISTRO_PRODUTO(
	ID_TIPO_REGISTRO INT NOT NULL,
	DESCRICAO_REGISTRO_PRODUTO VARCHAR(100) NOT NULL,
	CONSTRAINT PK_TIPO_REGISTRO PRIMARY KEY(ID_TIPO_REGISTRO)
);

CREATE TABLE SCH_ESTOQUE.REGISTRO_PRODUTO(
	ID_REGISTRO_PRODUTO INT NOT NULL,
	DATA_REGISTRO TIMESTAMP,
	TIPO_REGISTRO_PRODUTO INT NOT NULL,
	QUANTIDADE_PRODUTO INT NOT NULL,
	VALOR_PRODUTO DECIMAL NOT NULL,
	ID_PRODUTO INT NOT NULL,
	ID_USUARIO INT NOT NULL,
	ID_CLIENTE INT NOT NULL,
	CONSTRAINT PK_REGISTRO_PRODUTO PRIMARY KEY(ID_REGISTRO_PRODUTO),
	CONSTRAINT FK_TIPO_REGISTRO_PRODUTO FOREIGN KEY(TIPO_REGISTRO_PRODUTO) REFERENCES SCH_ESTOQUE.TIPO_REGISTRO_PRODUTO(ID_TIPO_REGISTRO),
	CONSTRAINT CK_QUANTIDADE_PRODUTO CHECK (QUANTIDADE_PRODUTO > 0),
	CONSTRAINT CK_VALOR_PRODUTO CHECK (VALOR_PRODUTO > 0),
	CONSTRAINT FK_PRODUTO FOREIGN KEY(ID_PRODUTO) REFERENCES SCH_ESTOQUE.PRODUTO(ID_PRODUTO),
	CONSTRAINT FK_USUARIO FOREIGN KEY(ID_USUARIO) REFERENCES SCH_ESTOQUE.USUARIO(ID_USUARIO),
	CONSTRAINT FK_CLIENTE FOREIGN KEY(ID_CLIENTE) REFERENCES SCH_ESTOQUE.USUARIO(ID_USUARIO)
);

-- TRIGGERS
--CAIXA
CREATE OR REPLACE FUNCTION inserirDataRegistroCaixa() RETURNS TRIGGER AS $example_table$
   BEGIN
      UPDATE SCH_ESTOQUE.CAIXA SET DATA_REGISTRO =  NOW() WHERE SCH_ESTOQUE.CAIXA.ID_CAIXA = NEW.ID_CAIXA;
	  RETURN NEW;
   END;
$example_table$ LANGUAGE plpgsql;

CREATE TRIGGER TR_DATA_REGISTRO_CAIXA AFTER INSERT 
ON SCH_ESTOQUE.CAIXA FOR EACH ROW EXECUTE PROCEDURE inserirDataRegistroCaixa();


--SCH_ESTOQUE.USUARIO
CREATE OR REPLACE FUNCTION inserirRegistroUsuario() RETURNS TRIGGER AS $example_table$
   BEGIN
      UPDATE SCH_ESTOQUE.USUARIO SET DATA_REGISTRO =  NOW() WHERE SCH_ESTOQUE.USUARIO.ID_USUARIO = NEW.ID_USUARIO;
	  RETURN NEW;
   END;
$example_table$ LANGUAGE plpgsql;

CREATE TRIGGER TR_DATA_REGISTRO_USUARIO AFTER INSERT 
ON SCH_ESTOQUE.USUARIO FOR EACH ROW EXECUTE PROCEDURE inserirRegistroUsuario();



--SCH_ESTOQUE.REGISTRO_PRODUTO
CREATE OR REPLACE FUNCTION inserirDataRegistroProduto() RETURNS TRIGGER AS $example_table$
   BEGIN
      UPDATE SCH_ESTOQUE.REGISTRO_PRODUTO SET DATA_REGISTRO =  NOW() WHERE SCH_ESTOQUE.REGISTRO_PRODUTO.ID_REGISTRO_PRODUTO = NEW.ID_REGISTRO_PRODUTO;
	  RETURN NEW;
   END;
$example_table$ LANGUAGE plpgsql;

CREATE TRIGGER TR_DATA_REGISTRO_PRODUTO AFTER INSERT 
ON SCH_ESTOQUE.REGISTRO_PRODUTO FOR EACH ROW EXECUTE PROCEDURE inserirDataRegistroProduto();

--SEQUENCES
CREATE SEQUENCE IF NOT EXISTS SCH_ESTOQUE.SEQ_TIPO_MOVIMENTACAO INCREMENT BY 1
START WITH 1 CACHE 10 NO CYCLE OWNED BY SCH_ESTOQUE.TIPO_MOVIMENTACAO.ID_MOVIMENTCAO;

CREATE SEQUENCE IF NOT EXISTS SCH_ESTOQUE.SEQ_CAIXA INCREMENT BY 1
START WITH 1 CACHE 10 NO CYCLE OWNED BY SCH_ESTOQUE.CAIXA.ID_CAIXA;

CREATE SEQUENCE IF NOT EXISTS SCH_ESTOQUE.SEQ_USUARIO INCREMENT BY 1
START WITH 1 CACHE 10 NO CYCLE OWNED BY SCH_ESTOQUE.USUARIO.ID_USUARIO;

CREATE SEQUENCE IF NOT EXISTS SCH_ESTOQUE.SEQ_TIPO_ACESSO_USUARIO INCREMENT BY 1
START WITH 1 CACHE 10 NO CYCLE OWNED BY SCH_ESTOQUE.TIPO_ACESSO_USUARIO.ID_ACESSO_USUARIO;

CREATE SEQUENCE IF NOT EXISTS SCH_ESTOQUE.SEQ_PRODUTO INCREMENT BY 1
START WITH 1 CACHE 10 NO CYCLE OWNED BY SCH_ESTOQUE.PRODUTO.ID_PRODUTO;

CREATE SEQUENCE IF NOT EXISTS SCH_ESTOQUE.SEQ_TIPO_REGISTRO_PRODUTO INCREMENT BY 1
START WITH 1 CACHE 10 NO CYCLE OWNED BY SCH_ESTOQUE.TIPO_REGISTRO_PRODUTO.ID_REGISTRO_PRODUTO;

