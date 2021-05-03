<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

</head>
<script type="text/javascript">
	$(document).ready(function(){
		//취소
		$(".cancle").on("click",function(){
			location.href= "/login";
		})
		
		//vaildator
		$("#submit").on("click",function(){
			var idReg = /^[a-z]+[a-z0-9]{5,19}$/g;
			if($("#userId").val()==""){
				alert("아이디를 입력하세요.");
				$("#userId").focus();
				return false;
		}
			if(!idReg.test( $("input[name=userId]").val())){
				alert("6~20자의 영문과 숫자로만 입력하세요.");
				$("#userId").focus();
				return false;
			}
			
			if($("#userPass").val()==""){
				alert("비밀번호를 입력하세요.");
			$("#userPass").focus();
			return false;
		}
			if($("#userName").val()==""){
				alert("이름을 입력하세요.");
				$("#userName").focus();
				return false;
		}
			
		});
		
	})
</script>
<body>
		<section id="container">
				<form action="/member/register" method="post">
					<div class="form-group has-feedback">
						<label class="control-label" for="userId">아이디</label>
						<input class="form-control" type="text" id="userId" name="userId" />
					</div>
					<div class="form-group has-feedback">
						<label class="control-label" for="userPass">패스워드</label>
						<input class="form-control" type="password" id="userPass" name="userPass" />
					</div>
					<div class="form-group has-feedback">
						<label class="control-label" for="userName">성명</label>
						<input class="form-control" type="text" id="userName" name="userName" />
					</div>
					<div class="form-group has-feedback">
						<button class="btn btn-success" type="submit" id="submit">회원가입</button>
						<button class="cencle btn btn-danger" type="button">취소</button>
					</div>
				</form>
			</section>

</body>
</html>