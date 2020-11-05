$(document).ready(function(){
    const url ="http://localhost:8080/FlightBookingMVC_Tram/findDes";
    $("#airPortStationFrom").change(function(){
        var source =  document.getElementById("airPortStationFrom").value;
        var urlSource=url + "?source=" + source;
       // alert(urlSource);
        var xhttp = new XMLHttpRequest();        
       
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
              document.getElementById("demo").innerHTML = this.responseText;
            }
        };
        xhttp.open("GET",urlSource, true);
        //xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); 
        xhttp.send();
    });
});


