/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function addPrevVisit(){
    
    data = {
       amka : $('#ExaminationAMKA').val(), 
       ExaminationID : $('#ExaminationID').val(), 
       ExaminationDate : $('#ExaminationDate').val(), 
       ExaminationType : $('#ExaminationType').val(), 
       PrescribedCure : $('#PrescribedMedicine').val(), 
       Diagnosis : $('#DiagnosisResult').val()
       
    }; 
    
    console.log(data);
    
    
    
     $.ajax({
        type: "POST",
        url: "AddPreviousVisitServlet",
        data: data,
        async: true,
        success: function(data) {
            
            alert("Previous Visit added"); 
            
        },
        error: {
            400: function(data) {
                console.log("Error invalid AMKA");
            }
        }
    });
    
    
    
    
}