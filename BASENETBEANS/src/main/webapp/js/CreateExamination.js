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
            console.log(data);
            console.log("Create eXAMINATION FINE "); 
            document.getElementById("ShowDiagnosisCard").style.display = "block";
            //to print
            document.getElementById("DiagnosisResult").innerHTML = data.Disease;
            document.getElementById("DiagnosisResult").value = data.Disease;
            document.getElementById("PrescribedMedicine").innerHTML = data.Medicine;
            document.getElementById("PrescribedMedicine").value = data.Medicine;
          
            //to add 
            document.getElementById("ExaminationAMKA").innerHTML = data.AMKA;
             document.getElementById("ExaminationAMKA").value = data.AMKA;
            document.getElementById("ExaminationDate").innerHTML = data.DATE;
             document.getElementById("ExaminationDate").value = data.DATE;
            document.getElementById("ExaminationType").innerHTML = data.EXAMTYPE;
             document.getElementById("ExaminationType").value = data.EXAMTYPE;
            document.getElementById("ExaminationID").innerHTML = data.ExamID;
             document.getElementById("ExaminationID").value = data.ExamID;
            console.log("TO DATE EINAI " + document.getElementById("ExaminationID").value);
            
            
        },
        error: {
            400: function(data) {
                console.log("Error invalid AMKA");
            }
        }
    });
    
    
}