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
	        //��ȡ��Ŀ�����·��
	        String realPath = ServletActionContext.getServletContext()
	                .getRealPath("/static/notice");
	        //�����µ��ļ���
	        String newFileName = UUID.randomUUID().toString()+"."
	                +FilenameUtils.getExtension(picFileName);// ��ȡ�ļ��ĺ�׺�� aa.jpg --> jpg
	        try {
				FileUtils.copyFile(pic, new File(realPath + File.separator + newFileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        System.out.println("Path��ɶ:"+realPath+newFileName);
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
		//��ȡ��Ŀ����ָ���ı����ϴ��ļ����ļ���·��  
        String path = ServletActionContext.getServletContext().getRealPath("/upload");  
        System.out.println();
        System.out.println("Path��:"+path);
        //���ϴ��ļ�������  
        FileInputStream fis = new FileInputStream(file);  
        //��Ŀ���ļ��������  
        FileOutputStream fos = new FileOutputStream(new File(path,fileFileName));  
          
        //������ת���ֽڣ����������д���ļ�  
        byte[] b = new byte[1024];  
        int length = 0;  
        try {  
            while((length = fis.read(b))!=-1){  
                fos.write(b,0,b.length);   //д���ļ�  
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
