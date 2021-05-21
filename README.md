"# Central-Word-Spring-Test" 

# What is a Hexagonal Architecture?

![Alt text](https://www.baeldung.com/wp-content/uploads/2019/12/DDD-Layers.png)

    Hexagonal architecture is a model of designing software applications around domain logic to isolate it from external factors.

    The domain logic is specified in a business core, which we'll call the inside part, the rest being outside parts. Access to domain logic from the outside is available through ports and adapters. 
    
   
    
    Firstly, we should define principles to divide our code. As explained briefly already, hexagonal architecture defines the inside and the outside part.

    What we'll do instead is divide our application into three layers; application (outside), domain (inside), and infrastructure (outside): Through the application layer, the user or any other program interacts with the application. This area should contain things like user interfaces, RESTful controllers, and         JSON serialization libraries. It includes anything that exposes entry to our application and orchestrates the execution of domain logic.

        In the domain layer, we keep the code that touches and implements business logic. This is the core of our application. Additionally, this layer should be isolated from   both the application part and the infrastructure part. On top of that, it should also contain interfaces that define the API to communicate with external parts, like the database, which the domain interacts with.

    Lastly, the infrastructure layer is the part that contains anything that the application needs to work such as database configuration or Spring configuration. Besides, it also implements infrastructure-dependent interfaces from the domain layer.

# Why is a Hexagonal Architecture?

# What is deferrent between Hexagonal and MVC Architecture?

#Referrence
> https://www.baeldung.com/hexagonal-architecture-ddd-spring
> https://reflectoring.io/spring-hexagonal


