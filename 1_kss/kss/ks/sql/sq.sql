create database Driverfiles;
use Driverfiles;

drop table if exists Driver;
create table Driver
(
    did Char(20),
    user char(20),
    password char(20),
    name char(20),
    remuneration char(20),
    bonus char(20),
    fine char(20),
    count char(20),
    PRIMARY KEY (did)
);
insert into Driver
    (did,user,password,name,remuneration,bonus,fine,count)
    values('d0001','d0001','d0001','����','5000','1000',' ','6000'),
           ('d0002','d0002','d0002','����','5000','1000',' ','6000'),
           ('d0003','d0003','d0003','��ɢ','5000','1000',' ','6000');


drop table if exists user;
create table user (
     id Char(20),
     username char(20),
     password char(20),
     name char(20),
     primary key (id) USING BTREE
)engine = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4;

insert into user (id,username,password,name)values ('u0001','u0001','u0001','����'),
                                               ('u0002','u0002','u0002','�Կ�');

drop table if exists cost;
create table cost(
    cid char(20),
    introduce char(20),
    time char(20),
    name char(20),
    allCard char(20),
    primary key (cid) USING BTREE
)engine = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4;

insert into cost (cid, introduce, time, name, allCard) VALUEs ('c0001','null','2022��11��10��','����','600'),
                                                              ('c0002','null','2022��11��15��','����','700');

drop table if exists car;
create table car(
    cid char(20),
    type char(20),
    volume char(20),
    state char(20),
    primary key (cid) USING BTREE
)engine = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4;

insert into car (cid, type, volume, state) VALUES ('c0001','����','3000','����'),
                                                  ('c0002','����','4000','����');

drop table if exists Oilcard;
create table Oilcard(
    oid char(20),
    name char(20),
    price char(20),
    remainprice char(20),
 primary key (oid) USING BTREE
)engine = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4;

insert into oilcard(oid, name, price, remainprice) VALUES ('o0001','����','6000','5000'),
                                                          ('o0002','����','6000','4000');

