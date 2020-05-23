
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Block implements Cloneable {

    int index;
    String previousHash;
    long timestamp;
    Data data; //change the type of this variable to suit what data we ask from the user
    String hash;
    int nonce;

    public Block(int index, String previousHash, long timeStamp, Data data,
                    String hash, int nonce){

            this.index = index;
            this. previousHash = previousHash;
            this.timestamp = timeStamp;
            this.data = data;
            this.hash = hash;
            this. nonce = nonce;
    }
    
    public Object clone() throws CloneNotSupportedException {
    	return (Block)super.clone();
    }
    
    public String toString(Block block){

        return ("Index: " + block.index + " \n Previous Hash: " + block.previousHash +  " \n TimeStamp: " + block.timestamp +
                " \n Data: " + block.data + " \n Hash: " + block.hash + " \n Nonce: " + block.nonce);
    }

    public String calculateBlockHash(Block block){

        String dataToHash = block.previousHash + block.timestamp + block.nonce + block.data;
        Logger logger = Logger.getLogger("name");
        MessageDigest digest = null;
        byte[] bytes = null;

        try {

            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));

        }catch(NoSuchAlgorithmException ex){

            logger.log(Level.SEVERE, ex.getMessage());
        }

        StringBuffer buffer = new StringBuffer();

        for(byte b: bytes){

            buffer.append(String.format("%2x", b));
        }

        return buffer.toString();
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

    protected Data getData(){

        return this.data;
    }

    public String getHash(){

        return this.hash;
    }

    public int getNonce(){

        return this.nonce;
    }

    //to do 
    public void setData(Data data) {

        
    }
}