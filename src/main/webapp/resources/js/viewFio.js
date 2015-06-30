/**
 * Created by SamsungR60P on 29.06.2015.
 */
function getJSON(putUrl){
    var xmlhttp = new XMLHttpRequest();
    var url = putUrl;
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            readJson(xmlhttp.responseText);
        }
    }
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}

function readJson(response){
    var arr = JSON.parse(response);
    var out = arr.fio;
    document.getElementById("id01").innerHTML = out;
}

function getFioFromJson(urlPath, idElem){
    $(document).ready(function() {
        $.ajax({
            url: urlPath,
            //force to handle it as text
            dataType: "text",
            success: function(data) {
                //data downloaded so we call parseJSON function
                //and pass downloaded data
                var json = $.parseJSON(data);
                //now json variable contains data in json format
                //let's display a few items
                $('#'+idElem).html('Fio user: ' + json.fio);
            }
        });
    });
}