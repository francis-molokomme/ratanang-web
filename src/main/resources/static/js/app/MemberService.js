'use strict'

angular.module('ratanang.services', []).factory('MemberService', ["$http", function ($http) {
    var service = {};
    service.getAllMembers = function () {
        var url = "/members/all";
        return $http.get(url);
    }

    service.getMemberById = function (idNumber) {
        var url = "/members/get/" + idNumber;
        return $http.get(url);
    }

    service.deleteMemberById = function (idNumber) {
        var url = "/members/delete/" + idNumber;
        return $http.get(url);
    }

    service.updateMember = function (idNumber, memberDetails) {
        var url = "/members/update/" + idNumber;
        return $http.put(url, memberDetails);
    }

    service.insertMember = function (memberDetails) {
        var url = "/members/insert";
        return $http.post(url, memberDetails);
    }

    return service;
}]);