<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/common.jsp" %>
<style type="text/css">
	.formWidth table {width: 100%;}
	.formWidth td{padding: 6px;}
	.formWidth input {width: 100%;
		border-style: none;
		border-bottom: 1px solid #000;
	}
	.formWidth textarea {width: 100%;
		border-style: none;
		border-bottom: 1px solid #000;
	}
</style>

<div id='dialog-form-supplier'>
	<form id='supplier' class='formWidth'>
	     <table>
		       <tbody>
		         <tr>
			           <td>公司类型:</td>
			           <td>
				             <input type='text' name='type' readonly='ture'></td>
			           <td>公司名称:</td>
			           <td>
				             <input type='text' placeholder='公司名称' id='companyName' name='company' readonly='ture'></td>
			           <td>企业性质:</td>
			           <td>
				             <input type='text' name='nature' readonly='ture'></td>
			           <td>所属行业:</td>
			           <td>
				             <input type='text' name='industry' readonly='ture'></td>
			         </tr>
		         <tr>
			           <td>开户银行:</td>
			           <td>
				             <input type='text' placeholder='开户银行' name='bank' readonly='ture'></td>
			           <td>银行账号:</td>
			           <td>
				             <input type='text' placeholder='银行账号' name='bankAccount' readonly='ture'></td>
			           <td>法人:</td>
			           <td>
				             <input type='text' placeholder='法人' name='legalPerson' readonly='ture'></td>
			           <td>法人联系电话:</td>
			           <td>
				             <input type='text' placeholder='法人联系电话' name='legalPersonPhone' readonly='ture'></td>
			         </tr>
		         <tr>
			           <td>国家:</td>
			           <td>
				             <input type='text' name='countries' readonly='ture'></td>
			           <td>省/自治区/直辖市:</td>
			           <td>
				             <input type='text' name='province' readonly='ture'></td>
			           <td>地址:</td>
			           <td>
				             <input type='text' placeholder='地址' name='address' readonly='ture'></td>
			           <td>邮 件:</td>
			           <td>
				             <input type='email' placeholder='邮件' name='mail' readonly='ture'></td>
			         </tr>
		         <tr>
			           <td>用 户 名 称:</td>
			           <td>
				             <input type='text' placeholder='用户名称' name='userName' readonly='ture'></td>
			           <td>部 门:</td>
			           <td>
				             <input type='text' placeholder='部门' name='department' readonly='ture'></td>
			           <td>职 务:</td>
			           <td>
				             <input type='text' placeholder='职务' name='position' readonly='ture'></td>
			           <td>手 机 号 码:</td>
			           <td>
				             <input type='text' placeholder='手机号码' name='phone' readonly='ture'></td>
			         </tr>
		         <tr>
			           <td>企业生产执行标准情况:</td>
			           <td colspan='7'>
				             <textarea id='production' name='production' readonly='ture'></textarea>
				           </td>
			         </tr>
		         <tr>
			           <td>质量保证情况:</td>
			           <td colspan='7'>
				             <textarea id='quality' name='quality' readonly='ture'></textarea>
				           </td>
			         </tr>
		       </tbody>
		     </table>
	   </form>
 </div>
 <div class='col-sm-12'>
   <div class='tabbable'>
	     <ul class='nav nav-tabs' id='myTab'>
		       <li class='active'>
			         <a data-toggle='tab' href='#table' aria-expanded='true'>
				           <i class='green ace-icon fa fa-th bigger-120'></i>供应商证件信息</a>
			       </li>
		     </ul>
	     <div class='tab-content'>
		       <div id='table' class='tab-pane fade active in'>
			         <p>改供应商在主持的时候没有上次相关的证件信息。</p>
			       </div>
		     </div>
	   </div>
 </div>
<script type="text/javascript">


</script>


