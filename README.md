
## N-Tier Architecture:
- Here each layer is responsible for only one Task.
``` 
[Client or CMD or Web App] --> 
[API Layer] -->
[Business Layer] -->
[DAO Layer] -->
[DB]
```

# Database Used:
- Postgres SQL
- Used Docker-Compose to run it on local with the help of compose file.
- Created DB using cmd
```
docker exec -it postgres bash
root@9afe3257c431:/# psql -U amigoscode
amigoscode=# \l
amigoscode=# CREATE DATABASE customer;
CREATE DATABASE
amigoscode=# \l
amigoscode=#
```
Table level Operations:
```
amigoscode-# \c customer
You are now connected to database "customer" as user "amigoscode".
customer-# \dt
 public | customer | table | amigoscode
customer-# \d
 public | customer             | table    | amigoscode
 public | customer_id_sequence | sequence | amigoscode
customer-# \d customer
 age    | integer                |           |          |
 id     | integer                |           | not null |
 email  | character varying(255) |           |          |
 name   | character varying(255) |           |          |
customer=# insert into customer (id, age, email, name) VALUES (nextval('customer_id_sequence'), 28,'prk@gmail.com','Pratik');
INSERT 0 1
customer=# insert into customer (id, age, email, name) VALUES (nextval('customer_id_sequence'), 26,'iam@gmail.com','Saurabh');
INSERT 0 1
customer=# Select * from customer;
  28 |  1 | prk@gmail.com | Pratik
  26 |  2 | iam@gmail.com | Saurabh
```

# Dependacies Added in pom.xml:
- [postgresql JDBC Driver](https://jdbc.postgresql.org/)
- spring data JPA

* While adding dependancies, artifactID should be searched and selected and based on that groupID will be suggested to select. 

## Shortcuts Used on IntelliJ Idea CE:
- Command + N : For Adding Constructor/Getter/Setter etc
- 