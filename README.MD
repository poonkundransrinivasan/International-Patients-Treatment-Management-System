# International Patients Treatment Management System

International Patients Treatment Management System is a web application to list and choose the treatment packages for International patients, register them, track their treatment to closure through insurance claim.


* The application can be broken down into four microservices and one web client
* The Microservices were independently tested and deployed on cloud
* The microservices used H2 In-memory database and performed CRUD operations
* These services were consumed from an MVC app running in a local environment
* The microservices were 
    * International patient treatment offerings module
    * International patient treatment module
    * Insurance claim module
    * Authorization service

## Technologies used

    # International Patients Treatment Management System

    A microservices-based web application to manage treatment packages for international patients, register patients, assign specialists, track treatment progress, and process insurance claims.

    ## Table of contents

    - [Overview](#overview)
    - [Architecture](#architecture)
    - [Services](#services)
    - [Technologies](#technologies)
    - [Getting started](#getting-started)
    - [Running the services (PowerShell)](#running-the-services-powershell)
    - [Testing and database console](#testing-and-database-console)
    - [API documentation / exploration](#api-documentation--exploration)
    - [Contributing](#contributing)
    - [License](#license)

    ## Overview

    This project demonstrates a hospital system that supports international patient workflows:

    - Publishing treatment packages and specialist information
    - Registering international patients and creating treatment plans
    - Assigning specialists and tracking treatment status until closure
    - Initiating and tracking insurance claims
    - Securing APIs via an authorization service

    The codebase is split into independent Spring Boot microservices and a web portal that consumes those services.

    ## Architecture

    Each microservice is independently buildable and deployable. During development they use an H2 in-memory database for simplicity. Services communicate using HTTP and OpenFeign.

    Key characteristics:

    - Spring Boot microservices
    - RESTful APIs
    - Spring Security for auth
    - H2 (runtime) for development and tests
    - OpenFeign for inter-service calls

    ## Services

    - `Portal-Microservice` — web portal (packaged as WAR) that integrates the other services and provides the UI.
    - `Authorizatiion-Microservice` — authentication and authorization.
    - `IPTreatmentOffering-Microservice` — treatment packages and specialist data.
    - `IPTreatment-MicroService` — patient registration, specialist assignment, treatment plans.
    - `InsuranceClaim` — insurers listing and claim initiation/processing.

    Each service folder contains its own `pom.xml` and Maven wrapper (`mvnw`, `mvnw.cmd`).

    ## Technologies

    - Java 8 / 11 (project uses Spring Boot 2.4.x in module POMs)
    - Spring Boot, Spring Data JPA, Spring MVC, Spring Security
    - Spring Cloud OpenFeign
    - H2 Database (development/runtime)
    - Lombok
    - JUnit, Mockito, MockMVC for tests
    - AWS (deployment-ready)

    ## Getting started

    Requirements

    - Java JDK 8 or 11 installed and JAVA_HOME configured
    - Git
    - (Optional) An IDE such as IntelliJ IDEA or VS Code

    Clone the repository:

    ```powershell
    git clone https://github.com/poonkundransrinivasan/International-Patients-Treatment-Management-System.git
    cd International-Patients-Treatment-Management-System
    ```

    Build all modules (from repo root):

    ```powershell
    # Windows PowerShell: run the Maven wrapper for each module or run a root-level build if you prefer
    cd .\Authorizatiion-Microservice; .\mvnw.cmd -DskipTests clean package; cd ..\
    cd .\IPTreatmentOffering-Microservice; .\mvnw.cmd -DskipTests clean package; cd ..\
    cd .\IPTreatment-MicroService; .\mvnw.cmd -DskipTests clean package; cd ..\
    cd .\InsuranceClaim; .\mvnw.cmd -DskipTests clean package; cd ..\
    cd .\Portal-Microservice; .\mvnw.cmd -DskipTests clean package; cd ..\
    ```

    Note: You can also build from your IDE or run each module with the `spring-boot:run` goal during development.

    ## Running the services (PowerShell)

    Start services (each in its own terminal). These commands use the Maven wrapper included in each service folder.

    ```powershell
    # Start Authorization service
    cd .\Authorizatiion-Microservice
    .\mvnw.cmd spring-boot:run

    # Start Treatment Offerings service (new terminal)
    cd ..\IPTreatmentOffering-Microservice
    .\mvnw.cmd spring-boot:run

    # Start IP Treatment service (new terminal)
    cd ..\IPTreatment-MicroService
    .\mvnw.cmd spring-boot:run

    # Start Insurance Claim service (new terminal)
    cd ..\InsuranceClaim
    .\mvnw.cmd spring-boot:run

    # Start Portal (web) service (new terminal)
    cd ..\Portal-Microservice
    .\mvnw.cmd spring-boot:run
    ```

    If you prefer to run packaged JAR/WAR files instead of `spring-boot:run`, build the project and run the generated artifact with `java -jar`.

    ## Testing and database console

    - Unit and integration tests use JUnit, Mockito and MockMVC. Run tests via Maven: `mvnw.cmd test` in a module directory.
    - H2 console (if enabled in a service) is typically available at `/h2-console` when the service is running — check the service's `application.properties` for the exact URL and credentials.

    ## API documentation / exploration

    - Use Postman or curl to explore REST endpoints exposed by each service.
    - If Swagger/OpenAPI is enabled in any module, the UI will usually be available at `/swagger-ui.html` or `/swagger-ui/index.html`.

    ## Contributing

    Contributions are welcome. Suggested workflow:

    1. Fork the repository
    2. Create a feature branch: `git checkout -b feat/your-feature`
    3. Commit changes and push
    4. Open a pull request describing your changes

    Please include unit tests for new functionality.

    ## License

    This project does not include a license file by default. If you want to add one, common choices are the MIT or Apache-2.0 license. Add a `LICENSE` file at the repository root and reference it here.

    ---

    If you'd like, I can:

    - add a quick-start script to run all services locally (PowerShell)
    - enable Swagger/OpenAPI configuration in each microservice
    - add a minimal integration test that boots the portal and one backend service

    Tell me which of the above you'd like me to do next.
