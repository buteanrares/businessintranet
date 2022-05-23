package com.BusinessIntranet.BusinessIntranet.Security;


import com.BusinessIntranet.BusinessIntranet.Configuration.Configuration;
import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import com.BusinessIntranet.BusinessIntranet.Employee.EmployeeRepository;
import com.BusinessIntranet.BusinessIntranet.Employee.EmployeeService;
import com.BusinessIntranet.BusinessIntranet.Security.Requests.LoginRequest;
import com.BusinessIntranet.BusinessIntranet.Security.Responses.JwtResponse;
import com.BusinessIntranet.BusinessIntranet.Security.Responses.MessageResponse;
import com.BusinessIntranet.BusinessIntranet.Security.Services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody Employee signUpRequest) {
        if (employeeService.employeeEmailExists(signUpRequest.getFirstName() + "." + signUpRequest.getLastName() + Configuration.EMAIL_DOMAIN))
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email " + signUpRequest.getEmail() + " is already taken!"));

        Employee employee = new Employee(
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                encoder.encode(Configuration.INITIAL_PASSWORD),
                signUpRequest.getEmailGroups(),
                signUpRequest.getRoles(),
                signUpRequest.getPhone(),
                signUpRequest.getJobTitle(),
                signUpRequest.getDepartment(),
                signUpRequest.getManagerId()
        );
        employeeRepository.save(employee);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
