Check OpenShift Daemons Status 
===

On master node, there are several services related to OpenShift.   

This role check the status of the services:
- atomic-openshift-master
- atomic-openshift-master-api
- atomic-openshift-master-controllers
- atomic-openshift-node
- etcd
- docker
- openvswitch
- dnsmasq
- NetworkManager


Requirements
---
none
 
Role Variables
---
 
| Name                    | Default value                  |Required               | Description                                                                 |
|-------------------------|--------------------------------|-----------------------|-----------------------------------------------------------------------------|
| none|
 
 
Dependencies
---
 none
 
 
Example Playbook
---
 
 ```
- name: Check if OpenShift daemons status is active.
  hosts: all
  gather_facts: false
  tasks:
  - include_roles:
  		name: openshift-daemons-status-check

 ```
 
Example Variables
---
```
all:
  masters:
    hosts:
      master1.example.com:
        ansible_port: 5555
        ansible_host: 192.0.2.50
```
      
 
License
---

Apache License Version 2.0

Author Information
------------------

This role was created in 2018 by [Jooho Lee](http://github.com/jooho).
 