<#macro import path="" url="" addQuery=false>
    <#if url?has_content>
        <script src="${url}"></script>
    <#else>
        <script type="text/javascript">
          addScript("${path}", ${addQuery?then('true', 'false')});
        </script>
    </#if>
</#macro>