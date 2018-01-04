package com.onetoone.ssh.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ImgAction extends ActionSupport{
	Map<String,Object> returndata=new HashMap<String,Object>();
	private File file;  
	private String fileFileName;  
	private String fileContentType;
	
	 private File pic;
	    private String picFileName;
	    private String picContentType;
	
	    public String test(){
	        //获取项目部署的路径
	        String realPath = ServletActionContext.getServletContext()
	                .getRealPath("/static/notice");
	        //生成新的文件名
	        String newFileName = UUID.randomUUID().toString()+"."
	                +FilenameUtils.getExtension(picFileName);// 获取文件的后缀名 aa.jpg --> jpg
	        try {
				FileUtils.copyFile(pic, new File(realPath + File.separator + newFileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        System.out.println("Path是啥:"+realPath+newFileName);
	        returndata.put("imgname",newFileName);  
			returndata.put("success", true);
			
	        return SUCCESS;
	    }
	
	public File getPic() {
			return pic;
		}

		public void setPic(File pic) {
			this.pic = pic;
		}

		public String getPicFileName() {
			return picFileName;
		}

		public void setPicFileName(String picFileName) {
			this.picFileName = picFileName;
		}

		public String getPicContentType() {
			return picContentType;
		}

		public void setPicContentType(String picContentType) {
			this.picContentType = picContentType;
		}

	public String test1() throws IllegalStateException, IOException, ServletException{
		//获取项目上中指定的保存上传文件的文件夹路径  
        String path = ServletActionContext.getServletContext().getRealPath("/upload");  
        System.out.println();
        System.out.println("Path是:"+path);
        //打开上传文件输入流  
        FileInputStream fis = new FileInputStream(file);  
        //打开目标文件夹输出流  
        FileOutputStream fos = new FileOutputStream(new File(path,fileFileName));  
          
        //输入流转成字节，并用输出流写入文件  
        byte[] b = new byte[1024];  
        int length = 0;  
        try {  
            while((length = fis.read(b))!=-1){  
                fos.write(b,0,b.length);   //写入文件  
            }  
            fis.close();  
            fos.close();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
  
          
        return SUCCESS;
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

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public Map<String, Object> getReturndata() {
		return returndata;
	}

	public void setReturndata(Map<String, Object> returndata) {
		this.returndata = returndata;
	}
	
	
}
