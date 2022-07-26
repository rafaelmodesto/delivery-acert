CREATE TABLE PEDIDO (
    ID INTEGER GENERATED BY DEFAULT AS IDENTITY,
    VALOR_TOTAL NUMERIC(15,2),
    DATA_CRIACAO TIMESTAMP NOT NULL,
    DATA_CONFIRMACAO TIMESTAMP,
    DATA_CANCELAMENTO TIMESTAMP,
    STATUS VARCHAR(10),
    CLIENTE_ID INTEGER NOT NULL
);

ALTER TABLE PEDIDO ADD CONSTRAINT PK_PEDIDO PRIMARY KEY (ID);

ALTER TABLE PEDIDO ADD CONSTRAINT FK_CLIENTE_ID FOREIGN KEY (CLIENTE_ID) REFERENCES USUARIO(ID);