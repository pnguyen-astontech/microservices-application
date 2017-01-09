angular.module('userService', [])

    .factory('userService', ['$http', function($http) {
        return {
            getAll : function () {
                return $http.get('/api/users')
                    .then(function (response) {
                        return response.data;
                    });
            },

            addNew : function(user) {
                return $http.post('/api/users', user)
                    .then(function (respose) {
                        return respose.data;
                    });
            }

        }
    }]);