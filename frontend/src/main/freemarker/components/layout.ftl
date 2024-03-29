<#import "webcomponents.ftl" as w>
<#macro layout title heading>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, maximum-scale=1.0" />
        <link rel="stylesheet" type="text/css" href="/css/all.css">

        <script src="/scripts/webcomponents-loader.js"></script>
        <script src="/scripts/tools.js"></script>
        <@w.import url="/components/public/addresses-link.js" />
        <@w.import url="/components/public/login-name.js" />

        <title>${title}</title>
    </head>
    <body>
    <div class="header-container">
        <ul class="main-menu">
            <li class="main-menu__item"><a href="/">Home</a></li>
            <li class="main-menu__item--last"><addresses-link></addresses-link></li>
            <li class="main-menu__item__login"><login-name></login-name></li>
        </ul>
    </div>

    <div class="content-container">
        <h1 class="main-heading">${heading}</h1>

        <#nested>
    </div>
    </body>
    </html>
</#macro>