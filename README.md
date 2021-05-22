# Central-Word-Spring-Test
> Design with Hexagonal architecture which have 3 layer, namely, domain, application, infrastucture.
> Using both temporary jpa with h2 database and third party with echo postman and already prepared data for test around 10 record of product.
> It incloulds caching (fixed 10 minute then clear) at get all products, you can see in my code.

# How to run this project>
> 1. run mudule bootLoader which is spring boot.
> 2. base url is http://localhost:8080

# End point
 1 JPA H2 Database
> 1. /v1/database/product/get -> get all products (Cache by 10 minute)
> 2. /v1/database/product/get/{id} -> get product by id
> 3. /v1/database/product/add -> post product by object productDto
> 4. /v1/database/product/update -> put product by object productDto
> 5. /v1/database/product/delete/{id} -> delete product by id

 2 Postman Echo
> 1. /v1/postman/product/get -> get all products (Cache by 10 minute)

# What is a Hexagonal Architecture?

![Alt text](https://www.baeldung.com/wp-content/uploads/2019/12/DDD-Layers.png)

> Hexagonal architecture is a model of designing software applications around domain logic to isolate it from external factors.

> The domain logic is specified in a business core, which we'll call the inside part, the rest being outside parts. Access to domain logic from the outside is available through ports and adapters. 


> Firstly, we should define principles to divide our code. As explained briefly already, hexagonal architecture defines the inside and the outside part.

> What we'll do instead is divide our application into three layers; application (outside), domain (inside), and infrastructure (outside): Through the application layer, the user or any other program interacts with the application. This area should contain things like user interfaces, RESTful controllers, and         JSON serialization libraries. It includes anything that exposes entry to our application and orchestrates the execution of domain logic.

> In the domain layer, we keep the code that touches and implements business logic. This is the core of our application. Additionally, this layer should be isolated from   both the application part and the infrastructure part. On top of that, it should also contain interfaces that define the API to communicate with external parts, like the database, which the domain interacts with.

> Lastly, the infrastructure layer is the part that contains anything that the application needs to work such as database configuration or Spring configuration. Besides, it also implements infrastructure-dependent interfaces from the domain layer.

# Why and when uses a Hexagonal Architecture?
> If we’re building a CRUD application that simply stores and saves data, an architecture like this is probably overhead. If we’re building an application with rich business rules that can be expressed in a rich domain model that combines state with behavior, then this architecture really shines because it puts the domain model in the center of things.

# What is difference between Hexagonal and MVC Architecture?

#Complex

> Using these patterns will help maximise your compliance with the principles of SOLID, but at the cost of an initial increase in development complexity. The hope however is that it'll decrease the development complexity over time as the project grows.

Includes: Hexagonal.

#Simple

> Using these patterns will help increase your compliance with the principles of SOLID, but it'll be easier to skimp on some principles. They're however simpler to use and will help decrease development complexity a lot sooner than the complex patterns.

Includes: MVVM, MVC, MVP.

# Referrence
> https://www.baeldung.com/hexagonal-architecture-ddd-spring<br/>
> https://reflectoring.io/spring-hexagonal


