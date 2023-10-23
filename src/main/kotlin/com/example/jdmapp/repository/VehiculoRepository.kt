package com.example.jdmapp.repository

import com.example.jdmapp.model.Vehiculo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VehiculoRepository: JpaRepository<Vehiculo, Long?>{
    fun findById (id: Long?): Vehiculo?
}
