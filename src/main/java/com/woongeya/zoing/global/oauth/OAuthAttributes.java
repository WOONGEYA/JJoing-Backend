package com.woongeya.zoing.global.oauth;

import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.domain.user.domain.autority.Authority;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Getter
public class OAuthAttributes implements OAuth2User {

    private Map<String, Object> attributes;
    private String registrationId;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder(access = AccessLevel.PRIVATE)
    public OAuthAttributes(Map<String, Object> attributes, String registrationId, String nameAttributeKey, String name, String email, String picture) {
        this.attributes = attributes;
        this.registrationId = registrationId;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes create(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equalsIgnoreCase("google")) {
            return ofGoogle(registrationId, attributes);
        }

        throw new IllegalStateException("인증에 실패 했습니다.");
    }

    private static OAuthAttributes ofGoogle(String registrationId, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .registrationId(registrationId)
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .nickName(name)
                .email(email)
                .authority(Authority.USER)
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
