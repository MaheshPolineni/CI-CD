package cloud.example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentRestController {

    @GetMapping("/")
    public String hello() {
        return "Webhook 2";
    }
}