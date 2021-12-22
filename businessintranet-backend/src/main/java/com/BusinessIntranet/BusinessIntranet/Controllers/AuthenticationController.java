package com.BusinessIntranet.BusinessIntranet.Controllers;

import com.BusinessIntranet.BusinessIntranet.Models.Account;
import com.BusinessIntranet.BusinessIntranet.Security.AuthenticationResponse;
import com.BusinessIntranet.BusinessIntranet.Security.Utils.JwtUtil;
import com.BusinessIntranet.BusinessIntranet.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final AccountService accountService;
    private final JwtUtil jwtTokenUtil;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, AccountService accountService, JwtUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.accountService = accountService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Account account) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(account.getEmail(), account.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = accountService.loadUserByUsername(account.getEmail());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
