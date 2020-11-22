This repo demonstrates usage of Azure app service maven plugin for deploying Spring boot for application to azure cloud. Azure app service is Platform as a Service offering from azure, which offers a fully managed platform for building, deploying and scaling your web apps. 


Pre-requisite:
```
1) JDK 11
2) Eclipse / IntelliJ IDE 
3) Maven (if not part of IDE already)
4) Postman
5) Azure cloud account 
6) Azure CLI
```

Steps to Setup :
1. Clone the application
```
https://github.com/dhruvesh-patel/spring-boot-azure-app-service.git
```

2. Go to src/main/resources/application.properties file and note H2 database user name & password. 
```
spring.datasource.username=XXXXX
spring.datasource.password=XXXXX
```

3. Build and run the app using IDE / maven
```
mvn clean install 
mvn spring-boot:run
The app will start running - check app health using http://localhost:8951/health.
```
4. For in-memory H2 database console, Use this URL - http://localhost:8951/h2-console and below values (refer above point 2 for user name / password).
```
JDBC URL - jdbc:h2:mem:testdb
User name - xxxxx
Password - xxxxx
```

You can run below query and check USERS table is created with 5 rows in it (as we have defined data.sql under resources folder). 
```
select * from USERS;
```

5. Explore Rest APIs. This app defines following CRUD APIs.

```
GET /users

GET /users/{userId}

DELETE /users/{userId}

POST /users

Sample Post Request - 
{
  "id": 100,
  "firstName": "MS",
  "lastName": "Dhoni",
  "email": "ms.dhoni@bcci.com",
  "status": "ACTIVE",
  "createdBy": "SYSTEM",
  "updatedBy": "SYSTEM"
}

PUT /users/{userId}

Sample Put Request - 

{
  "id": 5,
  "firstName": "Eoin",
  "lastName": "Morgan",
  "email": "eoin.morgan@ecb.com",
  "status": "ACTIVE",
  "createdBy": "SYSTEM",
  "updatedBy": "SYSTEM"
}
```

7. Once you test application locally and ensure it is working fine. Use below command to deploy the application to azure. 

```
Logon to Azure:
Use az login to connect to the Azure subscription. Ensure you have contributor access on the Resource Group.

Deploy to Azure App Service
mvn azure-webapp:deploy
```

8. Azure app service will show application URL and hit the APIs exposed to check application working. 
