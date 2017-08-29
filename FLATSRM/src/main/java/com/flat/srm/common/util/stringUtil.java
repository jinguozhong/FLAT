package com.flat.srm.common.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class stringUtil {
	/**
	 * 空判断
	 * */
	public static boolean isEmpty(String connt) {
		if (connt == null || connt.equals("")) {
			return true;
		} else {

			return false;
		}

	}

	/**
	 * 非空判断
	 * */
	public static boolean notEmpty(String connt) {
		return !isEmpty(connt);
	}

	/**
	 * md5加密工具
	 * */
	public static String base64Encode(byte[] b) {
		if (b == null) {
			return null;
		}
		return new BASE64Encoder().encode(b);
	}

	public static String md5Base64(String str) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			return base64Encode(md5.digest(str.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String formatDate(Date date, String pString) {

		if (notEmpty(pString) && date != null) {
			SimpleDateFormat sDateFormat = new SimpleDateFormat(pString);
			String sjString = sDateFormat.format(date);
			return sjString;
		} else {
			return "";
		}

	}

	/**
	 * 根据File文件的长度统计文件的大小
	 * 
	 * @param size
	 *            File的长度 file.lenght()
	 * @return 返回文件大小
	 */
	public static String countFileSize(long fileSize) {
		String fileSizeString = "";
		try {
			DecimalFormat df = new DecimalFormat("#.00");
			long fileS = fileSize;
			if (fileS == 0) {
				fileSizeString = "0KB";
			} else if (fileS < 1024) {
				fileSizeString = df.format((double) fileS) + "B";
			} else if (fileS < 1048576) {
				fileSizeString = df.format((double) fileS / 1024) + "KB";
			} else if (fileS < 1073741824) {
				fileSizeString = df
						.format(((double) fileS / 1024 / 1024) - 0.01) + "MB";
			} else {
				fileSizeString = df.format((double) fileS / 1024 / 1024 / 1024)
						+ "G";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileSizeString;
	}

	public static String conversionSpecialCharacters(String string) {
		return string.replaceAll("\\\\", "/");
	}

	public static void main(String[] args) {
		System.out.println(md5Base64("123456"));
		// SimpleDateFormat sDateFormat=new
		// SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// String sjString=sDateFormat.format(new Date());
		// System.out.println(formatDate(new Date(), "yyyy年MM月dd日 hh:mm:ss"));
		// System.out.println(countFileSize(1234522227));

	}

}
