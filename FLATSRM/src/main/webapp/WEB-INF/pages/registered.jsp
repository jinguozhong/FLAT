<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%
String path = request.getContextPath();
Integer port= request.getServerPort();
String basePath=null;
if(port==80){
	basePath = request.getScheme()+"://"+request.getServerName()+path;

}else{
	basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
}
request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>FLAT 供应平台  </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman"> 
    <!-- The fav icon -->
    <link rel="shortcut icon" href="${basePath}/resources/img/FGG.ico">
    <!-- CSS -->
    <link rel="stylesheet" href="${basePath}/resources/css/jqueryUI/jquery-ui.css">
	<link rel="stylesheet" href="${basePath}/resources/js/Validform/css/demo.css" />
	<link rel="stylesheet" href="${basePath}/resources/sg/css/sg.css" >
	<link rel="stylesheet" href="${basePath}/resources/css/login/style.css">
	<link rel="stylesheet" href="${basePath}/resources/assets/css/dropzone.min.css">
 	 <style type="text/css">
 		 .input_radio{
 		     width: 21px;
  			 height: 16px;
 		 }
 		 .nextBott{
	        color: #2283C5;
		    background-color: #dbdeea;
		    margin: 0 -1px 0 0;
		    position: relative;
		    display: inline-block;
		    padding: 5px 14px;
		    border: 1px solid #ddd;
 		 }
 		 a {
 		     text-decoration: none;
 		   }
 		   
 		 .formWidth{
 		 	width: 587px;
 		 }
 	 	textarea{
 	 		    overflow: hidden;
			    word-wrap: break-word;
			    resize: horizontal;
			    height: 150px;
			    box-shadow: none!important; 
			    background-color: #FFF;
			    border: 1px solid #D5D5D5;
			    width: 454px;
 	 	}
 	 </style>

</head> 
<body oncontextmenu="return false" style="background: url(${basePath}/resources/img/flat2.jpg) no-repeat fixed top; background-size: cover;	font-weight: bold"> 
        <div class="page-container" style="background:rgba(194, 221, 245, 0.53)">
            <h1>合作商注册</h1> 
            <p id='err' style="color: red;"></p>
            <div  id="company" class ="formWidth" style="margin: 15px auto 0 auto;">
            	<p >企业信息</p> 
            	<div  class ="formWidth" style="border-bottom: 1px dotted #171616;margin: 15px auto 0 auto;"></div>
	            <form id ="submitLogin" class ="formWidth">
				 	<table>
				 		<tbody>
				 			<tr>
				 				<td>公司类型:</td>
				 				<td>
				 					<input name="type" type="radio" value="生产厂商 " class="input_radio" datatype="*1-3" nullmsg="请输入公司类型"/>生产厂商 </label>
					 				<input name="type" type="radio" value="贸易商" class="input_radio" datatype="*1-3" nullmsg="请输入公司类型"/>贸易商 </label>
					 				<input name="type" type="radio" value="物流商" class="input_radio" datatype="*1-3" nullmsg="请输入公司类型"/>物流商</label>
				 				</td>
				 			</tr>
				 			 <tr>
								 <td>公司名称:</td>
				 			 	<td>
									<input type="text" placeholder="公司名称"  id="companyName" name="company" datatype="*1-30"  nullmsg="请输入公司名称" maxlength="30">
								</td>
				 			 </tr>
				 			 <tr>
				 			 	<td>企业性质:</td>
				 			 	<td>
				 			 		<select  name="nature" datatype="*1-30"  nullmsg="请输入企业性质">
				 			 		 	<option value="" selected="" title="-选择-">-选择-</option>
				 			 		 	<option value="国有企业">国有企业</option>
										<option value="股份有限公司">股份有限公司</option>
										<option value="私营企业">私营企业</option>
										<option value="外商投资企业">外商投资企业</option>
										<option value="集体企业">集体企业</option>
										<option value="中外合资企业">中外合资企业</option>
										<option value="有限责任公司">有限责任公司</option>
				 			 		</select> 	
				 			 	</td>  
				 			 </tr>
				 			 <tr>
				 			 	<td>所属行业:</td>
				 			 	<td>
				 			 		<select  name="industry" datatype="*1-30"  nullmsg="请输入所属行业">
				 			 		 	<option value="" selected="" title="-选择-">-选择-</option> 
				 			 		 	<option value="IT行业">IT行业</option>
										<option value="纸业">纸业</option>
										<option value="包装业">包装业</option>
										<option value="办公、文教类">办公、文教类</option>
										<option value="数码、电脑类">数码、电脑类</option>
										<option value="电工电气业">电工电气业</option>
										<option value="机械及行业设备类">机械及行业设备类</option>
										<option value="五金、工具类">五金、工具类</option>
										<option value="化工类">化工类</option>
										<option value="精细化工类">精细化工类</option>
										<option value="橡塑类">橡塑类</option>
										<option value="环保类">环保类</option>
										<option value="仪器、议标类">仪器、议标类</option>
										<option value="建筑、建材类">建筑、建材类</option>
										<option value="交通运输类">交通运输类</option>
										<option value="礼品、工艺品、饰品类">礼品、工艺品、饰品类</option>
										<option value="能源类">能源类</option>
										<option value="农业类">农业类</option>
										<option value="加工类">加工类</option>
										<option value="代理类">代理类</option>
										<option value="综合性公司类">综合性公司类</option>
				 			 		</select> 	
				 			 	</td>  
				 			 </tr>
				 			  <tr>
				 			 	<td>开户银行:</td>
				 			 	<td><input type="text" placeholder="开户银行"  name="bank" datatype="*1-30"  nullmsg="请输入开户银行"></td>
				 			 </tr>
				 			  <tr>
				 			 	<td>银行账号:</td>
				 			 	<td><input type="text" placeholder="银行账号"  name="bankAccount" datatype="*1-30"  nullmsg="请输入银行账号"></td>
				 			 </tr>
				 			 <tr>
				 			 	<td>法人:</td>
				 			 	<td><input type="text" placeholder="法人"  name="legalPerson" datatype="*1-10"  nullmsg="请输入法人"></td>
				 			 </tr>
				 			  <tr>
				 			 	<td>法人联系电话:</td>
				 			 	<td><input type="text" placeholder="法人联系电话"  name="legalPersonPhone" datatype="*1-30"  nullmsg="请输入法人联系电话"></td>
				 			 </tr> 
				 			 <tr>
				 			 	<td>国家:</td>
				 			 	<td>
									<select  name="countries" datatype="*1-30"  nullmsg="请输入国家">
										<option value="" title="-选择-">-选择-</option>
										<option value="安道尔">安道尔</option>
										<option value="阿联酋">阿联酋</option>
										<option value="阿富汗">阿富汗</option>
										<option value="安提瓜和巴布达">安提瓜和巴布达</option>
										<option value="安圭拉岛">安圭拉岛</option>
										<option value="阿尔巴尼亚">阿尔巴尼亚</option>
										<option value="亚美尼亚">亚美尼亚</option>
										<option value="荷属安的列斯岛">荷属安的列斯岛</option>
										<option value="安哥拉">安哥拉</option>
										<option value="南极洲">南极洲</option>
										<option value="阿根廷">阿根廷</option>
										<option value="萨摩亚, 美国">萨摩亚, 美国</option>
										<option value="奥地利">奥地利</option>
										<option value="澳大利亚">澳大利亚</option>
										<option value="阿鲁巴">阿鲁巴</option>
										<option value="阿塞拜疆">阿塞拜疆</option>
										<option value="波黑">波黑</option>
										<option value="巴巴多斯">巴巴多斯</option>
										<option value="孟加拉国">孟加拉国</option>
										<option value="比利时">比利时</option>
										<option value="布基纳法索">布基纳法索</option>
										<option value="保加利亚">保加利亚</option>
										<option value="巴林">巴林</option>
										<option value="布隆迪">布隆迪</option>
										<option value="贝宁">贝宁</option>
										<option value="百慕大群岛">百慕大群岛</option>
										<option value="文莱达鲁萨兰">文莱达鲁萨兰</option>
										<option value="玻利维亚">玻利维亚</option>
										<option value="巴西">巴西</option>
										<option value="巴哈马(群岛)">巴哈马(群岛)</option>
										<option value="不丹">不丹</option>
										<option value="布维群岛">布维群岛</option>
										<option value="博茨瓦纳">博茨瓦纳</option>
										<option value="白俄罗斯">白俄罗斯</option>
										<option value="伯利兹">伯利兹</option>
										<option value="加拿大">加拿大</option>
										<option value="库科纳群岛">库科纳群岛</option>
										<option value="刚果民主共和国">刚果民主共和国</option>
										<option value="CAR">CAR</option>
										<option value="刚果">刚果</option>
										<option value="瑞士">瑞士</option>
										<option value="象牙海岸">象牙海岸</option>
										<option value="科克群岛">科克群岛</option>
										<option value="智利">智利</option>
										<option value="喀麦隆">喀麦隆</option>
										<option selected="selected" value="中国">中国</option>
										<option value="哥伦比亚">哥伦比亚</option>
										<option value="哥斯答黎加">哥斯答黎加</option>
										<option value="塞尔维亚/Monten">塞尔维亚/Monten</option>
										<option value="古巴">古巴</option>
										<option value="佛得角群岛">佛得角群岛</option>
										<option value="圣诞岛">圣诞岛</option>
										<option value="塞浦路斯">塞浦路斯</option>
										<option value="捷克共和国">捷克共和国</option>
										<option value="德国">德国</option>
										<option value="吉布提">吉布提</option>
										<option value="丹麦">丹麦</option>
										<option value="多米尼加">多米尼加</option>
										<option value="多米尼加共和国">多米尼加共和国</option>
										<option value="阿尔及利亚">阿尔及利亚</option>
										<option value="厄瓜多尔">厄瓜多尔</option>
										<option value="爱沙尼亚">爱沙尼亚</option>
										<option value="埃及">埃及</option>
										<option value="撒哈拉西部">撒哈拉西部</option>
										<option value="埃立特里亚">埃立特里亚</option>
										<option value="西班牙">西班牙</option>
										<option value="埃塞俄比亚">埃塞俄比亚</option>
										<option value="芬兰">芬兰</option>
										<option value="斐济">斐济</option>
										<option value="福克兰群岛">福克兰群岛</option>
										<option value="密克罗尼西亚">密克罗尼西亚</option>
										<option value="法罗群岛">法罗群岛</option>
										<option value="法国">法国</option>
										<option value="加蓬">加蓬</option>
										<option value="英国">英国</option>
										<option value="格林纳达">格林纳达</option>
										<option value="乔治亚">乔治亚</option>
										<option value="法属圭亚那">法属圭亚那</option>
										<option value="加纳">加纳</option>
										<option value="直布罗陀">直布罗陀</option>
										<option value="格陵兰岛">格陵兰岛</option>
										<option value="冈比亚">冈比亚</option>
										<option value="几内亚">几内亚</option>
										<option value="瓜达洛普">瓜达洛普</option>
										<option value="赤道几内亚">赤道几内亚</option>
										<option value="希腊">希腊</option>
										<option value="南三维治岛">南三维治岛</option>
										<option value="危地马拉">危地马拉</option>
										<option value="关岛">关岛</option>
										<option value="几内亚比绍">几内亚比绍</option>
										<option value="圭亚那">圭亚那</option>
										<option value="中国香港">中国香港</option>
										<option value="荷德/马克多纳岛">荷德/马克多纳岛</option>
										<option value="洪都拉斯">洪都拉斯</option>
										<option value="克罗地亚">克罗地亚</option>
										<option value="海地">海地</option>
										<option value="匈牙利">匈牙利</option>
										<option value="印度尼西亚">印度尼西亚</option>
										<option value="爱尔兰">爱尔兰</option>
										<option value="以色列">以色列</option>
										<option value="印度">印度</option>
										<option value="英属印度洋区">英属印度洋区</option>
										<option value="伊拉克">伊拉克</option>
										<option value="伊朗">伊朗</option>
										<option value="冰岛">冰岛</option>
										<option value="意大利">意大利</option>
										<option value="牙买加">牙买加</option>
										<option value="约旦">约旦</option>
										<option value="日本">日本</option>
										<option value="肯尼亚">肯尼亚</option>
										<option value="吉尔吉斯斯坦">吉尔吉斯斯坦</option>
										<option value="柬埔寨">柬埔寨</option>
										<option value="基里巴斯">基里巴斯</option>
										<option value="科摩罗群岛">科摩罗群岛</option>
										<option value="圣基茨和那维斯">圣基茨和那维斯</option>
										<option value="北朝鲜">北朝鲜</option>
										<option value="韩国">韩国</option>
										<option value="科威特">科威特</option>
										<option value="开曼群岛">开曼群岛</option>
										<option value="哈萨克斯坦">哈萨克斯坦</option>
										<option value="老挝">老挝</option>
										<option value="黎巴嫩">黎巴嫩</option>
										<option value="圣路西亚">圣路西亚</option>
										<option value="列支敦士登">列支敦士登</option>
										<option value="斯里兰卡">斯里兰卡</option>
										<option value="利比里亚">利比里亚</option>
										<option value="莱索托">莱索托</option>
										<option value="立陶宛">立陶宛</option>
										<option value="卢森堡">卢森堡</option>
										<option value="拉脱维亚">拉脱维亚</option>
										<option value="利比亚">利比亚</option>
										<option value="摩洛哥">摩洛哥</option>
										<option value="摩纳哥">摩纳哥</option>
										<option value="摩尔多瓦">摩尔多瓦</option>
										<option value="马达加斯加">马达加斯加</option>
										<option value="马绍尔群岛">马绍尔群岛</option>
										<option value="马其顿">马其顿</option>
										<option value="马里">马里</option>
										<option value="缅甸">缅甸</option>
										<option value="蒙古">蒙古</option>
										<option value="中国澳门">中国澳门</option>
										<option value="北马里亚纳">北马里亚纳</option>
										<option value="马提尼克">马提尼克</option>
										<option value="毛里塔尼亚">毛里塔尼亚</option>
										<option value="蒙塞拉特岛">蒙塞拉特岛</option>
										<option value="马耳他">马耳他</option>
										<option value="毛里求斯">毛里求斯</option>
										<option value="马尔代夫">马尔代夫</option>
										<option value="马拉维">马拉维</option>
										<option value="墨西哥">墨西哥</option>
										<option value="马来西亚">马来西亚</option>
										<option value="莫桑比克">莫桑比克</option>
										<option value="纳米比亚">纳米比亚</option>
										<option value="新喀里多尼亚">新喀里多尼亚</option>
										<option value="尼日尔">尼日尔</option>
										<option value="诺福克岛">诺福克岛</option>
										<option value="尼日利亚">尼日利亚</option>
										<option value="尼加拉瓜">尼加拉瓜</option>
										<option value="荷 兰">荷 兰</option>
										<option value="挪威">挪威</option>
										<option value="尼泊尔">尼泊尔</option>
										<option value="瑙鲁">瑙鲁</option>
										<option value="纽埃群岛">纽埃群岛</option>
										<option value="新西兰">新西兰</option>
										<option value="阿曼">阿曼</option>
										<option value="巴拿马">巴拿马</option>
										<option value="秘鲁">秘鲁</option>
										<option value="法属波利尼西亚">法属波利尼西亚</option>
										<option value="巴布亚新几内亚">巴布亚新几内亚</option>
										<option value="菲律宾">菲律宾</option>
										<option value="波兰">波兰</option>
										<option value="St.Pier,Miquel.">St.Pier,Miquel.</option>
										<option value="波多黎哥">波多黎哥</option>
										<option value="巴基斯坦">巴基斯坦</option>
										<option value="巴基斯坦">巴基斯坦</option>
										<option value="葡萄牙">葡萄牙</option>
										<option value="帕劳">帕劳</option>
										<option value="巴拉圭">巴拉圭</option>
										<option value="卡塔尔">卡塔尔</option>
										<option value="统一">统一</option>
										<option value="罗马尼亚">罗马尼亚</option>
										<option value="俄罗斯联邦">俄罗斯联邦</option>
										<option value="卢旺达">卢旺达</option>
										<option value="沙特阿拉伯">沙特阿拉伯</option>
										<option value="所罗门群岛">所罗门群岛</option>
										<option value="塞舌尔群岛">塞舌尔群岛</option>
										<option value="苏丹">苏丹</option>
										<option value="瑞典">瑞典</option>
										<option value="新加坡">新加坡</option>
										<option value="圣赫勒拿岛">圣赫勒拿岛</option>
										<option value="斯洛文尼亚">斯洛文尼亚</option>
										<option value="皮特肯岛">皮特肯岛</option>
										<option value="皮特肯岛">皮特肯岛</option>
										<option value="斯洛伐克">斯洛伐克</option>
										<option value="塞拉利昂">塞拉利昂</option>
										<option value="圣马力诺">圣马力诺</option>
										<option value="塞内加尔">塞内加尔</option>
										<option value="索马里">索马里</option>
										<option value="苏里南">苏里南</option>
										<option value="圣多美和普林西比">圣多美和普林西比</option>
										<option value="萨尔瓦多">萨尔瓦多</option>
										<option value="叙利亚">叙利亚</option>
										<option value="斯威士兰">斯威士兰</option>
										<option value="特克斯/凯科斯岛">特克斯/凯科斯岛</option>
										<option value="乍得">乍得</option>
										<option value="法属圣特里特">法属圣特里特</option>
										<option value="多哥">多哥</option>
										<option value="泰国">泰国</option>
										<option value="塔吉克斯坦">塔吉克斯坦</option>
										<option value="托客劳群岛">托客劳群岛</option>
										<option value="土库曼斯坦">土库曼斯坦</option>
										<option value="突尼斯">突尼斯</option>
										<option value="汤加">汤加</option>
										<option value="东帝汶岛">东帝汶岛</option>
										<option value="东帝汶岛">东帝汶岛</option>
										<option value="土耳其">土耳其</option>
										<option value="特立尼达/多巴哥">特立尼达/多巴哥</option>
										<option value="图瓦卢">图瓦卢</option>
										<option value="台湾">台湾</option>
										<option value="坦桑尼亚">坦桑尼亚</option>
										<option value="乌克兰">乌克兰</option>
										<option value="乌干达">乌干达</option>
										<option value="小奥特兰群岛">小奥特兰群岛</option>
										<option value="美国">美国</option>
										<option value="乌拉圭">乌拉圭</option>
										<option value="乌兹别克斯坦">乌兹别克斯坦</option>
										<option value="梵蒂冈城">梵蒂冈城</option>
										<option value="圣文森特">圣文森特</option>
										<option value="委内瑞拉">委内瑞拉</option>
										<option value="英属维尔京群岛">英属维尔京群岛</option>
										<option value="美属维尔京群岛">美属维尔京群岛</option>
										<option value="越南">越南</option>
										<option value="瓦努阿图">瓦努阿图</option>
										<option value="瓦利斯/富图纳岛">瓦利斯/富图纳岛</option>
										<option value="萨摩亚">萨摩亚</option>
										<option value="也门">也门</option>
										<option value="马约特岛">马约特岛</option>
										<option value="塞尔维亚及门的">塞尔维亚及门的</option>
										<option value="南非">南非</option>
										<option value="赞比亚">赞比亚</option>
										<option value="津巴布韦">津巴布韦</option>
									</select>
				 			 	</td>
				 			 </tr>
				 			 <tr>
				 			 	<td>省/自治区/直辖市:</td>
				 			 	<td>
				 			 		<select  name="province" datatype="*1-30"  nullmsg="请输入省/自治区/直辖市">
				 			 		 	<option value="" selected="" title="-选择-">-选择-</option>
				 			 		 	<option value="安徽" title="安徽">安徽</option>
				 			 		 	<option value="北京" title="北京">北京</option>
				 			 		 	<option value="重庆" title="重庆">重庆</option>
				 			 		 	<option value="福建" title="福建">福建</option>
				 			 		 	<option value="甘肃" title="甘肃">甘肃</option>
				 			 		 	<option value="广东" title="广东">广东</option>
				 			 		 	<option value="广西" title="广西">广西</option>
				 			 		 	<option value="贵州" title="贵州">贵州</option>
				 			 		 	<option value="海南" title="海南">海南</option>
				 			 		 	<option value="河北" title="河北">河北</option>
				 			 		 	<option value="黑龙江" title="黑龙江">黑龙江</option>
				 			 		 	<option value="河南" title="河南">河南</option>
				 			 		 	<option value="湖北" title="湖北">湖北</option>
				 			 		 	<option value="湖南" title="湖南">湖南</option>
				 			 		 	<option value="内蒙古" title="内蒙古">内蒙古</option>
				 			 		 	<option value="江苏" title="江苏">江苏</option>
				 			 		 	<option value="江西" title="江西">江西</option>
				 			 		 	<option value="吉林" title="吉林">吉林</option>
				 			 		 	<option value="辽宁" title="辽宁">辽宁</option>
				 			 		 	<option value="宁夏" title="宁夏">宁夏</option>
				 			 		 	<option value="青海" title="青海">青海</option>
				 			 		 	<option value="陕西" title="陕西">陕西</option>
				 			 		 	<option value="山东" title="山东">山东</option>
				 			 		 	<option value="上海"  title="上海">上海</option>
				 			 		 	<option value="山西" title="山西">山西</option>
				 			 		 	<option value="四川" title="四川">四川</option>
				 			 		 	<option value="天津" title="天津">天津</option>
				 			 		 	<option value="西藏" title="西藏">西藏</option>
				 			 		 	<option value="新疆" title="新疆">新疆</option>
				 			 		 	<option value="云南" title="云南">云南</option>
				 			 		 	<option value="浙江" title="浙江">浙江</option>
				 			 		</select>
				 			 	</td>
				 			 </tr>
				 			 <tr>
				 			 	<td>地址:</td>
				 			 	<td><input type="text" placeholder="地址"  name="address" datatype="*1-40"  nullmsg="请输入地址"></td>
				 			 </tr>
				 			 <tr>
				 				<td>邮 件:</td>
				 				<td><input type="email" placeholder="邮件"  name="mail" datatype="e"  nullmsg="请输入邮箱"  errormsg ="邮箱的格式不对"></td>
				 			</tr>
				 			<tr>
				 				<td>用 户 名 称:</td>
				 				<td><input type="text" placeholder="用户名称"  name="userName" datatype="*1-30"  nullmsg="请输入用户名"></td>
				 			</tr> 
				 			<tr>
				 				<td>部 门:</td>
				 				<td><input type="text" placeholder="部门"  name="department" datatype="*1-30"  nullmsg="请输入部门"></td>
				 			</tr>
				 			<tr>
				 				<td>职 务:</td>
				 				<td><input type="text" placeholder="职务"  name="position" datatype="*1-30"  nullmsg="请输入职务"></td>
				 			</tr>
				 			<tr>
				 				<td>手 机 号 码:</td>
				 				<td><input type="text" placeholder="手机号码"  name="phone" datatype="*1-30"  nullmsg="请输入手机号码"></td>
				 			</tr>
				 			<tr>
				 				<td>企业生产执行标准情况:</td>
				 				<td>
				 					<textarea id="production" name="production" datatype="*1-255"  nullmsg="请输入企业生产执行标准情况"></textarea>
								</td>
				 			</tr>
				 			<tr>
				 				<td>质量保证情况:</td>
				 				<td>
				 					<textarea id="quality" name="quality" datatype="*1-255"  nullmsg="请输入质量保证情况"></textarea>
								</td>
				 			</tr>  
				 		</tbody>
				 	</table>
	            </form>  
	            <div >
            		<a href="javascript:void(this)" class="nextBott"  id="next" onclick="next(this)">Next →</a>
            	</div>
            </div>  
            <div  id="certificate" hidden="hidden" class ="formWidth" style=" margin: 15px auto 0 auto;"> 
            	<p>证件信息</p>
				<p>
					点击下面空白处，请将企业的营业执照（如果没有三证合一的企业需要提供工商营业执照、组织机构代码证、税务登记证）、企业资质证书等信息通过图片的方式上传。
				</p>
				<div>
					<div  class="dropzone well dz-clickable" id="dropzone">
						<div class="dz-default dz-message">
							<span>
								<span class="bigger-150 bolder">
									<i class="ace-icon fa fa-caret-right red"></i>
								</span>
								<span class="smaller-80 grey">点击空白处</span>
								<i class="upload-icon ace-icon fa fa-cloud-upload blue fa-3x"></i>
							</span>
						</div>
					</div>
				</div>
				<div >
            		<a href="javascript:void(this)" class="nextBott" onclick="nextBott(this)">Next →</a>
            	</div>
            </div>
           
        </div>  
		
        <!-- Javascript -->
		<script type="text/javascript" src="${basePath}/resources/js/jquery/jquery-2.1.4.min.js" ></script>  
     	<script type="text/javascript" src="${basePath}/resources/sg/sgutil.js"></script>
        <script type="text/javascript" src="${basePath}/resources/sg/sg.js"></script>
        <script type="text/javascript" src="${basePath}/resources/js/Validform/js/Validform_v5.3.2_min.js"></script>
		<script type="text/javascript" src="${basePath}/resources/sg/sg.js"></script>
        <script type="text/javascript" src="${basePath}/resources/js/srm/registered.js"></script>
		<script type="text/javascript" src="${basePath}/resources/assets/js/dropzone.js"></script>
		<script type="text/javascript">var basePath="${basePath}"; </script>
		<script type="text/javascript"> 
			$(function(){ 
				registere.validation($("#err"));

                Dropzone.autoDiscover = false;
                $("#dropzone").dropzone({
                    url: basePath+"/upload/file",
                    paramName: "doc",
                    maxFiles: 10,
                    maxFilesize: 1,
                    acceptedFiles: ".jpg,.gif,.png",
					//headers:{"uploadmulu":"gongys","sid":"2"},
                   // addRemoveLinks: true,
                    //删除按钮样子
                    dictRemoveLinks: "x",
                    //取消上传样式
                    dictCancelUpload: "x",
                    dictMaxFilesExceeded: "您最多只能上传10个文件！",
                    dictResponseError: '文件上传失败!',
                    dictInvalidFileType: "你不能上传该类型文件,文件类型只能是*.jpg,*.gif,*.png。",
                    dictFallbackMessage:"浏览器不受支持",
                    dictFileTooBig:"文件过大上传文件最大支持.",
					sending:function(file,xhr,formData){
                        var sid=$("#submitLogin").data("id");
						formData.append("uploadmulu","gongys");
                        formData.append("sid",sid);
					},
                    init: function() {
                        this.on("complete",function (data) {
                            console.log(data);
                            var re=eval('(' + data.xhr.responseText + ')');
                            if(re.err!=null && re.err!='') {
                                data.previewTemplate.appendChild(document.createTextNode(re.err));
                            }else if(re.records!=null && re.records!=''){
                                data.previewTemplate.appendChild(document.createTextNode("上传成功！"));
                                var supplierName=$("#companyName").val();
                                re.records.supplierName=supplierName;
								console.log(re.records);
                                registere.save(re.records);
							}

                        });
                    }
                })
			});
			
			function next(obj){ 
				/*$(obj).removeAttr("onclick");
                $("#submitLogin").submit();*/
                $("#company").slideUp("slow",function(){
                    $("#certificate").slideDown();
                });
            };

			function nextBott(obj){
                //提示框
                $.tzDialog({
                    title:"友情提示",
                    width: "400",
                    height:"300",
                    cancelText:"取消",
                    sureText:"确定提交",
                    content:"您的信息将会被认证，审核通过后将有邮件的方式通知到您这边，如果企业的营业执照等图片信息没有上次成功的话请点击取消按钮继续上传，否则无法通过认真。",
                    callback:function(state,$dialog,opts){
                        $dialog.next().remove();//关闭阴影层
                        $dialog.remove();
						if(state){
                            window.location.href=basePath+"/login";
						}

                    }
                });

			}
		</script>
    </body>
</html>
