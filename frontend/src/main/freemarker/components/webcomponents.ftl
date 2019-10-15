<#macro import url addQuery=false>
    <#if addQuery>
        <script type="text/javascript">
          addScriptWithQuery("${url}");
        </script>
    <#else>
        <script src="${url}"></script>
    </#if>
</#macro>