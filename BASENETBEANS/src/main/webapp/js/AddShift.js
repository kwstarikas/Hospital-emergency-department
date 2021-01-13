/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function addShift() {
    
    
    var data = {
      docs : $('#ShiftDocNum').val(), 
      nurses : $('#ShiftNurseNum').val(), 
      admins : $('#ShiftAdminNum').val(), 
      date : $('#ShiftDate').val()
    };
    
     console.log(data);
    $.ajax({
        type: "POST",
        url: "FetchDocServlet",
        data: data,
        async: true,
        success: function(data) {
           alert("Shift created");
           console.log("COOL");
        },
        error: {
            400: function(data) {
                console.log("Error invalid Shift things");
            }
        }
    });
    
}