$(function() {
	common.showMessage($("#message").val());
});

function remove(id) {
	$("#mainForm").attr("action",$("#basePath").val() + "/businesses/" + id);
	$("#mainForm").submit();
}

function search(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").attr("method","GET");
	$("#mainForm").attr("action",$("#basePath").val() + "/businesses/search");
	$("#mainForm").submit();
}

function modifyInit(id) {
	location.href = $("#basePath").val() + "/businesses/" + id;
}