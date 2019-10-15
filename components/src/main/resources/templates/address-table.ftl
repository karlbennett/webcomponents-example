<#import "webcomponent.ftl" as web>
<#import "drop-down.ftl" as drop>
<@web.component name="address-table">
    <#include "link-style.ftl">
    <style>
        p {
            margin: 0;
        }

        .address-table__nav {
            overflow: hidden
        }

        .address-table__page {
            display: inline-block;
            font-size: 0.8em;
            padding: 8px;
        }

        .address-table__position {
            display: inline-block;
            font-size: 0.8em;
            padding: 8px;
            float: right;
        }

        .address-table__sizes {
            list-style: none;
            margin: 0;
            padding: 0;
        }

        .address-table__size__link {
            display: block;
            width: 100%;
        }

        .address-table__previous {
            display: inline-block;
            float: right;
            margin-top: 8px;
            width: 0;
            height: 0;
            border-top: 8px solid transparent;
            border-bottom: 8px solid transparent;
            border-right: 8px solid black;
        }

        .address-table__next {
            display: inline-block;
            float: right;
            margin: 8px;
            width: 0;
            height: 0;
            border-top: 8px solid transparent;
            border-bottom: 8px solid transparent;
            border-left: 8px solid black;
        }

        .address-table {
            font-size: 0.8em;
            border-collapse: collapse;
            text-align: center;
            margin: 0 auto;
        }

        .address-table__heading {
            border: 1px solid black;
        }

        .address-table__row {
            border-bottom: 1px solid black;
        }

        .address-table__cell {
            width: 100px;
            padding: 8px;
        }

        @media only screen and (max-width: 768px) {
            .beds {display: none;}
            .baths {display: none;}
            .sqr-feet {display: none;}
            .type {display: none;}
            .price {display: none;}
            .lat {display: none;}
            .long {display: none;}
        }

        @media only screen and (min-width: 768px) and (max-width: 992px) {
            .baths {display: none;}
            .type {display: none;}
            .lat {display: none;}
            .long {display: none;}
        }

        @media only screen and (min-width: 992px) {

        }
    </style>
    <@nav id="address-top-nav" />
    <table class="address-table">
        <tr class="address-table__heading">
            <th class="address-table__cell street">Street</th>
            <th class="address-table__cell city">City</th>
            <th class="address-table__cell zip-code">Zip Code</th>
            <th class="address-table__cell state">State</th>
            <th class="address-table__cell beds">Beds</th>
            <th class="address-table__cell baths">Baths</th>
            <th class="address-table__cell sqr-feet">Sqr Feet</th>
            <th class="address-table__cell type">Type</th>
            <th class="address-table__cell price">Price</th>
            <th class="address-table__cell lat">Lat</th>
            <th class="address-table__cell long">Long</th>
        </tr>
        <#list addressPage.addresses as address>
            <tr class="address-table__row">
                <td class="address-table__cell street">${address.street}</td>
                <td class="address-table__cell city">${address.city}</td>
                <td class="address-table__cell zip-code">${address.zip}</td>
                <td class="address-table__cell state">${address.state}</td>
                <td class="address-table__cell beds">${address.beds}</td>
                <td class="address-table__cell baths">${address.baths}</td>
                <td class="address-table__cell sqr-feet">${address.squareFeet}</td>
                <td class="address-table__cell type">${address.type}</td>
                <td class="address-table__cell price">${address.price}</td>
                <td class="address-table__cell lat">${address.latitude}</td>
                <td class="address-table__cell long">${address.longitude}</td>
            </tr>
        </#list>
    </table>
    <@nav id="address-bottom-nav"/>
</@web.component>

<#macro nav id>
    <#assign previousPage = (addressPage.number > 1)?then(addressPage.number - 1, 1)>
    <#assign currentPage = addressPage.number>
    <#assign nextPage = (addressPage.number + 1)>
    <#assign totalPages = addressPage.totalPages>
    <#assign size = addressPage.size>
    <#assign firstRow = (1 + ((addressPage.number - 1) * addressPage.size))>
    <#assign lastRow = ((addressPage.number) * addressPage.size)>
    <#assign totalRows = addressPage.totalElements>
    <div class="address-table__nav">
        <span class="address-table__page">Page: ${currentPage} of ${totalPages}</span>
        <a class="address-table__next" href="?page=${nextPage}&size=${size}"></a>
        <a class="address-table__previous" href="?page=${previousPage}&size=${size}"></a>
        <span class="address-table__position">
            <@drop.down id="${id}-dropdown" label="${firstRow}-${lastRow} of ${totalRows}">
                <p>Rows:</p>
                <ul class="address-table__sizes">
                    <li class="address-table__size">
                        <a class="address-table__size__link" href="?page=${currentPage}&size=10">10</a>
                    </li>
                    <li class="address-table__size">
                        <a class="address-table__size__link" href="?page=${currentPage}&size=50">50</a>
                    </li>
                    <li class="address-table__size">
                        <a class="address-table__size__link" href="?page=${currentPage}&size=100">100</a>
                    </li>
                </ul>
            </@drop.down>
        </span>
    </div>
</#macro>