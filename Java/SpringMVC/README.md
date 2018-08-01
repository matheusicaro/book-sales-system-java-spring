# Course ServLets in Java - Done!

This project consists of a book sales system, where it is possible to book a book for sale with different types of prices and images of the product in a database. Also, it is possible to purchase products and simulate payment using an external API.

Below you will find each step until the project is completed.

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

# Installation and access

Necessary to configure a database, in this project was used PostGre. To configure another database, simply import the dependencies and configure the connection driver in the JPAConfiguration class. Export project in jar or run in an IDE.

The views are accessed through the addresses http: // localhost: 8080 / spring-adventure / *:

* / products -> Page that lists the products that are registered in the database

* / products / productsDetails / {id} -> Page to access the details of the desired product, or access through a link on the page of * / products.

* / shopping-cart -> Responsible for the shopping cart of the selected products.

The dependencies used in this project can be found in the pom.xml file.

# Course Certificate

** Course Summary: [Link] (https://drive.google.com/open?id=15KchQE4LEmKajFMcbpuqB1a17lGcvL5L)

** Certificate: [Link] (https://drive.google.com/open?id=1RIw-HRBOathi_80IszugPhcrlYrGqIKI)