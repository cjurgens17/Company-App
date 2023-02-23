package com.personPractice.bootstrap;





import com.personPractice.models.Department;
import com.personPractice.models.Employee;

import com.personPractice.models.Task;
import com.personPractice.repository.DepartmentRepository;
import com.personPractice.repository.EmployeeRepository;
import com.personPractice.repository.ImageRepository;
import com.personPractice.repository.TaskRepository;
import com.personPractice.services.ImageService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class DataLoad implements ApplicationListener<ContextRefreshedEvent> {

    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final ImageRepository imageRepository;
    private final ImageService imageService;





    public DataLoad(TaskRepository taskRepository, EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, ImageRepository imageRepository, ImageService imageService) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.imageRepository = imageRepository;
        this.imageService = imageService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
            getTasks();
            getEmployees();
    //            departmentRepository.saveAll(getDepartments());
//            imageRepository.saveAll(getImages());

    }
    @Transactional
    private void getTasks(){
        Task makeRepos = new Task();

        makeRepos.setTitle("Spring Boot Create Repositories");
        makeRepos.setDescription("Extending the Crud Repository in Java/Spring Boot through the JPA is a very important aspect of application development. \n"+
                "It allows us to persist all the data for our website to our stored servers. Imagine logging into a website, going through the grueling processes of \n"+
                "creating an account, verifying your account through email, setting up an MFA for your password, and then having to do that process over and over. \n"+
                "Sounds Terrible right! This is where developers come in and use the JPA to persist all of your data onto a server so you don't have these problems. \n"+
                "Heck, you can even update your information, get information that was previously stored, and even look at other users information, and so much more. \n"+
                "To say the least, this is a very important and crucial task for any application or website that's on the world wide web.");
        makeRepos.setId(1L);
        taskRepository.save(makeRepos);

        Task makeControllers = new Task();
        makeControllers.setTitle("Spring Boot Create Controllers");
        makeControllers.setDescription("Spring Boot controllers are important because they provide a way to handle HTTP requests and map them to appropriate methods in the application's code. \n"+
                "They act as the bridge between the incoming request and the application's business logic, handling user input, interacting with the model, and returning a response to the client. \n"+
        "They also provide a way to handle exception and error cases, ensuring that the application can handle and respond to any issues that may arise during the processing of a request. \n"+
        "Overall, Spring Boot controllers are a key component of the application's architecture, allowing for a clean separation of concerns and making it easy to test and maintain the codebase.");
        makeControllers.setId(2L);
        taskRepository.save(makeControllers);

        Task makeModels = new Task();
        makeModels.setTitle("Spring Boot Create Models");
        makeModels.setDescription("Spring Boot Models are important because they represent the data that is being manipulated by the application. \n" +
                "They provide a way to define the structure of the data, and to implement the business logic for manipulating that data. \n" +
                "Models are typically used to interact with databases or other data storage systems, and provide a way to perform CRUD (create, read, update, delete) operations on that data. \n" +
                "Spring Boot models also provide a way to validate user input, and to handle any errors or exceptions that may occur when interacting with the data. \n" +
                "Overall, Spring Boot models are a key component of the application's architecture, allowing for a clean separation of concerns and making it easy to test and maintain the codebase.");

        makeModels.setId(3L);
        taskRepository.save(makeModels);

        Task makeServices = new Task();
        makeServices.setDescription("Services are a very important part of developing and, especially in spring thayt are a core component to the framework. \n"+
                "Using microservices can be a great way to plan and implement different services in Spring Boot. \n"+
                "An example can involve the business of a Laundry Mat, and all the other services they offer. They have a point of sales service for processing payments. \n"+
                "They have a customer service department, a laundry service, and and operation service for their machines. Of course there are many more services, but these are some of the common ones! \n"+
                "Building an application in such a way that accounts for these services being developed at different times is how services work in Spring Boot and one of the many reasons why its so powerful.");

        makeServices.setTitle("Spring Boot Create Services");
        makeServices.setId(4L);
        taskRepository.save(makeServices);
    }
    @Transactional
    private void getEmployees(){
        //add data for bootstrap employees load up

        Employee employee1 = new Employee();
        employee1.setFirstName("Christopher");
        employee1.setLastName("Walken");
        employee1.setId(1L);
        employee1.setSalary(100_000L);
        employee1.setEmail("CWalken@yahoo.com");
        employee1.setDepartment(Department.builder().departmentName("Service").build());

        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setFirstName("Mike");
        employee2.setLastName("Wazowski");
        employee2.setId(2L);
        employee2.setSalary(150_000L);
        employee2.setEmail("AIncMonster@yahoo.com");
        employee2.setDepartment(Department.builder().departmentName("Lead Technician").build());

        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Brett");
        employee3.setLastName("Johnson");
        employee3.setId(3L);
        employee3.setSalary(200_000L);
        employee3.setEmail("CyberSecurity@yahoo.com");
        employee3.setDepartment(Department.builder().departmentName("Computer Operations").build());

        employeeRepository.save(employee3);

        Employee employee4 = new Employee();
        employee4.setFirstName("Donald");
        employee4.setLastName("Duck");
        employee4.setId(4L);
        employee4.setSalary(200_000L);
        employee4.setEmail("WaltDisney@yahoo.com");
        employee4.setDepartment(Department.builder().departmentName("Human Resources").build());

        employeeRepository.save(employee4);

        Employee employee5 = new Employee();
        employee5.setFirstName("John");
        employee5.setLastName("wick");
        employee5.setId(5L);
        employee5.setSalary(100_000L);
        employee5.setEmail("AnotherMansDog@aol.com");
        employee5.setDepartment(Department.builder().departmentName("Power Vac Specialist").build());

        employeeRepository.save(employee5);

        Employee employee6 = new Employee();
        employee6.setFirstName("John");
        employee6.setLastName("Snow");
        employee6.setId(6L);
        employee6.setSalary(250_000L);
        employee6.setEmail("NightsWatch@castleRock.com");
        employee6.setDepartment(Department.builder().departmentName("Sales").build());

        employeeRepository.save(employee6);


    }

//    private Set<Department> getDepartments(){
//
//        Set<Department> departments = new HashSet<>();
//
//        Department department1 = new Department();
//        department1.setId(1L);
//        department1.setDepartmentName("Service");
//        departments.add(department1);
//
//        Department department2 = new Department();
//        department2.setId(2L);
//        department2.setDepartmentName("Maintenance");
//        departments.add(department2);
//
//        Department department3 = new Department();
//        department3.setId(3L);
//        department3.setDepartmentName("Testing");
//        departments.add(department3);
//
//        Department department4 = new Department();
//        department4.setId(4L);
//        department4.setDepartmentName("Network Engineering");
//        departments.add(department4);
//
//        return departments;
//    }

//    private List<Image> getImages(){
//        List<Image> images = new ArrayList<>();
//
//        Image image1 = new Image();
//        image1.setId(1L);
//        image1.setName("employee1");
//        image1.setImage("xsgames.co/randomusers/avatar.php?g=female");
//        images.add(image1);
//
//        Image image2 = new Image();
//        image1.setId(2L);
//        image1.setName("employee2");
//        image1.setImage("xsgames.co/randomusers/avatar.php?g=male");
//        images.add(image2);
//
//        Image image3 = new Image();
//        image1.setId(3L);
//        image1.setName("employee3");
//        image1.setImage("xsgames.co/randomusers/avatar.php?g=female");
//        images.add(image3);
//
//        Image image4 = new Image();
//        image1.setId(4L);
//        image1.setName("employee4");
//        image1.setImage("xsgames.co/randomusers/avatar.php?g=male");
//        images.add(image4);
//
//        Image image5 = new Image();
//        image1.setId(5L);
//        image1.setName("employee5");
//        image1.setImage("xsgames.co/randomusers/avatar.php?g=female");
//        images.add(image5);
//
//        Image image6 = new Image();
//        image1.setId(6L);
//        image1.setName("employee6");
//        image1.setImage("xsgames.co/randomusers/avatar.php?g=male");
//        images.add(image6);
//        return images;
//    }

//    private void setImagesToEmployees(){
//        Set<Employee> employees = getEmployees();
//        AtomicInteger alternate = new AtomicInteger();
//
//
//
//
//
//
//
//      employees.forEach(employee -> {
//          Image image = new Image();
//          if(alternate.get() % 2==0){
//              image.setImage("xsgames.co/randomusers/avatar.php?g=female");
//                imageService.encodeImage(image.getImage());
//              alternate.getAndIncrement();
//          }else{
//              image.setImage("xsgames.co/randomusers/avatar.php?g=male");
//              imageService.encodeImage(image.getImage());
//              alternate.getAndIncrement();
//          }
//          employee.setImage(image);
//      });
//    }
}
