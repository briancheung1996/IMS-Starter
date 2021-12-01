# E-Commerce management system

This tool can be used to maintain the data for an ecommerce website.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

A MySQL database must be created with the SQL source located at `src\main\resources\sql-schema.sql`:

```
CREATE DATABASE ims;
USE ims;
SOURCE src\main\resources\sql-schema.sql
```

### Installing

To build and install dependencies, change the working directory to the project root
and type the following:

```
mvn install
```

This will generate a jar file in `target/` which can be run with:

```
java -jar ims-0.0.1-jar-with-dependencies.jar
```

The following shows an example interaction with the tool:

```
PS C:\Users\Admin\Documents\hackathon\IMS-Starter\target> java -jar .\ims-0.0.1-jar-with-dependencies.jar                                                                                    Welcome to the Inventory Management System!
Which entity would you like to use?
CUSTOMER: Information about customers
ITEM: Individual Items
ORDER: Purchases of items
STOP: To close the application
item
What would you like to do with item:
CREATE: To save a new entity into the database
READ: To read an entity from the database
UPDATE: To change an entity already in the database
DELETE: To remove an entity from the database
RETURN: To return to domain selection
READ_BY_ID: To read an entity from the database by providing its id
READ_BY_NAME: To read an entity from the database by providing its id
create
Please enter a name
Paper
Please enter a value
5.99
Item created
id:2 name:Paper value:5.99
What would you like to do with item:
CREATE: To save a new entity into the database
READ: To read an entity from the database
UPDATE: To change an entity already in the database
DELETE: To remove an entity from the database
RETURN: To return to domain selection
READ_BY_ID: To read an entity from the database by providing its id
READ_BY_NAME: To read an entity from the database by providing its id
update
Please enter the id of the item you would like to update
2
Please enter a name
Lined Paper
Please enter a value
6.88
Item Updated
What would you like to do with item:
CREATE: To save a new entity into the database
READ: To read an entity from the database
UPDATE: To change an entity already in the database
DELETE: To remove an entity from the database
RETURN: To return to domain selection
READ_BY_ID: To read an entity from the database by providing its id
READ_BY_NAME: To read an entity from the database by providing its id
read
id:1 name:Hammer value:11.0
id:2 name:Lined Paper value:6.88
What would you like to do with item:
CREATE: To save a new entity into the database
READ: To read an entity from the database
UPDATE: To change an entity already in the database
DELETE: To remove an entity from the database
RETURN: To return to domain selection
READ_BY_ID: To read an entity from the database by providing its id
READ_BY_NAME: To read an entity from the database by providing its id
delete
Please enter the id of the item you would like to delete
2
What would you like to do with item:
CREATE: To save a new entity into the database
READ: To read an entity from the database
UPDATE: To change an entity already in the database
DELETE: To remove an entity from the database
RETURN: To return to domain selection
READ_BY_ID: To read an entity from the database by providing its id
READ_BY_NAME: To read an entity from the database by providing its id
read
id:1 name:Hammer value:11.0
What would you like to do with item:
CREATE: To save a new entity into the database
READ: To read an entity from the database
UPDATE: To change an entity already in the database
DELETE: To remove an entity from the database
RETURN: To return to domain selection
READ_BY_ID: To read an entity from the database by providing its id
READ_BY_NAME: To read an entity from the database by providing its id
return
Which entity would you like to use?
CUSTOMER: Information about customers
ITEM: Individual Items
ORDER: Purchases of items
STOP: To close the application
stop
```
