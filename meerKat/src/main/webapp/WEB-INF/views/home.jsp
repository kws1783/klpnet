<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
        <!-- END META SECTION -->
        
        <!-- CSS INCLUDE -->        
        <link rel="stylesheet"	href="${pageContext.request.contextPath}/resources/css/theme-default.css">

	<title>Data</title>
</head>
<script type="text/javascript">
function test(){
	location.href="<%=request.getContextPath()%>/getCpuInfo.do";
}
</script>
<body>
      <!-- START PAGE CONTAINER -->
        <div class="container">
               <!-- START X-NAVIGATION VERTICAL -->
               <div style="height:7%;background:#088acf;width:100%;z-index:10;">
      
                 	<img src="${pageContext.request.contextPath}/resources/img/logo.png" width="50px" height="47px" style=" vertical-align: top;margin:3px 0px 0px 10px;"></img>
               		<b style="color:white;font-size: 3em;"> MEERKAT</b>
               		
               			<img src="${pageContext.request.contextPath}/resources/img/icon/out1.png"  width="40px" height="35px" style=" vertical-align: top;float:right; margin:0.7% 0.5% 0 0.7%;cursor:pointer" onclick="test();"></img>
               		<!-- 위엔 나가기 아래IMG태그는 로그아웃 -->	
                		<img src="${pageContext.request.contextPath}/resources/img/icon/smile.png"  width="40px" height="40px" style=" vertical-align: top;float:right; margin:0.5% 0.5% 0 0.5%;cursor:pointer" onclick="alert('로그아웃누름');"></img>
                </div>
              <!-- END X-NAVIGATION VERTICAL --> 
            <!-- START PAGE SIDEBAR -->
            <div class="sidebar" style="background:#088acf;float:left;width:8%;height: 100%">
                <!-- START 페이지 왼쪽 네비게이션 -->
        	  <ul class="">
       				
                </ul>
                <!-- END X-NAVIGATION -->
            </div>
          
            <!-- END PAGE SIDEBAR -->
              
     
              <!-- PAGE CONTENT -->
            <div class="page-content">
          		<table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>First Name</th>
                                                <th>Last Name</th>
                                                <th>Username</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Mark</td>
                                                <td>Otto</td>
                                                <td>@mdo</td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Jacob</td>
                                                <td>Thornton</td>
                                                <td>@fat</td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Larry</td>
                                                <td>the Bird</td>
                                                <td>@twitter</td>
                                            </tr>
                                        </tbody>
                                    </table>
                
            </div>
            </div>
            
</body>
</html>
