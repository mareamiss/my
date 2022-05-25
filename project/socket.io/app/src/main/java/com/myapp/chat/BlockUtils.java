package com.myapp.chat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BlockUtils {
    public static String calculateHash(Block block) {
        String record = (block.getIndex()) + block.getTimestamp() + (block.getVac()) + block.getPrevHash();

        return record;
    }


    public static Block generateBlock(Block oldBlock, int vac) {
        Block newBlock = new Block();
        newBlock.setIndex(oldBlock.getIndex() + 1);
        newBlock.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        newBlock.setVac(vac);
        newBlock.setPrevHash(oldBlock.getHash());
        newBlock.setHash(calculateHash(newBlock));
        return newBlock;
    }

    public static boolean isBlockValid(Block newBlock, Block oldBlock) {
        if (oldBlock.getIndex() + 1 != newBlock.getIndex()) {
            return false;
        }
        if (!oldBlock.getHash().equals(newBlock.getPrevHash())) {
            return false;
        }
        if (!calculateHash(newBlock).equals(newBlock.getHash())) {
            return false;
        }
        return true;
    }


    public List<Block> replaceChain(List<Block> oldBlocks, List<Block> newBlocks) {
        if (newBlocks.size() > oldBlocks.size()) {
            return newBlocks;
        }else{
            return oldBlocks;
        }
    }
}
