import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;


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

        int currentIndex = this.getLatestBlock().index + 1;
        String previousHash = this.getLatestBlock().hash;
        long currentTimeStamp = new Date().getTime();
        int currentNonce = 0; //not sure about this

        String currentHashTemporary = "0";
        Block currentBlock = new Block(currentIndex, previousHash, currentTimeStamp, data, currentHashTemporary, currentNonce);
        String currentBlockHash = currentBlock.calculateBlockHash(currentBlock);
        currentBlock.hash = currentBlockHash;

        return currentBlock;
    }
    
    public Block accessData(String name, String password) {
    	for (Block block: blockchain) {
    		if (block.getData().getPassword().equals(password) && block.data.getName().equals(name)) {
    			System.out.println(block.getData());
    			return block;
    		}
    	}
    	
    	Scanner input = new Scanner(System.in);
    	
    	//error message printed if invalid credentials given 
    	System.out.println("Error: invalid name and/or hash given.");
    	
    	//checks if user wants to attempt to get data again
    	System.out.println("Try again? (Y or N)");
    	if ("Y".equals(input.next())) {
    		
    		//stores inputed name in String
        	System.out.println("Full name:");
        	String newName = input.next();
        	
        	// stores inputed hash into String
        	System.out.println("Password:");
        	String newPassword = input.next();
        	
        	//calls itself to find patient's data
        	return accessData(newName, newPassword);
    	}
    	
    	//if user does not want to try to get data again, returns null
    	else {
    		System.out.println("Thank you for using ____");
    		return null;
    	}
    }
}
