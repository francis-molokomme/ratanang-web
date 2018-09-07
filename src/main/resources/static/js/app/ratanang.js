'use strict'

var ratanangApp = angular.module('ratanang', ['ui.bootstrap', 'ratanang.controllers', 'ratanang.services'
]);

ratanangApp.constant("CONSTANTS", {

    getUserByIdUrl: "/user/getUser/",

    getAllUsers: "/user/getAllUsers",

    saveUser: "/user/saveUser"

});