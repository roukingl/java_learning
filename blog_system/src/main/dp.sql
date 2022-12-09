create database if not exists blog_system charset utf8mb4;

use database blog_system;

drop table if exists blog;
create table blog(
                     blogId int primary key auto_increment comment '博客id',
                     title varchar(256) not null comment '博客标题',
                     content text not null comment '博客正文',
                     postTime datetime not null comment '博客发布时间',
                     userId int not null comment '博客作者id'
);

drop table if exists user;
create table user(
                     userId int primary key auto_increment comment '用户id',
                     userName varchar(50) unique comment '用户名',
                     password varchar(50) not null comment '用户密码'
);

insert into blog values (null, "第一篇博客", "第一篇博客的内容", "2020-11-10 12:00:00", 1);
insert into blog values (null, "第二篇博客", "第二篇博客的内容", "2021-11-10 09:23:43", 1);
insert into blog values (null, "第三篇博客", "第三篇博客的内容", "2022-09-22 15:33:12", 2);

insert into user values (null, "zhangsan", "123");
insert into user values (null, "lisi", "123");