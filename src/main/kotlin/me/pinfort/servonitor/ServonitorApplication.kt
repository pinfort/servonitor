package me.pinfort.servonitor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServonitorApplication

fun main(args: Array<String>) {
	runApplication<ServonitorApplication>(*args)
}
