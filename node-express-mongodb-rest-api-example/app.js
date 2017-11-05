'use strict';

const express = require('express');
const bodyparser = require('body-parser');
const mongoose = require('mongoose')


mongoose.connect('mongodb://localhost/employeedb', {useMongoClient : true})
		.then((db) => {app.use('/api', require('./routes/api'));});

const app = express();

app.use(bodyparser.urlencoded({ extended: true }));
app.use(bodyparser.json());



app.listen(8080);

var employees = [
	{
		"firstName":"Naresh",
		"lastName":"Joshi"
	},
	{
		"firstName":"Mahesh",
		"lastName":"Joshi"
	},
	{
		"firstName":"Dinesh",
		"lastName":"Joshi"
	},
];

app.get('/', (req, res) => {
	res.send(employees);
});

console.log('Server started on port 8080');