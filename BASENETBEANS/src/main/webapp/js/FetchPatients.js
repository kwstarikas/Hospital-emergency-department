/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function fetchPatients(){
    
    
    var data ={
        pid : $('#pid_input').val()
    }
    console.log("IN FETCH " + data.pid);
    
    $.ajax({
        type: "POST",
        url: "FetchPatientServlet",
        data: data,
        async: true,
        success: function(data) {
            console.log("Fetch patient"); 
            console.log(data);
            var patient = "";
            var i=0;
            
             //
            for( let prop in data ){
                console.log( data[prop] );
               patient += '<option selected >'+data[prop].toString()+'</option>'; 
            }
            //patient = data.i;
            console.log(patient)
            document.getElementById("FetchPatientDiv").innerHTML = '<label for="ExaminationPatient">Select Patient</label>'+
                                '<select id="ExaminationPatient" class="form-select">'+
                                '<option selected >Choose...</option>'+
                               patient+
                                
                              '</select>';
               
        },
        error: {
            400: function(data) {
                console.log("Error invalid AMKA");
            }
        }
    });
    
}