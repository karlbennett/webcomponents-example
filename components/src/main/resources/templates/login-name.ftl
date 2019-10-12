<#import "webcomponent.ftl" as web>
<@web.component name="login-name">
    <style>
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

        #dropdown__check {
            display: none;
        }

        .dropdown__label {
            cursor: pointer;
            padding-right: 8px;
            border-right: 1px solid white;
        }

        #dropdown__check:checked ~ .dropdown__submenu {
            display: block;
        }

        .dropdown__submenu {
            display: none;
            position: relative;
            padding: 8px;
            margin-top: 8px;
            border: 1px solid black;
        }
    </style>
    <div class="login-name">
        <#if username?has_content>
            <input id="dropdown__check" type="checkbox" name="dropdown" />
            <label class="dropdown__label" for="dropdown__check">&#9660; ${username}</label>
            <div class="dropdown__submenu">
                <div class="dropdown__submenu__item">
                    <form class="login-name__logout-form" action="/logout" method="post">
                        <input class="login-name__logout-submit" type="submit" value="Logout" />
                    </form>
                </div>
            </div>
        <#else>
            <a class="login-name__login" href="/login.html">Login</a>
        </#if>
    </div>
</@web.component>