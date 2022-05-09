package com.example.demo

import com.example.demo.generic.populateDatabase
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CaseApplication

fun main(args: Array<String>) {

	populateDatabase()

	runApplication<CaseApplication>(*args)
}
