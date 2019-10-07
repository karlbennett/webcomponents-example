<#macro layout title heading>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="/css/all.css">

        <title>${title}</title>
    </head>
    <body>
    <div class="header-container">
        <ul>
            <li><a href="/">Home</a></li>
            <li><a href="/login.html">Login</a></li>
        </ul>
    </div>

    <div class="content-container">
        <h1 class="main-heading">${heading}</h1>

        <#nested>
    </div>
    </body>
    </html>
</#macro>