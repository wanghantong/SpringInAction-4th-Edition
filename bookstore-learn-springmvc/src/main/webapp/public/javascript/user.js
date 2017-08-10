// 根据用户基本信息查询
$(function() {

	// 网邻通关联产品
	var wltCategory = {
		100301 : '房产网邻通',
		100302 : '房产网邻通增值服务',
		100303 : "免税房源网邻通",
		100304 : "房产网邻通2.0",// 与100301 互斥
		100311 : "降价房源网邻通",
		100312 : "急售房源网邻通",
		/*--------------旗舰店-------------*/
		100305 : "房产网邻通",
		100306 : "诚信房源网邻通",
		100307 : "免税房源网邻通"
	};

	var serviceCategory = {
		8 : "整租",
		9 : "短租",
		10 : "合租",
		11 : "求租",
		12 : "二手房",
		13 : "写字楼",
		14 : "商铺",
		15 : "厂房"

	};

	$("#searchUserAllInfo")
			.bind("click",function() {
				
				$("body").mLoading("show");//显示loading组件
				
						$.ajax({
									url : '/user/getAllInfo',
									// contentType : 'application/json',
									type : 'POST',
									// data :
									// $('#searchUserInfoForm').serialize(),
									data : {
										"mobile" : $("#all_mobile").val(),
										"email" : $("#all_email").val(),
										"username" : $("#all_username").val(),
										"userId" : $("#all_userId").val(),
									},
									success : function(msg) {
										if ( msg.code ==500) {
											$("body").mLoading("hide");//隐藏loading组件
											alert(msg.error);
										}
										if (msg.code == 404) {
											$("body").mLoading("hide");//隐藏loading组件
											alert(msg.reason);
										}
										if (msg.code == 200) {
											$("body").mLoading("hide");//隐藏loading组件

											// 清除企业和网邻通用户的子信息,防止下次查询表格字段冗余
											$("#enterpriseNameResult").remove();
											$("#isVerifiedBusinessResult")
													.remove();
											$("#enterpriseIdResult").remove();
											$("#enterpriseOrgCountResult")
													.remove();
											$("#enterpriseLevelCodeResult")
													.remove();

											$("#wltProductIdResult").remove();
											$("#wltStatusResult").remove();
											$("#wltOpenDateResult").remove();
											$("#wltEndDateResult").remove();

											if (msg.isEnterprise) {
												var enterpriseViewer = '<tr id="enterpriseNameResult"><td >企业名称:</td><td>'
														+ msg.enterpriseName
														+ '</td></tr><tr id="isVerifiedBusinessResult"><td>企业信息是否认证:</td><td>'
														+ (msg.isVerifiedBusiness ? '已认证'
																: '未认证')
														+ '</td></tr><tr id="enterpriseIdResult"><td >企业id:</td><td>'
														+ msg.enterpriseId
														+ '</td></tr><tr id="enterpriseOrgCountResult"><td >企业总人数:</td><td>'
														+ msg.enterpriseOrgCount
														+ '</td></tr><tr id="enterpriseLevelCodeResult"><td>所属企业层级:</td><td>'
														+ msg.enterpriseLevelCode
														+ '</td></tr>';
												$("#enterpriseDetail").after(
														enterpriseViewer);
											}
											$("#usernameResult").text(
													msg.username);
											$("#emailResult").text(msg.email);
											$("#realNameResult").text(
													msg.realName);
											$("#uidResult").text(msg.uid);
											$("#isLockedResult")
													.text(
															msg.isLocked ? "锁定"
																	: "未锁定");
											$("#verifiedEmailResult").text(
													msg.verifiedEmail ? "已认证"
															: "未认证");
											$("#verifiedmobileResult").text(
													msg.verifiedMobile ? "已认证"
															: "未认证");
											$("#verifiedRealNameResult")
													.text(
															msg.verifiedRealName ? "已认证"
																	: "未认证");
											$("#mobileResult").text(msg.mobile);
											$("#isEnterpriseResult").text(
													msg.isEnterprise ? "企业用户"
															: "个人用户");
											$("#isWLTResult").text(msg.isWLT);
											$("#registerTimeResult").text(
													msg.registerTime);
											$("#registerSourceResult").text(
													msg.registerSource);
											$("#cashBalanceResult").text(
													msg.freeCash+'元');
											$("#giftBalanceResult").text(
													msg.freeGift+'元');

											if (msg.wltInfoListResult.length > 0) {

												for (var i = 0; i < msg.wltInfoListResult.length; i++) {
													var serveCateResult = "";
													for (var j = 0; j < msg.wltInfoListResult[i].dispcateList.length; j++) {
														serveCateResult = serveCateResult
																+ msg.wltInfoListResult[i].dispcateList[j]
																+ serviceCategory[msg.wltInfoListResult[i].dispcateList[j]]
																+ ","
													}

													var wltViewer = '<tr id="wltProductIdResult" class="warning"><td>网邻通关联产品:</td><td>'
															+ msg.wltInfoListResult[i].productId
															+ '-'
															+ wltCategory[msg.wltInfoListResult[i].productId]
															+ '</td></tr><tr id="wltStatusResult"><td>网邻通用户状态:</td><td>'
															// +
															// msg.wltInfoListResult[i].state
															+ '服务中'
															+ '</td></tr><tr id="wltOpenDateResult"><td>开通时间:</td><td>'
															+ msg.wltInfoListResult[i].openDate
															+ '</td></tr><tr id="wltEndDateResult"><td>结束时间:</td><td>'
															+ msg.wltInfoListResult[i].endDate
															+ '</td></tr><tr id="dispcateListResult"><td>业务类别:</td><td>'
															+ serveCateResult
															+ '</td></tr>';

													$("#wltDetail").after(
															wltViewer);
													// $("#searchUserAllInfo").unbind();
												}

											}

										}
									},
									error : function(msg) {
										alert("未知错误")
									}
								});
					})

	$("#btnTest").click(function() {
		$("body").mLoading();
	});

})

// $("#searchUserBaseInfo").bind("click", function() {
// $.ajax({
// ContentType : 'application/json',
// url : '/searchUserBaseInfo',
// type : 'POST',
// data : {
// "base_mobile" : $("#base_mobile").val(),
// "base_email" : $("#base_email").val(),
// "base_username" : $("#base_username").val(),
// "base_userId" : $("#base_userId").val(),
// },
// success : function(result) {
// alert("result : " + result)
// if (result.code == 200) {
//
// }
//
// },
// error : function(errorMessage) {
//
// }
// })
// });

function demo() {

	alert($("#mobile").val());
}