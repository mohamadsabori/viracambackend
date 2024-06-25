### ViraCam Webshop Backend
This repository contains the backend service for the ViraCam webshop. It provides functionalities to manage categories, products, users, and orders in the store's database.

# Introduction
This backend service is designed to handle CRUD operations for managing electronic goods and related entities in the ViraCam webshop. It uses Spring Boot framework with a PostgreSQL database to store and retrieve data efficiently.

# Technologies Used
- `Java`: Programming language used for backend development.
- `Spring Boot`: Framework for creating RESTful services and managing dependencies.
- `Spring Data JPA`: Used for easy implementation of data access layer with JPA.
- `PostgreSQL`: Relational database management system for storing data.
- `JUnit 5 and Mockito`: Libraries for unit testing and mocking dependencies.
- `Maven`: Dependency management and build automation tool.
## Setup
To run this project locally, ensure you have Java 8 or higher installed along with Maven. You'll also need access to a PostgreSQL database. Follow these steps:

Clone the repository:

```shell
git clone git@github.com:mohamadsabori/viracambackend.git
cd viracambackend
```

## Configure database:

Create a PostgreSQL database named viracam_webshop.

Update application.properties with your database credentials:

## properties
```
spring.datasource.url=jdbc:postgresql://localhost:5432/viracam_webshop
spring.datasource.username=your_username
spring.datasource.password=your_password
```
## Run the application:
```shell
mvn spring-boot:run
```
This will start the application on http://localhost:8080.

## Usage
Once the application is running, you can use tools like Postman or curl to interact with the API endpoints. Below are the main functionalities provided:

## Endpoints
Categories
```
GET /api/categories: Retrieve all categories.
POST /api/categories: Add a new category.
Request Body:
json
Copy code
{
  "name": "Category Name",
  "description": "Category Description"
}
GET /api/categories/{categoryCode} Get category by category code.
```

Products
```
GET /api/products: Retrieve all products.
POST /api/products: Add a new product.
Request Body:
json
Copy code
{
  "name": "Product Name",
  "price": 100.00,
  "categoryCode": "category_code"
}
GET /api/products/{productId}: Get product by product ID.
```


Users
```
GET /api/users: Retrieve all users.
POST /api/users: Add a new user.
Request Body:
json
Copy code
{
  "username": "user123",
  "email": "user123@example.com",
  "password": "password"
}
GET /api/users/{userId}: Get user by user ID.
```
Orders
```
GET /api/orders: Retrieve all orders.
POST /api/orders: Place a new order.
Request Body:
json
Copy code
{
  "userId": 1,
  "productId": 1,
  "quantity": 2,
  "totalPrice": 200.00
}
```


## Testing
Unit tests are included to verify the functionality of each service and repository. To run the tests, use:

```Shell
mvn test
```

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your improvements.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

