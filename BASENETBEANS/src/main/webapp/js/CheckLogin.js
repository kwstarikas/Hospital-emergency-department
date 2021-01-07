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
                console.log(data);
                var userList = '<ul class=\"list-group\">' +
                    '<li class=\"list-group-item\"> ' + '<br>AMKA : ' + data.AMKA +
                    '<br>First Name : ' + data.First_Name +
                    ' <br>Last NAME : ' + data.Last_Name +
                    ' <br>Address : ' + data.Address +
                    ' <br>Insurance : ' + data.Insurance +
                    ' <br>Phone : ' + data.Phone +
                    ' <br>Giatros : ' + data.PID +
                    '</li>' +
                    '</ul> ';
                document.getElementById("ShowPatientINFO").innerHTML = userList;
                document.getElementById("ShowPersonnelINFO").style.display = "none";

                if (data.Has_Prev_visit) {
                    var userPreVisit = '<ul class=\"list-group\">' +
                        '<li class=\"list-group-item\"> ' + '<br>Date : ' + data.Date +
                        '<br>ExaminationID : ' + data.ExaminationID +
                        ' <br>Diagnosis : ' + data.Diagnosis +
                        ' <br>Examination : ' + data.Examination +
                        ' <br>Cure : ' + data.Cure +
                        '</li>' +
                        '</ul> ';
                    document.getElementById("ShowPatientsPrevVisits").innerHTML = userPreVisit;
                }
            } else {
                console.log("SAdasd");
                document.getElementById("ShowInvalidLogin").innerHTML = 'Invalid Amka';
                document.getElementById("ShowInvalidLogin").style.color = 'red';
            }

        },
        error: {
            400: function(data) {
                console.log("Error invalid AMka");
            }
        }
    });

}







// console.log("in Check Login");
//     var data = {
//         amka: $("#amka_input").val()
//     };

//     console.log(data.amka);
//     $.ajax({
//         type: "POST",
//         url: "LoginPatientServlet",
//         data: data,
//         async: true,
//         success: function(data) {
//             console.log("MPIKA SUCCERS");

//             $("#loginContainer").html(data);

//         },
//         error: {
//             400: function(data) {
//                 console.log("Error invalid AMka");
//             }
//         }
//     });







// var amka = document.getElementById("amka_input").value;


//     var xhr = new XMLHttpRequest();
//     xhr.onload = function() {
//         if (this.readyState === 4 && this.status === 200) {
//             console.log("SUCCESS");
//             var myObj = JSON.parse(this.responseText);
//             console.log(myObj);
//         }
//     };


//     xhr.open('POST', 'LoginPatientServlet');
//     xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
//     xhr.send('amka=' + amka);