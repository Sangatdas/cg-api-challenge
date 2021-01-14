package com.community.gaming.staking.service;

import com.community.gaming.staking.contracts.CGStaking;
import com.community.gaming.staking.model.ViewRewardResponse;
import com.community.gaming.staking.model.ViewStakeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeEncoder;
import org.web3j.abi.datatypes.Address;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Logger;

@Service
public class ViewRewardService {

    @Autowired
    private Web3j web3j;

    @Autowired
    private ViewStakeService viewStakeService;

    @Value("${PRIVATE_KEY}")
    private String key;

    @Value("${CONTRACT_ADDRESS}")
    private String address;

    public ViewRewardResponse getRewardByAddress(String address) {
        ViewStakeResponse response = viewStakeService.getStakeByAddress(address);
        return new ViewRewardResponse(response.getAccount(), response.getStake().divide(BigInteger.TEN));
    }
}
