/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registry.web.vo.fileUploader;

import java.io.InputStream;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author MAQIB
 */
@JsonIgnoreProperties({"content"})
public class FileMeta {

    private String fileName;
    private String fileSize;
    private String fileType;
    private String twitter;
    private InputStream content;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public InputStream getContent() {
        return content;
    }

    public void setContent(InputStream content) {
        this.content = content;
    }


}
