package com.pojo;

import java.io.Serializable;

public class Paper implements Serializable{
    private long paperId;
    private String paperName;
    private int paperNum;
    private String paperDetail;

    public Paper() {
    }

    public Paper(long paperId, String paperName, int paperNum, String paperDetail) {
        this.paperId = paperId;
        this.paperName = paperName;
        this.paperNum = paperNum;
        this.paperDetail = paperDetail;
    }

    public long getPaperId() {
        return paperId;
    }

    public void setPaperId(long paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public int getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(int paperNum) {
        this.paperNum = paperNum;
    }

    public String getPaperDetail() {
        return paperDetail;
    }

    public void setPaperDetail(String paperDetail) {
        this.paperDetail = paperDetail;
    }
}
