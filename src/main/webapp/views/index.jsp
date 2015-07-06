<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="ru">
    <meta charset="UTF-8">
    <title>Качество продукции</title>
    <%--resources paths--%>
    <spring:url value="/resources/css/style.css" var="style"/>
    <spring:url value="/resources/css/jquery/jquery-ui.css" var="jqueryuicss"/>
    <spring:url value="/resources/js/JQuery.js" var="jquery"/>
    <spring:url value="/resources/js/functions.js" var="functions"/>
    <spring:url value="/resources/js/jquery-ui.js" var="jqueryuijs"/>
    <spring:url value="/resources/js/viewFio.js" var="viewfiojs"/>
    <%--images paths--%>
    <spring:url value="/resources/img/loading.gif" var="loadgif"/>
    <spring:url value="/resources/img/Book%20Shelf.png" var="journalpng"/>
    <spring:url value="/resources/img/add.png" var="imgadd"/>
    <spring:url value="/resources/img/user.png" var="imguser"/>
    <%--views paths--%>
    <spring:url value="/all" var="v_all"/>
    <spring:url value="/metal" var="v_metal"/>
    <spring:url value="/complect" var="v_complect"/>
    <spring:url value="/himiya" var="v_chemistry"/>
    <spring:url value="/nemetal" var="v_nometal"/>
    <spring:url value="/setkaLentaProvoloka" var="v_setka"/>
    <spring:url value="/metiz" var="v_metiz"/>
    <%--response param from views--%>

    <link rel="stylesheet" href="${style}">
    <link rel="stylesheet" href="${jqueryuicss}">
    <script type="application/javascript" src="${jquery}"></script>
    <script type="text/javascript" src="${functions}"></script>
    <script type="text/javascript" src="${jqueryuijs}"></script>
    <script type="text/javascript" src="${viewfiojs}"></script>
</head>
<body>

<%--<c:set var="loginuser" scope="page" value=/>--%>
<%--<script>getFioFromJson("/userData/getFio/${username}")</script>--%>

<!--LOADING-->
<div id="loading_wrapper">
    <p>Загрузка <img src="${loadgif}"/></p>
</div>
<!--HEADER-->
<header id="header" class="header">
    <div id="header_content" class="header_content">
        <sec:authorize access="isAuthenticated()">
        <a href="/QP/index"><h2>Качество продукции</h2></a>
        </sec:authorize>
        <%--<a href="/QP"><h2>Качество продукции</h2></a>--%>
        <!--SEARCH-->
        <form id="search_form" class="search_form" name="search_form">
            <%--<input type="text" id="inpt_search2" class="inpt_search" name="inpt_search22"/>--%>
            <input type="text" id="inpt_search" class="inpt_search" name="inpt_search" placeholder="Введите поисковый запрос"/>
            <button id="btn_search" class="btn_search" name="btn_search">Поиск</button>
        </form>
        <!--NAVIGATION-->
        <nav>
            <ul class="nav">
                <li><a href="" class="mark" title="Журналы"><img src="${journalpng}"/></a>
                    <ul class="sub-nav">

                        <li><a href="${v_all}" title="Вся продукция">Вся продукция</a></li>

                        <sec:authorize ifAnyGranted="ROLE_ALL,ROLE_METAL">
                        <li><a href="${v_metal}" title="Металл (черный и цветной)">Металл (черный и цветной)</a></li>
                        </sec:authorize>

                        <sec:authorize ifAnyGranted="ROLE_ALL,ROLE_COMPL">
                        <li><a href="${v_complect}" title="Комплектующие">Комплектующие</a></li>
                        </sec:authorize>

                        <sec:authorize ifAnyGranted="ROLE_ALL,ROLE_CHEMISTRY">
                        <li><a href="${v_chemistry}" title="Химия, ГСМ">Химия, ГСМ</a></li>
                        </sec:authorize>

                        <sec:authorize ifAnyGranted="ROLE_ALL,ROLE_NONMETAL">
                        <li><a href="${v_nometal}" title="Неметаллические материалы">Неметаллические
                            материалы</a></li>
                        </sec:authorize>

                        <sec:authorize ifAnyGranted="ROLE_ALL,ROLE_SETKA">
                        <li><a href="${v_setka}" title="Сетка, лента, проволка">Сетка, лента, проволка</a></li>
                        </sec:authorize>

                        <sec:authorize ifAnyGranted="ROLE_ALL,ROLE_METIZ">
                        <li><a href="${v_metiz}" title="Метизы">Метизы</a></li>
                        </sec:authorize>
                    </ul>
                </li>
                <li><a href="#openModal_potrebitel" title="Добавить"><img src="${imgadd}"/></a></li>
                <li><a href="" title="Личный кабинет"><img src="${imguser}"/></a>
                    <ul class="sub-nav">
                        <li><a id="login_l" href="<c:url value="/j_spring_security_logout"/>" title="Выйти">Выйти</a></li>
                    </ul>
                    <script>
                    getFioFromJsonForLogin('/QP/userData/getFio/${username}','login_l');
                    </script>
                </li>
            </ul>
        </nav>
    </div>
</header>
<!--CONTENT-->
<div id="content" class="content">
    <!--LIST MAGAZIN-->
    <div id="list_magazin" class="list_magazin">

        <sec:authorize ifAnyGranted="ROLE_ALL,ROLE_METAL">
        <a href="${v_metal}" title="Металл (черный и цветной)">
            <article>Металл (черный и цветной)</article>
        </a>
        </sec:authorize>

        <sec:authorize ifAnyGranted="ROLE_ALL,ROLE_NONMETAL">
        <a href="${v_complect}" title="Комплектующие">
            <article>Комплектующие</article>
        </a>
        </sec:authorize>

        <sec:authorize ifAnyGranted="ROLE_ALL,ROLE_CHEMISTRY">
        <a href="${v_chemistry}" title="Химия, ГСМ">
            <article>Химия, ГСМ</article>
        </a>
        </sec:authorize>

        <sec:authorize ifAnyGranted="ROLE_ALL,ROLE_COMPL">
        <a href="${v_nometal}" title="Неметаллические материалы">
            <article>Неметаллические материалы</article>
        </a>
        </sec:authorize>

        <sec:authorize ifAnyGranted="ROLE_ALL,ROLE_SETKA">
        <a href="${v_setka}" title="Сетка, лента, проволка">
            <article>Сетка, лента, проволка</article>
        </a>
        </sec:authorize>

        <sec:authorize ifAnyGranted="ROLE_ALL,ROLE_METIZ">
        <a href="${v_metiz}" title="Метизы">
            <article>Метизы</article>
        </a>
        </sec:authorize>
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
                        <input type="text" id="fio_presenter" disabled/>
                        <script>
                            getFioFromJson('/QP/userData/getFio/${username}','fio_presenter');
                        </script>
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

                        <%--<script> getJSON("/QP1/userData/getFio/${username}","fio_last_modify"); </script>--%>

                        <input type="text" id="fio_last_modify" disabled/>
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
                        <input type="text" id="fio_controller" value="${username}" disabled/>
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
<%--<script></script>--%>
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
        <%--getFioFromJson('/userData/getFio/${username}','login_l'),--%>

        paginator());
</script>
</body>
</html>