package seabattle.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "seabattle.app")
public class SeaBattleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeaBattleApplication.class, args);
    }

}
