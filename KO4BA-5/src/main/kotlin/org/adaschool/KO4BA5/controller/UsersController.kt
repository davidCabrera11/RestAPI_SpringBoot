package org.adaschool.KO4BA5.controller

import org.adaschool.KO4BA5.controller.dto.UserDto
import org.adaschool.KO4BA5.model.User
import org.adaschool.KO4BA5.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/users")
class UsersController(@Autowired val userService: UserService) {

    //CRUD Operations

    //Create
    @PostMapping
    fun create(@RequestBody userDto: UserDto):User{
        return userService.save(userDto)

    }

    //Read
    @GetMapping
    fun getUsers():List<User>?{
        return userService.all()

    }

    //Read for specific user
    @GetMapping("/{id}")
    fun findUserById(@PathVariable id: String): User? {
        return userService.findUserById(id) ?: throw Exception()

    }

    //Update
    @PutMapping
    fun update(@PathVariable id:String,@RequestBody userDto: UserDto):User?{
        return userService.update(id,userDto)

    }

    //Delete
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:String):Boolean{
        return userService.delete(id)

    }



}