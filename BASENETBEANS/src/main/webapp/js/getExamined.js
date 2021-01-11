/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getExamined(){
    console.log("in Get Examined");
    var data = {
       symptom : $('#patientSymptom').val(), 
       amka :  $('#amka_input').val(),
       doctor : $('#DoctorToSee').val()
    };
    
      $.ajax({
        type: "POST",
        url: "getExaminedServlet",
        data: data,
        async: true,
        success: function(data) {
            console.log("GET EXAMINED FINE "); 
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

