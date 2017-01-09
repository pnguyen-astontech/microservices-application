angular.module('userController', ['userService'])

    .controller('userController', function($scope, userService) {
        var self = this;

        userService.getAll()
            .then(function (foundUserList) {
                $scope.userList = foundUserList
            });

        self.addUser = function () {
            self.user = {
                username: $scope.username,
                password: $scope.password,
                email_address: $scope.email_address,
                create_date: new Date(),
                user_type: "BASIC",
                user_detail: {
                    first_name: $scope.first_name,
                    last_name: $scope.last_name,
                    birth_date: $scope.bYear + '-' + $scope.bMonth + '-' + $scope.bDay,
                    gender: "OTHER"
                }
            }

            console.log(self.user);

            userService.addNew(self.user)
                .then(function (data) {
                    if (data) {
                        alert('save successful');
                        self.clearFields();
                    } else {
                        alert('save unsuccessful');
                    }
                });
        };

        self.clearFields = function() {
            $scope.username = '';
            $scope.password = '';
            $scope.confirm_password = '';
            $scope.email_address = '';
            $scope.first_name = '';
            $scope.last_name = '';
            $scope.bDay = '';
            $scope.bMonth = '';
            $scope.bYear = '';
            $scope.gender = '';
        }

    })