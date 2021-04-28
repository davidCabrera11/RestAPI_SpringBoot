package org.adaschool.KO4BA5.services

import org.adaschool.KO4BA5.controller.dto.UserDto
import org.adaschool.KO4BA5.model.User
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class UserServiceHashMap: UserService {

    private val users = HashMap<String, User>()

    private val nextOid = AtomicLong()

    override fun save(userDto: UserDto): User {
        val user = User(nextOid.incrementAndGet(),userDto)
        users[userDto.id] = user
        return user

    }

    override fun update(userId: String, userDto: UserDto): User {
        if (users.containsKey(userId)){
            val user = users[userId]
            users[userId] = User(user!!.oid,userDto)
        }

        return users[userId]!!

    }

    override fun findUserById(userId: String): User? {
        return if (users.containsKey(userId))
            users[userId]
        else
            null

    }

    override fun all(): List<User> {
        return users.values.toList()

    }


    override fun delete(userId: String): Boolean {
        return users.remove(userId) != null



    }


}