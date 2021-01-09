/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function registerPatient(){
    console.log("in reg Patient");
    var data = {
        Name: $("#patientName").val(),
        Surname : $('#patientPassword').val(),
        Address : $('#patientAddress').val(),
        Insurance : $('#insurance').val(),
        AMKA : $('#amka').val(),
        Phone : $('#patientCellphone').val(),
        CronicDiseases : $('#chronicdiseases').val(),
        ChronicDiseaseDate : $('#ChronicDiseaseDate').val()
        
    };
    console.log(data);
    
    $.ajax({
        type: "POST",
        url: "RegisterPatientServlet",
        data: data,
        async: true,
        success: function(data) {
            console.log("KOMPLE TO REGISTER");
//           
            document.getElementById("AddPatientSympom").style.display = "block";
            document.getElementById("PatientInfoCard").style.display = "block";

            document.getElementById("PatientInfoLogin").style.display = "none";
            document.getElementById("ShowPersonnelINFO").style.display = "none";

            document.getElementById("Patientname").innerHTML = data.First_Name;
            document.getElementById("Patientsurname").innerHTML = data.Last_Name;
            document.getElementById("Patientaddress").innerHTML = data.Address;
            document.getElementById("Patientinsurance").innerHTML = data.Insurance;
            document.getElementById("Patientamka").innerHTML = data.AMKA;
            document.getElementById("Patientcellphone").innerHTML = data.Phone;
            document.getElementById("PatientchronicDiseaseDD").innerHTML = data.ChronicDate;
            document.getElementById("PatientchronicDisease").innerHTML = data.Chronic;
             document.getElementById("DoctorToSee").innerHTML = '-';
           
        },
        error: {
            400: function(data) {
                console.log("Error invalid AMKA");
            }
        }
    });

}
