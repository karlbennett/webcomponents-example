<#macro import url addQuery=false>
    <#if !addQuery>
        <script src="${url}"></script>
    <#else>
        <script type="text/javascript">
          appendScriptTag("${url}")
        </script>
    </#if>
</#macro>