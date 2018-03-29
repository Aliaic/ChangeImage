<%--
  Created by IntelliJ IDEA.
  User: yuchao.liang
  Date: 2017/8/21
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bootstrap 101 Template</title>
  <link href="./css/upload.css" rel="stylesheet">
  <!-- Bootstrap -->
  <link href="./dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="./css/upload.css" type="text/css" />
  <link rel="stylesheet" href="./css/iconfont.css">
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!在移动设备上显示的更自然-->
  <!--<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">-->


</head>
<body>


<ul class="nav nav-tabs" role="tablist" id="myTab">
  <li role="presentation" class="active">
    <a href="#builddata"  role="tab" data-toggle="tab" >造数据<i class="iconfont">&#xe62e;</i></a>
  </li>

</ul>
<!-- Tab panes -->
<div class="tab-content">
  <div role="tabpanel" class="tab-pane fade in active" id="builddata">
    <form  id="form1" class="navbar-form navbar-left" role="form" style="line-height: 200%">
      <p id="test-error" style="color:red"></p>
      <div class="form-group">
        <input type="file" id="inputfile">

      </div>

      <div class="list-inline">
        <label>尺寸选择:</label>
        <!--  <label class="radio-inline">
              <input type="radio" name="radio" id="radio1" value="radio1" checked>尺寸
          </label> -->

        <div class="form-group">
          <input type="text" class="form-control" name="standard" id="standard" value="" placeholder="水平像素">
          <input type="text" class="form-control" name="vertical" id="vertical" value="" placeholder="垂直像素">
        </div>
        <div class="list-inline select">

          <p> <input type="checkbox"  name="checkbox_v1" value="version1" onclick="allSelect('checkbox_v1', 'format')">常用格式</p>
          <ul>

            <label>
              <input name="format" type="checkbox"  value="jpg" onclick="singleSelect2parent('checkbox_v1', 'format')" />jpg </label> <label>
            <input name="format" type="checkbox"  value="gif" />gif</label>
            <label><input name="format" type="checkbox" value="jpeg"onclick="singleSelect2parent('checkbox_v1', 'format')" />jpeg </label>
            <label><input name="format" type="checkbox" value="bmp" onclick="singleSelect2parent('checkbox_v1', 'format')"/>bmp </label>	<label><input name="format" type="checkbox" value="png" onclick="singleSelect2parent('checkbox_v1', 'format')"/>png</label>
            <label><input name="format" type="checkbox" value="webp"onclick="singleSelect2parent('checkbox_v1', 'format')" />webp </label>
          </ul>

          <!--<p>select：5个值里面选择1个；-->
          <!--datalist：你可以在文本框里填值，也可以在下面5个值里选1个。</p>-->
        </div>

        <button class="btn btn-default" type="button" id="saveData">保存</button>
    </form>
  </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="./dist/js/bootstrap.min.js"></script>
<script src="./dist/js/plupload.full.min.js"></script>

<script type="text/javascript" src="./js/upload.js"></script>
<script type="text/javascript" src="./js/data.js"></script>

</body>
</html>