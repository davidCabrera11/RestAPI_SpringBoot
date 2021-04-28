package org.adaschool.KO4BA5.controller

import org.adaschool.KO4BA5.controller.dto.ReserveDto
import org.adaschool.KO4BA5.controller.dto.RestaurantDto
import org.adaschool.KO4BA5.model.Reserve
import org.adaschool.KO4BA5.model.Restaurant
import org.adaschool.KO4BA5.services.ReserveService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/reserve")
class ReservationsController(@Autowired val reserveService: ReserveService) {


    //CRUD Operations

    //Create
    @PostMapping
    fun create(@RequestBody reserveDto: ReserveDto): Reserve {
        return reserveService.save(reserveDto)

    }

    //Read
    @GetMapping
    fun getRestaurants():List<Reserve>?{
        return reserveService.all()

    }

    //Read for specific user
    @GetMapping("/{id}")
    fun findRestaurantById(@PathVariable id:String): Reserve?{
        return reserveService.findReserveById(id) ?:throw Exception()

    }

    //Update
    @PutMapping
    fun update(@PathVariable id: String, @RequestBody reserveDto: ReserveDto): Reserve?{
        return reserveService.update(id,reserveDto)

    }
    //Delete
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:String):Boolean{
        return reserveService.delete(id)


    }




}