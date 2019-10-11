<#import "webcomponent.ftl" as web>
<@web.component name="login-name">
    <link rel="stylesheet" type="text/css" href="/css/login.css">
    <#if username?has_content>
        <span class="login-name__username">${username}</span>
    <#else>
        <a class="login-name__login" href="/login.html">Login</a>
    </#if>
</@web.component>