package tech.viacomcbs.intothespring;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.currentTimeMillis;

public class StartScanReport implements ApplicationListener<ApplicationEvent> {

    private Map<String, Long> stageSetup = new LinkedHashMap<>(16);

    private long lastTime;

    private int i;

    public StartScanReport() {
        lastTime = currentTimeMillis();
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        stageSetup.put(event.getClass().getSimpleName(), event.getTimestamp() - lastTime);
        if (event.getClass().equals(ApplicationReadyEvent.class)) {
            printRaport();
        }
        lastTime = event.getTimestamp();
    }

    private void printRaport() {
        i = 0;
        System.out.println("#####################################################################");
        System.out.println("#####################    Startup report     #########################");
        System.out.println("#####################################################################");
        stageSetup.forEach(
            (stage, duration) ->
                System.out.printf("%d: %50s took %6d ms\n", i++, stage, duration)
        );
    }
}
