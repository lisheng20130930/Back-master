function Ajax(option,success,error){	    
	    var url=option.urlStr;
	    var type=option.ajaxType;
	    var data=option.ajaxData;
	    var xhrRequest=null;
	    if(window.XMLHttpRequest){
	        xhrRequest = new XMLHttpRequest();
	    } else {
	        xhrRequest = new ActiveXObject('Microsoft.XMLHTTP')
	    }
	    var str="";	    
	    xhrRequest.open(type,url,true);

	    if(type==="POST"&&data!=null){
	        xhrRequest.setRequestHeader("Content-type", "application/json;charset=utf-8");
	　　　　str=JSON.stringify(data);
	    }else{
	　　　　str=null;
	    }
	    xhrRequest.onreadystatechange=function(){
	        if(xhrRequest.readyState==4){
	            if(xhrRequest.status==200){
	                var responseData=JSON.parse(xhrRequest.responseText);                
	                success(responseData);
	            }else{
	            	error(xhrRequest.status);
	            }
	        }
	    }
	    xhrRequest.send(str);
	}