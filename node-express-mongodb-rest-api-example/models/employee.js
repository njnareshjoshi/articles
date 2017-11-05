'use strict';

const restful = require('node-restful');
const mongoose = restful.mongoose;


const employeeSchema = new mongoose.Schema({
	name: String,
	email: String,
	salary : Number
});


module.exports = restful.model('Employee', employeeSchema);