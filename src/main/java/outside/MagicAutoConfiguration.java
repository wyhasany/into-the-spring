package outside;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MagicAutoConfiguration {

    public MagicAutoConfiguration() {
        System.out.println("MagicAutoConfiguration created");
    }
}
