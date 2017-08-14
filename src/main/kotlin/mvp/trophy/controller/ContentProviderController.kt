package mvp.trophy.controller

import mvp.trophy.domain.ContentProvider
import mvp.trophy.service.ContentProviderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Created by joshhorecny on 7/27/17.
 */

@RestController
@RequestMapping("/trophy-service")
class ContentProviderController (val contentProviderService: ContentProviderService) {

    @RequestMapping("/provider")
    fun getAllContentProviders () : ResponseEntity<List<ContentProvider>> {
        val providers: List<ContentProvider> = contentProviderService.getAllProviders() ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity.ok(providers)
    }

    @RequestMapping("/provider/{id}")
    fun getContentProvider (@PathVariable id: String) : ResponseEntity<ContentProvider> {
        val provider = contentProviderService.getContentProvider(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity.ok(provider)
    }

    @PostMapping("/provider")
    fun createContentProvider (@RequestBody contentProvider: ContentProvider) : ResponseEntity<ContentProvider> {
        val provider = contentProviderService.createContentProvider(contentProvider) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(provider, HttpStatus.CREATED)
    }

    @PutMapping("/provider/{id}")
    fun updateContentProvider (@PathVariable("id") id: String, @RequestBody contentProvider: ContentProvider) : ResponseEntity<ContentProvider> {
        val provider = contentProviderService.updateContentProvider(id, contentProvider) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity.ok(provider)
    }

    @DeleteMapping("/provider/{id}")
    fun deleteContentProvider (@PathVariable("id") id: String) : ResponseEntity<HttpStatus> {
        if (contentProviderService.deleteContentProvider(id))
            return ResponseEntity(HttpStatus.NO_CONTENT)
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @RequestMapping("/providers")
    fun getProvidersById(@RequestParam("id") ids: List<String>) : ResponseEntity<List<ContentProvider>> {
        val providers: List<ContentProvider> = contentProviderService.getProvidersById(ids) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity.ok(providers)
    }
}