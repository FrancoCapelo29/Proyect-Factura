package com.example.Invoice.repository

import com.example.Invoice.entity.Detail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DetailRepository : JpaRepository<Detail, Long?> {
    fun findById(id: Long?): Detail?
}