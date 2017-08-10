// 根据帖子id查询帖子信息
$(function() {

	$("#searchWhiteList").click(function() {
		$("body").mLoading();
	});

	$("#searchWhiteList").bind("click", function() {

		$.ajax({
			url : '/info/whiteList',
			type : 'POST',
			data : {
				"userId" : $("#userId").val(),
				"IP" : $("#IP").val()
			},
			success : function(result) {
				$("#whiteListResult").text("");
				if (result.code != 200) {
					$("body").mLoading("hide");// 隐藏loading组件
				} else {
					$("body").mLoading("hide");// 隐藏loading组件
					if (result.ip_list.length > 0) {
						var th = '<thead><tr><th>序号</th><th>UserId</th><th>入库时间</th></tr></thead>';
						$("#whiteListResult").append(th);
						for (var i = 0; i < result.ip_list.length; i++) {
								var viewer = '<tr class="error"><td>'+i+'</td><td>'
								+ result.ip_list[i].userid
								+ '</td><td>'+result.ip_list[i].createtime
								+'</td></tr>';
							$("#whiteListResult").append(viewer);
						}
					} else {
						$("#whiteListResult").html("该IP下没有维护白名单")
					}
				}
			},
			error : function(returndata) {
				alert("未知错误"+returndata);
				$("body").mLoading("hide");// 隐藏loading组件
			}
		});
	})

})
