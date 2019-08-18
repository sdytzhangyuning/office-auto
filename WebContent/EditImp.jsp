<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head>
		<title><s:text name="mainmanage.title"/></title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="images/impListstyle.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="images/manage.js"></script>
		<script language="JavaScript">
		function mymouseout(id,styleclass)
		{
			document.getElementById(id).className=styleclass;
		}
		</script>
		<s:head/>
	</head>
	<body>
	<div style="width:550px;background:white;margin-top:30px;">
		<s:form theme="simple" onsubmit="return editimpcheck();" action="editImp" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>edit info</legend>
			
			<table width="500">
				<tr>
					<td style="width:80px;">no:</td>
					<td><s:property value="impId"/><s:textfield name="impId" cssStyle="display:none"/></td>
				</tr>
				<tr>
					<td>name:</td>
					<td><s:textfield name="impName" cssClass="inputarea"/><span id="impNameerr" class="fielderr"></span></td>
				</tr>
				<tr>
					<td>gender:</td>
					<td><s:radio name="impGender" list="genderList" listKey="key" listValue="value"/></td>
				</tr>
				<tr>
					<td>date of birth:</td>
					<td><s:datetimepicker name="impBirth" label="date of buy" toggleType="explode" cssClass="timepick"/></td>
				</tr>
				<tr>
					<td>email:</td>
					<td><s:textfield name="impEmail" cssClass="inputarea"/><span id="impEmailerr" class="fielderr"></span></td>
				</tr>
				<tr>
					<td>phone:</td>
					<td><s:textfield name="impTel" cssClass="inputarea"/><span id="impTelerr" class="fielderr"></span></td>
				</tr>
				<tr>
					<td>dep:</td>
					<td>
						<s:select name="departId" list="departList" listKey="key" listValue="value"/>
					</td>
				</tr>
				<tr>
					<td>work:</td>
					<td><s:textfield name="impRoll" cssClass="inputarea"/><span id="impRollerr" class="fielderr"></span></td>
				</tr>
				<tr>
					<td>salary:</td>
					<td><s:textfield name="impSalary"/><span id="impSalaryerr" class="fielderr"></span></td>
				</tr>
				<tr>
					<td>change photo:</td>
					<td><input type="file" name="pic" class="infile"/></td>
				</tr>
			</table>
			</fieldset>
			<fieldset>
			<legend>resume</legend>
			<span id="impBioerr" class="fielderr"></span>
			<p><s:textarea cols="75" rows="15" name="impBio"></s:textarea></p>
			</fieldset>
			<s:submit value="submit" cssClass="tijiao"/>
		</s:form>
		<script language="JavaScript">
					result="<s:property value="result"/>";
					if(result!="")
					{
						alert(result);
					}
		</script>
		<s:fielderror cssClass="fielderr"/>
	</div>
	</body>
</html>