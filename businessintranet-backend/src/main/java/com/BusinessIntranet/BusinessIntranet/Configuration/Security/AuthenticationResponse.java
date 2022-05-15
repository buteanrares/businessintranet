package com.BusinessIntranet.BusinessIntranet.Configuration.Security;

public record AuthenticationResponse(String jwt) {

    public String getJwt() {
        return jwt;
    }
}
