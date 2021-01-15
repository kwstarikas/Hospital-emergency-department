/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function submitQuery(){
    
    data = {
      query : $('#AbstractQuery').val()
    };
    
   
    $.ajax({
        type: "POST",
        url: "SubmitAbstractQueryServlet",
        data: data,
        async: true,
        success: function(data) {
           
           var result = "";
           
           var res = '<div class="row">' 
                + '<div class="col-4" >'
                + '<ul class="list-group">';
           for (let prop in data){
               result += '<li class="list-group-item list-group-item-primary">'
                + data[prop]
                + '</li>';
                
           }
           res = res + result ;
           
           document.getElementById("AbstractQueryRes").innerHTML = res + '</ul> </div></div>';
           
           
           
        },
        error: {
            400: function(data) {
                alert("ERROR QUERY");
            }
        }
    });
   
   
}