package org.adaschool.KO4BA5.services

import org.adaschool.KO4BA5.controller.dto.UserDto
import org.adaschool.KO4BA5.model.User

interface UserService {

    //CRUD Operations

    //Create
    fun save(userDto: UserDto):User

    //Update
    fun update(userId: String, userDto: UserDto):User

    //Read specific user
    fun findUserById(userId: String):User?

    //Read all users
    fun all(): List<User>

    //Delete
    fun delete(userId:String):Boolean




}