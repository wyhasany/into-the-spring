package tech.viacomcbs.intothespring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SheldonApplicationListener {

    public SheldonApplicationListener() {
        System.out.println("SheldonApplicationListener created");
    }

    @EventListener
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("Received --> " + event.getClass().getName());
    }
}
