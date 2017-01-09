angular.module('appRoutes', ['ui.router', 'userController'])

    .config([
        '$stateProvider',
        '$urlRouterProvider',
        '$locationProvider',
        function ($stateProvider, $urlRouterProvider, $locationProvider) {

            $locationProvider.html5Mode(true).hashPrefix('!');

            $urlRouterProvider
                .when('/admin/t', '/admin')

            $stateProvider
                .state('index', {
                    url: '/',
                    templateUrl: 'views/home/home.html'
                })

                .state('users', {
                    url: '/users',
                    templateUrl: 'views/users/users.html',
                    controller: 'userController as userCtrl'
                })

                .state('signup', {
                    url: '/signup',
                    templateUrl: 'views/users/signup.html',
                    controller: 'userController as userCtrl'
                });

            $urlRouterProvider.otherwise('/');
        }]);