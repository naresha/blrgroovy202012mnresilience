package conferenceservice

import io.micronaut.http.annotation.PathVariable
import io.micronaut.retry.annotation.Fallback
import io.reactivex.Flowable

@Fallback
class FallbackSolution implements PresentationsOps {
    @Override
    Presentation getById(@PathVariable Object id) {
        return new Presentation(id: 1L, title: "NA")
    }

    //Flowable
}
