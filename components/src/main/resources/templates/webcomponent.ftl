<#macro component name>
    (function () {
        class Component extends HTMLElement {
            constructor() {
                super();
                this.shadow = this.attachShadow({mode: 'open'});
            }

            connectedCallback() {
            this.shadow.innerHTML = `
                <#nested>
            `;
            }
        }
        customElements.define('${name}', Component);
    })();
</#macro>