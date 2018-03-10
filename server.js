const express = require('express');
const http = require('http');
const path = require('path');
const Heroku = require('heroku-client');
const heroku = new Heroku({ token: process.env.HEROKU_API_TOKEN });
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

app.get('/heroku-token', function(req, res){
  res.send(heroku.HEROKU_API_TOKEN);
});

// Instruct the app
// to use the forceSSL
// middleware
//app.use(forceSSL());

// Run the app by serving the static files
// in the src/main/resources/static directory
app.use(express.static(__dirname + '/src/main/resources/static'));

// For all GET requests, send back index.html
// so that PathLocationStrategy can be used  
app.get('/*', function(req, res) {
  res.sendFile(path.join(__dirname + '/src/main/resources/static/index.html'));
});

app.route('/backend').get((req, res) => {
  console.log("called url successful");
  res.json({url: process.env.FPP_API_URL})
});


app.route('/api/cats').get((req, res) => {
  res.send({
    cats: [{ name: 'lilly' }, { name: 'lucy' }]
  });
});

// Start the app by listening on the default
// Heroku port
app.listen(process.env.PORT || 8080,function(){
  console.log("Angular app is running");
});

