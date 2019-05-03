package cwu.jsj.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cwu.jsj.model.Files;
import cwu.jsj.model.Price;
import cwu.jsj.model.User;
import cwu.jsj.service.PrintFileService;

@Controller
@RequestMapping("/printFile")
public class PrintFileController {
	@Resource
	private PrintFileService printFileService;
	@RequestMapping("/list.do")
	public String dolist(HttpSession session,HttpServletRequest request) {
		int userId = (int) session.getAttribute("userId");
		
		// 获取文件列表
		List<Files> files = printFileService.getFiles(userId);
		
		request.setAttribute("flist", files);
		
		return "user/user_PrintFile";
	}
	
	@RequestMapping("/createOrder")
	public String createOrder(HttpServletRequest request,HttpSession session,String fileIdstr,String fileName,String printCopiesstr,String urgentStatusstr,String printTypestr,String printRemark,String payAmountstr) throws ParseException{
		int urgentStatus;
		int printType;
		//查询用户余额
		int userId = (int) session.getAttribute("userId");
		User user = printFileService.getRemainSum(userId);
		double remainSum = user.getRemainSum();
		//打印总金额		
		double payAmount=Double.parseDouble(payAmountstr);
		if(payAmount>remainSum){
			String noRemainSum = "余额不足，请充值！";
			request.setAttribute("noRemainSum", noRemainSum);
			return "user/user_Pay";
		}
		
		//扣除打印费用
		double remainSum1 = remainSum-payAmount;
		int user2 = printFileService.updateRemainSum(userId,remainSum1);
		if(user2>0){
			//支付成功，创建订单
			//获取系统当前时间
			Date date = new Date();
			SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
			String createTimeStr=dateFormat.format(date);
			Date createTime = dateFormat.parse(createTimeStr);
			
			int fileId = Integer.parseInt(fileIdstr);
			if(urgentStatusstr.equals("是")){
				urgentStatus = 1;
			}else{
				urgentStatus = 0;
			}
			if(printTypestr.equals("黑白单面")){
				printType=1;
			}else if(printTypestr.equals("黑白双面")){
				printType=2;
			}else if(printTypestr.equals("彩色单面")){
				printType=3;
			}else{
				printType=4;
			}
			int printCopies = Integer.parseInt(printCopiesstr);
			//获取提交订单时系统时间（小时）
			Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
			int hour = c.get(Calendar.HOUR_OF_DAY);
			//查询文件URL
			Files file = printFileService.getRfilename(fileId);
			String url=file.getUploadUrl();
			int order = printFileService.createOrder(userId, createTime, fileName, urgentStatus, printType, printCopies, printRemark, hour,url,payAmount);
			return "forward:/myOrder/unfinished";
		}else{
			String payError = "支付失败，请重试！"; 
			request.setAttribute("payError", payError);
			return "user/user_Pay";
		}
		
	}
//创建订单信息	
	@RequestMapping("/pay")
	public String printFile(HttpServletRequest request,int fileId,String fileName,String printCopies,int urgentStatus,int printType,String printRemark){
		
		Map<String, String> Msg = new HashMap<String, String>();
		
		if(printCopies == null || printCopies.trim().length() == 0){
			String printCopiesNull="请输入打印份数";
			request.setAttribute("printCopiesNull", printCopiesNull);
			return "forward:/printFile/list.do";
		}
		Price price = printFileService.getPrintPrice(urgentStatus, printType);
		//打印每一页的单价
		double printPrice = price.getPayAmount();
		//文档页码
		int pageNum = 10;
		String pageNumstr = Integer.toString(pageNum);
		Msg.put("pageNum", pageNumstr);
		
		int printCop = Integer.parseInt(printCopies);
		//计算打印需支付的总金额
		double payAmount = pageNum*printPrice*printCop;
		
		String fileIdStr = Integer.toString(fileId);
		Msg.put("fileId", fileIdStr);

		Msg.put("fileName", fileName);
		Msg.put("printCopies", printCopies);
		
		if(urgentStatus==0){
			Msg.put("urgentStatus", "否");
		}
		if(urgentStatus==1){
			Msg.put("urgentStatus", "是");
		}
		if(printType==1){
			Msg.put("printType", "黑白单面");
		}
		if(printType==2){
			Msg.put("printType", "黑白双面");
		}
		if(printType==3){
			Msg.put("printType", "彩色单面");
		}
		if(printType==4){
			Msg.put("printType", "彩色双面");
		}
		if(printRemark == null || printRemark.trim().length() == 0){
			Msg.put("printRemark", "无");
		}else{
			Msg.put("printRemark", printRemark);
		}
		
		String payAmountStr = Double.toString(payAmount);
		Msg.put("payAmount", payAmountStr);
		
		request.setAttribute("Msg", Msg);
		return "user/user_Pay";
	}
	
	
//删除文件	
	@RequestMapping("/deleteFile")
	public String deleteFile(int fileId){
		Files files=printFileService.getRfilename(fileId);
		String rfilename=files.getRfileName();
		File file=new File("F:/1ZQ/SSMuploadFile",rfilename);
		//删除本地文件
		file.delete();
		//删除数据库记录
		printFileService.deleteFile(fileId);
		return "redirect:/printFile/list.do";
	}
//上传文件	
	@RequestMapping("/upload.do")
	public String doUpload(MultipartFile uploadFile,HttpSession session,HttpServletRequest request) throws Exception{
		
		// 上传
		String uploadMsg = "";
	
		if(uploadFile.getSize()>0){
			String filename = uploadFile.getOriginalFilename();
			
			if(filename.endsWith("doc")||filename.endsWith("pdf")||filename.endsWith("docx")){
				//获取文件后缀名
				String suffix = filename.substring(filename.lastIndexOf(".") + 1);

				int userId = (int) session.getAttribute("userId");
				String rfilename1=String.valueOf(userId);
				//获取系统当前时间
				Date date = new Date();
				SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
				String uploadTimeStr=dateFormat.format(date);
				Date uploadTime = dateFormat.parse(uploadTimeStr);
				//时间戳
				long timeStam = uploadTime.getTime();
				String rfilename2 = Long.toString(timeStam);
				//文件重命名：userId-系统当前时间戳.文件名后缀
				String rfilename =rfilename1+ "-"+rfilename2+"."+suffix;
				
				//存储
				String uploadPath = "F:/1ZQ/SSMuploadFile";
				File file = new File(uploadPath,rfilename);
				uploadFile.transferTo(file);
				uploadMsg = "上传成功";
				
				String uploadURL = uploadPath + "/" + rfilename;
				// 保存文件信息
				int files = printFileService.uploadFile(userId, filename, rfilename, uploadTime,uploadURL);	
		
			}else{
				uploadMsg = "暂不支持该种格式的文档";
			}
		}else{
			uploadMsg = "请选择文件后再上传";
		}
		
		// 设置值
		request.setAttribute("uploadMsg", uploadMsg);
		
		return "forward:/printFile/list.do";
	}
}
