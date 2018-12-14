var app = angular.module('service-request-app', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {

    $routeProvider.
        when('/addServiceRequest', {
            templateUrl: 'templates/add-service-request.html',
            controller: 'ServiceRequestCtrl'
        }).

        when('/listServiceRequest', {
            templateUrl: 'templates/list-service-request.html',
            controller: 'ServiceRequestCtrl'
        }).

        otherwise({
            redirectTo: '/listServiceRequest'
        });
    }]);

app.controller('ServiceRequestCtrl', function($scope, $http){
    var serverUrl = 'http://localhost:8080/';
    var requestServiceApi = 'api/service/request/';

    $scope.fetchAll = function(){
        $scope.fetchAllSolved();
        $scope.fetchAllPending();
    };

    $scope.fetchAllPending = function(){
        $http.get(serverUrl + requestServiceApi+'status/PENDING')
             .success(function(data){
                $scope.pendingRequests = data;
             });
    };

    $scope.fetchAllSolved = function(){
        $http.get(serverUrl + requestServiceApi+'status/RESOLVED')
             .success(function(data){
                $scope.solvedRequests = data;
             });
    };

    $scope.save = function(request){
        $http.post(serverUrl + requestServiceApi, request)
             .success(function(data){
                $scope.request = {};

                $scope.successMessage = 'Request registered successfully';
                $scope.errorMessage = '';

                $scope.fetchAll();

                $scope.myForm.$setPristine();
             }).error(function(err){
                console.error('Error while registering request ' + err.data.errorMessage);
                $scope.successMessage = '';
                $scope.errorMessage = 'Error while registering request ' + err.data.errorMessage;
             });
    }

    $scope.resolve = function(id){
        $http.put(serverUrl + requestServiceApi +'solve/'+ id)
             .success(function(data){
                $scope.request = data;
                $scope.fetchAll();
             });
    }

    $scope.reset = function(){
        $scope.request = {};
        $scope.myForm.$setPristine()
    }

    $scope.fetchAll();
});