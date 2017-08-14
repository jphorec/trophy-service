package mvp.trophy.controller

import mvp.trophy.domain.ContentProvider
import mvp.trophy.domain.Item
import mvp.trophy.service.ContentProviderService
import mvp.trophy.service.ItemService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.print.DocFlavor

/**
 * Created by joshhorecny on 7/27/17.
 */
@RestController
@RequestMapping("/trophy-service")
class ItemController (val itemService: ItemService) {

    @RequestMapping("/item")
    fun getAllItems () : ResponseEntity<List<Item>> {
        val items: List<Item> = itemService.getAllItems() ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(items, HttpStatus.OK)
    }

    @RequestMapping("/item/{id}")
    fun getItem (@PathVariable id: String) : ResponseEntity<Item> {
        val item: Item =  itemService.getItem(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(item, HttpStatus.OK)
    }

    @PostMapping("/item")
    fun createItem (@RequestBody item: Item) : ResponseEntity<Item> {
        val item: Item = itemService.createItem(item) ?: return ResponseEntity(HttpStatus.BAD_REQUEST)
        return ResponseEntity(item, HttpStatus.CREATED)
    }

    @PutMapping("/item/{id}")
    fun updateItem(@PathVariable("id") id: String, @RequestBody item: Item) : ResponseEntity<Item> {
        val item: Item = itemService.updateItem(id, item) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(item, HttpStatus.OK)
    }

    @DeleteMapping("/item/{id}")
    fun deleteItem(@PathVariable("id") id: String) : ResponseEntity<HttpStatus> {
        if (itemService.deleteItem(id))
            return ResponseEntity(HttpStatus.NO_CONTENT)
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @RequestMapping("/items")
    fun getItemsById(@RequestParam("id") ids: List<String>) : ResponseEntity<List<Item>> {
        val items: List<Item> = itemService.getItemsById(ids) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(items, HttpStatus.OK)
    }
}