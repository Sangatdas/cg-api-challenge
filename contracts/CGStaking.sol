// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <=0.8.0;

import "browser/CGToken.sol";

contract CGStaking {
    
    CGToken private token;
    
    mapping(address => uint256) private rewards;
    
    event StakeToken(address indexed _stakeholder, uint _amount);
    event WithdrawReward(address indexed _stakeholder, uint _amount);
    
    constructor(address _ofTokenContract) {
        token = CGToken(_ofTokenContract);
    }
    
    function stake(uint256 _amount) public {
        require(_amount >= 10, "Minimum stake amount should be more than 10");
        require(token.balanceOf(msg.sender) >= _amount, "Amount exceeds sender balance");
        token.transferFrom(msg.sender, address(this), _amount);
        emit StakeToken(msg.sender, _amount);
        rewards[msg.sender] += _amount / 10;
    }
    
    function withdrawReward(uint256 _amount) public {
        require(_amount <= rewards[msg.sender], "Amount exceeds total reward");
        require(_amount <= token.balanceOf(address(this)), "Amount exceeds contract account balance.");
        token.transfer(msg.sender, _amount);
        rewards[msg.sender] -= _amount;
        emit WithdrawReward(msg.sender, _amount);
    }

}
