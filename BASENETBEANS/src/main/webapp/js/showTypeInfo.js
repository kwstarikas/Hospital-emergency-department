/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




function showType(){
    
    var type = document.getElementById("PersonnelType").value; 
    console.log(type);
    var doc = "Doctor";
    var nurse = "Nurse"; 
    var admin = "Administrative stuff";
    
    
    if (!type.localeCompare(doc)) {
        
        document.getElementById("ExtraPersonnelTypeLabel").innerHTML = 'Specialization';
        document.getElementById("ExtraInfoDiv").style.display = "block";
    }
    else if (!type.localeCompare(nurse)){
        document.getElementById("ExtraPersonnelTypeLabel").innerHTML = 'Expertise';
        document.getElementById("ExtraInfoDiv").style.display = "block";
    }
    else if (!type.localeCompare(admin)){
        document.getElementById("ExtraPersonnelTypeLabel").innerHTML = 'Years of Servise';
        document.getElementById("ExtraInfoDiv").style.display = "block";
    }
    
    
    
}