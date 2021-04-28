package org.adaschool.KO4BA5.services

import org.adaschool.KO4BA5.controller.dto.ReserveDto
import org.adaschool.KO4BA5.model.Reserve
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class ReserveServiceHashMap:ReserveService {

    private val reserves = HashMap<String,Reserve>()

    private val nextOid = AtomicLong()


    override fun save(reserveDto: ReserveDto): Reserve {
        val reserve = Reserve(nextOid.incrementAndGet(),reserveDto)
        reserves[reserveDto.id] = reserve
        return reserve

    }

    override fun update(reserveId: String, reserveDto: ReserveDto): Reserve {
        if (reserves.containsKey(reserveId)){
            val reserve = reserves[reserveId]
            reserves[reserveId] = Reserve(reserve!!.oid,reserveDto)
        }
        return reserves[reserveId]!!

    }

    override fun findReserveById(reserveId: String): Reserve? {
        return if (reserves.containsKey(reserveId))
            reserves[reserveId]
        else
            null

    }

    override fun all(): List<Reserve> {
        return reserves.values.toList()

    }

    override fun delete(reserveId: String): Boolean {
        return reserves.remove(reserveId) != null
    }

}