function addScriptWithQuery(path) {
  var script = document.createElement('script');
  script.src = path + window.location.search;
  document.getElementsByTagName('head')[0].appendChild(script);
}