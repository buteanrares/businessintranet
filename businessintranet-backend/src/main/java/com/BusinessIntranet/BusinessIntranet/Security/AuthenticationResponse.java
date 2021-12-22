package com.BusinessIntranet.BusinessIntranet.Security;

public record AuthenticationResponse(String jwt) {

    public String getJwt() {
        return jwt;
    }
}
