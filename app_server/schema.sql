
/* Create user table */
CREATE TABLE USERS (
    aggregateId   varchar(80),
    username   varchar(80),
    userPassword   varchar(80)
);


/* Create message table */
CREATE TABLE Messages (
    aggregateId varchar(80),
    senderId varchar(80),
    recipientId varchar(80),
    isDeleted boolean,
    body varchar(250)
);