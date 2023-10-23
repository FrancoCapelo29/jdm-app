package com.example.jdmapp.controller

import com.example.jdmapp.model.Vehiculo
import com.example.jdmapp.service.VehiculoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/vehiculo")   //endpoint
class VehiculoController {
    @Autowired
    lateinit var vehiculoService: VehiculoService
    @GetMapping
    fun list ():List <Vehiculo>{
        return vehiculoService.list()
    }
    @PostMapping
    fun save (@RequestBody vehiculo:Vehiculo):ResponseEntity<Vehiculo>{
        return ResponseEntity(vehiculoService.save(vehiculo), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody vehiculo:Vehiculo):ResponseEntity<Vehiculo>{
        return ResponseEntity(vehiculoService.updateMotor(vehiculo), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(vehiculoService.listById(id), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return vehiculoService.delete(id)
    }
}