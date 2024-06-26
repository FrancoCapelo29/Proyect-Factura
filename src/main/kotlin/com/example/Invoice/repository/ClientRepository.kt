package com.example.Invoice.repository

import com.example.Invoice.entity.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : JpaRepository<Client, Long?> {
    fun findById(id: Long?): Client?
}