package com.ordertoy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OrdertoyApplication

fun main(args: Array<String>) {
	runApplication<OrdertoyApplication>(*args)
}
