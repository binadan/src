
	
	//检查权限
	function hasPermission(className,userId,resourceSn,permission){
		
		$.post("hasPermission?userId="+userId+"&resourceSn="+resourceSn+"&permission="+permission,null,function(resultData){
			
			var result = eval(eval("("+resultData+")"));
				
			if(result){
				//$('.'+className).css({"display":"block"});
			}else{
				$('.'+className).css({"visibility":"hidden"});
			}
		  		
		})
			
	}
	
	