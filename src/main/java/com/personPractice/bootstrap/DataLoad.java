package com.personPractice.bootstrap;





import com.personPractice.models.Department;
import com.personPractice.models.Employee;

import com.personPractice.models.PoolService;
import com.personPractice.models.Task;
import com.personPractice.repository.EmployeeRepository;
import com.personPractice.repository.PoolServiceRepository;
import com.personPractice.repository.TaskRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class DataLoad implements ApplicationListener<ContextRefreshedEvent> {

    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final PoolServiceRepository poolServiceRepository;







    public DataLoad(TaskRepository taskRepository, EmployeeRepository employeeRepository, PoolServiceRepository poolServiceRepository) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
        this.poolServiceRepository = poolServiceRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
            getTasks();
            getEmployees();
            getServices();
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

    @Transactional
    public void getServices(){
        //add services for database load
        PoolService service1 = new PoolService();
        service1.setDescription("Trust our experienced team for all your construction needs. We offer a range of high-quality services, including new construction, remodeling, and renovations." +
                " Our skilled professionals work closely with you to bring your vision to life, ensuring that your project is completed to the highest standards of quality and durability." +
                " From the initial planning stages to the final touches, we're dedicated to providing a top-quality service, with attention to detail and a commitment to customer satisfaction." +
                " Contact us today to learn more about how we can help you with your building project.");
        service1.setTitle("Construction");
        service1.setId(1L);
        service1.setImage("https://www.kaysmedical.com/wp-content/uploads/2019/09/Construction-1024x768.jpg");
        service1.setContact("Choosing our construction service can ensure that your dream pool becomes a reality," +
                " as our team of experts can handle every aspect of the project, from design to installation," +
                " using high-quality materials and advanced technology, resulting in a customized, durable," +
                " and stunning pool that will provide enjoyment and value for years to come.");
        poolServiceRepository.save(service1);

        PoolService service2 = new PoolService();
        service2.setDescription("Regular pool maintenance is essential to keep your pool in top condition." +
                " Our pool maintenance service provides a comprehensive range of services to ensure that your pool is always clean, safe, and ready to use." +
                " Our experienced technicians use the latest equipment and techniques to keep your pool water crystal clear and balanced, and they can also identify and repair any issues that may arise." +
                " We offer flexible scheduling to suit your needs, and our team is dedicated to providing a top-quality service with a commitment to customer satisfaction." +
                " Contact us today to learn more about how we can help you maintain your pool.");
        service2.setTitle("Maintenance");
        service2.setId(2L);
        service2.setImage("https://poolstar.net/wp-content/uploads/2015/03/Pool-Service-Equipment.jpg");
        service2.setContact("Choosing our pool company's maintenance service can guarantee that your pool stays clean, healthy, and functional year-round, as our team of skilled professionals can provide regular cleaning, maintenance," +
                " and repair services using industry-leading tools and techniques, ensuring optimal performance," +
                " safety, and longevity, and giving you more time to relax and enjoy your pool.");
        poolServiceRepository.save(service2);

        PoolService service3 = new PoolService();
        service3.setDescription("Transform your old, outdated pool into a stunning backyard oasis with our pool renovation services." +
                " Our expert team has years of experience in pool renovation, and we use only the highest quality materials and equipment to ensure that your pool is restored to its former glory." +
                " Whether you need new tiles, a new coping, or a complete pool remodel, we work closely with you to bring your vision to life." +
                " We understand that every project is unique, and we're dedicated to providing a top-quality service with attention to detail and a commitment to customer satisfaction." +
                " Contact us today to learn more about how we can help you renovate your pool.");
        service3.setTitle("Renovation");
        service3.setId(3L);
        service3.setImage("http://www.piscinaliner.com/wordpress/images/WhatsApp-Image-2020-09-04-at-09.41.26-1024x768.jpeg");
        service3.setContact("Your pool is an important investment that adds value to your home and enhances your lifestyle." +
                " Our pool company's renovation service can help you revitalize and improve the functionality and appearance of your pool," +
                " providing you with a fresh, modern, and enjoyable outdoor space.");
        poolServiceRepository.save(service3);

        PoolService service4 = new PoolService();
        service4.setDescription("Don't let a damaged or malfunctioning pool ruin your summer fun." +
                " Our pool repair service provides a comprehensive range of repair services to keep your pool in top condition." +
                " Our experienced technicians can quickly identify and repair any issues that may arise, from leaks and cracks to malfunctioning pumps and filters." +
                " We use only the highest quality materials and equipment to ensure that your repairs are durable and long-lasting." +
                " We're dedicated to providing a top-quality service with a commitment to customer satisfaction, and we offer flexible scheduling to suit your needs." +
                " Contact us today to learn more about how we can help you repair your pool.");
        service4.setTitle("Repairs");
        service4.setId(4L);
        service4.setImage("https://www.atxleakdetection.com/wp-content/uploads/2022/12/methods-2-1024x768.jpg");
        service4.setContact("If you're experiencing problems with your pool, such as leaks, cracks, or equipment malfunction," +
                " it's essential to address them promptly to prevent further damage and ensure the safety and hygiene of your pool." +
                " Our pool company's repair service is reliable," +
                " efficient, and cost-effective, providing you with the expertise and resources you need to keep your pool in top condition.");
        poolServiceRepository.save(service4);

        PoolService service5 = new PoolService();
        service5.setDescription("Say goodbye to harsh chemicals and hello to silky-smooth pool water with our pool salt conversion service." +
                " Our expert team can convert your existing chlorine pool into a saltwater pool quickly and easily." +
                " Saltwater pools offer many benefits, including softer and gentler water, lower maintenance costs, and a more enjoyable swimming experience." +
                " We use high-quality equipment and techniques to ensure that your conversion is seamless and stress-free." +
                " Our team is dedicated to providing a top-quality service with a commitment to customer satisfaction, and we're happy to answer any questions you may have about the conversion process." +
                " Contact us today to learn more about how we can help you convert your pool to saltwater.");
        service5.setTitle("Salt Conversion");
        service5.setId(5L);
        service5.setImage("https://alohadesertpools.com/wp-content/uploads/2021/12/pexels-kindel-media-8688524-1024x768.jpg");
        service5.setContact("If you're tired of the harsh chemicals and frequent maintenance required by traditional chlorine-based pool systems," +
                " our pool company's salt conversion service is a great alternative. With a saltwater pool," +
                " you'll enjoy a more natural and gentle swimming experience, as well as a lower overall cost of ownership and reduced environmental impact.");
        poolServiceRepository.save(service5);

        PoolService service6 = new PoolService();
        service6.setDescription("Ensure that your pool is safe and ready for use with our pool walkthrough service." +
                " Our experienced technicians will inspect your pool and its equipment to ensure that everything is in good working order and meets safety standards." +
                " We'll identify any issues or potential hazards and provide recommendations for repairs or upgrades to keep your pool running smoothly." +
                " We offer flexible scheduling to suit your needs, and our team is dedicated to providing a top-quality service with a commitment to customer satisfaction." +
                " Contact us today to learn more about how we can help you with your pool walkthrough needs.");
        service6.setTitle("Pool Walkthrough");
        service6.setId(6L);
        service6.setImage("https://production-next-images-cdn.thumbtack.com/i/456340651934343183/width/1024.jpeg");
        service6.setContact("Our pool company's pool walkthrough service is an essential step in ensuring the long-term health and safety of your pool." +
                " Our experts will carefully inspect every aspect of your pool," +
                " identifying potential problems and providing you with personalized recommendations and solutions to keep your pool in top condition for years to come.");
        poolServiceRepository.save(service6);
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
