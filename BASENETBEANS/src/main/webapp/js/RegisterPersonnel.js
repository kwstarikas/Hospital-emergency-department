/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function registerPersonnel(){
    
    console.log("in register Personnel");
    
    var data = {
        Name: $("#doctorName").val(),
        Surname : $('#doctorSurname').val(),
        Address : $('#doctorAddress').val(),
        Birthdate : $('#doctorBirthday').val(),
        //Licence : $('#amka').val(),
        Phone : $('#doctorCellphone').val(),
        Sex : $('#doctorSex').val(),
        Extra: $('#PersonnelType').val(),
        ExtraVal: $('#ExtraPersonnelType').val()
    };
    
    
    $.ajax({
        type: "POST",
        url: "RegisterPersonnelServlet",
        data: data,
        async: true,
        success: function(data) {
            if (data.Valid){
                console.log("Personnel added");
                console.log(data);

                document.getElementById("PatientInfoLogin").style.display = "none";
                document.getElementById("ShowPersonnelINFO").style.display = "none";
                document.getElementById("PersonnelInfoCard").style.display = "block"; 

                document.getElementById("ExtraInfo").innerHTML = data.Extra;
                document.getElementById("Personnelname").innerHTML = data.First_Name;
                document.getElementById("Personnelsurname").innerHTML = data.Last_Name;
                document.getElementById("PersonnelAddress").innerHTML = data.Address;
                document.getElementById("PersonnelBirthDate").innerHTML = data.Birthdate;
                document.getElementById("Personnelcellphone").innerHTML = data.Phone;
                document.getElementById("PersonelSex").innerHTML = data.Phone;
                document.getElementById("PersonnelExtraInfo").innerHTML = data.ExtraVal;
            
                if (data.Type.locale("Doctor")){
                    
                }
                else if (data.Type.locale("Doctor")){
                    document.getElementById("ShowShiftCard").style.display = "block";
                    
                }else if (data.Type.locale("Doctor")){
                    document.getElementById("ShowExaminationCard").style.display = "block";
                }
            
            
            }
            
        },
        error: {
            400: function(data) {
                console.log("Error invalid Licence");
            }
        }
    });
}