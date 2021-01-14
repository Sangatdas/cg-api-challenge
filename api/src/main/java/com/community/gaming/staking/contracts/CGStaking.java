package com.community.gaming.staking.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class CGStaking extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516108123803806108128339818101604052602081101561003357600080fd5b8101908080519060200190929190505050806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505061077e806100946000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c8063523a3f081461003b578063a694fc3a14610069575b600080fd5b6100676004803603602081101561005157600080fd5b8101908080359060200190929190505050610097565b005b6100956004803603602081101561007f57600080fd5b81019080803590602001909291905050506103d1565b005b600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205481111561014c576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601b8152602001807f416d6f756e74206578636565647320746f74616c20726577617264000000000081525060200191505060405180910390fd5b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231306040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b1580156101d357600080fd5b505afa1580156101e7573d6000803e3d6000fd5b505050506040513d60208110156101fd57600080fd5b8101908080519060200190929190505050811115610266576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260288152602001806107216028913960400191505060405180910390fd5b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a9059cbb33836040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b1580156102f757600080fd5b505af115801561030b573d6000803e3d6000fd5b505050506040513d602081101561032157600080fd5b81019080805190602001909291905050505080600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825403925050819055503373ffffffffffffffffffffffffffffffffffffffff167fbc84835063c693975166f00cffb19f01a94c2db55b1bf259238c5da3594e5066826040518082815260200191505060405180910390a250565b600a81101561042b576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602b8152602001806106f6602b913960400191505060405180910390fd5b8060008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231336040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b1580156104b357600080fd5b505afa1580156104c7573d6000803e3d6000fd5b505050506040513d60208110156104dd57600080fd5b81019080805190602001909291905050501015610562576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601d8152602001807f416d6f756e7420657863656564732073656e6465722062616c616e636500000081525060200191505060405180910390fd5b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd3330846040518463ffffffff1660e01b8152600401808473ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b15801561061157600080fd5b505af1158015610625573d6000803e3d6000fd5b505050506040513d602081101561063b57600080fd5b8101908080519060200190929190505050503373ffffffffffffffffffffffffffffffffffffffff167f95d0aa551474aeee124f0d92b9adb26d65b9472f637c408329a728e40ad0e8ef826040518082815260200191505060405180910390a2600a81816106a557fe5b04600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825401925050819055505056fe4d696e696d756d207374616b6520616d6f756e742073686f756c64206265206d6f7265207468616e203130416d6f756e74206578636565647320636f6e7472616374206163636f756e742062616c616e63652ea2646970667358221220bec38244dd26dfc020523a66c31879b03421ed32a79f134e0d22728cfa13878964736f6c63430007050033\n";

    public static final String FUNC_STAKE = "stake";

    public static final String FUNC_WITHDRAWREWARD = "withdrawReward";

    public static final Event STAKETOKEN_EVENT = new Event("StakeToken", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event WITHDRAWREWARD_EVENT = new Event("WithdrawReward", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected CGStaking(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CGStaking(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CGStaking(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CGStaking(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> stake(BigInteger _amount) {
        final Function function = new Function(
                FUNC_STAKE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<CGStaking> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _ofTokenContract) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_ofTokenContract)));
        return deployRemoteCall(CGStaking.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<CGStaking> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _ofTokenContract) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_ofTokenContract)));
        return deployRemoteCall(CGStaking.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CGStaking> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _ofTokenContract) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_ofTokenContract)));
        return deployRemoteCall(CGStaking.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CGStaking> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _ofTokenContract) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_ofTokenContract)));
        return deployRemoteCall(CGStaking.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public List<StakeTokenEventResponse> getStakeTokenEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(STAKETOKEN_EVENT, transactionReceipt);
        ArrayList<StakeTokenEventResponse> responses = new ArrayList<StakeTokenEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            StakeTokenEventResponse typedResponse = new StakeTokenEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._stakeholder = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<StakeTokenEventResponse> stakeTokenEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, StakeTokenEventResponse>() {
            @Override
            public StakeTokenEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(STAKETOKEN_EVENT, log);
                StakeTokenEventResponse typedResponse = new StakeTokenEventResponse();
                typedResponse.log = log;
                typedResponse._stakeholder = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<StakeTokenEventResponse> stakeTokenEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(STAKETOKEN_EVENT));
        return stakeTokenEventObservable(filter);
    }

    public RemoteCall<TransactionReceipt> withdrawReward(BigInteger _amount) {
        final Function function = new Function(
                FUNC_WITHDRAWREWARD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<WithdrawRewardEventResponse> getWithdrawRewardEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WITHDRAWREWARD_EVENT, transactionReceipt);
        ArrayList<WithdrawRewardEventResponse> responses = new ArrayList<WithdrawRewardEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WithdrawRewardEventResponse typedResponse = new WithdrawRewardEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._stakeholder = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WithdrawRewardEventResponse> withdrawRewardEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, WithdrawRewardEventResponse>() {
            @Override
            public WithdrawRewardEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WITHDRAWREWARD_EVENT, log);
                WithdrawRewardEventResponse typedResponse = new WithdrawRewardEventResponse();
                typedResponse.log = log;
                typedResponse._stakeholder = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<WithdrawRewardEventResponse> withdrawRewardEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WITHDRAWREWARD_EVENT));
        return withdrawRewardEventObservable(filter);
    }

    @Deprecated
    public static CGStaking load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CGStaking(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CGStaking load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CGStaking(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CGStaking load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CGStaking(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CGStaking load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CGStaking(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class StakeTokenEventResponse {
        public Log log;

        public String _stakeholder;

        public BigInteger _amount;
    }

    public static class WithdrawRewardEventResponse {
        public Log log;

        public String _stakeholder;

        public BigInteger _amount;
    }
}
