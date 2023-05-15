package com.woongeya.zoing.domain.auth.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.exception.AuthenticationException;
import com.woongeya.zoing.global.jwt.dto.TokenResponseDto;
import com.woongeya.zoing.global.jwt.util.JwtProvider;
import com.woongeya.zoing.global.oauth.OAuthAttributes;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class OAuth2GithubService {

    private final String GITHUB_TOKEN_REQUEST_URL = "https://github.com/login/oauth/access_token";
    private final String GITHUB_USERINFO_REQUEST_URL = "https://api.github.com/user";
    @Value("${spring.security.oauth2.client.registration.github.client-id}")
    private String githubClientId;
    @Value("${spring.security.oauth2.client.registration.github.client-secret}")
    private String githubClientSecret;
    @Value("${spring.security.oauth2.client.registration.github.redirect-uri}")
    private String githubRedirectUri;

    private final OAuth2LoginService oAuth2LoginService;
    private final JwtProvider jwtProvider;

    public TokenResponseDto getJwtToken(String code) {
        String googleToken = getGithubToken(code);
        OAuthAttributes oAuthAttributes = getOAuthAttributesByGithubToken(googleToken);
        User user = oAuth2LoginService.saveOrUpdate(oAuthAttributes);
        return jwtProvider.generateToken(user.getEmail(), user.getAuthority().toString());
    }

    public String getGithubToken(String code) {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("code", code);
        params.add("client_id", githubClientId);
        params.add("client_secret", githubClientSecret);
        params.add("redirect_uri", githubRedirectUri);
        params.add("grant_type", "authorization_code");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity entity = new HttpEntity(params, headers);

        // github에게 토큰 요청
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JsonNode> responseEntity = restTemplate.exchange(GITHUB_TOKEN_REQUEST_URL, HttpMethod.POST, entity, JsonNode.class);
        JsonNode accessToken = responseEntity.getBody();

        return accessToken.get("access_token").asText();
    }

    public OAuthAttributes getOAuthAttributesByGithubToken(String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Bearer " + token);

        // github토큰을 header에 담아서 유저 정보 요청
        HttpEntity entity = new HttpEntity(headers);
        Map<String, Object> attributes = getJson(entity);

        return OAuthAttributes.create("github", attributes);
    }

    private Map<String, Object> getJson(HttpEntity entity) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(GITHUB_USERINFO_REQUEST_URL, HttpMethod.GET, entity, String.class);
            String body = response.getBody();
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(body);
            return (Map<String, Object>) jsonObject;
        } catch (ParseException e) {
            throw AuthenticationException.EXCEPTION;
        }
    }
}
