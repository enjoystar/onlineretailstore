# Online Retail Store

Starting Application

1)  cd <ROOT_DIR>
mvn spring-boot:run

Test Application

Application can be tested in two ways:

1) Standalone Application: As an standalone application where user needs to enter inputs after starting the starting the application.
Sample input Output
	

	***********************************************
	             Online Retail Store
	***********************************************
	Product List:
	-------------
	Product [id=1, name='Bat', price='100.00', category='A' ]
	Product [id=2, name='Tennis Ball', pri00', category='A' ]
	Product [id=2, name='Tennis Ball', price='20.00', category='A' ]
	Product [id=3, name='Apple Laptop', price='90000.00', category='B' ]
	Product [id=4, name='Samsung Mobile', price='55000.00', category='B' ]
	Product [id=5, name='Apple Laptop', price='400.00', category='C' ]
	Product [id=6, name='Samsung Mobile', price='11000.00', category='C' ]

	--------------------------
	            Menu
	--------------------------
	(1) Add product to the list.
	(2) Display all product list
	(3) Total Bill
	(4) Exit.

2) REST Application: Using REST api's user can fetch products and its categories

	a) Get all the products available in online retail store
	curl http://localhost:8080/product

	b) Get all the products categories available in online retail store
	curl http://localhost:8080/category
	
NOTE:

1) Unit testing of domain CRUD operations is not needed because spring data is directly used. Hence there is no need of Service or Repository Implementation Layer.

2) Validation of Domain object is skipped and creation of business exception
