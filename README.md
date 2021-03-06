# cg-api-challenge
Hello and welcome! 
Your mission, should you choose to accept it, is to build a simple decentralized application that allows users to stake their tokens. This dApp is very minimal and does not need a user interface (interaction through Remix or Truffle is fine.) It does need to have a blockchain event listener to easily allow users to call up an API to see how many tokens they have staked, and how much they’ve earned in rewards. 

### Product Requirements: 
  - Create an ERC20 contract using OpenZeppellin standard with 18 decimal places 
  - Create a contract that allows users to send their tokens to stake and earn rewards (Reward is receiving more of the same ERC20 token, rewarding system can be very simple for the sake of this challenge) 
  - Have a Springboot service (using Java or Kotlin) to track the events coming from the blockchain. 
  - Have the Springboot service aggregate the data from the events and expose them using GraphQL or RESTful API. 
  - GET /stakedTokens/${publicAddress} -> Returns the holder’s staked tokens 
  - GET /stakingRewards/${publicAddress} -> Returns the user’s rewards from staking User interface. 
  - You may develop a user interface for this but it’s fine if the user interactions are all coming from something like Remix or truffle.
