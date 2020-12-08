package conferenceservice

import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.Retryable

@Client(id = "presentation")
//@Retryable(attempts = "2", delay = "2s")
interface Client2 extends PresentationsOps {
}