<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>  <!-- 자바스크립트 라이브러리 걸어두기! -->
	<script type="text/javascript">
	var user_id_count = -1 ; 
	var user_id =''; // user아이디를 전역변수로 변경하기! 
	
		function openZipcode(){
			window.open('zipcode', 'confirm', 
					    'toolbar=no, location=no, status=no, menubar=no, scrollbar=yes, resizable=no,'+
					    'width=400, height=400')
		}
		function validate() {                         //완료버튼 누를 때 검사하는 것 
			let f = document.regist;
			if (f.user_id.value.length< 4 || f.user_id.value.length>13){
				alert('아이디는 영문자+숫자 5~12문자로 작성하세요!');
				f.user_id.focus();
				return;
			}
			if(f.user_name.value.length<1 || f.user_name.value.length >7){
				alert('이름은 2~6 문자로 작성하세요!');
				f.user_name.focus();
				return;
			}
			if(f.user_pw.value.length<3 || f.user_pw.value.length >21){
				alert('비밀번호는 4~20 문자로 작성하세요!');
				f.user_pw.focus();
				return;
			}
				if(f.user_pw.value!=f.user_pw2.value){
					alert('비밀번호/비밀번호 확인이 일치하지 않습니다.');
					f.user_pw.focus();
					return;
				}
			if (f.user_birth.value==""){
				alert('생년월일을 입력하세요!');
				f.user_birth.focus();
				return;
			}
			if (f.user_phone.value==""){
				alert('전화번호를 입력하세요!');
				f.user_phone.focus();
				return;
			}
			if (f.zipcode.value==""){
				alert('우편번호를 입력하세요!');
				f.btnZipcode.focus();
				return;
			}
			if (f.address1.value==""){
				alert('주소를 입력하세요!');
				f.address1.focus();
				return;
			}
			if (f.address2.value==""){
				alert('상세 주소를 입력하세요!');
				f.address2.focus();
				return;
			}
			if(user_id_count != 0){               // 0이 아닌 경우 반드시 확인 하도록 
				alert('사용할 수 있는 아이디가 아닙니다.')
				f.user_id.focus();
				return; 
			}
			f.method='POST';             
			f.action='regist';     
			f.submit();
		}
		
		$(document).ready(function(){
			$('#user_id').on('keyup', function(){
				//console.log($('#user_id').val())
				user_id_count = -1;        
				let f =document.regist ;
				user_id = f.user_id.value;
				if (user_id.length< 4 || user_id.length>13){
					document.getElementById('check_id_result').innerHTML ='아이디는 영문자+숫자 4~12문자로 작성하세요!';
					return;
				}
				//new ajax.xhr.Request('checkID', 'user_id='+user_id, callback, 'POST') 
				$.post( "checkID", {"user_id" : user_id})
				 .done(function( data ) {
					 //function callback 부분을 아래에 입력했다. 
					 user_id_count=parseInt(data);
					 if (user_id_count === 1){
							$('#check_id_result').html(user_id+'는 이미 사용중인 아이디 입니다. ');
							return;
						}else if (user_id_count === 0){
							$('#check_id_result').html(user_id+'는 사용 가능한 아이디 입니다. ');
							return;
						}else {
							alert('OMG! 시스템 오류입니다!');
						}
				 });
			});
		});
	</script>
</head>
<body>
<form name="regist" method="post" action="">
<table border="1">
	<caption>회원 가입</caption>
<tr>
	<th>아이디</th>
	<td><input type="text" name="user_id" id="user_id" "/>
		<div id="check_id_result">영문자+숫자 4~12문자로 작성하세요!<br/></div>
	</td>
</tr>
<tr>
	<th>이름</th>
	<td><input type="text" name="user_name" id="user_name" /> 2~6 문자
	</td>
</tr>
<tr>
	<th>비밀번호</th>
	<td><input type="password" name="user_pw" id="user_pw" /> 4~20 문자</td>  
</tr>
<tr>
	<th>비밀번호 확인</th>
	<td><input type="password" name="user_pw2" id="user_pw2" /></td>
</tr>
<tr>
	<th>생일</th>
	<td><input type="date" name="user_birth" id="user_birth" /></td>
</tr>
<tr>
	<th>전화</th>
	<td><input type="text" name="user_phone" id="user_phone" /></td>
</tr>
<tr>
	<th>우편번호</th>
	<td>
		<input type="text" name="zipcode" readonly="readonly"
		onclick="alert('검색버튼을 이용하여 입력하세요');" 
		style="width:55px;"/>
		<input type="button" value="검색" name="btnZipcode"
		onclick ="openZipcode()"/>
	</td>
</tr>
<tr>
	<th>주소</th>
	<td>
		<input type="text" name="address1" style="width:250px;"/><br/>
	</td>
</tr>
<tr>
	<th>상세 주소</th>
	<td>
		<input type="text" name="address2" /><br/>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="button" value="완료" onclick="validate()"/>
	</td>
</tr>
</table>
</form>
</body>
</html>