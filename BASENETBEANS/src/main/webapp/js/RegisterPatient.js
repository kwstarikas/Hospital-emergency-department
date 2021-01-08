/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function registerPatient(){
    console.log("in add sympotm");
    var data = {
        Name: $("#patientName").val(),
        Surname : $('#patientPassword').val(),
        Address : $('#patientAddress').val(),
        Insurance : $('#insurance').val(),
        AMKA : $('#amka').val(),
        Phone : $('#patientCellphone').val(),
        CronicDiseases : $('#chronicdiseases').val()
        
    };
    
    
    
    console.log(data); 

    $.ajax({
        type: "POST",
        url: "RegisterPatientServlet",
        data: data,
        async: true,
        success: function(data) {
            console.log("Patient added");
        },
        error: {
            400: function(data) {
                console.log("Error invalid AMKA");
            }
        }
    });

}
