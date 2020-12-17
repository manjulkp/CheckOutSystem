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
   This scan the items 
   
##### Promotion Rules
   1. If you spend over £60, then you get 10% off your purchase
   2. If you buy 2 or more travel card holders then the price drops to £8.50.

Tests
---------------
There are a number of unit tests which cover pretty much everything that isn't a trivial getter/setter. 


