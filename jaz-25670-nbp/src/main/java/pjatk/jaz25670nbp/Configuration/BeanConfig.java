package pjatk.jaz25670nbp.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig
{
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
