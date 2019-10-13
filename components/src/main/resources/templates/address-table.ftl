<#import "webcomponent.ftl" as web>
<@web.component name="address-table">
    <style>
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
    </style>
    <div class="address-table__nav">
        <span class="address-table__page">
            Page: ${addressPage.number}
        </span>
        <a class="address-table__next" href="?page=${addressPage.number + 1}"></a>
        <a class="address-table__previous" href="?page=${(addressPage.number > 1)?then(addressPage.number - 1, 1)}"></a>
        <span class="address-table__position">
            ${1 + ((addressPage.number - 1) * addressPage.size)}-${(addressPage.number) * addressPage.size} of
            ${addressPage.totalElements}
        </span>
    </div>
    <table class="address-table">
        <tr class="address-table__heading">
            <th class="address-table__cell">Street</th>
            <th class="address-table__cell">City</th>
            <th class="address-table__cell">Zip Code</th>
            <th class="address-table__cell">State</th>
            <th class="address-table__cell">Beds</th>
            <th class="address-table__cell">Baths</th>
            <th class="address-table__cell">Sqr Feet</th>
            <th class="address-table__cell">Type</th>
            <th class="address-table__cell">Price</th>
            <th class="address-table__cell">Lat</th>
            <th class="address-table__cell">Long</th>
        </tr>
        <#list addressPage.addresses as address>
            <tr class="address-table__row">
                <td class="address-table__cell">${address.street}</td>
                <td class="address-table__cell">${address.city}</td>
                <td class="address-table__cell">${address.zip}</td>
                <td class="address-table__cell">${address.state}</td>
                <td class="address-table__cell">${address.beds}</td>
                <td class="address-table__cell">${address.baths}</td>
                <td class="address-table__cell">${address.squareFeet}</td>
                <td class="address-table__cell">${address.type}</td>
                <td class="address-table__cell">${address.price}</td>
                <td class="address-table__cell">${address.latitude}</td>
                <td class="address-table__cell">${address.longitude}</td>
            </tr>
        </#list>
    </table>
</@web.component>