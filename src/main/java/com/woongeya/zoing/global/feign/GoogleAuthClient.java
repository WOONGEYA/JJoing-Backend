package com.woongeya.zoing.global.feign;

import com.woongeya.zoing.global.feign.dto.request.GoogleTokenRequest;
import com.woongeya.zoing.global.feign.dto.response.GoogleTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "googleAuthClient", url = "https://oauth2.googleapis.com/token")
public interface GoogleAuthClient {

    @PostMapping()
    GoogleTokenResponse getGoogleToken(GoogleTokenRequest request);
}
