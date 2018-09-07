'use strict'

var module = angular.module('ratanang.controllers', []);
module.controller("MemberController", ["$scope", "MemberService",
    function ($scope, MemberService) {
        $scope.memberDetails = {
            idNumber: null,
            name: null,
            surname: null,
            telephone: null,
            address: null,
            effectiveDate: null,
            updatedDate: null
        };

        MemberService.getMemberById(1).then(function (value) {
            console.log(value.data);
        }, function (reason) {
            console.log("error occurred" + reason);
        }, function (value) {
            console.log("no callback" + value)
        });

        $scope.insertMember = function () {
            MemberService.insertMember($scope.memberDetails).then(function () {
                console.log("Member added successfully");
                MemberService.getAllMembers().then(function (value) {
                    $scope.allMembers = value.data;
                }, function (reason) {
                    console.log("error occurred" + reason);
                }, function (value) {
                    console.log("no callback" + value);
                });
            }, function (reason) {
                console.log("error occurred" + reason);
            }, function (value) {
                console.log("no callback" + value);
            });
        }
    }
]);