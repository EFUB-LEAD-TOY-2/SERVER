package com.efub.leadtoyproject.global.oauth2;

import com.efub.leadtoyproject.global.jwt.TokenProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final TokenProvider tokenProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // accessToken 발급
        String accessToken = tokenProvider.generateAccessToken(authentication);
        // 헤더 Authorization에 Bearer Token 담기
        response.addHeader("Authorization", "Bearer " + accessToken);
        log.info("카카오 로그인에 성공하였습니다. 발급된 accessToken: " + accessToken);
        String redirectUrl = "https://lead-paladin.vercel.app/login/loading";
        response.sendRedirect(redirectUrl+"?accessToken="+accessToken); // redirectUrl에 accessToken을 담아 보냄
    }
}