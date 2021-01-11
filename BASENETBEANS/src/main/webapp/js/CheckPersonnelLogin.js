/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function PersonnelLogin(){
     console.log("in Personel Login");
    var data = {
        pid: $("#pid_input").val()
    };
    console.log(data);
    $.ajax({
        type: "POST",
        url: "LoginPersonnelServlet2",
        data: data,
        async: true,
        success: function(data) {
            if (data.Exists) {
                
                console.log(data);
                document.getElementById("PersonnelInfoCard").style.display = "block";
                document.getElementById("ShowPersonnelINFO").style.display = "none";
                document.getElementById("PatientInfoLogin").style.display = "none";
                
                if (data.Type === 0){
                    console.log("IS DOCTOR");
                    document.getElementById("ShowExaminationCard").style.display = "block";
                    document.getElementById("ExtraInfo").innerHTML = 'Specialization';
                    
                }
                    
                else if (data.Type === 1){
                    document.getElementById("ExtraInfo").innerHTML = 'Expertise';
                }
                    
                else {
                    document.getElementById("ShowShiftCard").style.display = "block";
                    document.getElementById("ExtraInfo").innerHTML = 'Years of Service'
                }


                document.getElementById("Personnelname").innerHTML = data.First_Name;
                document.getElementById("Personnelsurname").innerHTML = data.Last_Name;
                document.getElementById("PersonnelAddress").innerHTML = data.Address;
                document.getElementById("PersonnelBirthDate").innerHTML = data.Birthdate;
                document.getElementById("PersonnelPID").innerHTML = data.PID;
                document.getElementById("Personnelcellphone").innerHTML = data.Phone;
                document.getElementById("PersonelSex").innerHTML = data.Sex;
                document.getElementById("PersonnelExtraInfo").innerHTML = data.Extra;
                
            
            }
                

        },
        error: {
            400: function(data) {
                console.log("Error invalid AMKA");
            }
        }
    });

}

function fetchPatients(){
    
    var data = {
        pid  : $('#pid_input')
    };
    console.log("In Fetch Patient" + data.pid);
    
//    $.ajax({
//        type: "POST",
//        url: "FetchPatientServlet",
//        data: data,
//        async: true,
//        success: function(data) {
//            console.log("Fetch patient"); 
//            conslole.log(data);
//            
//               
//        },
//        error: {
//            400: function(data) {
//                console.log("Error invalid AMKA");
//            }
//        }
//    });
    
}