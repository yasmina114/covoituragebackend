package com.example.covoituragebackend.security;

public interface SecurityParams {
    String JWT_HEADER_NAME="Authorization";
    String SECRET="mariamfatnassi01@gmail.com";
  long EXPIRATION=3600000;//1h le temps d'expiration
   String HEADER_PREFIX="Bearer ";
}
