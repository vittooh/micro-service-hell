package com.example.micro_service_hell

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MicroServiceHellApplication

fun main(args: Array<String>) {
	runApplication<MicroServiceHellApplication>(*args)
}
