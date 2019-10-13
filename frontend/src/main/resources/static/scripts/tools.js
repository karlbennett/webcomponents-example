var ENV = {};

(function () {
  var env = window.__env__;
  for (var key in env) {
    if (env.hasOwnProperty(key)) {
      ENV[key] = env[key];
    }
  }
})();

function addScript(path, addQuery) {
  var envPath = ENV.BASE_URL + path;
  var finalPath = addQuery ? envPath + window.location.search : envPath;
  document.write('<script src="' + finalPath + '"><\/script>');
}