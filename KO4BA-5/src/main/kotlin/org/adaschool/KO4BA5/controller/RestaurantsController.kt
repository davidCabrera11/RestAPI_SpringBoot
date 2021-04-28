package org.adaschool.KO4BA5.controller

import org.adaschool.KO4BA5.controller.dto.RestaurantDto
import org.adaschool.KO4BA5.model.Restaurant
import org.adaschool.KO4BA5.services.RestaurantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/restaurants")
class RestaurantsController(@Autowired val restaurantService: RestaurantService) {

    //CRUD Operations

    //Create
    @PostMapping
    fun create(@RequestBody restaurantDto: RestaurantDto):Restaurant{
        return restaurantService.save(restaurantDto)

    }

    //Read
    @GetMapping
    fun getRestaurants():List<Restaurant>?{
        return restaurantService.all()

    }

    //Read for specific user
    @GetMapping("/{id}")
    fun findRestaurantById(@PathVariable id:String):Restaurant?{
        return restaurantService.findRestaurantById(id) ?:throw Exception()

    }

    //Update
    @PutMapping
    fun update(@PathVariable id: String,@RequestBody restaurantDto: RestaurantDto):Restaurant?{
        return restaurantService.update(id,restaurantDto)

    }
    //Delete
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:String):Boolean{
        return restaurantService.delete(id)


    }



}