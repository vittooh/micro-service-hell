package com.example.micro_service_hell

import io.awspring.cloud.sns.core.SnsNotification
import io.awspring.cloud.sns.core.SnsOperations
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import software.amazon.awssdk.services.sns.SnsClient
import software.amazon.awssdk.services.sns.model.PublishRequest
import java.time.Duration
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/v1/potatos")
class PotatoController(
    val snsOperations: SnsOperations,
    val snsClient: SnsClient
) {

    @PostMapping
    fun potatoPostSNSClient() {
        val start = LocalDateTime.now()
        snsClient.publish(
            PublishRequest.builder()
                .topicArn("")
                .message("That is a potato with sns client")
                .messageDeduplicationId(UUID.randomUUID().toString())
                .build()
        )
        println(
            "Total time : ${
                Duration.between(
                    start,
                    LocalDateTime.now()
                )
            }"
        )
    }

    @PostMapping
    fun potatoPostSNSOperations() {
        val start = LocalDateTime.now()

        val notification: SnsNotification<String> = SnsNotification.builder<String>("a message")
            .deduplicationId("..")
            .groupId("..")
            .build()
        snsOperations.sendNotification(
            "teste",
            notification
        )
        println(
            "Total time : ${
                Duration.between(
                    start,
                    LocalDateTime.now()
                )
            }"
        )
    }
}