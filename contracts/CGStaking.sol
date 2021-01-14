// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <=0.8.0;

import "browser/CGToken.sol";

contract CGStaking {
    
    CGToken private token;
    
    event StakeToken(address indexed _stakeholder, uint _amount);
    
    constructor(address _ofTokenContract) {
        token = CGToken(_ofTokenContract);
    }
    
    function stake(uint256 _amount) public {
        require(_amount >= 10);
        require(token.balanceOf(msg.sender) >= _amount);
        token.transferFrom(msg.sender, address(this), _amount);
        emit StakeToken(msg.sender, _amount);
    }
    

}
