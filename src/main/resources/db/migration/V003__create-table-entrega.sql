CREATE TABLE ENTREGA (
    ID INTEGER GENERATED BY DEFAULT AS IDENTITY,
    STATUS VARCHAR(10),
    DATA_ENTREGA TIMESTAMP,
    PEDIDO_ID INTEGER NOT NULL
);

ALTER TABLE ENTREGA ADD CONSTRAINT PK_ENTREGA PRIMARY KEY (ID);

ALTER TABLE ENTREGA ADD CONSTRAINT FK_PEDIDO_ID FOREIGN KEY (PEDIDO_ID) REFERENCES PEDIDO(ID);