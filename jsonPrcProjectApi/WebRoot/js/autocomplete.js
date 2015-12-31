function  autoCom(){
              
	var searchKey;
    var searchType;
    searchKey = $("form#searchBar  input.input").attr("value");
    searchType = $("div#multipleselect a").attr("class");
   	if(searchKey){   //判定文本框是否为空
           
		$.get("checksupPhone?phone=1", {keyword:searchKey,type:searchType}, function (data, textStatus){ //异步读取数据
           alert(data);
        	var  listLength;                                //li长度
            var currentList;              //选中li位置
                             
            currentList = -1 ;             //初始化为-1
            $("#searchSuggest  ul").html(data); //将异步读取内容显示到提示框中
                             
            listLength = $("#searchSuggest  ul li").length;
                             
           	if(listLength > 1){       //判断是否有返回内容
                             
            	$("#searchSuggest").show();       //显示提示框
            }else{
                $("#searchSuggest").hide();       //隐藏提示框
                             
            }
            $("#searchSuggest  ul li").hover(function(){  //定制提示框内滑动动作
                $("#searchSuggest  ul li").removeClass();//先清除样式 避免跟键盘冲突
                $(this).addClass("lihover");
                currentList = $("#searchSuggest  ul li").index(this)
            }, function(){
                $(this).removeClass("lihover");
                                     
            }).click(function(){   //定制提示框内点击动作
                var keywordContent; 
            	keywordContent=$(this).text();
                                
                $("form#searchBar  input.input").val(keywordContent);
                                       
                	$("#searchSuggest").hide(); 
                	$("form#searchBar").submit();     //提交搜索请求
                });  
                                 
                $(document).keydown(function(event){  //键盘响应函数
                    event = event || window.event;  //兼容多浏览器
                            
                    if(event.keyCode==38){         //监听上方向键
                                //alert("上");
                    	if(currentList < 1 ){  
                           	currentList=listLength - 1;
                                  
                        	$("#searchSuggest  ul li").removeClass();//先清除样式 避免冲突
                            $("#searchSuggest  ul li").eq(currentList).addClass("lihover");
                         }else{
                            currentList--;
                            $("#searchSuggest  ul li").removeClass();//先清除样式 避免冲突
                            $("#searchSuggest  ul li").eq(currentList).addClass("lihover");
                                
                         }
                     };
                     if(event.keyCode==40){                    //监听下方向键
                                
                         if(currentList <  (listLength - 1) ){
                             currentList++;
                             $("#searchSuggest  ul li").removeClass();//先清除样式 避免冲突
                             $("#searchSuggest  ul li").eq(currentList).addClass("lihover");
                                     
                         }else{
                             currentList=0;
                         	 $("#searchSuggest  ul li").removeClass();//先清除样式 避免冲突
                            $("#searchSuggest  ul li").eq(currentList).addClass("lihover");
                         }
                      }; 
                             
                      if(event.keyCode==13){               //监听回车键
                      		if($("#searchSuggest  ul li").length >0){
                            	keywordContent2= $("#searchSuggest  ul li").eq(currentList).text();
                                $("form#searchBar  input.input").val(keywordContent2);
                                $("#searchSuggest").hide(); 
                             
                       }else{
                                  
                          $("form#searchBar").submit();  
                                  
                       }
                   }  
                });      //键盘相应结束             
              });
                     
                     
                     
                     //end  get  function
                         
			$("body").click(function(){       //点击其他地方隐藏搜索建议提示框
			         $("#searchSuggest").hide(); 
			                                      
				});                      
			}else{
                    $("#searchSuggest").hide();
 
 　               　	};};
    
              
$(function(){
	$("form#searchBar  input.input").keyup(function(event){    //为搜索框加键盘事件监听
		if((event.keyCode!=38)&&(event.keyCode!=40)&&(event.keyCode!=13)){    //判断键盘事件，抛弃上下键跟回车键
	         autoCom();
	 　     }
	});
})
 //end autoCom