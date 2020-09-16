package com.project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;


//@RunWith(SpringRunner.class)
@SpringBootTest
public class EthServiceTest {

    @Test
    public void getEthClientVersionSync() throws Exception
    {
        Web3j web3j = Web3j.build(new HttpService());
        Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
        System.out.println(web3ClientVersion.getWeb3ClientVersion());
    }


    @Test
    public void getEthClientVersionASync() throws Exception
    {
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
        System.out.println(web3ClientVersion.getWeb3ClientVersion());
    }

    @Test
    public void getEthClientVersionRx() throws Exception
    {
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
        web3.web3ClientVersion().flowable().subscribe(x -> {
            System.out.println(x.getWeb3ClientVersion());
        });

        Thread.sleep(5000);
    }
}


/*


geth --networkid 45 --nodiscover --maxpeers 0 --datadir C:\ssafy\project2\geth --mine --minerthreads 1 --allow-insecure-unlock --rpc --rpcaddr "0.0.0.0" --rpcport 8545 --rpccorsdomain "*" --rpcapi "admin, db, eth, debug, miner, net, shh, txpool, personal, web3" 2>>  C:\ssafy\project2\geth/geth.log &

geth attach rpc:http://localhost:8545

web3.fromWei(eth.getBalance(eth.accounts[0]), "ether")


//unlock
{
    "jsonrpc":"2.0",
    "method":"personal_unlockAccount",
    "params": [
        "0x34ee5e2e9842d03c4000e9b2c70f398b04a69004",
        "123qwe",
        0
        ],   
    "id":100
}




//send Tansaction with data

{
    "jsonrpc":"2.0",
    "method":"eth_sendTransaction",
    "params": [{
      "data": "0x2c2c2c2c2c2c2c2c2c2c2c2c",
      "from": "0x34ee5e2e9842d03c4000e9b2c70f398b04a69004",
      "to": "0x34ee5e2e9842d03c4000e9b2c70f398b04a69004",
      "value": "0x821ab0d4414980000"
    }],   
    "id":100
}

//result
{
    "jsonrpc": "2.0",
    "id": 100,
    "result": "0xc8e1b783a657792dec80c1822da6cd4eb1a6c2f797b173d63f9359b423201d1d"
}


*/