
# Pickar Currency Converter

**Pickar Currency Converter** is a simple web application that convert currency using real time data while logging every conversion made. Technologies used:

  - **Spring Boot** for Backend development.
  - **Angular** for Frontend development.

## Quick overview of the final result

Navigate to http://pickar-currency-converter.herokuapp.com to get an overview of the final result :)


## Building from source
To build the project from source, we start by building our angular app.
```sh
ng build --prod --aot
```
This will generate a dist folder containing our Angular Single Page Appilcation.
Copy the build inside *dist/pickar-currency-converter* to the spring boot *static* folder.

Build the Spring Boot project.
```sh
./mvnw
```
This will create a jar file inside the target folder. To run the application, run:
```sh
java -jar target/currency-converter-0.0.1-SNAPSHOT.jar
```
This will run the application locally on port 8080. To access the application, navigate to:
```sh
localhost:8080
```

## Docker
**Pickar Currency Converter** is very easy to install and deploy in a docker container.

By default, the repository is equipped with a Dockerfile enabling to build an out-of-the-box docker image.
To build the image from the Dockerfile, enter:

```sh
./mvnw package && sudo docker build -t pickar-currency-converter .
```
This will create the image tagged as *pickar-currency-converter* and pull in the necessary dependencies.

Once done, run the docker image and map the port to whatever you wish on your host. In this example, we simply map port 8000 of the host to port 8080 of the container.

```sh
sudo docker run -d -p 8000:8080 pickar-currency-converter
```
Verify the deployment by navigating to your server address in your preferred browser.

```sh
localhost:8000
```

## Technical limits
The converter is only able to convert the USD currency because of the limitation of the free subscription in the Currency Layer API :(
For this specific reason, the "Convert" button is disabled if the user wants to convert from another currency other than USD.
The layout was tested on Firefox, Chrome and Opera only.

## Architecture of the Spring project
The project is structured as follow:
  - config: configuration files for CORS and Redirection of wrong routes to index.html
  - controller: the entry-point of the application, defines a RESTful API as an interface.
  - dto: files used for data transfer and hiding domain-specific information from the outside.
  - model: defines the set entities.
  - repository: abstraction to the CRUD operations based on the JPA specification.
  - service: defines our business logic in terms of services.

## Architecture of the Angular project
The project is structured as follow:
- models: defines an interface to the RESTful API resources.
- services: defines the logic of interacting with external services.
- views: provides the different components of the application.

*.spec.ts* files define the test code of the different services and components.
