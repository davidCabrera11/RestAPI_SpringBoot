package org.adaschool.KO4BA5.services

import org.adaschool.KO4BA5.controller.dto.RestaurantDto
import org.adaschool.KO4BA5.model.Restaurant
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class RestaurantServiceHashMap: RestaurantService {

    private val restaurants= HashMap<String, Restaurant>()

    private val nextOid = AtomicLong()

    override fun save(restaurantDto: RestaurantDto): Restaurant {
        val restaurant = Restaurant(nextOid.incrementAndGet(),restaurantDto)
        restaurants[restaurantDto.id] = restaurant
        return restaurant

     }

    override fun update(restaurantId: String, restaurantDto: RestaurantDto): Restaurant {
        if(restaurants.containsKey(restaurantId)){
            val restaurant = restaurants[restaurantId]
            restaurants[restaurantId] = Restaurant(restaurant!!.oid,restaurantDto)
        }

        return restaurants[restaurantId]!!

     }

    override fun findRestaurantById(restaurantId: String): Restaurant? {
        return if (restaurants.containsKey(restaurantId))
            restaurants[restaurantId]
        else
            null

    }

    override fun all(): List<Restaurant> {
        return restaurants.values.toList()

    }

    override fun delete(restaurantId: String): Boolean {
        return restaurants.remove(restaurantId) != null

    }
}