ENV = window.__config__;

function appendScriptTag(path, addQuery) {
  var script = document.createElement('script');
  var actualPath = addQuery ? path + window.location.search : path;
  script.src = ENV.BASE_URL + actualPath;
  document.getElementsByTagName('head')[0].appendChild(script);
}