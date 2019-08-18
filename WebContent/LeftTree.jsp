<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>高级链接</title>
<link href="images/treestyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function change(num) {
		var s = document.getElementById("li" + num + 1).style.display;
		if (s == "none") {

			document.getElementById("li" + num).className = "kai";
			for ( var i = 1; i < 10; i++) {
				var obj = document.getElementById("li" + num + i);
				if (obj == null) {
					return;
				} else {
					obj.style.display = "block";
				}
			}
		} else {
			document.getElementById("li" + num).className = "he";
			for ( var i = 1; i < 10; i++) {
				var obj = document.getElementById("li" + num + i);
				if (obj == null) {
					return;
				} else {
					obj.style.display = "none";
				}
			}
		}
	}
</script>
</head>
<body>
	<div id="leftTree">
		<ul>
			<li><a href="#" onclick="change(1);" id="li1" class="kai">employee</a></li>
			<li id="li11" style="display: block;" class="son"><a class="sons" href="empAction_findEmpPageList.action">list</a></li>
			<li id="li12" style="display: block;" class="son"><a class="sons" href="empAction_addEmpUI.action">add</a></li>
			<li id="li13" style="display: block;" class="son"><a class="sons" href="empAction_searchEmp.action">query</a></li>

			<li><a href="#" onclick="change(2);" id="li2" class="kai">dep</a></li>
			<li id="li21" style="display: block;" class="son"><a class="sons" href="departAction_findDepPageList.action">dep list</a></li>
			<li id="li22" style="display: block;" class="son"><a class="sons" href="addDepartment.jsp">add dep</a></li>

			<li><a href="#" onclick="change(3);" id="li3" class="kai">manage check in</a></li>
			<li id="li31" style="display: block;" class="son"><a class="sons" href="attendanceAction_findTodayAtdUI.action">today check in</a></li>
			<li id="li32" style="display: block;" class="son"><a class="sons" href="attendanceAction_findAtdList.action">check in query</a></li>
			<li id="li33" style="display: block;" class="son"><a class="sons" href="QianDaoOption.jsp">check in</a></li>

			<li><a href="#" onclick="change(4);" id="li4" class="kai">manage over time</a></li>
			<li id="li41" style="display: block;" class="son"><a class="sons" href="extraworkAction_findExtPageList.action">dep</a></li>
			<li id="li42" style="display: block;" class="son"><a class="sons" href="extraworkAction_findOneExtPageList.action">personal</a></li>
			<li id="li43" style="display: block;" class="son"><a class="sons" href="AddExtraWork.jsp">add</a></li>

			<li><a href="#" onclick="change(5);" id="li5" class="kai">manage salary</a></li>
			<li id="li51" style="display: block;" class="son"><a class="sons" href="ComSalary.jsp">all</a></li>

			<li><a href="#" onclick="change(6);" id="li6" class="kai">manage vacation</a></li>
			<li id="li61" style="display: block;" class="son"><a class="sons" href="holsAction_adminHols.action">apply</a></li>
			<li id="toperson"><a href="empAction_empDet.action">info</a></li>
		</ul>
	</div>
</body>
</html>