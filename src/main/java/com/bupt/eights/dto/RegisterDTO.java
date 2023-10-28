package com.bupt.eights.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RegisterDTO {
    
    @NotBlank String email;
    
    @NotBlank String gender;
    
    String nickName;
    
    @NotBlank String password;
    
    @NotBlank String phone;
    
    @NotBlank String prefix;
    
    @NotBlank String userName;
    
}
