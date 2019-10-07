<#macro import path url="">
    <#if url?has_content>
        <script src="${url}"></script>
    <#else>
        <script type="text/javascript">
          appendScriptTag("${path}")
        </script>
    </#if>
</#macro>