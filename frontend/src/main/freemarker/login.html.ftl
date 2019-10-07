<#import "components/layout.ftl" as l>
<#import "components/input.ftl" as i>
<@l.layout title="Webcomponents (Login)" heading="Login">
    <form class="form" method="post">
        <@i.textInput class="form__input" label="Username" name="username"/>
        <@i.textInput class="form__input" label="Password" name="password" type="password"/>
        <div class="form__input">
            <input type="submit" value="Login">
        </div>
    </form>
</@l.layout>