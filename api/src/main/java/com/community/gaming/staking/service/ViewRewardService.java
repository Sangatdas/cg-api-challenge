package com.community.gaming.staking.service;

import com.community.gaming.staking.contracts.CGStaking;
import com.community.gaming.staking.model.ViewRewardResponse;
import com.community.gaming.staking.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeEncoder;
import org.web3j.abi.datatypes.Address;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ViewRewardService {

    @Autowired
    Helper helper;

    public ViewRewardResponse getRewardByAddress(String address) {
        final List<BigInteger> withdrawnRewardAmounts = new ArrayList<>();
        CGStaking contract = helper.loadContractFromAddress();
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST,
                contract.getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CGStaking.WITHDRAWREWARD_EVENT));
        filter.addOptionalTopics("0x" + TypeEncoder.encode(new Address(address)));
        contract.withdrawRewardEventObservable(filter).subscribe(event -> {
            System.out.printf("Event: Withdraw Reward\tAddress: %s\tAmount: %s%n",
                    event._stakeholder,
                    event._amount);
            withdrawnRewardAmounts.add(event._amount);
        });
        return new ViewRewardResponse(address, withdrawnRewardAmounts.stream().reduce(BigInteger.ZERO, (prev, next) -> prev.add(next)));
    }
}
