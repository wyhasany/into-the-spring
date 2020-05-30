package tech.viacomcbs.intothespring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyBean {

    public MyBean() {
        System.out.println("1st phase");
    }

    @PostConstruct
    public void init() {
        System.out.println("2nd phase");
    }

    @Main
    public void main() {
        System.out.println("3rd phase");
    }
}
