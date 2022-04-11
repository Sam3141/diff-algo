<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Text Diffing</title>
</head>
<body>
<h1>Diffing</h1>
<p>Word by word diffing algorithm is implemented</p>
<form action="<%=request.getContextPath()%>/Home" method="post">
<table width="100%"><tbody><tr>
  <td width="50%">
<h3>Text Version 1:</h3>
<textarea id="text1" name="textarea1" style="width: 100%" rows="10">
<%
if(request.getAttribute("ans")==null){
out.println("I am the very model of a modern Major-General,I've information vegetable, animal, and mineral, I know the kings of England, and I quote the fights historical, From Marathon to Waterloo, in order categorical.");
}
else{
	String t1 = request.getParameter("textarea1");
	out.println(t1);
}
%>
</textarea></td>
  <td width="50%">
<h3>Text Version 2:</h3>
<textarea id="text2" name="textarea2" style="width: 100%" rows="10">
<% 
if(request.getAttribute("ans")==null){
out.println("I am the very model of a cartoon individual, My animation's comical, unusual, and whimsical, I'm quite adept at funny gags, comedic theory I have read, From wicked puns and stupid jokes to anvils that drop on your head.");
}
else{
	String t2 = request.getParameter("textarea2");
	out.println(t2);
}
%>
</textarea></td>
</tr></tbody></table>
<p><input type="submit" name="submit" value=Compute Diff"></p>
</form>
<%
if(request.getAttribute("ans")!=null){
	out.println("<hr>");
	out.println("<br>");
	List<List<String>> ans = (List<List<String>>)request.getAttribute("ans");
	for(List<String> temp:ans){
		if(temp.get(1).equals("0")){
			out.println(temp.get(0)+" ");
		}
		else if(temp.get(1).equals("1")){
			out.println("<mark style=");
			out.println("background-color:#FF7F7F;>");
			out.println("<strike>");
			out.println(temp.get(0));
			out.println("</strike>");
			out.println("</mark>");

		}
		else if(temp.get(1).equals("2")){
			out.println("<mark style=");
			out.println("background-color:#90EE90;>");
			out.println(temp.get(0));
			out.println("</mark>");
		}
	}
}

%>

</body>
</html>