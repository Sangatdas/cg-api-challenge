package com.community.gaming.staking.utils;

import com.community.gaming.staking.contracts.CGStaking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.DefaultGasProvider;

@Component
public class Helper {

    @Autowired
    private Web3j web3j;

    @Value("${PRIVATE_KEY}")
    private String key;

    @Value("${CONTRACT_ADDRESS}")
    private String address;

    public CGStaking loadContractFromAddress() {
        Credentials credentials = Credentials.create(key);
        CGStaking cgStakingContract = CGStaking.load(address,
                web3j,
                credentials,
                DefaultGasProvider.GAS_PRICE,
                DefaultGasProvider.GAS_LIMIT);

        return cgStakingContract;
    }
}
