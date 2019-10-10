<#import "webcomponent.ftl" as web>
<@web.component name="addresses-item">
    <#if loggedIn??>
        <a class="addresses-item" href="/addresses.html">Addresses</a>
    <#else>
        <span class="addresses-item__disabled">Addresses</span>
    </#if>
</@web.component>