package org.adaschool.KO4BA5.model

import org.adaschool.KO4BA5.controller.dto.UserDto

data class User(
    val oid:Long,
    val id:String,
    val name:String,
    val email:String
) {
    constructor(oid:Long, userDto: UserDto) : this(oid,userDto.id,userDto.name,userDto.email)
}