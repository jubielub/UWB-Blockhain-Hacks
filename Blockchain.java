package com.company;

import netscape.javascript.JSObject;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

public class Blockchain {

    private ArrayList<Block> blockchain = new ArrayList<>();

    public Blockchain(){

        //the zeroeth block is the genesis block
        this.blockchain.add(new Block(0, "0", 000,
                "Welcome to Blockchain!", "000dc75a315c77a1f9c98fb6247d03dd18ac52632d7dc6a9920261d8109b37cf",
                604));
    }

    public static void main (String[] args) throws NoSuchAlgorithmException {

        Blockchain chain = new Blockchain();
        Block newBlock1 = chain.generateNextBlock("hill");
        chain.getBlockChain().add(newBlock1);
        Block newBlock2 = chain.generateNextBlock("bye");
        chain.getBlockChain().add(newBlock2);
    }

    public ArrayList<Block> getBlockChain(){

        return this.blockchain;
    }

    public Block getLatestBlock(){

        return this.blockchain.get(this.blockchain.size() - 1);
    }


    public String calculateHashForBlock(Block currentBlock) throws NoSuchAlgorithmException {

        System.out.println(this.calculateHash(currentBlock.index, currentBlock.previousHash,
                currentBlock.timestamp, currentBlock.data, currentBlock.nonce));

        return this.calculateHash(currentBlock.index, currentBlock.previousHash,
                currentBlock.timestamp, currentBlock.data, currentBlock.nonce);
    }


    public String calculateHash(int index, String preiousHash, long timeStamp, String data, int nonce) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(preiousHash.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodedhash);
        return bytesToHex(encodedhash);

    }

    //use to create hash for calculateHash() method
    private static String bytesToHex(byte[] hash){

        StringBuffer hexString = new StringBuffer();
        for(int i = 0; i < hash.length; i++){
            String hex = Integer.toHexString((0xff & hash[i]));
            if(hex.length() == 1){
                hexString.append('0');
            }
        }

        return hexString.toString();
    }

    //called in the main class or messages class
    public Block generateNextBlock(String data) throws NoSuchAlgorithmException {

        int currentIndex = (this.blockchain.size() - 1) + 1;
        String previousHash = (this.blockchain.get(this.blockchain.size() - 1)).hash;
        long currentTimeStamp = new Date().getTime();
        int currentNonce = 0; //not sure about this
        String currentHash = this.calculateHash(currentIndex, previousHash, currentTimeStamp, data, currentNonce);

        Block currentBlock = currentBlock = new Block(currentIndex, previousHash, currentTimeStamp, data, currentHash, currentNonce);
        System.out.println(currentHash);

        return currentBlock;
    }

    public boolean isValidNextBlock(Block nextBlock, Block previousBlock) throws NoSuchAlgorithmException {

        String nextBlockHash = this.calculateHashForBlock(nextBlock);

        if(previousBlock.index + 1 != nextBlock.index){

            return false;
        }

        else if (previousBlock.hash != nextBlock.previousHash){

            return false;
        }

        else if(nextBlockHash != nextBlock.hash){

            return false;
        }

        else{

            return true;
        }
    }

    // OTHER METHODS THAT I DONT UNDERSTAND:

    /*
    isValidChain(chain) {
        if (JSON.stringify(chain[0]) !== JSON.stringify(Block.genesis)) {
            return false;
        }

    const tempChain = [chain[0]];
        for (let i = 1; i < chain.length; i = i + 1) {
            if (this.isValidNextBlock(chain[i], tempChain[i - 1])) {
                tempChain.push(chain[i]);
            } else {
                return false;
            }
        }
        return true;
    }

    isChainLonger(chain) {
        return chain.length > this.blockchain.length;
    }

    replaceChain(newChain) {
        if (this.isValidChain(newChain) && this.isChainLonger(newChain)) {
            this.blockchain = JSON.parse(JSON.stringify(newChain));
        } else {
            throw "Error: invalid chain";
        }
    }
}

     */



}
