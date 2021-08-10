package com.example.miwokapp;

public class Word {

    private String mMivokTranslation;
    private String mdefaultTranslation;
    private int mImageresourceId =  NO_IMAGE_PROVIDER;
    private static final int NO_IMAGE_PROVIDER = -1;
    private int  mMediaResourceId;

    public int getmMediaResourceId() {
        return mMediaResourceId;
    }

    public String getMivokTranslation() {
        return mMivokTranslation;
    }

//    public void setMivokTranslation(String mivokTranslation) {
//        this.mMivokTranslation = mivokTranslation;
//    }

    public String getDefaultTranslation() {
        return mdefaultTranslation;
    }

//    public void setDefaultTranslation(String defaultTranslation) {
//        this.mdefaultTranslation = defaultTranslation;
//    }

    public int getImage(){
        return mImageresourceId;
    }

    public Word(String mMivokTranslation, String mdefaultTranslation,int image,int MediaResourceId) {
        this.mMivokTranslation = mMivokTranslation;
        this. mdefaultTranslation = mdefaultTranslation;
        this.mImageresourceId = image;
        this.mMediaResourceId = MediaResourceId;

    }
    public Word(String mMivokTranslation, String mdefaultTranslation,int MediaResourceId) {
        this.mMivokTranslation = mMivokTranslation;
        this. mdefaultTranslation = mdefaultTranslation;
        this.mMediaResourceId = MediaResourceId;

    }
    public boolean hasImage(){
        return mImageresourceId!=NO_IMAGE_PROVIDER;
    }
}
