package com.nbenliogludev.userservice.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author nbenliogludev
 */
@FeignClient("restaurant-service/api/v1/restaurants")
public class UserClient {
}
