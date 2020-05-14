package outside;

import org.springframework.context.annotation.Configuration;
import tech.viacomcbs.intothespring.conditionals.SampleConditional;

@Configuration
@SampleConditional
public class MagicAutoConfiguration {

    public MagicAutoConfiguration() {
        System.out.println("MagicAutoConfiguration created");
    }
}
