import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;


public class Blockchain {

    private ArrayList<Block> blockchain = new ArrayList<>();
    private int difficulty;

    public Blockchain(){

        //the zeroeth block is the genesis block which is added here
        this.blockchain.add(new Block(0, "0", 000,
               new Data("Welcome to Blockchain!") , "000dc75a315c77a1f9c98fb6247d03dd18ac52632d7dc6a9920261d8109b37cf",
                604));
        difficulty = 3;
    }

    public static void main (String[] args) throws NoSuchAlgorithmException {

        Blockchain chain = new Blockchain();
        Block newBlock1 = chain.generateNextBlock(new Data("hill"));
        chain.getBlockChain().add(newBlock1);
        Block newBlock2 = chain.generateNextBlock(new Data("bye"));
        chain.getBlockChain().add(newBlock2);
    }

    public ArrayList<Block> getBlockChain(){

        return this.blockchain;
    }

    public Block getLatestBlock(){

        return this.blockchain.get(this.blockchain.size() - 1);
    }


    //called in the main class or messages class
    public Block generateNextBlock(Data data) throws NoSuchAlgorithmException {

        int currentIndex = (this.blockchain.size() - 1) + 1;
        String previousHash = (this.blockchain.get(this.blockchain.size() - 1)).hash;
        long currentTimeStamp = new Date().getTime();
        int currentNonce = 0; //not sure about this
        String currentHashTemporary = "0";

        Block currentBlock = new Block(currentIndex, previousHash, currentTimeStamp, data, currentHashTemporary, currentNonce);
        String currentBlockHash = currentBlock.calculateBlockHash(currentBlock);
        currentBlock.hash = currentBlockHash;
        System.out.println(currentBlock.toString(currentBlock));

        return currentBlock;
    }

    public boolean isValidHashDifficulty(Block block){

        for(int i = 0; i < block.hash.length(); i++){

            if(!(block.hash.substring(i,i+1).equals("0"))){

                break;
            }

            return i >= this.difficulty;
        }

        return false;
    }
    
    public void accessBlock(String patientData) {
    	
    }
}