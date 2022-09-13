CREATE TABLE ITEM (
    ID UUID PRIMARY KEY,
    URL VARCHAR,
    PARENT_ID UUID,
    TYPE VARCHAR,
    SIZE BIGINT,
    FOREIGN KEY (PARENT_ID) REFERENCES ITEM (ID)
);
