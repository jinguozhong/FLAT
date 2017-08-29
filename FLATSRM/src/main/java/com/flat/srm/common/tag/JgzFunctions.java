package com.flat.srm.common.tag;

import com.flat.srm.common.util.TmStringUtils;
import com.flat.srm.common.util.ip.TmIpUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class JgzFunctions {
	/**
	 * 
	 * 自定义标签：日期的格式化方法<br/>
	 * com.jgz.tld <br/>
	 * 方法名：formatDate<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016-2-17-下午8:53:17 <br/>
	 * 
	 * @param date
	 * @param geshi
	 * @return 返回类型String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public static String formatDate(Date date, String geshi) {
		return TmStringUtils.formatDate(date, geshi);

	}

	/**
	 * 
	 * 获取集合的长度<br/>
	 * com.jgz.tld <br/>
	 * 方法名：getLength<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016-2-17-下午8:57:08 <br/>
	 * 
	 * @param collection
	 * @return 返回类型int<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public static int getLength(Collection collection) {
		if (collection != null) {

			return collection.size();

		} else {
			return 0;
		}

	}

	/**
	 * 
	 * 时间格式转换"几天前"<br/>
	 * com.jgz.tld <br/>
	 * 方法名：getTimeFormat<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016-2-23-下午1:15:52 <br/>
	 * 
	 * @param startTime
	 * @return 返回类型String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public static String getTimeFormat(Date startTime) {
		try {
			long startTimeMills = startTime.getTime();
			long endTimeMills = System.currentTimeMillis();
			long diff = (endTimeMills - startTimeMills) / 1000;// 秒
			long day_diff = (long) Math.floor(diff / 86400);// 天
			StringBuffer buffer = new StringBuffer();
			if (day_diff < 0) {
				return "[error],时间越界...";
			} else {
				if (day_diff == 0 && diff < 60) {
					if (diff == 0)
						diff = 1;
					buffer.append(diff + "秒前");
				} else if (day_diff == 0 && diff < 120) {
					buffer.append("1 分钟前");
				} else if (day_diff == 0 && diff < 3600) {
					buffer.append(Math.round(Math.floor(diff / 60)) + "分钟前");
				} else if (day_diff == 0 && diff < 7200) {
					buffer.append("1小时前");
				} else if (day_diff == 0 && diff < 86400) {
					buffer.append(Math.round(Math.floor(diff / 3600)) + "小时前");
				} else if (day_diff == 1) {
					buffer.append("1天前");
				} else if (day_diff < 7) {
					buffer.append(day_diff + "天前");
				} else if (day_diff < 30) {
					buffer.append(Math.round(Math.ceil(day_diff / 7)) + " 星期前");
				} else if (day_diff >= 30 && day_diff <= 179) {
					buffer.append(Math.round(Math.ceil(day_diff / 30)) + "月前");
				} else if (day_diff >= 180 && day_diff < 365) {
					buffer.append("半年前");
				} else if (day_diff >= 365) {
					buffer.append(Math.round(Math.ceil(day_diff / 30 / 12))
							+ "年前");
				}
			}
			return buffer.toString();
		} catch (Exception ex) {
			return "";
		}
	}

	/**
	 * 
	 * 将数字转换为中文数字<br/>
	 * com.jgz.tld <br/>
	 * 方法名：getMany<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016-2-27-上午10:46:24 <br/>
	 * 
	 * @param many
	 * @return 返回类型String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public static String getMany(Double many) {
		jgzRMB t2r = new jgzRMB();
		String s = t2r.cleanZero(t2r.splitNum(t2r.roundString(String
				.valueOf(many))));
		return s;

	}

	/**
	 * 
	 * 获取12345...的数字来获取ABCD...<br/>
	 * com.jgz.tld <br/>
	 * 方法名：getCharacter<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016-2-27-上午10:59:46 <br/>
	 * 
	 * @param num
	 * @return 返回类型String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public static String getCharacter(int num) {
		return String.valueOf((char) (64 + num));

	}

	/**
	 * 
	 * 获取数字并且转换成中文 <br/>
	 * com.jgz.tld <br/>
	 * 方法名：chinesCharacter<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016-2-27-上午11:06:49 <br/>
	 * 
	 * @param num
	 * @return 返回类型String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public static String chinesCharacter(int num) {
		String resultNumber = null;
		if (num > 10000 || num < 0) {
			return "";
		}
		HashMap chnNumbers = new HashMap();
		chnNumbers.put(0, "零");
		chnNumbers.put(1, "一");
		chnNumbers.put(2, "二");
		chnNumbers.put(3, "三");
		chnNumbers.put(4, "四");
		chnNumbers.put(5, "五");
		chnNumbers.put(6, "六");
		chnNumbers.put(7, "七");
		chnNumbers.put(8, "八");
		chnNumbers.put(9, "九");

		HashMap unitMap = new HashMap();
		unitMap.put(1, "");
		unitMap.put(10, "十");
		unitMap.put(100, "百");
		unitMap.put(1000, "千");
		int[] unitArray = { 1000, 100, 10, 1 };

		StringBuilder result = new StringBuilder();
		int i = 0;
		while (num > 0) {
			int n1 = num / unitArray[i];
			if (n1 > 0) {
				result.append(chnNumbers.get(n1)).append(
						unitMap.get(unitArray[i]));
			}
			if (n1 == 0) {
				if (result.lastIndexOf("零") != result.length() - 1) {
					result.append("零");
				}
			}
			num = num % unitArray[i++];
			if (num == 0) {
				break;
			}
		}
		resultNumber = result.toString();
		if (resultNumber.startsWith("零")) {
			resultNumber = resultNumber.substring(1);
		}
		if (resultNumber.startsWith("一十")) {
			resultNumber = resultNumber.substring(1);
		}
		return resultNumber;
	}

	/**
	 * 
	 * 根据IP地址查询地址<br/>
	 * com.jgz.tld <br/>
	 * 方法名：getIP<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016-2-27-下午1:09:24 <br/>
	 * 
	 * @param request
	 * @return 返回类型String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public static String getIP(HttpServletRequest request) {

		return TmIpUtil.ipLocation(request);
	}

	public static void main(String[] args) {
		// System.out.println(formatDate(new Date(),"yyyy年MM月dd日 hh:mm:ss"));

		System.out.println(getTimeFormat(new Date()));
		// System.out.println(TmIpUtil.ipLocation("116.23.24.118"));

	}
}
