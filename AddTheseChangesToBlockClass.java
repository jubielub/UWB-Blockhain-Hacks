package com.company;

public class AddTheseChangesToBlockClass {

    //technically the change data method
    //to do
    public void setData(Data data) {

        data = this.data;
    }

    public Block changeData(Data changedData){

        //create a new block for the new data to be stored in
        Block newBlock = null;

        //set the data of the new block to be the changed data
        newBlock.setData(changedData);

        //based on the changedData, make new hash
        calculateBlockHash(newBlock);

        return newBlock;

    }

}
