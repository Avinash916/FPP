const path = require('path');
const express = require('express');
const app = express();
const Heroku = require('heroku-client');
const heroku = new Heroku({ token: process.env.HEROKU_API_TOKEN });

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
app.use(app.router);
app.get('/heroku-env', function(req, res){
  res.write(heroku.HEROKU_API_TOKEN);
  res.end();
});

// Instruct the app
// to use the forceSSL
// middleware
app.use(forceSSL());

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
app.listen(process.env  .PORT || 8080);
app.set('port', port);