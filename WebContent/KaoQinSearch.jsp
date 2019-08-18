<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<html>
<head>
<s:head theme="xhtml"/> <sx:head parseContent="true"/>
<title><s:text name="mainmanage.title" /></title>
<link href="images/style.css" rel="stylesheet" type="text/css" />
<link href="images/mainstyle.css" rel="stylesheet" type="text/css" />
<link href="images/qiandao.css" rel="stylesheet" type="text/css" />
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
				alert("surpass);
				
				return false;
			}
			else
			{
				return true;
			}
		}
		</script>
<s:head />
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


			<div>
				<s:form theme="simple" action="attendanceAction_findConditionAtdList.action">
					<table width="100%" style="font-size: 14px; color: #404040;">
						<tr>
							<td>choose dep: <s:select name="departId" label="" labelposition="left" list="departList" listKey="key" listValue="value" />
							</td>
							<td>status: <s:select name="attendType" label="choose status：" labelposition="left" list="stateList" listKey="key" listValue="value" />
							</td>
							<td>start date:<sx:datetimepicker name="from_day" toggleType="explode" value="today" displayFormat="yyyy-MM-dd" />
							</td>
							<td>end date:<sx:datetimepicker name="to_day" toggleType="explode" value="today" displayFormat="yyyy-MM-dd" />
							</td>
							<td><s:submit value="submit" /></td>
						</tr>
					</table>


				</s:form>
				<s:if test="attendances.size()>0">
					<table border="1" bgcolor="#e2e2e2" cellspacing="1" align="center" width="770px">
						<caption>
							<h4>list</h4>
						</caption>
						<tr class="headerClass">
							<th>no</th>
							<th>name</th>
							<th>dep</th>
							<th>date</th>
							<th>status</th>

						</tr>
						<s:iterator id="recordList" value="attendances" status="a">
							<tr id="a<s:property value="#a.index"/>" <s:if test="#a.odd">class="oddRow"</s:if> <s:else>class="evenRow"</s:else>
								onmouseover="this.className='selectedRow';"
								onmouseout="mymouseout('a<s:property value='#a.index'/>',
							<s:if test='#a.odd'>'oddRow'</s:if>
							<s:else>'evenRow'</s:else>);">
								<td><s:property value="employeeinfo.empId" /></td>
								<td><s:property value="employeeinfo.empName" /></td>
								<td><s:property value="employeeinfo.departmentinfo.departName" /></td>
								<td><s:property value="attendTime" /></td>
								<td><s:property value="attendState==0?'absense':(attendState==1?'on':'')" /> <a
									href="qingJiaDetail.action?empId=<s:property value="employeeinfo.empIdemployeeinfo.empId"/>&date=<s:property value="attendTime"/>"
									target="_blank"><s:property value="attendState==2?'leave':''" /></a></td>
							</tr>
						</s:iterator>
					</table>
					<div>
						<s:form theme="simple" action="attendanceAction_findAtdList.action" onsubmit="return checkmax1()">
							<table width="770px">
								<td style="width: 400px; font-size: 14px; color: #404040">count<s:property value="PageCount" />page <s:property value="totalMessage" />info
								</td>
								<td style="width: 400px; font-size: 14px;"><s:if test="index>1">
										<a href="attendanceAction_findAtdList.action?index=<s:property value="index-1"/>">last</a>
									</s:if></td>
								<td style="width: 400px; font-size: 14px;"><s:if test="index<PageCount">
										<a href="attendanceAction_findAtdList.action?index=<s:property value="index+1"/>">next</a>
									</s:if></td>
								<td style="width: 400px; font-size: 14px; color: #404040">go to<s:textfield id="tiaoye" name="index" cssStyle="width:20px;height:20px;"
										onmouseover="this.select();" />page <s:submit value="go" cssClass="tiaozhuan" />
								</td>
							</table>
						</s:form>
					</div>
				</s:if>
				<s:else>
					<span style="font-size: 25; color: red;">none</span>
				</s:else>
				<s:fielderror cssClass="fielderr" />
			</div>

		</div>
	</div>
</body>
</html>