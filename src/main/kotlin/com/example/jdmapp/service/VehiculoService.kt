package com.example.jdmapp.service

import com.example.jdmapp.model.Vehiculo
import com.example.jdmapp.repository.VehiculoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class VehiculoService {
    @Autowired
    lateinit var vehiculoRepository: VehiculoRepository
    fun list ():List<Vehiculo>{
        return vehiculoRepository.findAll()
    }
    fun save(vehiculo: Vehiculo): Vehiculo{
        try{
            return vehiculoRepository.save(vehiculo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateMotor(vehiculo: Vehiculo): Vehiculo{
        try{
            val response = vehiculoRepository.findById(vehiculo.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                motor=vehiculo.motor //un atributo del modelo
            }
            return vehiculoRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = vehiculoRepository.findById(id)
                    ?: throw Exception("ID no existe")
            vehiculoRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}