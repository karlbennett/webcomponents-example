<#import "webcomponent.ftl" as web>
<#import "drop-down.ftl" as drop>
<@web.component name="login-name">
    <#include "link-style.ftl">
    <style>
        .login-name {
            text-align: right;
            min-width: 70px;
            background-color: white;
        }

        .login-name__login {
            padding-right: 8px;
            border-right: 1px solid white;
        }

        .login-name__logout-submit {
            background: none;
            color: inherit;
            border: none;
            padding: 0;
            font: inherit;
            cursor: pointer;
            outline: inherit;
        }
    </style>
    <div class="login-name">
        <#if username?has_content>
            <@drop.down id="login-dropdown" label=username>
                <form class="login-name__logout-form" action="/logout" method="post">
                    <input class="login-name__logout-submit" type="submit" value="Logout" />
                </form>
            </@drop.down>
        <#else>
            <a class="login-name__login" href="/login.html">Login</a>
        </#if>
    </div>
</@web.component>