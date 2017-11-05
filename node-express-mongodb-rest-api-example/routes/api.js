'use strict';

const express = require('express');
const router = express.Router();

const Employee = require('../models/employee');
Employee.methods(['get', 'put', 'post', 'delete']);
Employee.register(router, '/employees');

module.exports = router;