package com.example.jdmapp.model

import jakarta.persistence.*

@Entity
@Table(name = "marcas")
class Marcas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var modelo: String? = null
    var ano: String? = null
}