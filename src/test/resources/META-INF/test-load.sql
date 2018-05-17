--  Table Name: AnsibleControllers
--  Table Description: ansible control node that will execute ansible script
--  columes :
--  	- id (Numberic)
--   - Name (String)
--  	- hostIp (String)
--   - userId (String)
--   - userPw (Password)*/
--   - hostsFile (Blob) 
--insert into ANSIBLE_CONTROLLERS (acName, hostIp, userId, userPw, hostsFile) values ('sandbox', '10.10.12.21', 'root', 'redhat', 'master.example.com 10.10.10.10');


-- insert into CMD_PROFILES (profileName, cmdId) values ('ansible controller', 1)
-- insert into CMD_PROFILES (profileName, cmdId) values ('ansible controller', 2)
-- 
-- insert into CMD_DETAIL (cmdGrp, cmdId, cmdName, description) values (1, 'oc', 'OpenShift Client Command', 'basic')
-- insert into CMD_DETAIL (cmdGrp, cmdId, cmdName, description) values (2, 'systemctl', 'System Daemon Command','basic')
 
--create table CONDhttps://www.evernote.com/MarketingOpenId.action?referralSpecifier=mweb_home_1g&analyticsLoginOrigin=home_newITION (condIndex integer not null auto_increment, condId integer, condSubId integer, condDesc varchar(255), yesDept varchar(255), noDept varchar(255),yesMsg varchar(255),noMsg varchar(255),  primary key (condIndex));

--insert into CONDITION (condIndex, condId, condSubId, condDesc, yesDept, noDept, yesMsg, noMsg) values (1,1, 0, 'Ansible Installation', 'none', 'none','none','none');
--insert into CONDITION (condIndex, condId, condSubId, condDesc, yesDept, noDept, yesMsg, noMsg) values (2,1, 1, 'Ansible Installed', '2-0', '1-2','none','none' );
--insert into CONDITION (condIndex, condId, condSubId, condDesc, yesDept, noDept, yesMsg, noMsg) values (3,1, 2, 'Docker Installed', '1-3', '500-0', 'none', 'cannot.execute.ansible');
--insert into CONDITION (condIndex, condId, condSubId, condDesc, yesDept, noDept, yesMsg, noMsg) values (4,1, 3, 'Docker Image Downloadable', '1-4', '500-0', 'none', 'cannot.execute.ansible');
--insert into CONDITION (condIndex, condId, condSubId, condDesc, yesDept, noDept, yesMsg, noMsg) values (5,1, 4, 'Docker Image Runnable', '2-0', '500-0', 'none', 'cannot.execute.ansible');
--insert into CONDITION (condIndex, condId, condSubId, condDesc, yesDept, noDept, yesMsg, noMsg) values (6,2, 0, 'Host Accessibility', 'none', 'none', 'none', 'none');
--insert into CONDITION (condIndex, condId, condSubId, condDesc, yesDept, noDept, yesMsg, noMsg) values (7,2, 1, 'Master Hosts Accessible', '2-2', 'none', 'none', 'none');
--insert into CONDITION (condIndex, condId, condSubId, condDesc, yesDept, noDept, yesMsg, noMsg) values (8,2, 2, 'Node Hosts Accessible', '2-3', 'none', 'none', 'none');
--insert into CONDITION (condIndex, condId, condSubId, condDesc, yesDept, noDept, yesMsg, noMsg) values (9,2, 3, 'ETCD Host Accessible', 'none', '3-1', 'none', 'none');
--insert into CONDITION (condIndex, condId, condSubId, condDesc, yesDept, noDept, yesMsg, noMsg) values (10,3, 0, 'Requirement Packages Installation ', 'none', 'none', 'none', 'none');
--insert into CONDITION (condIndex, condId, condSubId, condDesc, yesDept, noDept, yesMsg, noMsg) values (10,3, 1, 'Yum Pkg installable', 'end', 'end', 'none', 'none');
--insert into CONDITION (condIndex, condId, condSubId, condDesc, yesDept, noDept, yesMsg, noMsg) values (10,100, 0, 'Notify Msg', 'none', 'none',  'none', 'none');
--insert into CONDITION (condIndex, condId, condSubId, condDesc, yesDept, noDept, yesMsg, noMsg) values (11,500, 0, 'Notify Msg', 'none', 'none',  'none', 'none');
--
--
--insert into CONDITION_RESULT (condResultIndex,acName, condId, condSubId, condResult, msg) values (1,'sandbox', 1, 0, 0, 'none' );
--insert into CONDITION_RESULT (condResultIndex,acName, condId, condSubId, condResult, msg) values (2,'sandbox', 1, 1, 0, 'none' );
--insert into CONDITION_RESULT (condResultIndex,acName, condId, condSubId, condResult, msg) values (3,'sandbox', 1, 2, 2, 'none' );
--insert into CONDITION_RESULT (condResultIndex,acName, condId, condSubId, condResult, msg) values (4,'sandbox', 1, 3, 2, 'none' );
--insert into CONDITION_RESULT (condResultIndex,acName, condId, condSubId, condResult, msg) values (5,'sandbox', 1, 4, 2, 'none' );
--insert into CONDITION_RESULT (condResultIndex,acName, condId, condSubId, condResult, msg) values (6,'sandbox', 2, 0, 1, 'none' );
--insert into CONDITION_RESULT (condResultIndex,acName, condId, condSubId, condResult, msg) values (7,'sandbox', 2, 1, 1, 'master1.example.com ok\n master2.example.com no' );
--insert into CONDITION_RESULT (condResultIndex,acName, condId, condSubId, condResult, msg) values (8,'sandbox', 2, 2, 0, 'node1.example.com ok\n node2.example.com ok' );
--insert into CONDITION_RESULT (condResultIndex,acName, condId, condSubId, condResult, msg) values (9,'sandbox', 2, 3, 0, 'etcd1.example.com ok\n etcd2.example.com ok' );
--

