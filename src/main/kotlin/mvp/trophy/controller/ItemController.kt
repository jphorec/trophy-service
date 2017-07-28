package mvp.trophy.controller

import mvp.trophy.domain.ContentProvider
import mvp.trophy.domain.Item
import mvp.trophy.service.ContentProviderService
import mvp.trophy.service.ItemService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 * Created by joshhorecny on 7/27/17.
 */
@RestController
@RequestMapping("/trophy-service")
class ItemController (val itemService: ItemService) {

    @RequestMapping("/item")
    fun getAllItems () : List<Item> {
        return itemService.getAllItems()
    }

    @RequestMapping("/item/{id}")
    fun getItem (@PathVariable id: String) : Item {
        return itemService.getItem(id)
    }

    @PostMapping("/item")
    fun createContentProvider (@RequestBody item: Item) : Item {
        return itemService.createItem(item)
    }
}