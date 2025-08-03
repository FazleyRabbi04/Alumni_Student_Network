package com.nsu.alumni.data_transfer;

import com.nsu.alumni.entity_class.EmailAddress;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
public class SignupRequest {
    // Getters and Setters
    @Getter
    @NotBlank(message = "Role is required")
    private String role;

    @Getter
    @NotBlank(message = "First name is required")
    @Size(min = 2, message = "First name must be at least 2 characters")
    private String firstName;

    @Getter
    @NotBlank(message = "Last name is required")
    @Size(min = 2, message = "Last name must be at least 2 characters")
    private String lastName;

    // Fixed: Return type should match the field type (String)
    @Getter  // Added @Getter annotation here
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Getter
    @NotBlank(message = "Department is required")
    private String department;

    @Getter
    private Integer gradYear; // For Alumni

    @Getter
    private String batch; // For Student

    @Getter
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    @Getter
    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;

}