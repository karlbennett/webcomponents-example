<#import "components/layout.ftl" as l>
<#import "components/inputs.ftl" as i>
<@l.layout title="Webcomponents (Login)" heading="Login">
    <form class="login-form" method="post">
        <@i.field class="login-form__field" label="Username" name="username"/>
        <@i.field class="login-form__field" label="Password" name="password" type="password"/>
        <input class="login-form__submit" type="submit" value="Login">
    </form>
</@l.layout>