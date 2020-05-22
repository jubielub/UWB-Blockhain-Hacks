package com.company;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class GenerateNewBlockMethod {

    public Block generateNextBlock(Data data) throws NoSuchAlgorithmException {

        int currentIndex = this.getLatestBlock().index + 1;
        String previousHash = this.getLatestBlock().hash;
        long currentTimeStamp = new Date().getTime();
        int currentNonce = 0; //not sure about this

        String currentHashTemporary = "0";
        Block currentBlock = new Block(currentIndex, previousHash, currentTimeStamp, data, currentHashTemporary, currentNonce);
        String currentBlockHash = currentBlock.calculateBlockHash(currentBlock);
        currentBlock.hash = currentBlockHash;
        System.out.println(currentBlock.toString(currentBlock));

        return currentBlock;
    }

}
