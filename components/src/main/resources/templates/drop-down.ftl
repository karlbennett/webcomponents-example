<#macro down id label>
    <style>
        #${id} {
            display: none;
        }

        .dropdown__label {
            cursor: pointer;
            padding-right: 8px;
            border-right: 1px solid white;
        }

        #${id}:checked ~ .dropdown__submenu {
            display: block;
        }

        .dropdown__submenu {
            display: none;
            position: absolute;
            padding: 8px;
            margin-top: 8px;
            border: 1px solid black;
            background: white;
        }
    </style>
    <input id="${id}" type="checkbox" name="dropdown" />
    <label class="dropdown__label" for="${id}">&#9660; ${label}</label>
    <div class="dropdown__submenu">
        <div class="dropdown__submenu__item">
            <#nested>
        </div>
    </div>
</#macro>