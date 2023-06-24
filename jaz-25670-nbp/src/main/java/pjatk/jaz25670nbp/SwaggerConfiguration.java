package pjatk.jaz25670nbp;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI openAPI(){
        Contact contact = new Contact();
        contact.setEmail("s25670@pjwstk.edu.pl");
        contact.setName("s25670");

        Info info = new Info()
                .title("NBP")
                .version("1.0")
                .contact(contact)
                .description("API wsywietlajace informacje o średnim kursie walut z podanego zakresu dni");

        return new OpenAPI().info(info);
    }
}
