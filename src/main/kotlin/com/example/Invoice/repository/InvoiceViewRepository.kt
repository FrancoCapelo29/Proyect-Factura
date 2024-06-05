package com.example.Invoice.repository

import com.example.Invoice.entity.InvoiceView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceViewRepository : JpaRepository<InvoiceView, Long?> {
    fun findById(id: Long?): InvoiceView?
    
}

//localhost:8081/invoices/1/get-total