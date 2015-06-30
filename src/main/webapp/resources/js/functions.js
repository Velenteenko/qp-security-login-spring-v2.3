/**
 * Created by kycenko on 18.06.15.
 */
function paginator() {
    var pageNumber = 1;
    getAllProduct(pageNumber)
    $('#prev').click(function () {
        if (pageNumber > 1) {
            pageNumber = pageNumber - 1;
        }
        getAllProduct(pageNumber);
    });
    $('#next').click(function () {
        pageNumber = pageNumber + 1;
        getAllProduct(pageNumber)
    });
    //getPageNumber(pageNumber);
}

function getAllProduct(pageNumber) {
    document.getElementById('loading_wrapper').style.display = "block";
    $.ajax({
        url: '/QP/api/service/all_product_name',
        cache: false,
        data: 'page=' + pageNumber,
        dataType: 'json',
        success: function (data) {
            document.getElementById('loading_wrapper').style.display = "none";
            var prData = '';
            $.each(data, function (index, prName) {
                prData = prData + '<tr>';
                if (prName !== null) {
                    prData = prData + '<td>' + prName.Name + '</td>';
                } else {
                    prData = prData + '<td>&nbsp;<td>';
                }
                prData = prData + '</tr>';
            });
            $('#table_content').html(prData);
        }
    })
}

//LIST MAGAZINE
function getAllMagazine() {
    $.ajax({
        url: '/QP/api/service/all_magazine',
        cache: false,
        dataType: 'json',
        success: function (data) {
            var magData = magData + '<option value=' + null + '>Выбрать</option>';
            $.each(data, function (index, magazine) {
                if (magazine !== null) {
                    magData = magData + '<option value=' + magazine.MagazineId + '>' + magazine.MagazineName + '</option>';
                } else {
                    magData = magData + '&nbsp;';
                }
            });
            $('.magazine_name').html(magData);
        }
    })
}

//LIST STANDART TYPE
function getAllStdType() {
    $.ajax({
        url: '/QP/api/service/all_std_type',
        cache: false,
        dataType: 'json',
        success: function (data) {
            var typeData = typeData + '<option value=' + null + '>Выбрать</option>';
            $.each(data, function (index, type) {
                if (type !== null) {
                    typeData = typeData + '<option value=' + type.stdId + '>' + type.stdName + '</option>';
                } else {
                    typeData = typeData + '&nbsp;';
                }
            });
            $('.std_type').html(typeData);
        }
    })
}

//LIST PRODUCT LIKE NAME
function getProductLikeName() {
    $('#product_like_name_id').autocomplete({
        source: function (request, response) {
            $.ajax({
                url: '/QP/api/service/product_like_name',
                dataType: 'json',
                data: {
                    name: request.term // поисковая фраза
                },
                success: function (data) {
                    response($.map(data, function (item) {
                        return {
                            id: item.likeId,
                            value: item.likeName
                        }
                    }));
                }
            });
        },
        select: function (event, ui) {
            $("#product_like_name_id").val(ui.item.value);
            $("#hvr_product_like_name_id").val(ui.item.id);
            return false;
        },
        minLength: 2 // начинать поиск
    });
}

//LIST PRODUCT LIKE TYPE
function getProductLikeType() {
    $('#product_like_type_id').autocomplete({
        source: function (request, response) {
            $.ajax({
                url: '/QP/api/service/product_like_type',
                dataType: 'json',
                data: {
                    name: request.term // поисковая фраза
                },
                success: function (data) {
                    response($.map(data, function (item) {
                        return {
                            id: item.likeId,
                            value: item.likeName
                        }
                    }));
                }
            });
        },
        select: function (event, ui) {
            $("#product_like_type_id").val(ui.item.value);
            $("#hvr_product_like_type_id").val(ui.item.id);
            return false;
        },
        minLength: 2 // начинать поиск
    });
}

//LIST STANDART LIKE NAME
function getStandartLikeName() {
    $('#standart_like_name_id').autocomplete({
        source: function (request, response) {
            $.ajax({
                url: '/QP/api/service/standart_like',
                dataType: 'json',
                data: {
                    name: request.term // поисковая фраза
                },
                success: function (data) {
                    response($.map(data, function (item) {
                        return {
                            id: item.likeId,
                            value: item.likeName
                        }
                    }));
                }
            });
        },
        select: function (event, ui) {
            $("#standart_like_name_id").val(ui.item.value);
            $("#hvr_standart_like_name_id").val(ui.item.id);
            return false;
        },
        minLength: 2 // начинать поиск
    });
}

//LIST STANDART LIKE TYPE
function getStandartLikeType() {
    $('#standart_like_type_id').autocomplete({
        source: function (request, response) {
            $.ajax({
                url: '/QP/api/service/standart_like',
                dataType: 'json',
                data: {
                    name: request.term // поисковая фраза
                },
                success: function (data) {
                    response($.map(data, function (item) {
                        return {
                            id: item.likeId,
                            value: item.likeName
                        }
                    }));
                }
            });
        },
        select: function (event, ui) {
            $("#standart_like_type_id").val(ui.item.value);
            $("#hvr_standart_like_type_id").val(ui.item.id);
            return false;
        },
        minLength: 2 // начинать поиск
    });
}

//DATA TERM PRODUCT
function dataTermProduct() {
    $(function () {
        $.datepicker.setDefaults(
            $.extend($.datepicker.regional['ru'])
        );
        $("#datepicker_term").datepicker();
    });
}

//DATA PRODUCE PRODUCT
function dataProduce() {
    $(function () {
        $.datepicker.setDefaults(
            $.extend($.datepicker.regional['ru'])
        );
        $("#datepicker").datepicker();
    });
}

//DATA GET PRODUCT
function dataGetProduct() {
    $(function () {
        $.datepicker.setDefaults(
            $.extend($.datepicker.regional['ru'])
        );
        $("#datepicker_get").datepicker();
    });
}

//DATA GET PRODUCT
function dataLastModify() {
    $(function () {
        $.datepicker.setDefaults(
            $.extend($.datepicker.regional['ru'])
        );
        $("#date_last_modify").datepicker();
    });
}

//LIST CONSUMER LIKE NAME
function getConsumerLikeName() {
    $('#consumer_id').autocomplete({
        source: function (request, response) {
            $.ajax({
                url: '/QP/api/service/consumer_like_name',
                dataType: 'json',
                data: {
                    name: request.term // поисковая фраза
                },
                success: function (data) {
                    response($.map(data, function (item) {
                        return {
                            id: item.likeId,
                            value: item.likeName
                        }
                    }));
                }
            });
        },
        select: function (event, ui) {
            $("#consumer_id").val(ui.item.value);
            $("#hvr_consumer_id").val(ui.item.id);
            return false;
        },
        minLength: 2 // начинать поиск
    });
}

//LIST MEASURE
function getAllMeasure() {
    $.ajax({
        url: '/QP/api/service/all_measure',
        cache: false,
        dataType: 'json',
        success: function (data) {
            var magData = magData + '<option value=' + null + '>Выбрать</option>';
            $.each(data, function (index, measure) {
                if (measure !== null) {
                    magData = magData + '<option value=' + measure.MeasureId + '>' + measure.MeasureName + '</option>';
                } else {
                    magData = magData + '&nbsp;';
                }
            });
            $('.measure').html(magData);
        }
    })
}

//LIST LOCATION
function getLocation() {
    $.ajax({
        url: '/QP/api/service/location',
        cache: false,
        dataType: 'json',
        success: function (data) {
            var magData = magData + '<option value=' + null + '>Выбрать</option>';
            $.each(data, function (index, location) {
                if (location !== null) {
                    magData = magData + '<option value=' + location.LocationId + '>' + location.LocationName + '</option>';
                } else {
                    magData = magData + '&nbsp;';
                }
            });
            $('.location').html(magData);
        }
    })
}


//CREATE PRODUCT (TABLE PRODUCT AND PRODUCT INCOME IN DB)
function createProduct(){
    $("#createProduct").click(function () {
        var product = {
            idMagazine: $(".magazine_name").val(),
            idProdName: $("#hvr_product_like_name_id").val(),
            nameStandartProdName: $("#hvr_standart_like_name_id").val(),
            stdTypeIdName: $("#type_standart_by_name").val(),
            idProdType: $("#hvr_product_like_type_id").val(),
            nameStandartProdType: $("#hvr_standart_like_type_id").val(),
            stdTypeIdType : $("#type_standart_by_type").val(),
            waranty : $("#datepicker_term").val(),
            produceDate : $("#datepicker").val(),
            datePresenter : $("#datepicker_get").val(),
            lot : $("#number_part_id").val(),
            consumerId : $("#hvr_consumer_id").val(),
            numberDoc : $("#doc_number").val(),
            countProduct : $("#count_id").val(),
            measureId : $(".measure").val(),
            locationId : $(".location").val(),
            fioPresenter : $("#fio_presenter").val(),
            fioLastModify : $("#fio_last_modify").val(),
            dateLastModify : $("#date_last_modify").val(),
            fioControler : $("#fio_controller").val(),
            arrangements : $("#arrangements").val(),
            note : $("#note").val()
        };
        $.ajax({
            url: '/QP/api/service/create_product',
            type: 'POST',
            data: JSON.stringify(product),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function ( newProduct ) {
                window.location.replace("http://192.168.31.200/QP/");
            },
            error: function( newProduct ){
                alert("Ошибка дабавления продукции!");
            }
        });
    });

}
