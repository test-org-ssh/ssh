package com.onetoone.ssh.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;

public class AdminUploadAction extends ActionSupport {
    Map<String,Object> returndata=new HashMap<String,Object>();
    public Map<String, Object> getReturndata() {
        return returndata;
    }

    public void setReturndata(Map<String, Object> returndata) {
        this.returndata = returndata;
    }
    private String message = "你已成功上传文件";
    private File file;
    private String fileFileName;
    private String fileFileContentType;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileFileContentType() {
        return fileFileContentType;
    }

    public void setFileFileContentType(String fileFileContentType) {
        this.fileFileContentType = fileFileContentType;
    }

    public String uploadUserPhoto() throws Exception {
	String path = ServletActionContext.getServletContext().getRealPath("/static/images");
	System.out.println(ServletActionContext.getServletContext().getRealPath("/"));
        try {
            File f = this.getFile();
            FileInputStream inputStream = new FileInputStream(f);
            FileOutputStream outputStream = new FileOutputStream(path + "/"+ System.currentTimeMillis()+"_"+this.getFileFileName());
            byte[] buf = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, length);
            }
            inputStream.close();
            outputStream.flush();

            String dburl = "static/images/"+ System.currentTimeMillis()+"_"+this.getFileFileName();
            returndata.put("msg","文件上传成功");
            returndata.put("url",dburl);
            returndata.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            message = "文件上传失败";
            returndata.put("msg",message);
            returndata.put("success", false);
        }

	return SUCCESS;
    }

}
