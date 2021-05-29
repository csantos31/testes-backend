const express = require('express');
const routes = express.Router();

const apiTest = require('./controller/index');
const apiConversao = require('./controller/conversao');

routes.get('/', apiTest.index);
routes.get('/conversao',apiConversao.index);

module.exports = routes;