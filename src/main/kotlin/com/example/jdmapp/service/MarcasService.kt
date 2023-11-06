package com.example.jdmapp.service

import com.example.jdmapp.model.Marcas
import com.example.jdmapp.model.Vehiculo
import com.example.jdmapp.repository.MarcasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class MarcasService {
    @Autowired
    lateinit var marcasRepository: MarcasRepository
    fun list ():List<Marcas>{
        return marcasRepository.findAll()
    }
    fun save(marcas: Marcas): Marcas {
        try{
            return marcasRepository.save(marcas)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateMotor(marcas: Marcas): Marcas {
        try{
            val response = marcasRepository.findById(marcas.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                modelo=marcas.modelo //un atributo del modelo
            }
            return marcasRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = marcasRepository.findById(id)
                    ?: throw Exception("ID no existe")
            marcasRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?): Marcas?{
        return marcasRepository.findById(id)
    }
}