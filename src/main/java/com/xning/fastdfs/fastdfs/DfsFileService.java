package com.xning.fastdfs.fastdfs;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * 文件上传service
 */
@Service
public class DfsFileService {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(DfsFileService.class);

    public String saveFile(MultipartFile multipartFile) throws IOException {
        String[] fileAbsolutePath = {};
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] file_buff = null;
        InputStream inputStream = multipartFile.getInputStream();
        if (inputStream != null) {
            int len1 = inputStream.available();
            file_buff = new byte[len1];
            inputStream.read(file_buff);
        }
        inputStream.close();
        FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
        try {
            fileAbsolutePath = FastDFSClient.upload(file);  //upload to fastdfs
        } catch (Exception e) {
            logger.error("upload file Exception!", e);
        }
        if (fileAbsolutePath == null) {
            logger.error("upload file failed,please upload again!");
        }
        String path = "/" + fileAbsolutePath[0] + "/" + fileAbsolutePath[1];
        return path;
    }

    public boolean deleteFile(String path) {
        String groupName = "group" + path.charAt(6);
        try {
            int i = FastDFSClient.deleteFile(groupName, path);
            if (i > 0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
