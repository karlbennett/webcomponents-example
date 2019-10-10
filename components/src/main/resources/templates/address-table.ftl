<#import "webcomponent.ftl" as web>
<@web.component name="address-table">
    <p class="address-table__current-page">
        <span>Current Page: </span><span>${addressPage.number}</span>
    </p>
    <p class="address-table__total-pages">
        <span>Total Pages: </span><span>${addressPage.totalPages}</span>
    </p>
    <p class="address-table__total-addresses">
        <span>Total Addresses: </span><span>${addressPage.totalElements}</span>
    </p>
    <table class="address-table">
        <tr>
            <th>Street</th>
            <th>City</th>
            <th>Zip Code</th>
            <th>State</th>
            <th>Number of Beds</th>
            <th>Number of Baths</th>
            <th>Square Feet</th>
            <th>Type</th>
            <th>Price</th>
            <th>Lat</th>
            <th>Long</th>
        </tr>
        <#list addressPage.addresses as address>
            <tr>
                <td>${address.street}</td>
                <td>${address.city}</td>
                <td>${address.zip}</td>
                <td>${address.state}</td>
                <td>${address.beds}</td>
                <td>${address.baths}</td>
                <td>${address.squareFeet}</td>
                <td>${address.type}</td>
                <td>${address.price}</td>
                <td>${address.latitude}</td>
                <td>${address.longitude}</td>
            </tr>
        </#list>
    </table>
    <div class="address-table__previous">
        <a href="?page=${(addressPage.number > 1)?then(addressPage.number - 1, 1)}">Previous</a>
    </div>
    <div class="address-table__next">
        <a href="?page=${addressPage.number + 1}">Next</a>
    </div>
</@web.component>