<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title></title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />
<style>
  header{
    position: relative;
    margin-bottom: 20px;
    display: block;
  }
  header h3,h4{
    display: inline-block;
    padding: 5px;
  }
  header h5{
    position: absolute;
    right: 12px;
    bottom: 12px;
    padding: 3px;
    vertical-align:text-top;
  }
  h5 img{
    width: 25px;
    height: 25px;
    margin-bottom: 2px;
  }
  #main,header{
    border-left: 1px dashed gray;
    border-right: 1px dashed gray;
  	box-shadow: 2px 2px 2px black;
  }
  .pull1{
    width:50px;
    height:130px;
  }
  .pull2{
    height: 150px;
  }
  article{
    margin-top: 13px;
    padding: 20px;
  }
  ul{
  	
	list-style-type:none;
	-moz-column-count: 3;
	-webkit-column-count: 3;
	-moz-column-gap: 2em;
	-webkit-column-gap: 2em;
	-moz-column-rule: 1px solid red;
	-webkit-column-rule: 1px solid red;
	text-align:center;
 }
 ul li{
    padding: 5px;
 }
 ul, menu, dir {
    -webkit-padding-start: 0px;
    -moz-padding-start: 0px;
    -webkit-padding-end: 0px;
    -moz-padding-end: 0px;
 }
 .li{
 	background-color: pink;
 }
 #sections{
 	height: auto;
 	display: -moz-box;
 	display: -webkit-box;
 	-moz-box-align: center;
 	-webkit-box-align: center;
 	-moz-box-pack: center;
 	-webkit-box-pack: center;
 }
 #name,#form1,#form2,#form3{
 	padding: 13px;
 	text-align:left;
 }
 #form1,#form2,#form3{
 	border: 1px solid gray;
 	box-shadow: 2px 2px 2px black;
 	width: 400px;
 }
 #name *,#form1 *,#form2 *,#form3 *{
 	margin-right: 10px;
 	margin-bottom: 13px;
  }
 #model2,#model3{
 	display: none;
 }
</style>
<!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
</head>
<body class="row" onload="initGuitars()">
  <div class="col-lg-2 col-md-1 col-xs-0"></div>

  <div class="col-lg-8 col-md-10 col-xs-12" id="main">
    <header>
      <h3><img src="images/header.png" alt="GUITAR之家" /></h3>
       <h3><img src="images/header2.png" alt="GUITAR之家" /></h3>
      <h5>
        <a href="javascript:void(0)">登录 |</a>
        <a href="javascript:void(0)"> 注册  </a>
      </h5>  
    </header>
    <div style="display:inline-block;position: absolute;top:0px;right:-50px;">
      <img src="images/pull.png" alt="试着拖拽我"  id="pull" class="pull1"/>
    </div>
    <article class="row"  style="height:auto;">
    	<ul id="ul">
				<li id="ul_item1" class="li">搜索guitar</li>
				<li id="ul_item2">编辑/删除guitar</li>
				<li id="ul_item3">添加新的guitar</li>
		</ul>
		<br/>
		<section id="sections">
			<section id="model1">
				<form id="form1">
				  <div id="characters1" class="input">				    
					<div><label>builder：</label><input type="text" name="guitarSpec.builder"/></div>
					<div><label>model：</label><input type="text" name="guitarSpec.model"/></div>
					<div><label>type：</label><input type="text" name="guitarSpec.type"/></div>
					<div><label>backWood：</label><input type="text" name="guitarSpec.backWood"/></div>
					<div><label>topWood：</label><input type="text" name="guitarSpec.topWood"/></div>	
				  </div>
					<span class="btn btn-info" style="float:right;" onclick="searchGuitars()"><span class="glyphicon glyphicon-search"></span>搜索</span>
				</form>			
			</section>
			<section id="model2">
			    <table class="table table-striped table-bordered table-hover" id="data">
					<tr>
						<th>index</th>
						<th>serialNumber</th>
						<th>price</th>
						<th>builder</th>
						<th>model</th>
						<th>type</th>
						<th>backWood</th>
						<th>topWood</th>
						<th>操作</th>
					</tr>
					<tr>
						<td>1</td>
						<td>11277</td>
						<td>3999.95</td>
						<td>Collings</td>
						<td>CJ</td>
						<td>acoustic</td>
						<td>Indian Rosewood</td>
						<td>Sitka</td>
						<td>编辑  | <span onclick="deleteGuitar()"></删除></td>
					</tr>
				</table>
			</section>
			<section id="model3">
				<form id="form3">
				  <div id="characters3" class="input">
				    <div><label>serialNumber：</label><input type="text" name="guitar.serialNumber"/></div>
				    <div><label>price：</label><input type="text" name="guitar.price"/></div>				    
					<div><label>builder：</label><input type="text" name="guitar.builder"/></div>
					<div><label>model：</label><input type="text" name="guitar.model"/></div>
					<div><label>type：</label><input type="text" name="guitar.type"/></div>
					<div><label>backWood：</label><input type="text" name="guitar.backWood"/></div>
					<div><label>topWood：</label><input type="text" name="guitar.topWood"/></div>	
				  </div>
					<span class="btn btn-info" style="float:right;" onclick="addGuitar()"><span class="glyphicon glyphicon-ok"></span>保存</span>
				</form>
			</section>
	   </section>
    </article>
    <div id="Searchresult">
				
	</div>
  </div>

  <div class="col-lg-2 col-md-1 col-xs-0"></div>

	<script type="text/javascript" src="js/jquery-2.2.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$("ul li").each(function(index){
		var ele = $("#ul_item" + (index+1));
		ele.click(function(){
			$(this).addClass("li");
			$(this).siblings().removeClass("li");
			var id = $(this).attr("id");
			var secIndex = id.substring(id.length-1);
			var section = $("#model" + secIndex);
			section.show();
			section.siblings().hide();
			if(index > 0){
				$("#Searchresult").hide();
			}else{
				$("#Searchresult").show();
			}
		})		
	});
	function searchGuitars(){
	  $("#Searchresult").empty();
	  $.post("guitar/search_searchGuitar", $("#form1").serialize(),
	      function(data, statusText) {          
	        json=data;  
	        var jsonData = eval(json);	       
	        $.each(jsonData,function(i,n){  
	        	$("#Searchresult").append("<div class='col-xs-6 col-md-3'><a href='#' class='thumbnail'><img src='images/guitar.jpg' style='height: 180px; width: 100%; display: block;'></a><div class='caption'>" + "builder: " + n.builder + "<br/>serialNumber:" +  n.serialNumber + "<br/>model:" +  n.model + "<br/>type:" +   n.type + "<p>" + " price:" +  n.price + "<br/>backWood:" +  n.backWood + "<br/>topWood:" +n.topWood + "</p></div></div>");        
	           });
	  	  }); 
	   }

	function addGuitar(){
		  $.post("guitar/search_addGuitar", $("#form3").serialize(),
		      function(data, statusText) { 
			    initGuitars();        
			    console.log(data);
		        console.log(statusText);
		  	  }); 
	}

	function initGuitars(){
		$("#data").empty().append("<tr><th>serialNumber</th><th>price</th><th>builder</th><th>model</th><th>type</th><th>backWood</th><th>topWood</th><th>操作</th></tr>");	
		$.post("guitar/search_loadGuitars",
		 	function(data, statusText) { 
			 	json=data;  
		        var jsonData = eval(json);	       
		        $.each(jsonData,function(i,n){
		        	$("#data").append("<tr><td>" + n.serialNumber + "</td><td>" + n.price + "</td><td>" + n.builder + "</td><td>" + n.model + "</td><td>" + n.type + "</td><td>" + n.backWood + "</td><td>" + n.topWood + "</td><td>编辑  | <span onclick='deleteGuitar(" + n.serialNumber + ")'>删除</span></td></tr>")
			    });		        
			}); 
	}

	function deleteGuitar(serialNumber){
		alert(serialNumber);
		  $.post("guitar/search_deleteGuitar",{'serialNumber': serialNumber},
		      function(data, statusText) { 
			  	initGuitars();       
		        console.log(data);
		        console.log(statusText);
		  	  }); 
	}
  </script>
</body>
</html>