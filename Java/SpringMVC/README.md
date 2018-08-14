# Course ServLets in Java - Done!

This project consists of a book sales system, where it is possible to book a book for sale with different types of prices and images of the product in a database. Also, it is possible to purchase products and simulate payment using an external API.

Below you will find each step until the project is completed.
**PART 1
1) Creating a first control and entities
2) Configuring Home, preparing Spring JPA, and configuring the TransactionManager
3) Creating the Views and modeling the type of data and price of the products, and still registering in the database
4) Preparing econding and controller, DAO and JSP
5) Implementing HTTP, Redirect methods with flash scope
6) Validating and converting data, ValidationUtils.
7) Preparing the ResourceBundle and Setting the Views
8) Using Calendar
9) Implementing file uploads with Multipart
10) Implementing attributes in views through arguments to friendly URLs
11) Exposing Attributes in Views
12) Scope Session
13) Implementing a shopping cart and payment using external api.
14) Implementing asynchronous requests

**PART 2
1) Cache Performance
2) Rest Service Creation
3) Spring Security
4) Views with Template
5) i18n
6) Publishing project - Heroku

# Installation and access

**1. mvn clean
  2. mvn clean install
  3. Go to the target folder

**create database and after starting the application, the tables will be generated automatically by Hibernate, done this, necessary to insert query below to login and in the system and pages monitored by Spring Security.
```
insert into Role values('ROLE_ADMIN');

insert into Usuario (email, name, password) values ('admin@admin', 'Administrador', '$2a$04$qP517gz1KNVEJUTCkUQCY.JzEoXzHFjLAhPQjrg5iP6Z/UmWjvUhq'); //password = 123456, gerado por gerado por "new BCryptPasswordEncoder().encode("123456")";

insert into Usuario_Role(user_email, roles_name) values('admin@admin', 'ROLE_ADMIN');
```

The views are accessed through the addresses http: // localhost: 8080 / spring-adventure / *:

*/products -> Page that lists the products that are registered in the database

*/products / productsDetails / {id} -> Page to access the details of the desired product, or access through a link on the page of * / products.

*/shopping-cart -> Responsible for the shopping cart of the selected products.

The dependencies used in this project can be found in the pom.xml file.

# Course Certificate

**Certificate pt 1: [Link] (https://drive.google.com/open?id=1RIw-HRBOathi_80IszugPhcrlYrGqIKI)
**Certificate pt 2: [Link] (https://drive.google.com/open?id=1YRH9TF_UZ7MN8-Smi5RQ0SGF_hlrV_8_)
