<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
          function test()
          {
        	  $.post(
        		 "testJSON",		  //服务器地址
        		 //{"name":"zs"},
        		 function(result)
        		 {
        			 alert(result.id);
        		 }
        			);
          }
</script>
</head>
<body>
         <input id="testJSON" type="button" value="testJSON" onclick="test()">
</body>
</html>