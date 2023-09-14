<%-- 
    Document   : Admin_Home
    Created on : 14 Sep, 2023, 11:24:50 AM
    Author     : 91630
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <style type="text/css">
    #apDiv1 {
	position: absolute;
	width: 535px;
	height: 170px;
	z-index: 1;
	left: 271px;
	top: 111px;
}
    #apDiv2 {
	position: absolute;
	width: 642px;
	height: 350px;
	z-index: 1;
	top: 144px;
	left: 227px;
}
#apDiv5 {
	position: absolute;
	width: 732px;
	height: 48px;
	z-index: 3;
	left: 51px;
	letter-spacing: normal;
	vertical-align: super;
	word-spacing: normal;
	top: 5px;
}
    </style>
    <link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css">
    <style type="text/css">
    body,td,th {
	font-size: 18px;
	color: #09F;
}
body {
	background-color: #FFF;
}
    </style>
    </head>
    <body>
        <div id="apDiv5">
      <ul id="MenuBar1" class="MenuBarHorizontal">
        
       
        
       
      </ul>
</div>
    
    <div id="apDiv2">
       <table width="644" border="1">
        <tr>
          <td width="634">  <% 
                if(request.getAttribute("msg")!=null)
                out.println(request.getAttribute("msg"));
            
            %><br></br>
         WELCOME TO ADMIN HOME PAGE  <form name="form1" method="post" action="adminlogin.jsp">      
                          <input type="submit" name="logout" id="logout" value="logout"></td></form>
        </tr>
       <br></br>
            <br></br>
            <br></br>
       
      </table>
      <table width="643" height="77" border="0">
        <tr>
            
          <td><a href="Admin_Home.jsp">
          Admin Home
          </a></td>
          <td><a href="insertser.jsp">
          Add Train
          </a></td>
          <td><a href="updatetrain.jsp">
            Update Train
          </a></td>
          
          </form></td>
        </tr>
        <tr>
             <td><a href="customer.jsp">
            Customer List
          </a></td>
          <td><a href="insertstation.jsp">
            Add Station
          </a></td>
          <td><a href="updatestation.jsp">
           Update Station
          </form></td>
          
        </tr>
      </table>
            <form name="form1" method="post" action="adminlogin.jsp">
      </form>
      <p>&nbsp;</p>
    </div>
</body>
</html>