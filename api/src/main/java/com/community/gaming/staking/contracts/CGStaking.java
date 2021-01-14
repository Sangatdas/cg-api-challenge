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
    private static final String BINARY = "608060405234801561001057600080fd5b506040516103403803806103408339818101604052602081101561003357600080fd5b8101908080519060200190929190505050806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550506102ac806100946000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c8063a694fc3a14610030575b600080fd5b61005c6004803603602081101561004657600080fd5b810190808035906020019092919050505061005e565b005b600a81101561006c57600080fd5b8060008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231336040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b1580156100f457600080fd5b505afa158015610108573d6000803e3d6000fd5b505050506040513d602081101561011e57600080fd5b8101908080519060200190929190505050101561013a57600080fd5b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd3330846040518463ffffffff1660e01b8152600401808473ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b1580156101e957600080fd5b505af11580156101fd573d6000803e3d6000fd5b505050506040513d602081101561021357600080fd5b8101908080519060200190929190505050503373ffffffffffffffffffffffffffffffffffffffff167f95d0aa551474aeee124f0d92b9adb26d65b9472f637c408329a728e40ad0e8ef826040518082815260200191505060405180910390a25056fea2646970667358221220b4774a2a6a1b83331ff5a4b49457f4d236e6326475d09ec9b1e59bda220e553864736f6c63430007050033\n";

    public static final String FUNC_STAKE = "stake";

    public static final Event STAKETOKEN_EVENT = new Event("StakeToken", 
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
}
