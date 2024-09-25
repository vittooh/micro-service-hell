package com.example.micro_service_hell

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sns.SnsClient

@Configuration
class BeanHell {

    @Bean
    fun createClientSNS(): SnsClient {
        return SnsClient.builder()
            .region(Region.SA_EAST_1)
            .build()
    }
}

