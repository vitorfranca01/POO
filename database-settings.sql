CREATE TABLE Subsidiary (
    Id INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(120) NOT NULL
)

CREATE TABLE User (
    Id INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(120) NOT NULL,
    CPF VARCHAR(14) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    SubsidiaryId INT NOT NULL,
    CreationDate DATE DEFAULT GETDATE(),
    PRIMARY KEY (Id),
    FOREIGN KEY (SubsidiaryId) REFERENCES Subsidiary(Id)
)

CREATE TABLE Permission (
    Id INT NOT NULL AUTO_INCREMENT,
    Role VARCHAR(255) NOT NULL,
    Description VARCHAR(255) NOT NULL,
    PRIMARY KEY (Id)
)

CREATE TABLE UserPermission (
    UserId INT,
    PermissionId INT,
    FOREIGN KEY (UserId) REFERENCES User(Id),
    FOREIGN KEY (PermissionId) REFERENCES Permission(Id)
)

CREATE TABLE Product (
    Id INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(120) NOT NULL,
    Description VARCHAR(255),
    Price DOUBLE NOT NULL,
    Amount INT DEFAULT 0,
    CreationDate DATE DEFAULT GETDATE(),
    PRIMARY KEY (Id)
)

CREATE TABLE Order (
    Id INT NOT NULL AUTO_INCREMENT,
    Total DOUBLE NOT NULL,
    CreationDate DATE DEFAULT GETDATE(),
    CPF VARCHAR(14),
    UserId INT NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (UserId) REFERENCES User(Id)
)

CREATE TABLE OrderItem (
    Id INT NOT NULL AUTO_INCREMENT,
    OrderId INT NOT NULL,
    ProductId INT NOT NULL,
    Amount INT NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (OrderId) REFERENCES Order(Id)
)