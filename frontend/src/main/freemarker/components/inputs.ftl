<#macro field class label name type="text">
    <div class="${class}">
        <label class="${class}__label" for="${name}">${label}</label>
        <input class="${class}__input" id="${name}" type="${type}" name="${name}">
    </div>
</#macro>