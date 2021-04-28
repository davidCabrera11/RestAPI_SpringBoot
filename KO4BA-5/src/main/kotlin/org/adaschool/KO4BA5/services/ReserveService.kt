package org.adaschool.KO4BA5.services

import org.adaschool.KO4BA5.controller.dto.ReserveDto
import org.adaschool.KO4BA5.model.Reserve

interface ReserveService {


    //CRUD Operations

    //Create
    fun save(reserveDto: ReserveDto):Reserve

    //Update
    fun update(reserveId: String,reserveDto: ReserveDto):Reserve

    //Read specific reserve
    fun findReserveById(reserveId: String):Reserve?

    //Read all reserves
    fun all():List<Reserve>

    //Delete
    fun delete(reserveId:String):Boolean



}