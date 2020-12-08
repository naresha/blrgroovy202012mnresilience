package conferenceservice

import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client

@Client(value = "http://localhost:8081")
interface PresentationClient extends PresentationsOps {

}