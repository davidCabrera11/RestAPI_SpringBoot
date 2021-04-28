package org.adaschool.KO4BA5.model

import org.adaschool.KO4BA5.controller.dto.ReserveDto


data class Reserve(
    val oid: Long,
    val id: String,
    val name:String,
    val phoneNumber:Long,
    val time:String
){
    constructor(oid: Long,reserveDto: ReserveDto):this
        (oid,reserveDto.id,reserveDto.name,reserveDto.phoneNumber,reserveDto.time)

}
