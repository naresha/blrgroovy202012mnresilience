package presentationservice

import groovy.util.logging.Slf4j
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic
import io.micronaut.runtime.event.annotation.EventListener

import javax.inject.Inject
import javax.inject.Singleton

@CompileStatic
@Slf4j
@Singleton
class Application {

    final PresentationRepository presentationRepository

    Application(PresentationRepository presentationRepository) {
        this.presentationRepository = presentationRepository
    }

    static void main(String[] args) {
        Micronaut.run(Application)
    }

    @EventListener
    void init(StartupEvent e) {
        log.info("Inside startup event")
        List<Presentation> presentations = [
                new Presentation(title: 'Resilience with Micronaut', durationInMinutes: 20, speakerId: 1L),
                new Presentation(title: 'Integration Testing with TestContainers', durationInMinutes: 20, speakerId: 1L),
                new Presentation(title: 'Grinding the Monolith', durationInMinutes: 60, speakerId: 2L),
                new Presentation(title: 'Effective Java with Groovy', durationInMinutes: 60, speakerId: 1L),
        ]
        presentationRepository.saveAll(presentations)
    }

}
