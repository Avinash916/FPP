const express = require('express');
const http = require('http');
const path = require('path');
const Heroku = require('heroku-client');
const compression = require('compression');
const app = express();

// If an incoming request uses
// a protocol other than HTTPS,
// redirect that request to the
// same url but with HTTPS
const forceSSL = function() {
  return function (req, res, next) {
    if (req.headers['x-forwarded-proto'] !== 'https') {
      return res.redirect(['https://', req.get('Host'), req.url].join(''));
    }
    next();
  }
}

// Instruct the app
// to use the forceSSL
// middleware
app.use(forceSSL());

// Gzip
app.use(compression());

// Run the app by serving the static files
// in the src/main/resources/static directory
app.use(express.static(__dirname + '/src/main/resources/static'));

// For all GET requests, send back index.html
// so that PathLocationStrategy can be used  
app.get('/*', function(req, res) {
  res.sendFile(path.join(__dirname + '/src/main/resources/static/index.html'));
});

// Start the app by listening on the default
// Heroku port
var port = process.env.PORT || 8080;
app.listen(port, function () {
  console.log('app listening on port ' + port + '!');
});

