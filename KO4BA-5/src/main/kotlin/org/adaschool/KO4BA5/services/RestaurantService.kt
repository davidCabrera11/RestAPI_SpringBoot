package org.adaschool.KO4BA5.services

import org.adaschool.KO4BA5.controller.dto.RestaurantDto
import org.adaschool.KO4BA5.model.Restaurant

interface RestaurantService {

    //CRUD Operations

    //Create
    fun save (restaurantDto: RestaurantDto):Restaurant

    //Update
    fun update(restaurantId:String, restaurantDto: RestaurantDto):Restaurant

    //Read specific restaurant
    fun findRestaurantById(restaurantId: String):Restaurant?

    //Read all restaurants
    fun all():List<Restaurant>

    //Delete
    fun delete(restaurantId: String):Boolean

}