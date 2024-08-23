
# MakerSharks Supplier Search API

## Project Overview

The MakerSharks Supplier Search API allows buyers to search for manufacturers based on customized requirements such as location, nature of business, and manufacturing processes. This proof of concept (POC) API is built using Spring Boot and follows best practices in RESTful API design.

## Table of Contents

= Introduction

= Features

= Installation

= Usage

= Contributing

= License


## Introduction

The MakerSharks Supplier Search API addresses the challenge of finding reliable suppliers by providing a searchable database of manufacturers. It allows buyers to search for suppliers based on specific criteria such as location, nature of business (e.g., small, medium, or large scale), and manufacturing processes (e.g., moulding, 3D printing). This API makes it easier for businesses to connect with the right manufacturers, saving time and improving efficiency in the procurement process.


## Features

- Supplier Management: Add and manage suppliers in the database with detailed information, including company name, website, location, nature of business, and manufacturing processes.

- Search Functionality: Search for suppliers using multiple criteria, such as location, nature of business, and manufacturing process.

- Pagination Support: Retrieve search results in a paginated format, with customizable page sizes.

- Exception Handling: Robust exception handling with meaningful error messages for common issues like supplier not found.
- API documentation using Swagger.

## Installation

### Prerequisites

Before installing, ensure that you have the following installed on your system:

- Java 17 or later

- Maven 3.6+

- Maven 3.6+

- Postman (optional, for API testing)


### Setup Instructions

#### 1. Clone the Repository:

git clone https://github.com/your-username/makersharks-supplier-search.git
cd makersharks-supplier-search


#### 2. Configure the Database:

- Create a MySQL database named 'restdb'

  CREATE DATABASE restdb;

- Update the database connection settings in src/main/resources/application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/restdb
spring.datasource.username=root
spring.datasource.password=admin


#### 3. Build the Project:
mvn clean install

#### 4. Run the Application:
mvn spring-boot:run


The application will start on http://localhost:8080.


## Usage

### 1. Adding a Supplier

To add a supplier, send a POST request to the following endpoint:

- Endpoint: /api/supplier/add
- Method: POST

- Request Body (Example):

{
  "companyName": "ABC Manufacturing",
  "website": "http://abcmanufacturing.com",
  "location": "New York",
  "natureOfBusiness": "MEDIUM_SCALE",
  "manufacturingProcesses": ["MOULDING", "CASTING"]
}

- Response: Returns the added supplier's details, including the generated supplierId.


### 2. Searching for Suppliers

To search for suppliers, send a GET request to the following endpoint:

- Endpoint: /api/supplier/query

- Method: GET

#### Query Parameters:

    - location: (String) Location of the supplier (e.g., "New York").

    - natureOfBusiness: (Enum) Scale of the business (SMALL_SCALE, MEDIUM_SCALE, LARGE_SCALE).

    - process: (Enum) Manufacturing process (MOULDING, THREE_D_PRINTING, CASTING, COATING).

    - size: (Optional) Number of results per page (default is 10).

#### Example Request:

  GET http://localhost:8080/api/supplier/query?location=New%20York&natureOfBusiness=MEDIUM_SCALE&process=MOULDING&size=10


### 3.  Testing with Postman

You can use Postman to test the API endpoints:

- Add Supplier: Use the POST method with the /api/supplier/add endpoint and provide the supplier details in the body.

- Search Supplier: Use the GET method with the /api/supplier/query endpoint, passing the required query parameters.

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

    1. Fork the repository.

    2. Create a new branch (git checkout -b feature/your-feature-name).

    3. Make your changes.

    4. Commit your changes (git commit -m 'Add some feature').

    5. Push to the branch (git push origin feature/your-feature-name).

    6. Open a pull request.

Please ensure that your code follows the project's coding standards and includes appropriate tests.


