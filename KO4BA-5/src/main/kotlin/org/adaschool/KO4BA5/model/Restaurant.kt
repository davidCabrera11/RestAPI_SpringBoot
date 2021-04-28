package org.adaschool.KO4BA5.model

import org.adaschool.KO4BA5.controller.dto.RestaurantDto

data class Restaurant(
    val oid:Long,
    val id:String,
    val name:String,
    val email:String,
    val address:String
){
    constructor(oid: Long,restaurantDto: RestaurantDto): this
        (oid,restaurantDto.id,restaurantDto.name,restaurantDto.email,restaurantDto.address)

}