package tech.viacomcbs.intothespring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

public class SheldonApplicationListener implements ApplicationListener<ApplicationEvent> {

    public SheldonApplicationListener() {
        System.out.println("SheldonApplicationListener created");
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("Received --> " + event.getClass().getName());
    }
}
