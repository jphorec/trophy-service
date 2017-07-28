package mvp.trophy.controller

import mvp.trophy.domain.Room
import mvp.trophy.service.RoomService
import org.springframework.web.bind.annotation.*

/**
 * Created by joshhorecny on 7/27/17.
 */
@RestController
@RequestMapping("/trophy-service")
class RoomController (val roomService: RoomService) {
    @RequestMapping("/room")
    fun getRooms() : List<Room> {
        return roomService.getAllRooms()
    }
    @RequestMapping("/room/{id}")
    fun getRoom(@PathVariable id: String) : Room {
        return roomService.getRoom(id)
    }
    @PostMapping("/room")
    fun createRoom(@RequestBody room: Room) : Room {
        return roomService.createRoom(room)
    }
}