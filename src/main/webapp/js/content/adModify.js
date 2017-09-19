$(function() {
	common.showMessage($("#message").val());
	$("#mainForm").validate({
		rules : {
			title : "required",
			link : "required",
			weight : {
				required : true,
				digits : true,
				maxlength : 5
			}
		},
		messages : {
			title : "请输入标题！",
			link : "请输入链接地址！",
			weight: {
		        required: "请输入权重",
		        digits: "请输入整数",
		        maxlength: "长度不能超过5"
		    }	
		}
	});
});

function modify() {
	$("#mainForm").submit();
}

function goback() {
	location.href = $('#basePath').val() + '/ad';
}