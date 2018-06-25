<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>  
    <script type="text/javascript" src="js/jquery.min.js"></script>  
</head>	
<body>
	<!-- 具体请求是   http://localhost:8080/mymvc/requestParam?name=hepei&age=25 -->
	<h1>@RequestParam的例子</h1>
    <h2>${name}</h2>
    <h2>${age}</h2>
    
    <!-- 具体请求是 由ajax.jsp中的发出的 -->
	<h1>@RequestBody的例子</h1>
   <label for="username">username:<input type="text" id="username"/></label>  
   <label for="password">password:<input type="text" id="password"/></label> 
   <label>提交:<input type="button" id="submit"/></label>
   <label>提交1:<input type="button" id="requestBody"/></label>
   
   <h2>user:${username}</h2>
   <h2>password:${password}</h2>
   
   <h1>@PathVariable的例子1</h1>
   <h2>${pathVariable1}</h2>
   <h2>${pathVariable2}</h2>
   
   <!-- 具体请求是   http://localhost:8080/mymvc/PathVariable/pathVariable1/param1/pathVariable2/param2 -->
   <h1>@PathVariable的例子2</h1>
   <h2>${param1}</h2>
   <h2>${param2}</h2>
   
   
    
   <h1>@ResponseBody的例子</h1>
   <h3>具体请求是 ：  http://localhost:8080/mymvc/responseBody </h3>
    <script>  
    $("#requestBody").on("click",function(){  
    	//下面这两个属性
        var username=$("#username").val();
        var password=$("#password").val();
        var user = {"name":username,"password":password};
        
        $.ajax({  
            type:"POST",//type可以为post也可以为get  
            url:"requestBody",  
            data:JSON.stringify(user),//这行不能省略，如果没有数据向后台提交也要写成data:{}的形式  
            dataType:"json",//这里要注意如果后台返回的数据不是json格式，那么就会进入到error:function(data){}中 
            contentType:"application/json"
        });
    })  
    
    
    $("#submit").on("click",function(){  
        var username=$("#username").val();
        var password=$("#password").val();
        if(username!=undefined&&username.length>0){  
        	var user = {"name":username,"password":password};
            $.ajax({  
                type:"POST",//type可以为post也可以为get  
                url:"requestBody",  
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