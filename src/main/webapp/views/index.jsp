<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="ru">
    <meta charset="UTF-8">
    <title>Качество продукции</title>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/jquery/jquery-ui.css">
    <script type="application/javascript" src="/resources/js/JQuery.js"></script>
    <script type="text/javascript" src="/resources/js/functions.js"></script>
    <script type="text/javascript" src="/resources/js/jquery-ui.js"></script>
</head>
<body>
<!--LOADING-->
<div id="loading_wrapper">
    <p>Загрузка <img src="/resources/img/loading.gif"/></p>
</div>
<!--HEADER-->
<header id="header" class="header">
    <div id="header_content" class="header_content">
        <a href="/QP"><h2>Качество продукции</h2></a>
        <!--SEARCH-->
        <form id="search_form" class="search_form" name="search_form">
            <input type="text" id="inpt_search" class="inpt_search" name="inpt_search" placeholder="Введите поисковый запрос"/>
            <button id="btn_search" class="btn_search" name="btn_search">Поиск</button>
        </form>
        <!--NAVIGATION-->
        <nav>
            <ul class="nav">
                <li><a href="" class="mark" title="Журналы"><img src="/resources/img/Book%20Shelf.png"/></a>
                    <ul class="sub-nav">
                        <li><a href="/views/all.jsp" title="Вся продукция">Вся продукция</a></li>
                        <li><a href="/views/metall.jsp" title="Металл (черный и цветной)">Металл (черный и цветной)</a>
                        </li>
                        <li><a href="/views/complect.jsp" title="Комплектующие">Комплектующие</a></li>
                        <li><a href="/views/chemistry.jsp" title="Химия, ГСМ">Химия, ГСМ</a></li>
                        <li><a href="/views/nometall.jsp" title="Неметаллические материалы">Неметаллические
                            материалы</a></li>
                        <li><a href="/views/setka.jsp" title="Сетка, лента, проволка">Сетка, лента, проволка</a></li>
                        <li><a href="/views/metiz.jsp" title="Метизы">Метизы</a></li>
                    </ul>
                </li>
                <li><a href="#openModal_potrebitel" title="Добавить"><img src="/resources/img/add.png"/></a></li>
                <li><a href="" title="Личный кабинет"><img src="/resources/img/user.png"/></a>
                    <ul class="sub-nav">
                        <li><a href="" title="Выйти">Выйти</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</header>
<!--CONTENT-->
<div id="content" class="content">
    <!--LIST MAGAZIN-->
    <div id="list_magazin" class="list_magazin">
        <a href="/views/metall.jsp" title="Металл (черный и цветной)">
            <article>Металл (черный и цветной)</article>
        </a>
        <a href="/views/complect.jsp" title="Комплектующие">
            <article>Комплектующие</article>
        </a>
        <a href="/views/chemistry.jsp" title="Химия, ГСМ">
            <article>Химия, ГСМ</article>
        </a>
        <a href="/views/nometall.jsp" title="Неметаллические материалы">
            <article>Неметаллические материалы</article>
        </a>
        <a href="/views/setka.jsp" title="Сетка, лента, проволка">
            <article>Сетка, лента, проволка</article>
        </a>
        <a href="/views/metiz.jsp" title="Метизы">
            <article>Метизы</article>
        </a>
    </div>
    <!--LIST MAGAZIN END-->
    <h2>Вся продукция</h2>
    <!--TABLE PRODUCT-->
    <table border="0" cellpadding="0" cellspacing="0" id="main_table" class="main_table">
        <tbody>
        <tr class="table_header">
            <th><h5>Наименование продукции</h5></th>
            <th><h5>Марка, тип продукции</h5></th>
            <th><h5>Номер партии</h5></th>
            <th><h5>Поставщик</h5></th>
            <th><h5>№ сопроводительного документа</h5></th>
        </tr>
        </tbody>
        <tbody id="table_content"></tbody>
    </table>
    <!--PAGINATION-->
    <div class="pagination_product">
        <button id="prev" class="paginator_btn">Предыдущая</button>
        <button id="next" class="paginator_btn">Следующая</button>
    </div>
</div>
<!--MODAL WINDOW-->
<div id='openModal_potrebitel' class='modalDialog'>
    <div>
        <div class="wrrap_modal_header">
            <div class="modal_header"/>
        </div>
        <div class="wrrap_close">
            <a href='#close' title='Закрыть' class='close'>x</a>
        </div>
        <h3 id=''>Форма добавления продукции</h3>
        <form method="post" id="create_product" action="/QP" >
            <table id="t_modal" class="t_modal">
                <tr>
                    <td class="t_td_name"><p>Журнал</p></td>
                    <td class="t_td_input" id="t_td_input_mag">
                        <select class="magazine_name"></select>
                    </td>
                </tr>
                <tr>
                    <td class="t_td_name"><p>Наименование</p></td>
                    <td class="t_td_input">
                        <input type="text" id="product_like_name_id"/>
                        <input type="hidden" id="hvr_product_like_name_id"/>
                    </td>
                </tr>
                <tr>
                    <td class="t_td_name"><p>ГОСТ, ОСТ, ТУ, ДСТУ</p></td>
                    <td class="t_td_input_gost">
                        <input type="text" id="standart_like_name_id"/>
                        <input type="hidden" id="hvr_standart_like_name_id"/>
                        <select class="std_type" id="type_standart_by_name"></select>
                    </td>
                </tr>
                <tr>
                    <td class="t_td_name"><p>Марка, тип</p></td>
                    <td class="t_td_input">
                        <input type="text" id="product_like_type_id"/>
                        <input type="hidden" id="hvr_product_like_type_id"/>
                    </td>
                </tr>
                <tr>
                    <td class="t_td_name"><p>ГОСТ, ОСТ, ТУ, ДСТУ</p></td>
                    <td class="t_td_input_gost">
                        <input type="text" id="standart_like_type_id"/>
                        <input type="hidden" id="hvr_standart_like_type_id"/>
                        <select class="std_type" id="type_standart_by_type"></select>
                    </td>
                </tr>
                <tr>
                    <td class="t_td_name"><p>Гарантийный срок (гггг-мм-дд)</p></td>
                    <td class="t_td_input">
                        <input id="datepicker_term" type="text"/>
                    </td>
                </tr>
                <tr>
                    <td class="t_td_name"><p>Дата изготовления (гггг-мм-дд)</p></td>
                    <td class="t_td_input">
                        <input id="datepicker" type="text"/>
                    </td>
                </tr>
                <tr>
                    <td class="t_td_name"><p>Дата предьявления (гггг-мм-дд)</p></td>
                    <td class="t_td_input">
                        <input id="datepicker_get" type="text"/>
                    </td>
                </tr>
                <tr>
                    <td class="t_td_name"><p>№ партии</p></td>
                    <td class="t_td_input">
                        <input type="text" id="number_part_id"/>
                    </td>
                </tr>
                <tr>
                    <td class="t_td_name"><p>Поставщик</p></td>
                    <td class="t_td_input">
                        <input type="text" id="consumer_id"/>
                        <input type="hidden" id="hvr_consumer_id"/>
                    </td>
                </tr>
                <tr>
                    <td class="t_td_name"><p>№ сопроводительного документа</p></td>
                    <td class="t_td_input">
                        <input type="text" id="doc_number"/>
                    </td>
                </tr>
                <tr>
                    <td class="t_td_name"><p>Количество продукции</p></td>
                    <td class="t_td_input_gost">
                        <input type="text" id="count_id"/>
                        <select class="measure"></select>
                    </td>
                </tr>
                <tr>
                    <td><p>ФИО предъявителя</p></td>
                    <td class="t_td_input">
                        <input type="text" id="fio_presenter" value="ФИО" disabled/>
                    </td>
                </tr>
                <tr>
                    <td><p>Место нохождения продукции</p></td>
                    <td class="t_td_input">
                        <select class="location"></select>
                    </td>
                </tr>
                <tr>
                    <td><p>Автор последнего изменения</p></td>
                    <td class="t_td_input">
                        <input type="text" id="fio_last_modify" value="ФИО" disabled/>
                    </td>
                </tr>
                <tr>
                    <td><p>Заключение входного контроля</p></td>
                    <td class="t_td_input">
                        <input type="text" id="doc_id"/>
                    </td>
                </tr>
                <tr>
                    <td><p>Дата последнего изменения</p></td>
                    <td class="t_td_input">
                        <input type="text" id="date_last_modify"/>
                    </td>
                </tr>
                <tr>
                    <td><p>ФИО контролера</p></td>
                    <td class="t_td_input">
                        <input type="text" id="fio_controller" value="ФИО" disabled/>
                    </td>
                </tr>
                <tr>
                    <td><p>Принятые меры</p></td>
                    <td class="t_td_input">
                        <input type="text" id="arrangements"/>
                    </td>
                </tr>
                <tr>
                    <td><p>Примечание</p></td>
                    <td class="t_td_input">
                        <input type="text" id="note"/>
                    </td>
                </tr>
            </table>
            <div class="pagination_product">
                <a href='#cancel' title='Закрыть' class="paginator_btn">Отмена</a>
                <button title="Сохранить" type="button" class="paginator_btn" id="createProduct">Сохранить</button>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">$(document).ready(
        getAllMagazine(),
        getAllStdType(),
        getProductLikeName(),
        getStandartLikeName(),
        getProductLikeType(),
        getStandartLikeType(),
        dataTermProduct(),
        dataProduce(),
        dataGetProduct(),
        dataLastModify(),
        getConsumerLikeName(),
        getAllMeasure(),
        getLocation(),
        createProduct(),
        paginator());
</script>
</body>
</html>