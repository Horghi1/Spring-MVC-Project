# Online-Shopping-Spring-MVC
This is a demo E-commerce web Application using Spring MVC [XML Configuration] for school project. It uses JSP for templates views and it has an In-Memory database. 

# Assignment requirements:
Create the online store application. Within the application, there must be at least 3 pages (customers, products, and sales).
On the products page, products must be allowed to be inserted, deleted, and updated.
On the customer page, the introduction, deletion and updating of customers must be allowed, and on the sales page, the sale of products to certain customers must be ensured.
Each sale involves updating the status in the product table as well as in the customer table.
You can use any framework that is being processed in course


*Additional specification:

In this application you do not need to differentiate between regular users and administrators.
Sales will be recorded only in the sales table. The registration of the sale will in principle contain three data:
1. the date by which the customer will be identified, which will be the customer's id

2. the date by which the sold product will be identified, which will be the product id

3. the quantity of the product sold.

Of course, a sale transaction can be seen in a more complex way, for example being stored in the record of a sale and other data, or being composed of the sale of several products. But for this application this modeling is enough.
At this point it will be noted that there will be three entities: Customer, Product and Sales.
Each product will at some point have a quantity in which it will be available. When a sale transaction is made, the quantity sold will be deducted from the available quantity. It is noted that the transaction will be possible only if the quantity sold will be less than or at most equal to the quantity available. If this condition is not met, the sale transaction should not be possible, and the application may issue an error message.
The application may or may not provide a data persistence mechanism





# Tools & Technologies
*	Spring MVC Framework (Java Config)
*	JSP
*	CSS
*	Bootstrap
* Maven
*	GlassFish

# Functionalities
* Add new User 
*	CRUD Operations like
*	User can add product to his cart
*	Admin can add product to the product list
*	Admin can edit the product details
*	Admin can delete the product from the list
*	Admin can approve/decline sale process


# ScreenShots

* **Welcome**

![Welcome](https://user-images.githubusercontent.com/60060379/91293137-d4884600-e797-11ea-97a5-9696e37b8ae0.jpg)

* **Products**

![Products](https://user-images.githubusercontent.com/60060379/91293764-cc7cd600-e798-11ea-805f-ec661601cd3e.jpg)

* **Clients**

![Clients](https://user-images.githubusercontent.com/60060379/91293339-2335e000-e798-11ea-9942-082d5f1dfb3a.jpg)

* **Sales**

![Sales](https://user-images.githubusercontent.com/60060379/91293367-3183fc00-e798-11ea-95d7-7ad3bba98066.jpg)

* **Update Product**

![UpdateProduct](https://user-images.githubusercontent.com/60060379/91293396-3d6fbe00-e798-11ea-937b-d243a7e17ab9.jpg)

* **Add New Product**

![AddNewProduct](https://user-images.githubusercontent.com/60060379/91293425-46f92600-e798-11ea-9db4-39e04ab72a87.jpg)



