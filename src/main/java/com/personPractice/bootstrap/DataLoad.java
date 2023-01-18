package com.personPractice.bootstrap;


import com.personPractice.models.Task;
import com.personPractice.repository.TaskRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoad implements ApplicationListener<ContextRefreshedEvent> {

    private final TaskRepository taskRepository;

    public DataLoad(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
            taskRepository.saveAll(getTasks());
    }

    private Set<Task> getTasks(){

        Set<Task> tasks = new HashSet<>();

        Task makeRepos = new Task();

        makeRepos.setTitle("Spring Boot Create Repositories");
        makeRepos.setDescription("Extending the Crud Repository in Java/Spring Boot through the JPA is a very important aspect of application development. \n"+
                "It allows us to persist all the data for our website to our stored servers. Imagine logging into a website, going through the grueling processes of \n"+
                "creating an account, verifying your account through email, setting up an MFA for your password, and then having to do that process over and over. \n"+
                "Sounds Terrible right! This is where developers come in and use the JPA to persist all of your data onto a server so you don't have these problems. \n"+
                "Heck, you can even update your information, get information that was previously stored, and even look at other users information, and so much more. \n"+
                "To say the least, this is a very important and crucial task for any application or website that's on the world wide web.");

        tasks.add(makeRepos);

        Task makeControllers = new Task();
        makeControllers.setTitle("Spring Boot Create Controllers");
        makeControllers.setDescription("Spring Boot controllers are important because they provide a way to handle HTTP requests and map them to appropriate methods in the application's code. \n"+
                "They act as the bridge between the incoming request and the application's business logic, handling user input, interacting with the model, and returning a response to the client. \n"+
        "They also provide a way to handle exception and error cases, ensuring that the application can handle and respond to any issues that may arise during the processing of a request. \n"+
        "Overall, Spring Boot controllers are a key component of the application's architecture, allowing for a clean separation of concerns and making it easy to test and maintain the codebase.");

        tasks.add(makeControllers);

        Task makeModels = new Task();
        makeModels.setTitle("Spring Boot Create Models");
        makeModels.setDescription("Spring Boot Models are important because they represent the data that is being manipulated by the application. \n" +
                "They provide a way to define the structure of the data, and to implement the business logic for manipulating that data. \n" +
                "Models are typically used to interact with databases or other data storage systems, and provide a way to perform CRUD (create, read, update, delete) operations on that data. \n" +
                "Spring Boot models also provide a way to validate user input, and to handle any errors or exceptions that may occur when interacting with the data. \n" +
                "Overall, Spring Boot models are a key component of the application's architecture, allowing for a clean separation of concerns and making it easy to test and maintain the codebase.");

        tasks.add(makeModels);

        Task makeServices = new Task();
        makeServices.setDescription("Services are a very important part of developing and, especially in spring thayt are a core component to the framework. \n"+
                "Using mcriservices can be a great way to plan and implement different services in Spring Boot. \n"+
                "An example can involve the business of a Laundry Mat, and all the other services they offer. They have a point of sales service for processing payments. \n"+
                "They have a customer service department, a laundry service, and and operation service for their machines. Of course there are many more services, but these are some of the common ones! \n"+
                "Building an application in such a way that accounts for these services being developed at different times is how services work in Spring Boot and one of the many reasons why its so powerful.");

        makeServices.setTitle("Spring Boot Create Services");

        tasks.add(makeServices);



        return tasks;
    }


}
