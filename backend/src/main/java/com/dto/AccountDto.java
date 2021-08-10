package com.dto;

import com.model.Role;
import lombok.Data;

@Data
public class AccountDto {

    private String username;

    private String password;

    private int status;

    private long idRole;

    private Role role;
}
