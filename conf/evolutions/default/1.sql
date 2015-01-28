# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table word (
  id                        bigint auto_increment not null,
  thai                      varchar(255),
  lanna                     varchar(255),
  link                      varchar(255),
  constraint pk_word primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table word;

SET FOREIGN_KEY_CHECKS=1;

