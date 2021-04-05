## Configuration
Clone the api-java repository (you can do it from your IDE)
```
git clone https://github.com/alexdlle/mspr-spring-api.git
```
Launch the project in your IDE and let the dependencies be installed

## Launch Spring Serv
```
mvn spring-boot:run
```
If Maven is not installed, use :
```
brew install maven
```

## Test the API
You can test the API with Postman.\
The PATH to test it is :
```
http://localhost:8080/upload
```
The API need one File parameter.
There is a test file inside the repo below :
```
/src/main/resources/test.xml
```

[Postman-configuration](images/postman.png)