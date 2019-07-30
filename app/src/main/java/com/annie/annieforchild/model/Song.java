package com.annie.annieforchild.model;

import java.util.List;

public class Song {
    private String bookName;
    private String bookImageUrl;
    private int audioSource;
    private int audioType;
    private int count;
    private int bookId;
    private float lastScore;
    private float totalScore;
    private int totalPages;
    private int isCollected; //0：未收藏 1：已收藏
    private int isJoinMaterial; //0：未加入自选教材 1：已加入自选教材
    private int Jurisdiction;
    private List<String> bookResourceUrl;
    private String myResourceUrl;
    private String recordCount;
    private int isusenectar;
    private int nectar;
    private int iskouyu;
    private int ismoerduo;
    private int isyuedu;
    private String path;
    private boolean isPlaying = false;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImageUrl() {
        return bookImageUrl;
    }

    public void setBookImageUrl(String bookImageUrl) {
        this.bookImageUrl = bookImageUrl;
    }

    public int getAudioSource() {
        return audioSource;
    }

    public void setAudioSource(int audioSource) {
        this.audioSource = audioSource;
    }

    public int getAudioType() {
        return audioType;
    }

    public void setAudioType(int audioType) {
        this.audioType = audioType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public float getLastScore() {
        return lastScore;
    }

    public void setLastScore(float lastScore) {
        this.lastScore = lastScore;
    }

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getIsCollected() {
        return isCollected;
    }

    public void setIsCollected(int isCollected) {
        this.isCollected = isCollected;
    }

    public int getIsJoinMaterial() {
        return isJoinMaterial;
    }

    public void setIsJoinMaterial(int isJoinMaterial) {
        this.isJoinMaterial = isJoinMaterial;
    }

    public int getJurisdiction() {
        return Jurisdiction;
    }

    public void setJurisdiction(int jurisdiction) {
        Jurisdiction = jurisdiction;
    }

    public List<String> getBookResourceUrl() {
        return bookResourceUrl;
    }

    public void setBookResourceUrl(List<String> bookResourceUrl) {
        this.bookResourceUrl = bookResourceUrl;
    }

    public String getMyResourceUrl() {
        return myResourceUrl;
    }

    public void setMyResourceUrl(String myResourceUrl) {
        this.myResourceUrl = myResourceUrl;
    }

    public String getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(String recordCount) {
        this.recordCount = recordCount;
    }

    public int getIsusenectar() {
        return isusenectar;
    }

    public void setIsusenectar(int isusenectar) {
        this.isusenectar = isusenectar;
    }

    public int getNectar() {
        return nectar;
    }

    public void setNectar(int nectar) {
        this.nectar = nectar;
    }

    public int getIskouyu() {
        return iskouyu;
    }

    public void setIskouyu(int iskouyu) {
        this.iskouyu = iskouyu;
    }

    public int getIsmoerduo() {
        return ismoerduo;
    }

    public void setIsmoerduo(int ismoerduo) {
        this.ismoerduo = ismoerduo;
    }

    public int getIsyuedu() {
        return isyuedu;
    }

    public void setIsyuedu(int isyuedu) {
        this.isyuedu = isyuedu;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }
}
