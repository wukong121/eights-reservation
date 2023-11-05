DROP TABLE IF EXISTS Student;
CREATE TABLE Student
(
    id           INTEGER      NOT NULL AUTO_INCREMENT,
    first_name   VARCHAR(10)  NOT NULL DEFAULT '' COMMENT '学生名字',
    last_name    VARCHAR(10)  NOT NULL DEFAULT '' COMMENT '学生姓氏',
    gender       VARCHAR(10)  NOT NULL DEFAULT '' COMMENT '性别',
    phone_number VARCHAR(20)  NOT NULL DEFAULT '' COMMENT '电话号码',
    user_id      VARCHAR(255) NOT NULL DEFAULT '' COMMENT 'user_id',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '学生表';

DROP TABLE IF EXISTS User;
CREATE TABLE User
(
    userId       VARCHAR(255) NOT NULL DEFAULT '' COMMENT '用户id',
    username     VARCHAR(10)  NOT NULL DEFAULT 'user' COMMENT '用户名称',
    email        VARCHAR(30)  NOT NULL DEFAULT '' COMMENT '邮箱',
    phone_number VARCHAR(20)  NOT NULL DEFAULT '' COMMENT '手机号码',
    gender       VARCHAR(10)  NOT NULL DEFAULT '' COMMENT '性别',
    nick_name    VARCHAR(10)  NOT NULL DEFAULT '' COMMENT '昵称',
    password     VARCHAR(63)  NOT NULL DEFAULT '' COMMENT '密码',
    create_time  TIMESTAMP    NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
    authority    VARCHAR(15)  NOT NULL DEFAULT 'ROLE_STUDENT' COMMENT '用户角色'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '用户表';

DROP TABLE IF EXISTS Room;
CREATE TABLE Room
(
    roomId         INTEGER     NOT NULL AUTO_INCREMENT,
    name           VARCHAR(10) NOT NULL DEFAULT '' COMMENT '浴室名称',
    address        VARCHAR(30) NOT NULL DEFAULT '' COMMENT '浴室地址',
    category       VARCHAR(10) NOT NULL DEFAULT '' COMMENT '浴室类别',
    specialization VARCHAR(10) NOT NULL DEFAULT 'MEDIUM' COMMENT '浴室大小',
    PRIMARY KEY (roomId)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '浴室表';

DROP TABLE IF EXISTS Appointment;
CREATE TABLE Appointment
(
    appointmentId INTEGER     NOT NULL AUTO_INCREMENT,
    date          DATE        NOT NULL DEFAULT (current_date) COMMENT '预定日期',
    time          TIME        NOT NULL DEFAULT (current_time) COMMENT '预定时间',
    notes         VARCHAR(30) NOT NULL DEFAULT '' COMMENT '备注',
    status        VARCHAR(10) NOT NULL DEFAULT '' COMMENT '预定状态',
    studentName   VARCHAR(20) NOT NULL DEFAULT '' COMMENT '预定学生姓名',
    roomName      VARCHAR(10) NOT NULL DEFAULT '' COMMENT '浴室名称',
    PRIMARY KEY (appointmentId)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '预约表';