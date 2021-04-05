package com.thenoiseteam.filedemo.payload;

public class UploadFileResponse {

    private String filename, filetype;
    private long size;

    public UploadFileResponse(String filename, String filetype, long size) {
        this.filename = filename;
        this.filetype = filetype;
        this.size = size;
    }

    public String getFilename() {
        return filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public long getSize() {
        return size;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
