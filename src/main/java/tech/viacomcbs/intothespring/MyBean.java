package tech.viacomcbs.intothespring;

import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    public void repeat() {
        System.out.println("Repeat: " + repeat);
    }

}
