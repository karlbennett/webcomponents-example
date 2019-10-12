<#import "webcomponent.ftl" as web>
<@web.component name="addresses-link">
    <style><#t>
        a {
            text-decoration: none;
        }

        a:link {
            color: inherit;
        }

        a:focus {
            color: inherit;
        }

        a:hover {
            color: inherit;
        }

        a:visited {
            color: inherit;
        }

        a:active {
            color: inherit;
        }
    </style><#t>
    <#if loggedIn??>
        <a class="addresses-link" href="/addresses.html">Addresses</a><#t>
    <#else>
        <span class="addresses-link__disabled">Addresses</span><#t>
    </#if>
</@web.component>