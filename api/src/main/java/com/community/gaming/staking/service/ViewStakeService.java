package com.community.gaming.staking.service;

import com.community.gaming.staking.contracts.CGStaking;
import com.community.gaming.staking.model.ViewStakeResponse;
import com.community.gaming.staking.utils.Helper;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ViewStakeService {

    @Autowired
    Helper helper;

    public ViewStakeResponse getStakeByAddress(String address) {
        final List<BigInteger> stakedAmounts = new ArrayList<>();
        CGStaking contract = helper.loadContractFromAddress();
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST,
                contract.getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CGStaking.STAKETOKEN_EVENT));
        filter.addOptionalTopics("0x" + TypeEncoder.encode(new Address(address)));
        contract.stakeTokenEventObservable(filter).subscribe(event -> {
            System.out.println("Address: " + event._stakeholder + "\tAmount: " + event._amount);
            stakedAmounts.add(event._amount);
        });
        return new ViewStakeResponse(address, stakedAmounts.stream().reduce(BigInteger.ZERO, (prev, next) -> prev.add(next)));
    }


}
