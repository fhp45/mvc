<%@ page contentType="text/html;charset=UTF-8" language="java" %>  
<html>  
<head>  
    <%  
        String path=request.getContextPath();  
    %>  
    <title></title>  
    <script type="text/javascript" src="js/jquery.min.js"></script>  
    <style>  
        #username-info{  
            display: none;  
            border: none;  
        }  
        label{  
            display: block;  
            margin-top: 3px;  
        }  
    </style>  
</head>  
<body>  
<form id="myForm">  
    <label for="username">username:<input type="text" id="username"/><input type="text" id="username-info"/></label>  
    <label for="password">password:<input type="text" id="password"/></label>  
    <label>提交:<input type="button" id="submit"/></label>
</form>
<script>  
  
    $("#submit").on("click",function(){  
        var username=$("#username").val();
        var password=$("#password").val();
        if(username!=undefined&&username.length>0){  
        	var user = {"name":username,"password":password};
            $.ajax({  
                type:"GET",//type可以为post也可以为get  
                url:"ajax",  
                data:JSON.stringify(user),//这行不能省略，如果没有数据向后台提交也要写成data:{}的形式  
                dataType:"json",//这里要注意如果后台返回的数据不是json格式，那么就会进入到error:function(data){}中 
                contentType:"application/json",
                success:function(data){  
                    $("#username-info").css("display","block");  
                    if(data.availiable==="0"){  
                        $("#username-info").css("color","green");  
                    }else{  
                        $("#username-info").css("color","red");  
                    }  
                    $("#username-info").val(data.info);  
                },  
                error:function(data){  
                    alert("用户名提交出现了错误！");  
                }  
            });  
        }else{  
            alert("用户名不能为空！")  
            return false;  
        }  
    })  
</script>  
</body>  
</html> 