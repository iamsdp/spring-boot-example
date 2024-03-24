
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

# Dependacies Added in pom.xml:
- [postgresql JDBC Driver](https://jdbc.postgresql.org/)
- spring data JPA

* While adding dependancies, artifactID should be searched and selected and based on that groupID will be suggested to select. 

## Shortcuts Used on IntelliJ Idea CE:
- Command + N : For Adding Constructor/Getter/Setter etc
- 