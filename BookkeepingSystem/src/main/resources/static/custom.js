$(document).ready(function() {
    $('#sortAlphabet').click(function(){
       var token = $("meta[name='_csrf']").attr("content");

       $.ajax({
         type: 'POST',
         headers: {"X-CSRF-TOKEN": token},
         timeout : 100000,
         url: '/sortalphabet',
         success : function(data) {
                				console.log("SUCCESS: ", data);

                			},
                			error : function(e) {
                				console.log("ERROR: ", e);

                			},
                			done : function(e) {
                				console.log("DONE");

                			}
       });



    });
});