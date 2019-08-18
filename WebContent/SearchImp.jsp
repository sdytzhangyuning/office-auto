<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title><s:text name="mainmanage.title" /></title>
<link href="images/style.css" rel="stylesheet" type="text/css" />
<link href="images/mainstyle.css" rel="stylesheet" type="text/css" />
<link href="images/impListstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
		function mymouseout(id,styleclass)
		{
			document.getElementById(id).className=styleclass;
		}
		
		function checkmax1()
		{
			var total=<s:property value="PageCount"/>
			var page=document.getElementById("tiaoye").value;
			if(page>total)
			{
				alert("surpass");
				
				return false;
			}
			else
			{
				return true;
			}
		}
		</script>
</head>
<body>
	<div id="container">
		<div id="tophead">
			<jsp:include page="Top.jsp" />
		</div>
		<div id="leftcontent">
			<jsp:include page="LeftTree.jsp" />
		</div>
		<div id="maincontent">
			<s:form theme="simple" method="post" action="empAction_searchEmpList.action">
				<table width="100%" style="color: #404040; font-size: 14px; text-align: center;">
					<tr>
						<td>dep:<s:select name="departId" label="" labelposition="left" list="departList" listKey="key" listValue="value" />
						</td>
						<td>no:<s:textfield name="empId" cssStyle="width:70px;" />
						</td>
						<td>name:<s:textfield name="empName" cssStyle="width:70px;" />
						</td>
						<td>salary:<s:textfield name="downSalary" cssStyle="width:60px;" />to<s:textfield name="upSalary" cssStyle="width:60px;" />
						</td>
						<td><s:submit value="comfirm" /></td>
					</tr>
				</table>
			</s:form>
			<s:if test="emps.size()!=0">

				<table border="1" bgcolor="#e2e2e2" cellspacing="1" align="center" width="770px">

					<tr class="headerClass">
						<th>no</th>
						<th>name</th>
						<th>gender</th>
						<th>date of birth</th>
						<th>dep</th>
						<th>work</th>
						<th>salary</th>
						<th>phone</th>
						<th>info</th>
						<th>^_^</th>
					</tr>
					<s:iterator id="impList" value="emps" status="e">
						<tr id="e<s:property value="#e.index"/>" <s:if test="#e.odd">class="oddRow"</s:if> <s:else>class="evenRow"</s:else>
							onmouseover="this.className='selectedRow';"
							onmouseout="mymouseout('e<s:property value='#e.index'/>',
							<s:if test='#e.odd'>'oddRow'</s:if>
							<s:else>'evenRow'</s:else>);">
							<td><s:property value="empId" /></td>
							<td><s:property value="empName" /></td>
							<td><s:property value="empSex" /></td>
							<td><s:property value="empBirth" /></td>
							<td><s:property value="departmentinfo.departName" /></td>
							<td><s:property value="empRoll" /></td>
							<td><s:property value="empSalary" /></td>
							<td><s:property value="empTel" /></td>
							<td><a href="empAction_empDetail.action?empId=<s:property value="empId"/>" target="_blank">check</a></td>
							<td><a href="empAction_updateEmpUI.action?empId=<s:property value="empId"/>" target="_blank">edit</a>/<a
								href="empAction_dellEmp.action?empId=<s:property value="empId"/>">delete</a></td>
						</tr>
					</s:iterator>
				</table>

				<div id="buttomop">
					<div class="info">
						<span class="totalpage"><s:text name="impleeyList.gong" /> <s:property value="PageCount" /> <s:text name="impleeyList.ye" /></span> <span
							class="totalnum"><s:property value="totalMessage" /> <s:text name="impleeyList.jilushu" /></span>
					</div>
					<div class="pageop">
						<span class="shangye"> <s:if test="index>1">
								<a href="searchImp.action?index=<s:property value="index-1"/>"><s:text name="impleeyList.shangye" /></a>
							</s:if>
						</span> <span class="xiaye"> <s:if test="index<PageCount">
								<a href="searchImp.action?index=<s:property value="index+1"/>"><s:text name="impleeyList.xiaye" /></a>
							</s:if>
						</span>
						<s:form action="searchImp" theme="simple" onsubmit="return checkmax1()">
							<span class="tiaozhuan"><s:text name="impleeyList.tiaozhuan" /></span>
							<s:textfield id="tiaoye" name="index" cssClass="yefield" onmouseover="this.select();" />
							<span class="ye"><s:text name="impleeyList.ye" /></span>
							<s:submit value="%{getText(\"impleeyList.queding\")}" cssClass="queding" />

						</s:form>

					</div>

				</div>

			</s:if>
			<s:else>
				<p>none</p>
			</s:else>

		</div>
	</div>
</body>
</html>