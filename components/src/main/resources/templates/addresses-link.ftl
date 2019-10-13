<#import "webcomponent.ftl" as web>
<@web.component name="addresses-link">
    <#include "link-style.ftl">
    <style><#t>
        .addresses-link__disabled {
            color: lightgray;
        }
    </style><#t>
    <#if loggedIn??>
        <a class="addresses-link" href="/addresses.html">Addresses</a><#t>
    <#else>
        <span class="addresses-link__disabled">Addresses</span><#t>
    </#if>
</@web.component>