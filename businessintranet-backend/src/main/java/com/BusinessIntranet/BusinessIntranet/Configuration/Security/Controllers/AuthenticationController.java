package com.BusinessIntranet.BusinessIntranet.Configuration.Security.Controllers;

import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import com.BusinessIntranet.BusinessIntranet.Configuration.Security.AuthenticationResponse;
import com.BusinessIntranet.BusinessIntranet.Configuration.Security.Utils.JwtUtil;
import com.BusinessIntranet.BusinessIntranet.Employee.EmployeeService;
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
    private final EmployeeService employeeService;
    private final JwtUtil jwtTokenUtil;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, EmployeeService employeeService, JwtUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.employeeService = employeeService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Employee employee) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(employee.getEmail(), employee.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = employeeService.loadUserByUsername(employee.getEmail());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
