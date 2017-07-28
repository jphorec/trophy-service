package mvp.trophy.controller

import mvp.trophy.domain.User
import mvp.trophy.service.UserService
import org.springframework.web.bind.annotation.*

/**
 * Created by joshhorecny on 7/27/17.
 */
@RestController
@RequestMapping("/trophy-service")
class UserController  (val userService: UserService) {
    @RequestMapping("/user")
    fun getUsers () : List<User> {
        return userService.getAllUsers()
    }
    @RequestMapping("/user/{id}")
    fun getUser (@PathVariable id: String) : User {
        return userService.getUser(id)
    }
    @PostMapping("/user")
    fun createUser (@RequestBody user: User) : User {
        return userService.createUser(user)
    }
}