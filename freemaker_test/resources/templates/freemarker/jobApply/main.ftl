<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>me.yeonghoon.kim :: 입사지원</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
function jobAdd() {
	var params = $("#jobAdd").serialize();
	$.ajax({
		type : "post",			  
		url : "jobAdd",
		dataType : "json",
		data : params,
		success : function(res) { 
			if(res.result == "success") {
				alert("등록이 완료되었습니다.");
			} else if(res.result == "null") {
				alert("회사명 또는 공고명을 입력해주세요.");
			} else {
				alert("에러 발생!!");
			}
			location.href = "jobApply";
		},
		error : function(reqsuest, status, error) {  
			console.log("text : " + reqsuest.responseTxt);
			console.log("error : " + error);
		}
	});
}
</script>
</head>
<body>
	<div class="container-sm">
		<form action="jobAdd" id="jobAdd" method="post">
			<span>회사명 : </span>
			<input type="text" name="companyName" />
			<span>공고명 : </span>
			<input type="text" name="announceName" />
			<button type="button" class="btn btn-sm btn-danger" onclick="jobAdd()">등록</button>
		</form>
		<div class="table-responsive">
			<table class="table table-striped table-sm text-center">
				<thead>
					<tr>
						<th>지원일</th>
						<th>회사명</th>
						<th>공고명</th>
						<th>열람</th>
						<th>합격</th>
						<th>진행</th>
						<th>변경</th>
					</tr>
				</thead>
				<tbody id="applyList">
					<#if list??>
						<#list list as list>
						<tr>
							<td>${list.apply_date}</td>
							<td>${list.company_name}</td>
							<td>${list.announcement_name}</td>
							<#if list.read_yn == "Y">
								<td class="text-primary font-weight-bold">${list.read_yn}</b></td>
							<#else>
								<td>${list.read_yn}</td>
							</#if>
							<#if list.pass_yn == "N">
								<td class="text-danger font-weight-bold">${list.pass_yn}</td>
							<#else>
								<td>${list.pass_yn}</td>
							</#if>
							<td>${list.apply_status}</td>
							<#if list.pass_yn != "N">
								<td><button class="btn btn-primary" data-no="${list.id}">변경</button></td>
							<#else>
								<td></td>
							</#if>
						</tr>
						</#list>
					</#if>
				</tbody>
			</table>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="modifyStatus" tabindex="-1" role="dialog"
			aria-labelledby="modifyLabel" aria-hidden="true">
			<form action="actionForm" id="actionForm" method="post">
				<input type="hidden" id="selectNo" name="selectNo" />
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="modifyLabel">수정</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">열람여부, 합격여부, 진행상태 수정</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">닫기</button>
							<button type="button" class="btn btn-primary" onclick="modifyStatus()">수정</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>