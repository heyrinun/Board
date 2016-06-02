<%@page import="com.board.beans.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border = 1 width = 400 height = "80" align = "center">
    <tr>
        <td>번호</td>
        <td>제목</td>
        <td>아이디</td>                 
        <td>날짜</td>
    </tr>
 
    <%
        BoardDto dto = new BoardDto();
        ArrayList list = (ArrayList)request.getAttribute("List"); 
        for (int i = 0;  i< list.size(); i++) {
            dto = (BoardDto)list.get(i);
     %>           
            <tr>
                <td><%=dto.getBseq()%></td>
                <td>
            <a href = "/WEB_LGS/BoardServlet?actionMode=VIEW&bseq=<%=dto.getBseq()%>"/>
            <%=dto.getTitle()%></td>                 
                <td><%=dto.getRegid()%></td>
                <td><%=dto.getRegdate()%></td>
            </tr>
    <% } %>
 
</table>
</body>
</html>