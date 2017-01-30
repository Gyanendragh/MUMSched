	var contextRoot = "/" + window.location.pathname.split( '/' )[1];

function categorySubmit(){
   	var dataToSend = JSON.stringify(serializeObject($('#categoryForm')));
   	 $.ajax({
		type: 'POST',
		url: contextRoot + '/categories/add',
		dataType: "json",           // Accept header
 		data:dataToSend,
 		contentType: 'application/json',   // Sends - Content-type
		success: function(category){
			var x = document.getElementById("category.categoryId");
		    var option = document.createElement("option");
		    option.text = category.name;
		    option.value = category.categoryId;
		    
		    x.add(option);
		    x.value = category.categoryId;
		    
			$('#errors').html("");
			$("#success").append( '<H3 align="center">Create Category successful!!! <H3>');                
	 	    //$('#result').show();
		},
 
		error: function(errorObject ){				
			if (errorObject.responseJSON.errorType == "ValidationError") {
	 			$('#success').html("");
	 			$('#errors').html("");
	 			$("#errors").append( '<H3 align="center"> Error(s)!! <H3>');                
	  			    $("#result").append( '<p>');
	  			    
	  			    var errorList = errorObject.responseJSON.errors;
	 	 	        $.each(errorList,  function(i,error) {			   
	 		    		$("#errors").append( error.message + '<br>');
			    	});
	 	 	        $("#errors").append( '</p>');
	 	 	        $('#result').show();
			}
			else {
				alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
			}
 		}
	});
}

 
resetForm = function(id) {
    var element = document.getElementById(id);
    $(element)[0].reset();
    $("#success").html("");
}	  
	


make_hidden = function(id) {
    var e = document.getElementById(id);
        e.style.display = 'none';
        }	   

make_visible = function(id) {
    var e = document.getElementById(id);
    e.style.display = 'block';
 }	   

// Translate form to array
// Then put in JSON format
 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

};


 