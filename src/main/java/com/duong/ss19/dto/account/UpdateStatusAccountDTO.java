package com.duong.ss19.dto.account;

import com.duong.ss19.entity.account.AccountStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UpdateStatusAccountDTO {
    private int id;
    private AccountStatus status;
}
