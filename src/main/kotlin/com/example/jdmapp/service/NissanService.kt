package com.example.jdmapp.service

import com.example.jdmapp.repository.NissanRepository
import com.example.jdmapp.model.Nissan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class NissanService {
    @Autowired
    lateinit var nissanRepository: NissanRepository
    fun list ():List<Nissan>{
        return nissanRepository.findAll()
    }
    fun save(nissan: Nissan): Nissan{
        try{
            return nissanRepository.save(nissan)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(nissan: Nissan): Nissan{
        try{
            val response = nissanRepository.findById(nissan.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                fullname=nissan.fullname //un atributo del modelo
            }
            return nissanRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}