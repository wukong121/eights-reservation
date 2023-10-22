DROP TABLE IF EXISTS Student;
CREATE TABLE Student
(
    id           INTEGER      NOT NULL AUTO_INCREMENT,
    first_name   VARCHAR(10)  NOT NULL DEFAULT '' COMMENT '学生名字',
    last_name    VARCHAR(10)  NOT NULL DEFAULT '' COMMENT '学生姓氏',
    gender       VARCHAR(10)  NOT NULL DEFAULT '' COMMENT '性别',
    phone_number BIGINT       NOT NULL DEFAULT '' COMMENT '电话号码',
    user_id      VARCHAR(255) NOT NULL DEFAULT '' COMMENT 'user_id'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '学生表';


