var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'SkyeSDKRefrigerators', 'coolMethod', [arg0]);
};

model.export.activationActivity = function (arg0, success, error) {
    exec(success, error, 'SkyeSDKRefrigerators', 'activationActivity', [arg0]);
};
