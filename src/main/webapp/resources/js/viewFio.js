/**
 * Created by SamsungR60P on 29.06.2015.
 */
function getJSON(loginOrElement, putUrl, idElement){
    var xmlhttp = new XMLHttpRequest();
    var url = putUrl;
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            if(loginOrElement){
                readJsonForLogout(xmlhttp.responseText, idElement);
            }
            readJson(xmlhttp.responseText, idElement);
        }
    }
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}

function readJson(response, idElem){
    var arr = JSON.parse(response);
    var out = arr.fio;
    document.getElementById(idElem).innerHTML = out;
}

function readJsonForLogout(response, idElem){
    var arr = JSON.parse(response);
    var out = arr.fio;
    document.getElementById(idElem).innerHTML = out +' - Выйти';
}

function getFioFromJson(urlPath, idElem){
    $(document).ready(function() {
        $.ajax({
            url: urlPath,
            type: "GET",
            dataType: "text",
            success: function(data) {
                var jsonparse = $.parseJSON(data);
                //var parseData ='';
                //parseData = jsonparse.fio;
                $('#'+idElem).val(jsonparse.fio);
                //return json.fio;
            }
        });
    });
}
function getFioFromJsonForLogin(urlPath, idElem){
    $(document).ready(function() {
        $.ajax({
            url: urlPath,
            type: "GET",
            dataType: "text",
            success: function(data) {
                var jsonparse = $.parseJSON(data);
                //var parseData ='';
                var logoutData = ' - Выйти';
                var parseData = jsonparse.fio+logoutData;
                $('#'+idElem).html(parseData);
                //return json.fio;
            }
        });
    });
}

