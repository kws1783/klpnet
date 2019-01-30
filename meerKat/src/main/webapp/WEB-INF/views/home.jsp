<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
        <!-- END META SECTION -->
        
        <!-- CSS INCLUDE -->        
        <link rel="stylesheet"	href="${pageContext.request.contextPath}/resources/css/theme-default.css">
	
	<title>Data</title>
		 <!-- jQuery -->
        <script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
$(document).ready(function(){	
	$('#server_1').css('background-color','white');
	$('#server_1').css('color','#088acf');
	$("#desktop_1").attr("src", "${pageContext.request.contextPath}/resources/img/icon/desktop_click.png");
	$("#server_1").addClass('choose');
});
//서버를 눌렀을 때 발생할 일,아규먼트는 아이디의 번호와 같다.
function svChange(svNum){
	var i=1;
	$(".svList").each(function(){
		if($("#server_"+i).hasClass('choose')){
			$("#server_"+i).removeClass('choose');
			$("#server_"+i).css('background-color','');
			$("#server_"+i).css('color','white');
			$("#desktop_"+i).attr("src", "${pageContext.request.contextPath}/resources/img/icon/desktop.png");
			}else{
				i++;
				}
		});
	$('#server_'+svNum).css('background-color','white');
	$('#server_'+svNum).css('color','#088acf');
	$("#desktop_"+svNum).attr("src", "${pageContext.request.contextPath}/resources/img/icon/desktop_click.png");
	$("#server_"+svNum).addClass('choose');

}
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
            <div class="sidebar" style="background:#088acf;float:left;width:100px;height: 100%">
                <!-- START 페이지 왼쪽 네비게이션 -->
                
        	 <div style="width:100px;height: 95px;text-align:center;cursor:pointer;color:white" id="server_1" onclick="svChange('1');" class="svList">
        	 		<img id="desktop_1" src="${pageContext.request.contextPath}/resources/img/icon/desktop.png" width="70px" height="50px" style=" vertical-align: top;float:left;margin:15px 15px 3px 15px"></img>
        	 	<b>SERVER1</b>
        	 </div>
        	  <div style="width:100px;height: 95px;text-align:center;cursor:pointer;color:white" id="server_2" class="svList" onclick="svChange('2');">
        	 		<img id="desktop_2" src="${pageContext.request.contextPath}/resources/img/icon/desktop.png" width="70px" height="50px" style=" vertical-align: top;float:left;margin:15px 15px 3px 15px"></img>
        	 	<b>SERVER2</b>
        	 </div>
        	  <div style="width:100px;height: 95px;text-align:center;cursor:pointer;color:white" id="server_3" class="svList" onclick="svChange('3');">
        	 		<img id="desktop_3" src="${pageContext.request.contextPath}/resources/img/icon/desktop.png" width="70px" height="50px" style=" vertical-align: top;float:left;margin:15px 15px 3px 15px"></img>
        	 	<b>SERVER3</b>
        	 </div>
                <!-- END X-NAVIGATION -->
            </div>
          
            <!-- END PAGE SIDEBAR -->
              
     
              <!-- PAGE CONTENT /사이드바 자리까지 page-content영역 처리되어서 부득이하게 margin값 줌-->
            <div class="page-content" style="margin-left:100px;padding:10px 10px 10px 10px">
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
