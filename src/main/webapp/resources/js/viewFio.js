/**
 * Created by SamsungR60P on 29.06.2015.
 */
function getJSON(putUrl){
    var httpReq = new XMLHttpRequest();
    httpReq.open('GET',putUrl,true);
    httpReq.send();
    return httpReq.responseText;
}

function getFioFromUserLoginToElementId(putUrl, putElem){
    var jsonObj = JSON.parse(getJSON(putUrl));
    document.getElementById(putElem).innerHTML =
        jsonObj.fio;
}

function getFioFromUserLoginToString(putUrl){
    var jsonObj = JSON.parse(getJSON(putUrl));
    return jsonObj.fio;
}

function CallURL(){
    $.ajax({
        url: 'https://www.googleapis.com/freebase/v1/text/en/bob_dylan',
        type: "GET",
        dataType: "text",
        async:false,
        success: function (msg) {
            JsonpCallback(msg);
        },
        error: function () {
            ErrorFunction();
        }

    });

}

function JsonpCallback(json)
{
    document.getElementById('summary').innerHtml=json.result;

}