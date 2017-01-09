var app = angular.module('app', ['appRoutes', 'userController']);

app.directive('navbar', function() {
    return {
        templateUrl: '/views/includes/navbar.html'
    }
});

app.directive('footer', function() {
    return {
        templateUrl: '/views/includes/footer.html'
    }
});

//angular.module('app', [])
//    .service('greetingService', greetingService)
//    .controller('appController', appController)
//    .directive('navbar', function(){
//        return {
//            templateUrl: 'views/includes/navbar.html'
//        }
//    })
//    .directive('main', function() {
//        return {
//            templateUrl: 'views/home/home.html'
//        }
//    });
//
//function greetingService($http) {
//    this.getGreeting = function() {
//        var url = 'resource/'
//        return $http.get(url)
//            .then(function (response) {
//                return response.data;
//            });
//    }
//}
//
//function appController(greetingService, $scope) {
//    var self = this;
//
//    self.getGreeting = function() {
//        greetingService.getGreeting()
//            .then(function (foundGreeting) {
//                self.greeting = foundGreeting;
//            });
//    };
//
//    self.getGreeting();
//
//};