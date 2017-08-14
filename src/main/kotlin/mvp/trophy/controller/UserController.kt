package mvp.trophy.controller

import mvp.trophy.domain.User
import mvp.trophy.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.xml.ws.Response

/**
 * Created by joshhorecny on 7/27/17.
 */
@RestController
@RequestMapping("/trophy-service")
class UserController  (val userService: UserService) {
    @RequestMapping("/user")
    fun getUsers () : ResponseEntity<List<User>> {
        val users: List<User> = userService.getAllUsers()
        if (!users?.isEmpty()) {
            return ResponseEntity(users, HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }
    @RequestMapping("/user/{id}")
    fun getUser (@PathVariable id: String) : ResponseEntity<User> {
        val user: User = userService.getUser(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(user, HttpStatus.OK)
    }
    @PostMapping("/user")
    fun createUser (@RequestBody user: User) : ResponseEntity<User> {
        val createUser: User = userService.createUser(user) ?: return ResponseEntity(HttpStatus.BAD_REQUEST)
        return ResponseEntity(createUser, HttpStatus.CREATED)
    }
    @PutMapping("/user/{id}")
    fun updateUser (@PathVariable("id") id: String, @RequestBody user: User) : ResponseEntity<HttpStatus> {
        val updateUser: User = userService.updateUser(id, user) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
    @DeleteMapping("/user/{id}")
    fun deleteUser (@PathVariable("id") id: String) : ResponseEntity<HttpStatus> {
        if (userService.deleteUser(id))
            return ResponseEntity(HttpStatus.NO_CONTENT)
        else
            return ResponseEntity(HttpStatus.NOT_FOUND)
    }
    @RequestMapping("/users")
    fun getUsersByIds(@RequestParam("id") ids: List<String>) : ResponseEntity<List<User>> {
        val users: List<User> = userService.getUsersById(ids) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(users, HttpStatus.OK)
    }
}