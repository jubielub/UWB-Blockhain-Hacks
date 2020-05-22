package com.company;

public class Block {

    int index;
    String previousHash;
    long timestamp;
    String data; //change the type of this variable to suit what data we ask from the user
    String hash;
    int nonce;

    public Block(int index, String previousHash, long timeStamp, String data,
                    String hash, int nonce){

            this.index = index;
            this. previousHash = previousHash;
            this.timestamp = timeStamp;
            this.data = data;
            this.hash = hash;
            this. nonce = nonce;
    }

    public int getIndex(){

        return this.index;
    }

    public String getPreviousHash(){

        return this.previousHash;
    }

    public long getTimestamp(){

        return this.timestamp;
    }

    public String getData(){

        return this.data;
    }

    public String getHash(){

        return this.hash;
    }

    public int getNonce(){

        return this.nonce;
    }

    public void setData(String data) {

        this.data = data;
    }
}
