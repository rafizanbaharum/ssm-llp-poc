TODO ssm-llp-poc
===========
- DONE login as admin use spring-sec taglibs  <sec:authorize ifAllGranted="ROLE_ADMINISTRATOR">
- DONE login as regular user
- DONE email username/password:ssm.llp.poc@gmail.com/senanggila
- DONE add current username "User X" to page header
- DONE gmail email registration
- DONE registration     register > registered
- DONE class diagram for presentation NAME, COMPANY
- DONE logout
- DONE JSON android na  me search
- DONE checkout+build on amazon
- DONE search name in secure/ pages, then reserve
- DONE logo on gatein, gateout
- non-avatar menu
- register name from page dashboard > companies > reservations
- search name in secure/ pages, then register
- port to POSTGRES on amazon cloud
- sitemesh for templating
- cache jquery js

NAME RESERVATION
 - pilih nama
 - kalau valid (check thru poison + search) boleh register or reserve(optional, kena bayar)
 - reserve ada expiry date, kasik 3 bulan
 - dari reserve, boleh register

NAME REGISTRATION
 - pilih nama
 - kalau valid boleh register terus, tanpa reserve
 - register, kasik name, registrar(nama tukang register, boleh 3rd party), payment info


KEY POINTS
============
1. Latest Technology Stack
   - Easier to embrace and take advantage of latest tools and technology
   - Java, Hibernate, spring, web+mobile
   - Multi interface, channel, JSON/REST/web/webservice
   - Workflow ready, custom business processes
   - Batch job ready, periodical processes

2. Expansion Room in Design
   - Can handle schema evolution gracefully.
   - Can handle future expansion ie ROB and ROC registration
   - Can integrate with external via ESB.

3. Dynamic, Configurable Rules and Filters
   - Gazetted, Offensive, state, country - can add record.
   - Reserved - expiry, time sensitive
   - Rules are scripted, exposed for admin

4. Performance + Scalability
   - Can take advantage of L1, L2, distributed cache.
   - Cloud ready, deploy on clustered application server

