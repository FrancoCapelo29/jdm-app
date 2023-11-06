package com.example.jdmapp.controller

import com.example.jdmapp.model.Marcas
import com.example.jdmapp.model.Vehiculo
import com.example.jdmapp.service.MarcasService
import com.example.jdmapp.service.VehiculoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/marcas")   //endpoint
class MarcasController {
    @Autowired
    lateinit var marcasService: MarcasService
    @GetMapping
    fun list ():List <Marcas>{
        return marcasService.list()
    }
    @PostMapping
    fun save (@RequestBody marcas: Marcas): ResponseEntity<Marcas> {
        return ResponseEntity(marcasService.save(marcas), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody marcas: Marcas): ResponseEntity<Marcas> {
        return ResponseEntity(marcasService.updateMotor(marcas), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(marcasService.listById(id), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return marcasService.delete(id)
    }
}