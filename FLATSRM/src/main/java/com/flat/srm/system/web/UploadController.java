package com.flat.srm.system.web;

import com.flat.srm.common.core.BaseController;
import com.flat.srm.common.util.TmFileUtil;
import com.flat.srm.common.util.stringUtil;
import com.flat.srm.dictionary.bean.SupplierPicture;
import com.flat.srm.dictionary.service.supplierPicture.ISupplierPictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 

@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController {
	@Autowired
	private ISupplierPictureService supplierPictureService;

	private final static Logger logger = LoggerFactory.getLogger(UploadController.class);
	@ResponseBody
	@RequestMapping("/file")
	public Map<String,Object> fromUpload(@RequestParam("doc") MultipartFile mfile,
								  HttpServletRequest request) throws IllegalStateException,
			IOException {
		/**
		 *UploadController方法fromUpload的功能描述
		 * 供应商注册时图片信息的上传
		 * @paam [mfile, request, supplierPicture]
		 * @return java.util.Map<java.lang.String,java.lang.Object>
		 * @throws
		 * @sice v1.0
		 * @author jingu qq 274492196
		 * 2017/8/15
		*/
		Map<String, Object> re = new HashMap<String, Object>();
		if (!mfile.isEmpty()) {
			String uploadmulu = request.getParameter("uploadmulu");
			if (stringUtil.notEmpty(uploadmulu)) {
				String uid = request.getParameter("sid");
				String fileNmae = mfile.getOriginalFilename();
				String extNoPoint = TmFileUtil.getExtNoPoint(fileNmae);
				String url = "upfilte/" + uploadmulu+"/"+uid;
				long size = mfile.getSize();
				// 设置文件存放路劲
				//String path = request.getRealPath(url);
				String path=request.getSession().getServletContext().getRealPath(url);
				// 加载File类
				File parent = new File(path);
				// 判断目录是否存在
				if (!parent.exists()) {
					parent.mkdir();
				}
				HashMap<String, Object> map = new HashMap<String, Object>();
				// 获取文件名，不含后缀
				String name = fileNmae.substring(0, fileNmae.lastIndexOf("."));
				 // 获取文件的后缀
				Integer integer = fileNmae.lastIndexOf(".");
				String huozui = fileNmae.substring(integer);
				// 整合上传文件名
				String fname = TmFileUtil.getJoiningtogether(name,
						Integer.valueOf(uid), huozui);
				logger.info("上传文件名称:" + fname+"上传路径:" + url+"文件大小:" + TmFileUtil.countFileSize(size));
				map.put("supplierId", uid);
				map.put("name", fname);
				map.put("url", url);
				map.put("size", TmFileUtil.countFileSize(size));
				//查询是否有重复
				SupplierPicture supplierPicture=supplierPictureService.find(fname);
				if(supplierPicture!=null){
					re.put("err","上传失败！重复！");
				}else{
					// 开始上传
					mfile.transferTo(new File(parent, fname));
					// 返回json序列化
					re.put("records",map);
				}
			} else {
				re.put("err","上传失败！请选择目录");
			}
		} else {
			 re.put("err","接收的文件是null");
		}
		return re;
	}


}