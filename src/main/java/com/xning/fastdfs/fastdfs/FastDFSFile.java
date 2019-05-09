package com.xning.fastdfs.fastdfs;

import lombok.Data;

/**
 * 封装FastDFSFile，文件基础信息包括文件名、内容、文件类型、作者等
 */
@Data
public class FastDFSFile {
    private String name;
    private byte[] content;
    private String ext;
    private String md5;
    private String author;

    public FastDFSFile(String name, byte[] content, String ext, String height,
                       String width, String author) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.author = author;
    }

    public FastDFSFile(String name, byte[] content, String ext) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;

    }
}
