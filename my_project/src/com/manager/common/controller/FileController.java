package com.manager.common.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.utils.JsonUtil;
import com.utils.Msg;

@Controller
@RequestMapping("/file")
public class FileController extends BaseController {

	private static Logger logger = Logger.getLogger(FileController.class);

	/**
	 * <p>Title: doAddUser</p>
	 * <p>Description:方法二上传文件，一次可以多张 </p>
	 * @param session
	 * @param request
	 * @param attachs
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void upload(HttpSession session, HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "attachs", required = false) MultipartFile[] attachs) {
		Msg msg=null;
		// 定义两个上传文件的路径
		String wkpicpath = null;
		String hdpicpath = null;
		String errorinfo = null;
		// 定义上传过程管理标记
		boolean flag = true;
		// 定义文件保存的位置
		String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
		// 循环读取文件信息
		for (int i = 0; i < attachs.length; i++) {
			MultipartFile attach = attachs[i];
			// 判断文件是否为空
			if (!attach.isEmpty()) {
				// 判断是第几个文件
				if (i == 0) {
					errorinfo = "uploadwkError";
				} else if (i == 1) {
					errorinfo = "uploadhdError";
				}
				// 获取源文件名
				String oldName = attach.getOriginalFilename();
				// 获取源文件名后缀
				String prefixName = FilenameUtils.getExtension(oldName);

				int fileSize = 500000;
				// 判断上传大小不得超过500K
				if (attach.getSize() > fileSize) {
					msg = new Msg(Msg.FAIL, "上传文件不得大于500k");
					flag = false;
				} else if (prefixName.equalsIgnoreCase("jpg") || prefixName.equalsIgnoreCase("png") || prefixName.equalsIgnoreCase("jpeg")
						|| prefixName.equalsIgnoreCase("pneg")) {
					// 判断上传格式
					// 定义新的文件名，当前系统时间+随机数+固定后缀，
					// RandomUtils需要引入jar文件commons-lang.jar
					// String fileName =
					// System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"personer.jpg";
					String fileName = System.currentTimeMillis() + "personer.jpg";
					// 创建新的文件，用于接收用户上传的文件流
					File targetFile = new File(path, fileName);
					if (!targetFile.exists()) {
						targetFile.mkdirs();
					}
					// 将上传的文件保存
					try {
						attach.transferTo(targetFile);
						msg = new Msg(Msg.SUCCESS, "上传成功");
					} catch (Exception e) {
						e.printStackTrace();
						msg = new Msg(Msg.FAIL, "上传失败");
						flag = false;
					}

					// 更新上传的路径
					if (i == 0) {
						wkpicpath = path + File.separator + fileName;
					} else if (i == 1) {
						hdpicpath = path + File.separator + fileName;
					}
				} else {
					msg = new Msg(Msg.FAIL, "图片格式不正确");
					flag = false;
				}
			}
		}
		logger.error("类-upload-返回-: " + JsonUtil.toJson(msg));
		this.send(response, msg);

	}
}
