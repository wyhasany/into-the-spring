package tech.viacomcbs.intothespring;

import org.springframework.stereotype.Component;

@Component
@Profiling
public class MyBean {

    public void getMe() {
        System.out.println("Do sth");
    }

}
