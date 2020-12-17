# CheckOutSystem
=======================


Table of Contents
-----------------

- [Intro](#intro)
- [Prerequisites](#prerequisites)
- [Building and Testing](#building-and-testing)
- [Where do I start](#where-do-i-start)
- [Design and Implementation](#design-and-implementation)
- [Tests](#tests)

Intro
-------------

This is my implementation of the Checkout System.


Prerequisites
-------------

- Java 8
- Maven
- Junit

Building and Testing
---------------

To build the application and run the tests, simply navigate to the project's root directory and run:

```
mvn clean verify
```

Where do I start?
---------------
To get feel of the application , the best place to start would be this tests.: ```/checkout.system.com/src/main/java/helper/TestCheckout.java```
It serves as a good usage example to consumers of the Checkout class.


Design and Implementation
---------------
This section briefly describes the important interfaces/classes of the system and the design decisions behind them.


##### ItemRepository
   This provides an interface for accessing information about the items available at the shop.
   
##### CheckOut 
   1. This scan the items and compare with itemDb
   2. Apply the promotion rule at item level and on the total amount if there is discount criteria if the amount crosses the expected total amount
   3. Calculate the total ,since we are dealing with money -dataType choosen is BigDecimal with 2 decimal precision
   
   
##### Promotion Rules
   1. If you spend over £60, then you get 10% off your purchase
   2. If you buy 2 or more travel card holders then the price drops to £8.50.

Tests
---------------
Test data
---------
1. Basket: 001,002,003
   Total price expected: £66.78
2. Basket: 001,003,001
   Total price expected: £36.95
3. Basket: 001,002,001,003
   Total price expected: £73.76


