package com.community.gaming.staking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ViewRewardResponse {
    private String account;
    private BigInteger reward;
}
