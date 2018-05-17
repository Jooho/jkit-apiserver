--  Table Name: AnsibleControllers
--  Table Description: ansible control node that will execute ansible script
--  columes :
--  	- id (Numberic)
--   - Name (String)
--  	- hostIp (String)
--   - userId (String)
--   - userPw (Password)*/
--   - hostsFile (Blob)
-- we don't know how to generate schema PUBLIC (class Schema) :(
-- https://www.freeformatter.com/sql-formatter.html#ad-output
--  Table Name: AnsibleControllers
--  Table Description: ansible control node that will execute ansible script
--  columes :
--  	- id (Numberic)
--   - Name (String)
--  	- hostIp (String)
--   - userId (String)
--   - userPw (Password)*/
--   - hostsFile (Blob)
-- we don't know how to generate schema PUBLIC (class Schema) :(
create table ANSIBLE_CONTROLLER ( AC_INDEX INTEGER auto_increment NOT NULL, AC_NAME VARCHAR not null primary key, HOST_IP VARCHAR not null, USER_ID VARCHAR not null, USER_PW VARCHAR not null, HOSTS_FILE VARCHAR not null );
create unique index ANSIBLE_CONTROLLER_AC_INDEX_UINDEX on ANSIBLE_CONTROLLER (AC_INDEX);
create unique index ANSIBLE_CONTROLLER_HOST_IP_UINDEX on ANSIBLE_CONTROLLER (HOST_IP);
create table CONDITION ( CONDINDEX INTEGER auto_increment NOT NULL primary key, CONDID INTEGER, CONDSUBID INTEGER, CONDDESC VARCHAR(255), YESDEPT VARCHAR(255), NODEPT VARCHAR(255), YESMSG VARCHAR(255), NOMSG VARCHAR(255) );
create table ROLE ( ROLE_INDEX INTEGER auto_increment NOT NULL, ROLE_NAME VARCHAR not null primary key, ROLE_TARGET_HOSTS VARCHAR not null, ROLE_SHORT_DESC VARCHAR not null, ROLE_LONG_DESC VARCHAR not null );
create unique index ROLE_ROLE_INDEX_UINDEX on ROLE (ROLE_INDEX);
create table ROLE_OPERATE ( OPERATE VARCHAR not null primary key, OPERATE_DESC VARCHAR, OPERATE_INPUT_INDEX INTEGER not null, OPERATE_INDEX INTEGER auto_increment NOT NULL );
create unique index ROLE_EXPECT_RESULT_ROLE_OPERATE_OPERATE_DISPLAY_FK_INDEX_5 on ROLE_OPERATE (OPERATE_INDEX);
create table ROLE_OPERATE_INPUT ( OPERATE_INPUT_INDEX INTEGER, OPERATE_INPUT_TYPE VARCHAR, OPERATE_INPUT_VALUE VARCHAR );
create unique index ROLE_OPERATE_INPUT_OPERATE_INPUT_VALUE_UINDEX on ROLE_OPERATE_INPUT (OPERATE_INPUT_VALUE);
create table ROLE_PROFILE ( RP_INDEX INTEGER auto_increment NOT NULL, RP_NAME VARCHAR not null primary key, RP_DESC VARCHAR );
create table ROLE_ACTUAL_RESULT ( RP_INDEX INTEGER not null constraint ROLE_ACTUAL_RESULT_ROLE_PROFILE_RP_INDEX_FK references ROLE_PROFILE (RP_INDEX), ROLE_INDEX INTEGER not null constraint ROLE_ACTUAL_RESULT_ROLE_ROLE_INDEX_FK references ROLE (ROLE_INDEX), ACTUAL_RESULT VARCHAR, ACTUAL_RESULT_DATE TIMESTAMP not null, ACTUAL_RESULT_RAW_DATA VARCHAR not null, constraint ROLE_ACTUAL_RESULT_RP_INDEX_ROLE_INDEX_PK primary key (RP_INDEX, ROLE_INDEX) );
create table ROLE_EXPECT_RESULT ( RP_INDEX INTEGER constraint ROLE_EXPECT_RESULT_ROLE_PROFILE_RP_INDEX_FK references ROLE_PROFILE (RP_INDEX), ROLE_INDEX INTEGER constraint ROLE_EXPECT_RESULT_ROLE_ROLE_INDEX_FK references ROLE (ROLE_INDEX), OPERATE_INDEX INTEGER constraint ROLE_EXPECT_RESULT_ROLE_OPERATE_OPERATE_DISPLAY_FK references ROLE_OPERATE (OPERATE_INDEX), EXPECT_RESULT VARCHAR );
create unique index ROLE_ACTUAL_RESULT_ROLE_PROFILE_RP_INDEX_FK_INDEX_9 on ROLE_PROFILE (RP_INDEX);
create unique index ROLE_PROFILE_RP_INDEX_UINDEX  on ROLE_PROFILE (RP_INDEX);
create table ROLE_PROFILE_BIND ( RP_INDEX INTEGER not null constraint ROLE_PROFILE_BIND_ROLE_PROFILE_RP_INDEX_FK references ROLE_PROFILE (RP_INDEX), ROLE_INDEX INTEGER not null constraint ROLE_PROFILE_BIND_ROLE_ROLE_INDEX_FK references ROLE (ROLE_INDEX), constraint ROLE_PROFILE_BIND_RP_INDEX_ROLE_INDEX_PK primary key (RP_INDEX, ROLE_INDEX) );