CREATE TABLE `user` (
  `guid`       CHAR(40)    NOT NULL,
  `firstName`  VARCHAR(25) NOT NULL,
  `lastName`   VARCHAR(20) NOT NULL,
  `licenseNum` INT(11)     NOT NULL,
  `dob`        DATE        DEFAULT NULL,
  `username`   VARCHAR(20) NOT NULL,
  `password`   VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (`guid`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


CREATE TABLE `order` (
  `guid`                CHAR(40)    NOT NULL,
  `purchaseOrderNumber` INT(11)     NOT NULL,
  `jobName`             VARCHAR(20) NOT NULL,
  `materialType`        VARCHAR(12) NOT NULL,
  `orderType`           VARCHAR(10) NOT NULL,
  `orderDate`           DATETIME    NOT NULL,
  `pickupDate`          DATETIME    NOT NULL,
  `city`                VARCHAR(30) NOT NULL,
  `orderPlaced`         BIT(1)      NOT NULL,
  `isPickedOrShipped`   BIT(1)      NOT NULL,
  `finishedDate`        DATETIME    NOT NULL,
  `note`                VARCHAR(100) DEFAULT NULL,
  `userKey`             CHAR(40)    NOT NULL,
  PRIMARY KEY (`guid`),
  KEY `fkUserKey` (`userKey`),
  CONSTRAINT `fkUserKey` FOREIGN KEY (`userKey`) REFERENCES `user` (`guid`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO user (guid, firstName, lastName, licenseNum, dob, username, password)
VALUES ('10645c4a-cc25-11e7-acdc-96395d26a8d8', 'Michael', 'Jordan', 9483336, '1976-10-10', 'mjordan', 'jordan');
INSERT INTO user (guid, firstName, lastName, licenseNum, dob, username, password)
VALUES ('36ce3c3e-cc25-11e7-acdc-96395d26a8d8', 'Lebron', 'James', 9487026, '1976-10-15', 'ljames', 'ljames');
INSERT INTO user (guid, firstName, lastName, licenseNum, dob, username, password)
VALUES ('77888298-cc25-11e7-acdc-96395d26a8d8', 'Trisha', 'Yearwood', 111111, '1976-10-20', 'tyearwood', 'yearwood');
