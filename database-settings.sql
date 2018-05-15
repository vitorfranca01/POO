CREATE TABLE Subsidiary (
    Id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    Name VARCHAR(120) NOT NULL,
    PRIMARY KEY (Id)
);

CREATE TABLE "GROUP" (
    Id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    Name VARCHAR(100) NOT NULL,
    PRIMARY KEY (Id)
);

CREATE TABLE "USER" (
    Id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    Name VARCHAR(120) NOT NULL,
    CPF VARCHAR(14) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL,
    SubsidiaryId INT NOT NULL,
    CreationDate DATE DEFAULT CURRENT_DATE,
    GroupId INT NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (SubsidiaryId) REFERENCES Subsidiary(Id),
    FOREIGN KEY (GroupId) REFERENCES "GROUP"(Id)
);


CREATE TABLE Product (
    Id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    Name VARCHAR(120) NOT NULL,
    Description VARCHAR(255),
    Brand VARCHAR(120) NOT NULL,
    Price DOUBLE NOT NULL,
    Amount INT DEFAULT 0,
    CreationDate DATE DEFAULT CURRENT_DATE,
    PRIMARY KEY (Id)
);

CREATE TABLE "ORDER" (
    Id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    Total DOUBLE NOT NULL,
    CreationDate DATE DEFAULT CURRENT_DATE,
    CPF VARCHAR(14),
    UserId INT NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (UserId) REFERENCES "USER"(Id)
);

CREATE TABLE OrderItem (
    Id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    OrderId INT NOT NULL,
    ProductId INT NOT NULL,
    Amount INT NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (OrderId) REFERENCES "ORDER"(Id)
);

INSERT INTO "GROUP" (Name)
VALUES ('Vendedor'), ('Gerente');

INSERT INTO "SUBSIDIARY" (Name)
VALUES ('S�o Paulo'), ('Minas Gerais'), ('Recife');

INSERT INTO "USER" (Name, CPF, Password, SubsidiaryId, GroupId)
VALUES ('Wilson', '123.456.789-10', '123', 2, 1), ('Valdomiro', '549.569.812-10', '123', 1, 2);

INSERT INTO "PRODUCT" (Name, Description, Price, Brand)
VALUES ('Bolacha', 'Bolacha recheada', 2.49, 'Trakinass');

INSERT INTO "ORDER" (Total, CPF, UserId)
VALUES (50, NULL, 2);

INSERT INTO "ORDERITEM" (OrderId, ProductId, Amount)
VALUES (1, 1, 2);
