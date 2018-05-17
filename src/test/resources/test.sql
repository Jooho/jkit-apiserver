create table CONDITION (condIndex integer not null auto_increment, condId integer, condSubId integer, condDesc varchar(255), yesDept varchar(255), noDept varchar(255),yesMsg varchar(255),noMsg varchar(255),  primary key (condIndex));
create table CONDITION_RESULT (condResultIndex integer not null auto_increment, acName varchar(255), condId integer, condSubId integer, condResult integer, msg varchar(255),  primary key (condResultIndex));

insert into CONDITION (condId, condSubId, condDesc, yesDept, noDept, yesMsg, noMsg) values (1, 0, 'Ansible Installation', 'none', 'none','none','none');
insert into CONDITION (condId, condSubId, condDesc, yesDept, noDept, yesMsg, noMsg) values (1, 1, 'Ansible Installed', 'none', 'none','none','none');
insert into CONDITION_RESULT (condResultIndex,acName, condId, condSubId, condResult, msg) values (2,'sandbox', 1, 1, 0, 'none' );

select cr.acName, cr.condId, cr.condSubId, cond.condDesc, cr.msg from CONDITION_RESULT as cr LEFT JOIN CONDITION as cond ON cr.condId=cond.condId AND cr.condSubId = cond.condSubId