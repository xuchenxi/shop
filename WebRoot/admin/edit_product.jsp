<%@ page language="java" pageEncoding="UTF-8" %>
<%
	final String path = request.getContextPath();
	final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<!--[if lt IE 7 ]><html lang="en" class="ie6 ielt7 ielt8 ielt9"><![endif]-->
<!--[if IE 7 ]><html lang="en" class="ie7 ielt8 ielt9"><![endif]-->
<!--[if IE 8 ]><html lang="en" class="ie8 ielt9"><![endif]-->
<!--[if IE 9 ]><html lang="en" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<jsp:include page="top.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="row">
			<jsp:include page="left.jsp"></jsp:include>
			<div class="span9">
				<h1>修改商品</h1>
				<form id="uploadForm" class="form-horizontal"
					enctype="multipart/form-data">
					<fieldset>
						<div class="control-group">
							<label class="control-label" for="input01">商品所属二级分类</label>
							<div class="controls">
								<select name="cid">

								</select>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="input01">商品名称</label>
							<div class="controls">
								<input type="text" class="input-xlarge" id="pname" name="pname" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="input01">商品原价格</label>
							<div class="controls">
								<input type="text" class="input-xlarge" id="oldPrice"
									name="oldPrice" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="input01">商品新价格</label>
							<div class="controls">
								<input type="text" class="input-xlarge" id="newPrice"
									name="newPrice" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="fileInput">商品图片</label>
							<div class="controls">

								<input class="input-file" id="imageFile" multiple="multiple"
									name="imageFile" type="file" accept="image/*" />
							</div>
							<div class="controls" id="imgs"></div>
						</div>
						<div class="control-group">
							<label class="control-label" for="input01">商品库存</label>
							<div class="controls">
								<input type="text" class="input-xlarge" id="total" name="total" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="textarea">商品描述</label>
							<div class="controls">
								<textarea class="input-xlarge" id="pdesc" rows="4" name="pdesc"></textarea>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="optionsCheckbox">是否热门商品</label>
							<div class="controls">
								&nbsp;<input type="radio" name="isHot" id="isHot" value="1" />&nbsp;是&nbsp;
								&nbsp;<input type="radio" name="isHot" id="isHot" value="0"
									checked="checked" />&nbsp;否
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="optionsCheckbox">是否轮播图商品</label>
							<div class="controls">
								&nbsp;<input type="radio" name="isPic" id="isPic" value="1" />&nbsp;是&nbsp;
								&nbsp;<input type="radio" name="isPic" id="isPic" value="0"
									checked="checked" />&nbsp;否
							</div>
						</div>
						<div class="form-actions">
							<button type="button" class="btn btn-primary"
								onclick="javascript:modify()">修改</button>
							&nbsp;&nbsp;
							<button class="btn" onclick="javascript:history.back();">取消</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
var url = decodeURI(window.location.href);

var argsIndex = url .split("?pid=");
var arg = argsIndex[1];
console.log(arg);
var request = {
		pid : arg
}
	$(function() {
		getCategory("getCategories");
	});
	$.ajax({
		url:"getProductByPid",
		type:"post",
		data:request,
		dataType:"json",
		success:function(data){
			$("#pname").val(data.pname);
			$("#oldPrice").val(data.oldPrice);
			$("#newPrice").val(data.newPrice);
			$("#total").val(data.total);
			$("#pdesc").val(data.pdesc);
			$("input:radio[value=+"+data.is+"]").attr('checked','true');
			$("input:radio[isPic][value=+"+data.isPic+"]").attr('checked','true');
			$("input:radio[isHot][value=+"+data.isHot+"]").attr('checked','true');
		}
	});
	$(function() {
		//1、建立FckEditor的对象
		var ofckEditor = new FCKeditor("pdesc");
		//参数：是页面的TextArea的name属性
		//2、设定路径
		ofckEditor.BasePath = "../fckeditor/";

		//3、FckEditor的对象的属性（宽、高）
		ofckEditor.Height = 800;
		ofckEditor.Width = 530;
		//4、利用该FckEditor的对象替换掉页面的TextArea
		ofckEditor.ReplaceTextarea();

	});
	function modify(){
		//上传文件时，不能使用表单序列化的方式
		var params=new FormData($("#uploadForm")[0]);
		//将再现编辑器的内容取出来，放到FormData中去
		var oEditor=FCKeditorAPI.GetInstance("pdesc");
		var fcontent=oEditor.GetXHTML();
		params.set("pdesc",fcontent);
		params.set("pid", arg);
		//发送ajax请求
		$.ajax({
			url:"editProduct",
			type:"post",
			data:params,
			contentType:false,
			processData:false,
			success:function(data){
				if(data==1){
					alert("商品修改成功!");
					window.location.reload(true);
				}else{
					alert("商品修改失败!");
    			}
			}
		});
	}
</script>
</html>

