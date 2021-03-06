# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table status (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_status primary key (id))
;

create table terminology (
  id                        bigint auto_increment not null,
  thai                      varchar(255),
  lanna                     varchar(255),
  link                      varchar(255),
  romanbali                 varchar(255),
  thaibali                  varchar(255),
  comment                   varchar(255),
  user_id                   bigint,
  constraint pk_terminology primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  password                  varchar(255),
  firstname                 varchar(255),
  surname                   varchar(255),
  name                      varchar(255),
  address                   varchar(255),
  tel                       varchar(255),
  email                     varchar(255),
  status_id                 bigint,
  constraint pk_user primary key (id))
;

create table word (
  id                        bigint auto_increment not null,
  thai                      varchar(255),
  lanna                     varchar(255),
  link                      varchar(255),
  romanbali                 varchar(255),
  thaibali                  varchar(255),
  constraint pk_word primary key (id))
;

alter table terminology add constraint fk_terminology_user_1 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_terminology_user_1 on terminology (user_id);
alter table user add constraint fk_user_status_2 foreign key (status_id) references status (id) on delete restrict on update restrict;
create index ix_user_status_2 on user (status_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table status;

drop table terminology;

drop table user;

drop table word;

SET FOREIGN_KEY_CHECKS=1;

