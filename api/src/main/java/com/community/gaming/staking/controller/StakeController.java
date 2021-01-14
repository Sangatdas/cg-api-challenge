package com.community.gaming.staking.controller;

import com.community.gaming.staking.model.ViewRewardResponse;
import com.community.gaming.staking.model.ViewStakeResponse;
import com.community.gaming.staking.service.ViewRewardService;
import com.community.gaming.staking.service.ViewStakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "/")
public class StakeController {

    @Autowired
    private ViewRewardService viewRewardService;

    @Autowired
    private ViewStakeService viewStakeService;

    @GetMapping(value = "/stakedTokens/{publicAddress}", produces = "application/json")
    public ViewStakeResponse getStakedTokensByAddress(@PathVariable String publicAddress) {
        return viewStakeService.getStakeByAddress(publicAddress);
    }

    @GetMapping(value = "/stakingRewards/{publicAddress}", produces = "application/json")
    public ViewRewardResponse getStakingRewardsByAddress(@PathVariable String publicAddress) {
        return viewRewardService.getRewardByAddress(publicAddress);
    }
}
