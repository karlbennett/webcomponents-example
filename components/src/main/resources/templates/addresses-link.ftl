<#import "webcomponent.ftl" as web>
<@web.component name="addresses-link">
    <#if loggedIn??>
        <a class="addresses-link" href="/addresses.html">Addresses</a>
    <#else>
        <span class="addresses-link__disabled">Addresses</span>
    </#if>
</@web.component>