package com.example.jdmapp.repository

import com.example.jdmapp.model.Marcas
import com.example.jdmapp.model.Vehiculo
import org.springframework.data.jpa.repository.JpaRepository

interface MarcasRepository: JpaRepository<Marcas, Long?> {
    fun findById (id: Long?): Marcas?
}