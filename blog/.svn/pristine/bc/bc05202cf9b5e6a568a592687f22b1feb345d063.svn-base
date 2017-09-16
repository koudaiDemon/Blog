package com.softeem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.softeem.dao.BaseDAO;
import com.softeem.dao.HeadDAO;
import com.softeem.dto.Head;
import com.softeem.jspsmart.upload.File;
import com.softeem.jspsmart.upload.Files;
import com.softeem.jspsmart.upload.SmartUpload;


@WebServlet("/uploadImg")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private static final String BASE_DIR="d:/file";
    
    public ImageServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		switch(flag){
		case "user":
			handlerUserImg(request,response);
			break;
		case "notice":
			handlerNoticeImg(request,response);
			break;
		default:
			break;        
		}
	}


	private void handlerNoticeImg(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//创建一个smartupload对象
			SmartUpload su = new SmartUpload();
			//初始化smartupload(初始化servlet以及请求响应对象)
			su.initialize(this, request, response);
			//设置允许上传的文件
			su.setAllowedFilesList("png,jpg,jepg,bmp,gif");
			//设置不允许上传的文件
			su.setDeniedFilesList("exe,bat,dll");
			su.upload();
			
			/*获取上传文件信息*/
			Files files = su.getFiles();
			PrintWriter out = response.getWriter();
			for(int i = 0 ; i < files.getCount() ; i++)
			{
				File file = files.getFile(i);
				//只有当文件大小大于0的时候才保存
				if(file.getSize()>0){
					String fname = UUID.randomUUID()+"."+file.getFileExt();
					/*对每个文件进行重命名后*/
					file.saveAs(BASE_DIR+java.io.File.separator+fname);
					out.print(fname);
					out.flush();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
	}
		
	}


	private void handlerUserImg(HttpServletRequest request,
			HttpServletResponse response) {
		List<String> filenames = new ArrayList<>();
		try {
			//创建一个smartupload对象
			SmartUpload su = new SmartUpload();
			//初始化smartupload(初始化servlet以及请求响应对象)
			su.initialize(this, request, response);
			//设置允许上传的文件
			su.setAllowedFilesList("png,jpg,jepg,bmp,gif");
			//设置不允许上传的文件
			su.setDeniedFilesList("exe,bat,dll");
			su.upload();
			
			/*获取上传文件信息*/
			Files files = su.getFiles();
			HeadDAO dao = new HeadDAO();
			Head h = null;
			String json = "";
			PrintWriter out = response.getWriter();
			for(int i = 0 ; i < files.getCount() ; i++)
			{
				File file = files.getFile(i);
				//只有当文件大小大于0的时候才保存
				if(file.getSize()>0){
					String fname = UUID.randomUUID()+"."+file.getFileExt();
					/*对每个文件进行重命名后*/
					file.saveAs(BASE_DIR+java.io.File.separator+fname);
					filenames.add(fname);
					h = new Head();
					h.setPath(fname);
					int hid = dao.addAndReturn(h);
					h.setId(hid);
					json = JSON.toJSONString(h);
					out.print(json);
					out.flush();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
