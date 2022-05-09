package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CaseApplication

fun main(args: Array<String>) {
	runApplication<CaseApplication>(*args)
}
