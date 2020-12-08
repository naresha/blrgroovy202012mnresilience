package conferenceservice

import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable

interface PresentationsOps {

    @Get(value = "/{id}")
    Presentation getById(@PathVariable id)
}