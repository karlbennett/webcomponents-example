<#import "components/layout.ftl" as l>
<#import "components/webcomponents.ftl" as w>
<@l.layout title="Webcomponents (Addresses)" heading="Addresses">
    <@w.import path="/components/address-table.js" addQuery=true />
    <p>
        Hay WOW! Some addresses.
    </p>
    <div class="address-table">
        <address-table></address-table>
    </div>
</@l.layout>