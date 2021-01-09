/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




function checkPatientLogin() {
    console.log("in Check Login");
    var data = {
        amka: $("#amka_input").val()
    };

    console.log(data.amka);
    $.ajax({
        type: "POST",
        url: "LoginPatientServlet",
        data: data,
        async: true,
        success: function(data) {
            if (data.Exists) {
                
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
                document.getElementById("DoctorToSee").innerHTML = '-';
                
                if (data.ChronicDisease != false){
                     document.getElementById("PatientchronicDisease").innerHTML = data.ChronicDisease;
                     document.getElementById("PatientchronicDiseaseDD").innerHTML = data.DiagnosisDate;
                     
                }
                else {
                    document.getElementById("PatientchronicDisease").innerHTML = '-';
                    document.getElementById("PatientchronicDiseaseDD").innerHTML = '-';
                }
                
                if (data.Has_Prev_visit) {
                    document.getElementById("ShowPreviousVisitINFO").style.display = "block";
                    document.getElementById("PreviousVExaminationID").innerHTML = data.ExaminationID;
                    document.getElementById("PreviousVDate").innerHTML = data.Date;
                    document.getElementById("PreviousVDiagnosis").innerHTML = data.Diagnosis;
                    document.getElementById("PreviousVExamination").innerHTML = data.Examination;
                    document.getElementById("PreviousVCure").innerHTML = data.Cure;
                }
            } else {
                console.log("Patient Not Found");
                document.getElementById("ShowInvalidLogin").innerHTML = 'Invalid AMKA';
                document.getElementById("ShowInvalidLogin").style.color = 'red';
            }

        },
        error: {
            400: function(data) {
                console.log("Error invalid AMKA");
            }
        }
    });

}



function hide(){
    document.getElementById("PatientInfoCard").style.display = "none";
    document.getElementById("ShowPreviousVisitINFO").style.display = "none";
    document.getElementById("AddPatientSympom").style.display = "none";
    document.getElementById("PersonnelInfoCard").style.display = "none";
}