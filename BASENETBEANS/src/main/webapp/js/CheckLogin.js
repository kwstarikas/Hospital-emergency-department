/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function testRedirection() {
    amka = document.getElementById("amka_input").value;
    console.log("Entered testRedirection");
    console.log("AMKA =", amka);
    if (amka === "123123") {
        window.location = "pages/patient.html";
    }
}

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
                console.log(data);
                //window.location.replace("pages/patient.html");
                if (data.Has_Prev_visit) {}
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