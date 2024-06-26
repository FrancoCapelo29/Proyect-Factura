package com.example.Invoice.controller

import com.example.Invoice.entity.Invoice
import com.example.Invoice.entity.InvoiceView
import com.example.Invoice.service.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/invoices")   //endpoint
class InvoiceController {
    @Autowired
    lateinit var invoiceService: InvoiceService

    @GetMapping("/{value}/get-total")
    fun getTotal (@PathVariable value:Double):List<Invoice>{
        return invoiceService.getTotal(value)
    }

    @GetMapping
    fun list(): List<Invoice> {
        return invoiceService.list()
    }

    @GetMapping("/whit-client")
    fun listView ():List<InvoiceView>{
        return invoiceService.listView()
    }

    @PostMapping
    fun save(@RequestBody invoice: Invoice): ResponseEntity<Invoice> {
        return ResponseEntity(invoiceService.save(invoice), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody invoice: Invoice): ResponseEntity<Invoice> {
        return ResponseEntity(invoiceService.update(invoice), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody invoice: Invoice): ResponseEntity<Invoice> {
        return ResponseEntity(invoiceService.updateName(invoice), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(invoiceService.listById(id), HttpStatus.OK)

    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): Boolean? {
        return invoiceService.delete(id)
    }
}