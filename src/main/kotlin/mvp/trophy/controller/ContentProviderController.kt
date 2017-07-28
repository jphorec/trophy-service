package mvp.trophy.controller

import mvp.trophy.domain.ContentProvider
import mvp.trophy.service.ContentProviderService
import org.springframework.web.bind.annotation.*

/**
 * Created by joshhorecny on 7/27/17.
 */

@RestController
@RequestMapping("/trophy-service")
class ContentProviderController (val contentProviderService: ContentProviderService) {

    @RequestMapping("/provider")
    fun getAllContentProviders () : List<ContentProvider> {
        return contentProviderService.getAllProviders()
    }

    @RequestMapping("/provider/{id}")
    fun getContentProvider (@PathVariable id: String) : ContentProvider {
        return contentProviderService.getContentProvider(id)
    }

    @PostMapping("/provider")
    fun createContentProvider (@RequestBody contentProvider: ContentProvider) : ContentProvider {
        return contentProviderService.createContentProvider(contentProvider)
    }
}