<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<html>
<head>
<s:head theme="xhtml" />
<sx:head parseContent="true" />
<title><s:text name="mainmanage.title" /></title>
<link href="images/style.css" rel="stylesheet" type="text/css" />
<link href="images/mainstyle.css" rel="stylesheet" type="text/css" />
<link href="images/addimp.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="images/manage.js"></script>
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
			<div id="ftdiv">
				<s:form onsubmit="return addimpcheck();" theme="simple" action="empAction_addEmp.action" method="post" enctype="multipart/form-data">
					<fieldset>
						<legend>regist</legend>

						<table width="500">
							<tr>
								<td style="width: 80px;">emp no:</td>
								<td><s:textfield name="emp.empId" id="impId" cssClass="inputarea" /><span id="impIderr" class="fielderr"></span></td>

							</tr>
							<tr>
								<td>emp name:</td>
								<td><s:textfield name="emp.empName" id="impName" cssClass="inputarea" /><span id="impNameerr" class="fielderr"></span></td>
							</tr>
							<tr>
								<td>emp gender:</td>
								<td><s:radio name="emp.empSex" list="genderList" listKey="key" listValue="value" /></td>
							</tr>
							<tr>
								<td>date of birth:</td>
								<td><sx:datetimepicker name="emp.empBirth" id="impBirth" label="" toggleType="explode" value="today" cssClass="timepick" displayFormat="yyyy-MM-dd"/><span
									id="impBirtherr" class="fielderr"></span></td>
							</tr>
							<tr>
								<td>e-mail:</td>
								<td><s:textfield name="emp.empEmail" id="impEmail" cssClass="inputarea" /><span id="impEmailerr" class="fielderr"></span></td>
							</tr>
							<tr>
								<td>phone:</td>
								<td><s:textfield name="emp.empTel" id="impTel" cssClass="inputarea" /><span id="impTelerr" class="fielderr"></span></td>
							</tr>
							<tr>
								<td>dep:</td>
								<td><s:select name="emp.departmentinfo.departId" list="departList" listKey="key" listValue="value" /></td>
							</tr>
							<tr>
								<td>work:</td>
								<td><s:textfield name="emp.empRoll" id="impRoll" cssClass="inputarea" /><span id="impRollerr" class="fielderr"></span></td>
							</tr>
							<tr>
								<td>salary:</td>
								<td><s:textfield id="impSalary" name="emp.empSalary" /><span id="impSalaryerr" class="fielderr"></span></td>
							</tr>
							<tr>
								<td>photo:</td>
								<td><input type="file" name="upload" class="infile" /></td>
							</tr>
						</table>
					</fieldset>
					<fieldset>
						<legend>resume</legend>
						<span id="impBioerr" class="fielderr"></span>
						<p>
							<s:textarea cols="68" rows="15" id="impBio" name="emp.empBio"></s:textarea>
						</p>
					</fieldset>
					<s:submit value="submit" cssClass="tijiao" onmouseover="this.className='tijiaoover';" onmouseout="this.className='tijiao';" />
				</s:form>
				<s:fielderror cssClass="fielderr" />
				<script type="text/javascript">
					result = "<s:property value="result"/>";
					if (result != "") {
						alert(result);
					}
				</script>
			</div>

		</div>
	</div>
</body>
</html>