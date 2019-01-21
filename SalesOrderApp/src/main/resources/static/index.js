
    	debugger;
    	
    	
    	
        
    	
    	var break1=document.createElement("BR");
    	var break2=document.createElement("BR");
    	document.body.appendChild(break1);
    	document.body.appendChild(break2);
    	
    	
    	var table = document.createElement("TABLE");
  	  table.setAttribute("id", "myTable");
  	  document.body.appendChild(table);

  	  var header = table.createTHead();
  	  
  	  var row = header.insertRow(0);
  	  row.setAttribute("id","TableHead")
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        
      cell1.innerHTML = "ORDER ID";
        cell2.innerHTML = "CUSTOMER ID";
        cell3.innerHTML="PRODUCT CODE";
        cell4.innerHTML="QUANTITY";
        cell5.innerHTML="TOTAL PRICE";
  	 
        var xmlhttp = new XMLHttpRequest();
  	 
  	xmlhttp.onreadystatechange = function()
  	{
  	    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
  	    {
  	        //Use parse() method to convert JSON string to JSON object
  	        //console.log(responseText);
  	        
  	        
  	        var jsonobj = JSON.parse(this.responseText);
  	    	//document.getElementById("allcustomer").innerHTML = this.responseText;
  	    	
  	    	for (let i = 0; i < jsonobj.length; i++) {
  	        const item=jsonobj[i];
  	     
  	        var table = document.getElementById("myTable");
  	        
  	        
  	        var row = table.insertRow(-1);
  	        var cell1 = row.insertCell(0);
  	        var cell2 = row.insertCell(1);
  	        var cell3 = row.insertCell(2);
  	      var cell4 = row.insertCell(3);
  	    var cell5 = row.insertCell(4);
  	        
  	      cell1.innerHTML = item.orderid;
  	        cell2.innerHTML = item.customer.id;
  	        cell3.innerHTML=item.product.pcode;
  	      cell4.innerHTML=item.quantity;
  	    cell5.innerHTML=item.totalprice;
  	    	}
  	        
  	       // document.getElementById("list").innerhtml = item.id;
  	    	
  	    	
  	    }
  	};
  	 
  	xmlhttp.open("GET", "http://localhost:8080/sales/getall", true);
  	 
  	xmlhttp.send();
 
      