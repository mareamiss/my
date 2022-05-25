package com.myapp.chat;

public class Block {
    private int index;
    private String timestamp;
    private int vac;
    private String hash;
    private String prevHash;
    private int difficulty;
    private String nonce;

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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

}
