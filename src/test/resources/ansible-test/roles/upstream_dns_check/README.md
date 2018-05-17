Check Upstream DNS 
===

For OpenShift Container Platform, we use 2 DNS server: upstream DNS, SkyDNS. 

This role check upstream DNS:
- Resolvable hostname of master/nodoe/etcd/lb/nfs

[Detail information about OpenShift DNS server](https://www.redhat.com/en/blog/red-hat-openshift-container-platform-dns-deep-dive-dns-changes-red-hat-openshift-container-platform-36)


Requirements
---
- bind-utils
 
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
- name: Check if DNS can resolve all hostname((master/etcd/master/lb/nfs[if nfs group exist]) in OCP cluster
  hosts: nodes:masters:etcd
  gather_facts: false
  tasks:
  - include_roles:
  		name: upstream-dns-check

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
 