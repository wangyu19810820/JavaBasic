-- 表
CREATE TABLE z_table (
[id] int NOT NULL ,
[name] varchar(255) NOT NULL
);

-- 表值参数(Table-Valued Parameter)
CREATE TYPE dbo.z_type AS TABLE ( id int, name varchar(255) );

-- 存储过程
CREATE PROC z_proc(@c z_type READONLY)
as
INSERT z_table SELECT * FROM @c;