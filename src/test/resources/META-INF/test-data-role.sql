-- Role Data

INSERT INTO PUBLIC.ROLE (ROLE_INDEX, ROLE_NAME, ROLE_TARGET_HOSTS, ROLE_SHORT_DESC, ROLE_LONG_DESC) VALUES (1, 'master_controller_lead_varification', 'master', 'Master Controller Lead Verification', 'Who is the lead controller among masters?');
INSERT INTO PUBLIC.ROLE (ROLE_INDEX, ROLE_NAME, ROLE_TARGET_HOSTS, ROLE_SHORT_DESC, ROLE_LONG_DESC) VALUES (2, 'api_server_health_check', 'master', 'Check API Server/Web Console health', 'API Server/Web Console health Check using RESTful API.');
INSERT INTO PUBLIC.ROLE (ROLE_INDEX, ROLE_NAME, ROLE_TARGET_HOSTS, ROLE_SHORT_DESC, ROLE_LONG_DESC) VALUES (3, 'openshift_daemons_status_check', 'masters:nodes:etcd', 'Check OpenShift Daemons Status', 'On master node, there are several services related to OpenShift.');
INSERT INTO PUBLIC.ROLE_PROFILE (RP_INDEX, RP_NAME, RP_DESC) VALUES (1, 'master', 'basic master health check items');

INSERT INTO PUBLIC.ROLE_PROFILE_BIND (RP_INDEX, ROLE_INDEX) VALUES (1, 1);
INSERT INTO PUBLIC.ROLE_PROFILE_BIND (RP_INDEX, ROLE_INDEX) VALUES (1, 2);
INSERT INTO PUBLIC.ROLE_PROFILE_BIND (RP_INDEX, ROLE_INDEX) VALUES (1, 3);

INSERT INTO PUBLIC.ROLE_OPERATE_INPUT (OPERATE_INPUT_INDEX, OPERATE_INPUT_TYPE, OPERATE_INPUT_VALUE) VALUES (1, 'String', 'active');
INSERT INTO PUBLIC.ROLE_OPERATE_INPUT (OPERATE_INPUT_INDEX, OPERATE_INPUT_TYPE, OPERATE_INPUT_VALUE) VALUES (1, 'String', 'inactive');

INSERT INTO PUBLIC.ROLE_OPERATE (OPERATE, OPERATE_DESC, OPERATE_INPUT_INDEX, OPERATE_INDEX) VALUES ('Is_Active', 'Check if a daemon is active or inactive', 1, 1);
INSERT INTO PUBLIC.ROLE_EXPECT_RESULT (RP_INDEX, ROLE_INDEX, OPERATE_INDEX, EXPECT_RESULT) VALUES (1, 3, 1, 'active');



-- Config Data

insert into ANSIBLE_CONTROLLER (ac_name, host_ip, user_id, user_pw, hosts_file) values ('sandbox', '10.10.12.21', 'root', 'redhat', 'master.example.com 10.10.10.10');