package com.community.gaming.staking.service;

import com.community.gaming.staking.contracts.CGStaking;
import com.community.gaming.staking.utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;

import javax.annotation.PostConstruct;

@Service
public class EventListenerService {

    @Autowired
    Helper helper;

    @Autowired
    Web3j web3j;

    Logger logger = LoggerFactory.getLogger(EventListenerService.class);

    @PostConstruct
    public void listen() {
        EthFilter filter = new EthFilter();
        web3j.ethLogObservable(filter).subscribe(event -> {
           logger.info("Address: " + event.getAddress() + "\tData: " + event.getData());
        });
    }
}
