# node-express-mongodb-rest-api-example


### Open command promt with Adminstrative rights and install Chocolatey, Chocolatey is a package manager for Windows which helps us install applications from command promt
```
@"%SystemRoot%\System32\WindowsPowerShell\v1.0\powershell.exe" -NoProfile -InputFormat None -ExecutionPolicy Bypass -Command "iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))" && SET "PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin"
```

### Install long term support version of NodeJS
```
choco install nodejs-lts
```

### Install latest version of MongoDB
```
choco install mongodb
```

## Create new a directory for the project and cd to it
```
mkdir node-express-mongodb-rest-api-example
cd node-express-mongodb-rest-api-example
```

## Run npm init and provide the details
```
This utility will walk you through creating a package.json file.
It only covers the most common items, and tries to guess sensible defaults.

See `npm help json` for definitive documentation on these fields
and exactly what they do.

Use `npm install <pkg>` afterwards to install a package and
save it as a dependency in the package.json file.

Press ^C at any time to quit.
package name: (express-mongodb-rest-api-example) node-express-mongodb-rest-api-example
version: (1.0.0)
description: Simple application to demonstrate rest api creation with nodejs, expressjs and mongodb
entry point: (index.js) app.js
test command:
git repository:
keywords: nodejs, expressjs, mongodb, rest
author: Naresh Joshi
license: (ISC)
About to write to F:\git\articles\node-express-mongodb-rest-api-example\package.json:

{
  "name": "node-express-mongodb-rest-api-example",
  "version": "1.0.0",
  "description": "Simple application to demonstrate rest api creation with nodejs, expressjs and mongodb",
  "main": "app.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "keywords": [
    "nodejs",
    "expressjs",
    "mongodb",
    "rest"
  ],
  "author": "Naresh Joshi",
  "license": "ISC"
}


Is this ok? (yes)
```


## Install 
```
npm install -g nodemon
npm install --save express mongoose body-parser node-restful
```
