/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function addSymptom(){
    console.log("in add sympotm");
    var data = {
        symptom: $("#patientSymptom").val(),
        amka : $('#amka_input').val()
    };
    
    $.ajax({
        type: "POST",
        url: "AddSymptomServlet",
        data: data,
        async: true,
        success: function(data) {
            console.log("Symptom added");
            document.getElementById("DoctorToSee").innerHTML = data.DOC;
           // document.getElementById("ShowExaminationButton").style.display = "block";
               
        },
        error: {
            400: function(data) {
                console.log("Error invalid AMKA");
            }
        }
    });

}
