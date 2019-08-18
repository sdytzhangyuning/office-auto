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
<link href="images/qiandao.css" rel="stylesheet" type="text/css" />
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
			<s:form theme="simple" method="post" action="salaryAction_salUI.action">
				<span class="choseinfo">choose month：</span>
				<sx:datetimepicker name="salaryMonth" toggleType="explode" value="today" displayFormat="yyyy-MM" />
				<s:submit value="generate" cssClass="shengcheng" />
				<font color="red"><s:property value="result" /></font>
				<s:fielderror cssClass="fielderr" />
			</s:form>
		</div>
	</div>
</body>
</html>