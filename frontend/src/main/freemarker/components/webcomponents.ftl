<#macro import path addQuery=false url="">
    <#if url?has_content>
        <script src="${url}"></script>
    <#else>
        <script type="text/javascript">
          appendScriptTag("${path}", ${addQuery?string('true', 'false')})
        </script>
    </#if>
</#macro>