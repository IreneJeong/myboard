<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="app" value="${pageContext.request.contextPath }"/>
<c:set var="vo" value="${articleVO}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/xhr.js"></script>
<script type="text/javascript">
function confirm_delete() {
	if(confirm('정말로 삭제하시겠습니꺄?')) {
		location.href='delete';
	}	
}
</script>
</head>
<body>
<table>
	<caption>게시물 상세보기</caption>
<tr>
	<th>글번호</th>
	<td>${vo.art_no}</td>
</tr>
<tr>
	<th>제목</th>
	<td>${vo.art_title}</td>
</tr>
<tr>
	<th>작성자</th>
	<td>${vo.userVO.user_name}(${vo.userVO.user_id})</td>
</tr>
<tr>
	<th>작성일</th>
	<td><fmt:formatDate value='${vo.art_regdate}' pattern="yyyy-MM-dd hh24:mm:ss"/></td>
</tr>
<tr>
	<th>조회수</th>
	<td>${vo.art_readcnt}</td>
</tr>
<tr>
	<th>내용</th>
	<td>${vo.art_content}</td>
</tr>
<tr>
	<th>추천</th>
	<td><span id="like_count">${vo.art_like}</span><img src="${app}/resources/img/good.png" id="like" /></td>
</tr>
<tr>
	<th>비추천</th>
	<td><span id="dislike_count">${vo.art_dislike}</span><img src="${app}/resources/img/bad.png" id="dislike" /></td>
</tr>
<tr>
	<th>작성자ip</th>
	<td>${vo.art_ip}</td>
</tr>
<tr>
	<td colspan="2">
		<a href="list">[리스트]</a>
		<c:if test="${vo.userVO.user_id == sessionScope.userInfo.user_id}">
			<a href="update?no=${vo.art_no}">[수정]</a>
			<a href="javascript:;" onclick="confirm_delete()">[삭제]</a>
		</c:if>
	</td>
</tr>
<tr>
	<td colspan="2">
	<table>
		<tr>
			<td>
			
				<textarea id="c_content" name="c_content" style="width:400px;height:60px;"></textarea><br/>
				<input type="button" value="댓글등록"  />
			</td>
		</tr>
	</table>
	</td>
</tr>


</table><br/>
</body>
</html>