<#import "components/layout.ftl" as l>
<#import "components/webcomponents.ftl" as w>
<@l.layout title="Webcomponents (Addresses)" heading="Addresses">
    <@w.import url="/components/address-table.js" addQuery=true />
    <p>
        Hay WOW! Some addresses.
    </p>
    <div class="address-table">
        <address-table>
            <div class="address-table__nav">
                <span class="address-table__page">Page:</span>
                <a class="address-table__next" href="#"></a>
                <a class="address-table__previous" href="#"></a>
            </div>
            <table class="address-table">
                <tr class="address-table__heading">
                    <th class="address-table__cell street">&nbsp;</th>
                    <th class="address-table__cell city">&nbsp;</th>
                    <th class="address-table__cell zip-code">&nbsp;</th>
                    <th class="address-table__cell state">&nbsp;</th>
                    <th class="address-table__cell beds">&nbsp;</th>
                    <th class="address-table__cell baths">&nbsp;</th>
                    <th class="address-table__cell sqr-feet">&nbsp;</th>
                    <th class="address-table__cell type">&nbsp;</th>
                    <th class="address-table__cell price">&nbsp;</th>
                    <th class="address-table__cell lat">&nbsp;</th>
                    <th class="address-table__cell long">&nbsp;</th>
                </tr>
            </table>
        </address-table>
    </div>
</@l.layout>