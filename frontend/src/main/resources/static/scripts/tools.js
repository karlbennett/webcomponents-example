ENV = window.__config__;

function appendScriptTag(path) {
  var script = document.createElement('script');
  script.src = ENV.BASE_URL + path;
  document.getElementsByTagName('head')[0].appendChild(script);
}