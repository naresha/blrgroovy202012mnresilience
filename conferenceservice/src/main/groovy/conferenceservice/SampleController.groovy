package conferenceservice

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.CircuitBreaker
import io.micronaut.retry.annotation.Retryable
import io.micronaut.scheduling.annotation.ExecuteOn

import javax.inject.Inject

@Controller("/")
class SampleController {

    @Inject
    PresentationClient presentationClient

    @Inject
    Client2 client2

    @Get("/timeout")
    Presentation getPresentation() {
        client2.getById(4)
    }

    @Get("/retry")
    //@Retryable
    Presentation retry() {
        client2.getById(1)
    }

    @Get("/cb")
    @CircuitBreaker(reset = "20s", attempts = "1")
    @ExecuteOn()
    Presentation cb() {
        client2.getById(1)
    }
}
