package com.assessment.assessment.List.interceptors;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Component
public class LoggingInterceptor
  extends OncePerRequestFilter
  implements HandlerInterceptor {

  private static final Logger logger = LoggerFactory.getLogger(
    LoggingInterceptor.class
  );

  @Override
  @SuppressWarnings("null")
  public boolean preHandle(
    HttpServletRequest request,
    HttpServletResponse response,
    Object handler
  ) throws Exception {
    // Log request details
    logger.info(
      "Received request: {} {} from {}",
      request.getMethod(),
      request.getRequestURI(),
      request.getRemoteAddr()
    );
    return true;
  }

  @Override
  @SuppressWarnings("null")
  public void afterCompletion(
    HttpServletRequest request,
    HttpServletResponse response,
    Object handler,
    Exception ex
  ) throws Exception {
    // Log response details
    logger.info(
      "Sent response: {} {} with status {}",
      request.getMethod(),
      request.getRequestURI(),
      response.getStatus()
    );
  }

  @Override
  @SuppressWarnings("null")
  protected void doFilterInternal(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain filterChain
  ) throws ServletException, IOException {
    ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(
      request
    );
    ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(
      response
    );

    filterChain.doFilter(requestWrapper, responseWrapper);

    String requestBody = getStringValue(
      requestWrapper.getContentAsByteArray(),
      request.getCharacterEncoding()
    );
    String responseBody = getStringValue(
      responseWrapper.getContentAsByteArray(),
      response.getCharacterEncoding()
    );

    logger.info("Request Payload: {}", requestBody);

    logger.info(
      "Response Payload: {} with status {}",
      responseBody,
      response.getStatus()
    );
    responseWrapper.copyBodyToResponse();
  }

  private String getStringValue(
    byte[] contentAsByteArray,
    String characterEncoding
  ) {
    try {
      return new String(
        contentAsByteArray,
        0,
        contentAsByteArray.length,
        characterEncoding
      );
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return "";
  }
}
