package com.myapp.chat;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
    private int index;
    private long timestamp;
    private int vac;
    private String hash;
    private String prevHash;
    private int difficulty;
    private String nonce;
   private String massegs;
    private String previousHash;
    private String creator;
    private static final long serialVersionUID = 1L;


    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public int getVac() {
        return vac;
    }
    public void setVac(int vac) {
        this.vac = vac;
    }
    public String getHash() {
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }
    public String getPrevHash() {
        return prevHash;
    }
    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }
    public int getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    public String getNonce() {
        return nonce;
    }
    public void setNonce(String nonce) {
        this.nonce = nonce;
    }
    public String getMassegs() {
        return massegs;
    }

    public void setMassegs(String massegs) {
        this.massegs = massegs;
    }
    public Block() {
    }

    @Override
    public String toString() {
        return "Block{" +
                "index=" + index +
                ", timestamp=" + timestamp +
                ", creator=" + creator +
//                ", hash='" + hash + '\'' +
//                ", previousHash='" + previousHash + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Block block = (Block) o;
        return index == block.index
                                && hash.equals(block.hash)
                && previousHash.equals(block.previousHash)
                && creator.equals(block.creator);
    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + hash.hashCode();
        result = 31 * result + previousHash.hashCode();
        result = 31 * result + creator.hashCode();
        return result;
    }

    public Block(int index, String preHash, String creator) {
        this.index = index;
        this.previousHash = preHash;
        this.creator = creator;
        timestamp = System.currentTimeMillis();
        hash = calculateHash(String.valueOf(index) + previousHash + String.valueOf(timestamp));
    }

    public String getCreator() {
        return creator;
    }


    public String getPreviousHash() {
        return previousHash;
    }

    private String calculateHash(String text) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            return "HASH_ERROR";
        }

        final byte bytes[] = digest.digest(text.getBytes());
        final StringBuilder hexString = new StringBuilder();
        for (final byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public int getTimestamp() {
        return 0;
    }

    public void setTimestamp(String format) {

    }
}

