/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function createExamination(){
     console.log("in Create Examination")
         
         
         
     var ext = document.getElementById("ExaminationPatient").value;
    
    
    var data = {
      patient : $('#ExaminationPatient').val(), 
      examType : $('#ExaminationKind').val(), 
      date : $('#ExaminationDate').val()
    };
     
     console.log(data.patient);
         
         
    
     $.ajax({
        type: "POST",
        url: "CreateExaminationServlet",
        data: data,
        async: true,
        success: function(data) {
            console.log("Create eXAMINATION FINE "); 
            document.getElementById("ShowDiagnosisCard").style.display = "block";
             document.getElementById("DiagnosisResult").innerHTML = data.Disease;
              document.getElementById("PrescribedMedicine").innerHTML = data.Medicine;
            
        },
        error: {
            400: function(data) {
                console.log("Error invalid AMKA");
            }
        }
    });
    
    
}