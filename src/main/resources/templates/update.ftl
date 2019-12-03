<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="application/javascript" src="../js/jQuery3.4.1.js"></script>
    <script src="https://cdn.bootcss.com/jquery.serializeJSON/2.9.0/jquery.serializejson.js"></script>
</head>
<body>

<div align="center">
    <div>
        <h1>CMS UPDATE</h1>
    </div>
    <form >
        <div class="_gap">
            <span>&nbsp;&nbsp;发布人&nbsp;：</span><input type="text" id="owner" name="owner" class="input_gap">
        </div>
        <div class="_gap">
            <span>&nbsp;&nbsp;&nbsp;&nbsp;内容&nbsp;&nbsp;&nbsp;：</span><input id="details" name="details" type="text">
        </div>
        <div class="_gap">
            <span>查看次数：</span><input type="text" id="view" name="view">
        </div>
        <div class="_gap">
            <span>&nbsp;&nbsp;&nbsp;&nbsp;只读&nbsp;&nbsp;&nbsp;：</span><input type="text" id="readOnly" name="readOnly">
        </div>
        <div class="_gap">
            <input type="button" class="submit_gap" value="提交"><input type="reset" class="reset_gap">
        </div>
    </form>
</div>
</body>
<style type="text/css">
    ._gap{
        margin-top: 30px;
    }
    .input_gap{
        margin-left: 3px;
    }
    .submit_gap{
        margin-right: 5px;
        background: deepskyblue;
    }
    .reset_gap{
        margin-left: 5px;
        background: red;
    }
</style>
<script type="application/javascript">
    $(".submit_gap").on("click",function () {
        $.ajax({
            url:"/cms/edit",
            type:"POST",
            data:JSON.stringify($('form').serializeJSON()),
            contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
            success:function(data){
                alert("成功");
            }
        });
    })
</script>
</html>