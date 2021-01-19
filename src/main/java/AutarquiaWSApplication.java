import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AutarquiaWSApplication implements ApplicationRunner{
    public static void main(String[] args) {
        SpringApplication.run(AutarquiaWSApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments arg0) throws Exception {
        System.out.println("Initializing Database");
        //Bootstrapping.loadData(createPersonService, us002_1CreateGroupService);
        System.out.println("Database Created");
    }
}
